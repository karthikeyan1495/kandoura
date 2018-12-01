package com.example.tailor.kandoraexpress.products.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.FragemntProductlistBinding;
import com.example.tailor.kandoraexpress.products.adaptor.ProductlistAdaptor;
import com.example.tailor.kandoraexpress.products.addproducts.AddNewProducts;
import com.example.tailor.kandoraexpress.products.modal.Product;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProductListVm extends java.util.Observable {

    Activity activity;

    FragemntProductlistBinding binding;
    MyProgressDialog myProgressDialog;

    String datafilter = "";

    public ProductListVm(Activity activity, FragemntProductlistBinding binding) {
        this.activity = activity;
        this.binding = binding;
        myProgressDialog = new MyProgressDialog();

        productApiCall();

        searchviewfilter();


    }

        private void searchviewfilter() {


        binding.selectCustomeroption.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence chars, int start, int before, int count) {

                datafilter = chars.toString();

                Toast.makeText(activity,""+datafilter,Toast.LENGTH_LONG).show();


            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });

    }

    private void setofRecycleview(List<ProductDetails> product) {

        ProductlistAdaptor adaptor = new ProductlistAdaptor(activity, product);
        binding.productlistRecycleview.setAdapter(adaptor);

    }

    private void productApiCall() {
        binding.productlistRecycleview.setLayoutManager(new GridLayoutManager(activity, 3));

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<Product>> observable = api.productlist(MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {

                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            List<ProductDetails> product = responses.body().getProductDetails();

                            setofRecycleview(product);

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


    public void OnClickaddnewproducts(View view) {

        activity.startActivity(new Intent(activity, AddNewProducts.class));


    }
}
