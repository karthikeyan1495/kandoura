package com.example.tailor.kandoraexpress.payment.ordersucessfulpage;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.OrderSucessfullyplacedBinding;

public class ActivityOrderSucessful extends AppCompatActivity {

    OrderSucessfullyplacedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding= DataBindingUtil.setContentView(this, R.layout.order_sucessfullyplaced);


    }
}
