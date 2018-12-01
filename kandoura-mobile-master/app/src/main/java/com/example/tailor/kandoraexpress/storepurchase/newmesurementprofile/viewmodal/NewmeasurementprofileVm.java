package com.example.tailor.kandoraexpress.storepurchase.newmesurementprofile.viewmodal;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityNewneasurementprofileBinding;
import com.example.tailor.kandoraexpress.storepurchase.newmesurementprofile.BodyMeasurement;
import com.example.tailor.kandoraexpress.storepurchase.newmesurementprofile.KandoraMeasurement;


public class NewmeasurementprofileVm {

    Activity activity;
    ActivityNewneasurementprofileBinding binding;

    public NewmeasurementprofileVm(Activity activity, ActivityNewneasurementprofileBinding binding) {

        this.activity = activity;
        this.binding = binding;
    }
}
