package com.example.tailor.kandoraexpress.storepurchase.user.viewmodal;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class NewCustomerVm {
    Activity activity;

    public NewCustomerVm(Activity activity) {


        this.activity=activity;

    }

    public void OnClickSave(View view){

        Toast.makeText(activity, "save", Toast.LENGTH_SHORT).show();
    }
}
