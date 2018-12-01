package com.example.tailor.kandoraexpress.storepurchase.viewmodal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.CRM.customer.ActivityCRMCustomer;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerDetail;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerList;
import com.example.tailor.kandoraexpress.CRM.modal.Customers;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.ActivityNewcustomerBinding;
import com.example.tailor.kandoraexpress.databinding.FragmentStorePurchaseBinding;
import com.example.tailor.kandoraexpress.products.modal.Product;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.storepurchase.tailor.TailorProductsActivity;
import com.example.tailor.kandoraexpress.storepurchase.user.viewmodal.NewCustomerVm;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class StorepurchaseVm {
    Activity activity;

    FragmentStorePurchaseBinding binding;

    private PopupWindow mPopupWindow;

    NewCustomerVm newCustomerVm;

    String views;

    MyProgressDialog myProgressDialog;


    public StorepurchaseVm(Activity activity, FragmentStorePurchaseBinding binding) {
        this.activity = activity;
        this.binding = binding;
        myProgressDialog = new MyProgressDialog();

    }

    public void onClickselectcustomer(View view) {
        getcustomerApiCall();
    }

    private void getcustomerApiCall() {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<Customers>> observable = api.crmcustomerlist(MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            customernamepopup(responses.body().getCustomerList());

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

    private void customernamepopup(List<CustomerList> customerList) {

        CharSequence item[] = null;

        item = new CharSequence[customerList.size()];

        for (int i = 0; i < customerList.size(); i++) {

            item[i] = customerList.get(i).getFirstname() + " " + customerList.get(i).getLastname();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setItems(item, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                binding.selectCustomeroption.setText(customerList.get(item).getFirstname() + " " + customerList.get(item).getLastname());

                setcustomerdetailsAPIICall(customerList.get(item).getParent_id());
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void setcustomerdetailsAPIICall(String parent_id) {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<CustomerDetail>> observable = api.crmcustomerdetails( parent_id,MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            CustomerDetail customerDetail=responses.body();

                            binding.name.setText(customerDetail.getCustomerList().getFirstname()+" "+customerDetail.getCustomerList().getLastname());
                            binding.mobile.setText(customerDetail.getCustomerList().getTelephone());
                            binding.country.setText(customerDetail.getCustomerList().getCountry_id());
                            binding.city.setText(customerDetail.getCustomerList().getCity());
                            binding.email.setText(customerDetail.getCustomerList().getEmail());

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

    public void OnClicknewCustomer(View view) {

        activity.startActivity(new Intent(activity, ActivityCRMCustomer.class));

    }

    public void OnClickproceed(View view) {

        activity.startActivity(new Intent(activity, TailorProductsActivity.class));
    }

}
