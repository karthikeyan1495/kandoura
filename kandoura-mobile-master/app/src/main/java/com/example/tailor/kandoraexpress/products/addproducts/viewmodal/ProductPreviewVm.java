package com.example.tailor.kandoraexpress.products.addproducts.viewmodal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.api.GeneralResponse;
import com.example.tailor.kandoraexpress.products.addproducts.modal.Addproductmodal;
import com.example.tailor.kandoraexpress.products.addproducts.modal.Categories;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.APIUtil;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProductPreviewVm {

    Activity activity;

    MyProgressDialog myProgressDialog;

    ProductModel productModel;


    public ProductPreviewVm(Activity activity, ProductModel productModel) {
        this.activity = activity;
        this.productModel = productModel;
        myProgressDialog = new MyProgressDialog();
    }

}
