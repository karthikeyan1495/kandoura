package com.example.tailor.kandoraexpress.user.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.tailor.kandoraexpress.user.editdeliiverylocation.ActivityEditDeliverylocation;

public class EditprofileVm {

    Activity activity;

    public EditprofileVm(Activity activity) {
        this.activity = activity;
    }

    public void OnClickclose(View view) {

        activity.finish();
    }

    public void OnClickdeliveryLocation(View view) {

        activity.startActivity(new Intent(activity, ActivityEditDeliverylocation.class));
    }


}
