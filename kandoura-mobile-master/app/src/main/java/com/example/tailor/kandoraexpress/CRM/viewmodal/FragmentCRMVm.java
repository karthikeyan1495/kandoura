package com.example.tailor.kandoraexpress.CRM.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.tailor.kandoraexpress.CRM.adaptor.CRMAdaptor;
import com.example.tailor.kandoraexpress.CRM.customer.ActivityCRMCustomer;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerList;
import com.example.tailor.kandoraexpress.CRM.modal.Customers;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.FragmentCrmBinding;
import com.example.tailor.kandoraexpress.order.modal.OrderItem;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class FragmentCRMVm {
    Activity activity;
    MyProgressDialog myProgressDialog;
    FragmentCrmBinding binding;

    public FragmentCRMVm(Activity activity, FragmentCrmBinding binding) {
        this.activity = activity;
        this.binding=binding;
        this.myProgressDialog = new MyProgressDialog();
        custommerlistAPICall();
    }

    private void custommerlistAPICall() {


        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<Customers>> observable = api.crmcustomerlist( MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            List<CustomerList>customerLists=responses.body().getCustomerList();

                            setUprecycleview(customerLists);

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

    private void setUprecycleview(List<CustomerList> customerLists) {

        binding.crmRecycleView.setLayoutManager(new LinearLayoutManager(activity));

        CRMAdaptor adaptor=new CRMAdaptor(activity,customerLists);

        binding.crmRecycleView.setAdapter(adaptor);

    }

    public void OnClickcreatecustomer(View view) {

        activity.startActivity(new Intent(activity, ActivityCRMCustomer.class));
    }
}
