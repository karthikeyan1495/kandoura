package com.example.tailor.kandoraexpress.CRM.customerdetails.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.tailor.kandoraexpress.CRM.customerdetails.adaptor.CustomerDetailAdaptor;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerDetail;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerList;
import com.example.tailor.kandoraexpress.CRM.modal.Customerorderlist;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.ActivityCustomerdetailsBinding;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class CustomerDetailsVm {
    Activity activity;
    ActivityCustomerdetailsBinding binding;
    CustomerList customerList;
    MyProgressDialog myProgressDialog;
    List<Customerorderlist>orderlist;

    public CustomerDetailsVm(Activity activity, ActivityCustomerdetailsBinding binding, CustomerList customerList) {
        this.activity=activity;
        this.binding=binding;
        this.customerList=customerList;
        myProgressDialog=new MyProgressDialog();
        orderlist=new ArrayList<>();
        customerdetailsApicall();

    }

    private void customerdetailsApicall() {


        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<CustomerDetail>> observable = api.crmcustomerdetails( customerList.getParent_id(),MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            CustomerDetail customerDetail=responses.body();

                            setUprecycleview(customerDetail);

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

    private void setUprecycleview(CustomerDetail customerDetail) {
        binding.customerName.setText(customerDetail.getCustomerList().getFirstname()+" "+customerDetail.getCustomerList().getLastname());
        binding.city.setText(customerDetail.getCustomerList().getCity());
        binding.country.setText(customerDetail.getCustomerList().getCountry_id());
        binding.contactNo.setText(customerDetail.getCustomerList().getTelephone());
        binding.street.setText(customerDetail.getCustomerList().getStreet());
        orderlist=customerDetail.getCustomerorderlists();
        binding.recentOrderRecycleview.setLayoutManager(new LinearLayoutManager(activity));

        CustomerDetailAdaptor customerDetailAdaptor=new CustomerDetailAdaptor(activity,orderlist);
        binding.recentOrderRecycleview.setAdapter(customerDetailAdaptor);



    }

    public void OnClickbackpress(View view){

        activity.finish();
    }


}
