package com.example.tailor.kandoraexpress.storepurchase.tailor.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.ActivityTailorproductsBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.ActivityEditCustomKandora;
import com.example.tailor.kandoraexpress.payment.ActivityPayment;
import com.example.tailor.kandoraexpress.products.modal.Product;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.StorePurchaeCustomKandora;
import com.example.tailor.kandoraexpress.storepurchase.tailor.adaptor.TailorproductAdaptor;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class TailorProductsVm {

    Activity activity;

    ActivityTailorproductsBinding binding;
    MyProgressDialog myProgressDialog;

    public TailorProductsVm(Activity activity, ActivityTailorproductsBinding binding) {

        this.activity = activity;
        this.binding = binding;
        myProgressDialog = new MyProgressDialog();
        productApiCall();
    }

    public void OnClickclose(View view) {

        activity.finish();
    }

    private void setupRecycleview(List<ProductDetails> product) {


        TailorproductAdaptor adaptor = new TailorproductAdaptor(activity, product);
        adaptor.notifyDataSetChanged();
        binding.tailorProductrecycleviewlist.setAdapter(adaptor);


    }


    private void productApiCall() {
        binding.tailorProductrecycleviewlist.setLayoutManager(new GridLayoutManager(activity, 2));

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<Product>> observable = api.productlist(MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        Log.e("response", "" + responses.code());

                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            List<ProductDetails> product = responses.body().getProductDetails();

                            setupRecycleview(product);

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
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.no_internet));
        }


    }


    public void OnClickcustomKandora(View view) {

        activity.startActivity(new Intent(activity, StorePurchaeCustomKandora.class));

    }
}
