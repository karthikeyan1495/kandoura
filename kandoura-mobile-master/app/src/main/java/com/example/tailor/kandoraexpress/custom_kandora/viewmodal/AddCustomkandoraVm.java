package com.example.tailor.kandoraexpress.custom_kandora.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.example.tailor.kandoraexpress.custom_kandora.CustomKandoraFragment;

public class AddCustomkandoraVm  {

    Activity activity;


    public AddCustomkandoraVm(Activity activity) {

        this.activity=activity;
    }

    public void  OnClickaddcustomKandoraVm(View view){

        activity.startActivity(new Intent(activity, CustomKandoraFragment.class));
    }
}
