package com.example.tailor.kandoraexpress.products.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.api.GeneralResponse;
import com.example.tailor.kandoraexpress.products.ProductModalParser;
import com.example.tailor.kandoraexpress.products.addproducts.AddNewProducts;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MyProductItemVm extends java.util.Observable {

    Activity activity;
    MyProgressDialog myProgressDialog;

    public MyProductItemVm(Activity activity, ProductDetails productDetails) {
        this.activity = activity;
        myProgressDialog = new MyProgressDialog();
    }

    public void OnClickproductItem(View view, ProductDetails productDetails) {

        Intent intent=new Intent(activity, AddNewProducts.class);
       intent.putExtra("productModel", ProductModalParser.productItemParser(productDetails));
        activity.startActivity(intent);
    }

    public void OnClickDeleteproductItem(View view, ProductDetails productDetails) {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<GeneralResponse>> observable = api.deleteProduct(productDetails.getProductID(), MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            MySnackBar.getInstance().showPositiveSnackBar(activity, responses.body().getMessage());
                            setChanged();
                            notifyObservers(productDetails);

                        } else {
                            if (responses.body() != null) {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.body().getMessage());
                            } else {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.errorBody().string());
                            }
                        }
                    }, throwable -> {
                        myProgressDialog.dismissDialog();
                        MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.something_went_wrong_while_retrieving_information));

                    });
        } else {
            myProgressDialog.dismissDialog();
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.no_internet));
        }

    }
}
