package com.example.tailor.kandoraexpress.CRM;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.tailor.kandoraexpress.CRM.customerdetails.CustomerDetailsActivity;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerList;

public class CustomerListVm {

    Activity activity;
    CustomerList customerList;

    public CustomerListVm(Activity activity, CustomerList customerList) {

        this.activity = activity;
        this.customerList = customerList;
    }


    public void OnClickdetails(View view) {

        activity.startActivity(new Intent(activity, CustomerDetailsActivity.class).putExtra("customer_details",customerList));
    }
}
