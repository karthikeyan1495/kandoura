package com.example.tailor.kandoraexpress.user.editdeliiverylocation.viewmodal;

import android.app.Activity;
import android.view.View;


public class EditDeliveryLocationVm {

    Activity activity;

    public EditDeliveryLocationVm(Activity activity) {
        this.activity = activity;
    }

    public void OnClickbackPress(View view) {

        activity.finish();
    }
}
