package com.example.tailor.kandoraexpress.CRM.customer.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.util.Patterns;
import android.view.View;

import com.example.tailor.kandoraexpress.CRM.customer.ActivityCRMCustomer;
import com.example.tailor.kandoraexpress.CRM.customer.modal.SellerCustomer;
import com.example.tailor.kandoraexpress.CRM.customer.modal.Sellercustomerpost;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.api.GeneralResponse;
import com.example.tailor.kandoraexpress.databinding.ActivityCrmnewcustomerBinding;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.user.login.modal.User;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;
import com.example.tailor.kandoraexpress.util.Util;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class CRMCustomerVm {
    Activity activity;
    SellerCustomer sellerCustomer;
    ActivityCrmnewcustomerBinding binding;
    MyProgressDialog myProgressDialog;

    public CRMCustomerVm(Activity activity, SellerCustomer sellerCustomer, ActivityCrmnewcustomerBinding binding) {
        this.activity = activity;
        this.sellerCustomer = sellerCustomer;
        this.binding = binding;
        myProgressDialog = new MyProgressDialog();
    }

    public void OnClicksave(View view) {
        validation();
    }

    private void validation() {

        if (sellerCustomer.getFirstname().trim().length() == 0) {

            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_first_name));

        } else if (sellerCustomer.getLastname().trim().length() == 0) {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_last_name));
        } else if (sellerCustomer.getEmail().trim().length() == 0 || !Patterns.EMAIL_ADDRESS.matcher(sellerCustomer.getEmail().trim()).matches()) {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_valid_email));
        } else if (sellerCustomer.getTelephone().trim().length() == 0) {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_mobile_number));
        } else if (!Util.getInstance().passwordValidator(sellerCustomer.getPassword().trim())) {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_password));
        }else if(!sellerCustomer.getPassword().equals(sellerCustomer.getConfirmpassword())){
            MySnackBar.getInstance().showNagativeSnackBar(activity,activity.getString(R.string.confirm_password));
        } else if (sellerCustomer.getStreet().trim().length() == 0) {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_street));
        } /*else if (sellerCustomer.getCountry().trim().length() == 0) {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_country));
        } else if (sellerCustomer.getCity().trim().length() == 0) {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.please_enter_the_city));
        } */ else {

            sellerCustomer.setCountry("AE");
            sellerCustomer.setCity("Dubai");
            sellerCustomer.setRegion("Dubai");

            createcustomerApiCall();
        }

    }

    private void createcustomerApiCall() {

        Sellercustomerpost sellercustomerpost = new Sellercustomerpost();

        sellercustomerpost.setFirstname(sellerCustomer.getFirstname());
        sellercustomerpost.setLastname(sellerCustomer.getLastname());
        sellercustomerpost.setCity(sellerCustomer.getCity());
        sellercustomerpost.setEmail(sellerCustomer.getEmail());
        sellercustomerpost.setTelephone(sellerCustomer.getTelephone());
        sellercustomerpost.setPassword(sellerCustomer.getPassword());
        sellercustomerpost.setStreet(sellerCustomer.getStreet());
        sellercustomerpost.setCountry(sellerCustomer.getCountry());
        sellercustomerpost.setCity(sellerCustomer.getCity());
        sellercustomerpost.setRegion(sellerCustomer.getRegion());


        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<GeneralResponse>> observable = api.createsellercusstomer(MySession.getInstance(activity).getUser().getToken(), sellercustomerpost);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        Log.e("create_customerApi:", "" + responses.code());

                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {
                            MySnackBar.getInstance().showPositiveSnackBar(activity, responses.body().getMessage());
                            activity.finish();
                            activity.startActivity(new Intent(activity, ActivityCRMCustomer.class));

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

    public void OnClickclose(View view) {
        activity.finish();
    }
}
