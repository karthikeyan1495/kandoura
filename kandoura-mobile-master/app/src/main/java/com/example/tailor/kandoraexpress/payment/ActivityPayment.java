package com.example.tailor.kandoraexpress.payment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityPaymentBinding;
import com.example.tailor.kandoraexpress.payment.viewmodal.ActivityPaymentVm;

public class ActivityPayment extends AppCompatActivity {

    ActivityPaymentBinding binding;
    ActivityPaymentVm activityPaymentVm;

    String name[]={"Custom Kandora","Custom Kandora"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding= DataBindingUtil.setContentView(this, R.layout.activity_payment);
        activityPaymentVm=new ActivityPaymentVm(this);
        binding.setActivitypaymentVm(activityPaymentVm);

        setupRecycleView();


    }

    private void setupRecycleView() {
        binding.paymentRecycleview.setLayoutManager(new LinearLayoutManager(this));
        PaymentAdaptor paymentAdaptor=new PaymentAdaptor(this,name);
        binding.paymentRecycleview.setAdapter(paymentAdaptor);


    }
}
