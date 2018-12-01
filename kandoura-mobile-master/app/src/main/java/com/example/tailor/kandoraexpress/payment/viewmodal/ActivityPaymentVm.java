package com.example.tailor.kandoraexpress.payment.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.payment.ActivityPayment;
import com.example.tailor.kandoraexpress.payment.ordersucessfulpage.ActivityOrderSucessful;

public class ActivityPaymentVm {

    Activity activity;


    public ActivityPaymentVm(Activity activity) {
        this.activity=activity;
    }

    public void  OnClickPlaceorder(View view){

        activity.startActivity(new Intent(activity, ActivityOrderSucessful.class));
    }
}
