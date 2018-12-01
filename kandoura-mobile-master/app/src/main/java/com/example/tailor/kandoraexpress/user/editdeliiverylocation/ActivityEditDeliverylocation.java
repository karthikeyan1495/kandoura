package com.example.tailor.kandoraexpress.user.editdeliiverylocation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityEditdeliverylocationBinding;
import com.example.tailor.kandoraexpress.user.editdeliiverylocation.viewmodal.EditDeliveryLocationVm;

public class ActivityEditDeliverylocation extends AppCompatActivity {


    ActivityEditdeliverylocationBinding binding;
    EditDeliveryLocationVm editDeliveryLocationVm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding= DataBindingUtil.setContentView(this, R.layout.activity_editdeliverylocation);
        editDeliveryLocationVm=new EditDeliveryLocationVm(this);

    }
}
