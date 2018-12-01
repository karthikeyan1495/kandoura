package com.example.tailor.kandoraexpress.mycart.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.tailor.kandoraexpress.payment.ActivityPayment;

public class MycartVm {
    Activity activity;
    public MycartVm(Activity activity) {
        this.activity=activity;
    }

    public  void OnClickpayment(View view){

        activity.startActivity(new Intent(activity, ActivityPayment.class));

    }
}
