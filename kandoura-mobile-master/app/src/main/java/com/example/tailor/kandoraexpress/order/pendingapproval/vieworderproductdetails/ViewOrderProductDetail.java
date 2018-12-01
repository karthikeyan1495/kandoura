package com.example.tailor.kandoraexpress.order.pendingapproval.vieworderproductdetails;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentOrderproductdetailsBinding;
import com.example.tailor.kandoraexpress.order.pendingapproval.vieworderproductdetails.viewmodal.ViewOrderProductDetailsVm;

public class ViewOrderProductDetail extends AppCompatActivity {
    FragmentOrderproductdetailsBinding binding;
    ViewOrderProductDetailsVm viewOrderProductDetailsVm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();
    }

    private void bindview() {

        Intent intent=getIntent();

        String status=intent.getStringExtra("orderId");

        binding= DataBindingUtil.setContentView(this, R.layout.fragment_orderproductdetails);

        viewOrderProductDetailsVm=new ViewOrderProductDetailsVm(this,binding,status);

        binding.setVieworderproductDetails(viewOrderProductDetailsVm);


    }
}
