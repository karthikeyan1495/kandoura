package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.tailor.kandoraexpress.databinding.StorepurchasemeasurementtabBinding;
import com.example.tailor.kandoraexpress.storepurchase.newmesurementprofile.ActivitynewMeaurementProfile;

public class StorePurchaseMeasurementTabVm {

    Activity activity;
    StorepurchasemeasurementtabBinding binding;


    public StorePurchaseMeasurementTabVm(Activity activity, StorepurchasemeasurementtabBinding binding) {
        this.activity=activity;
        this.binding=binding;
    }

    public  void  onClickmesurementprofile(View view){

        activity.startActivity(new Intent(activity, ActivitynewMeaurementProfile.class));

    }
}
