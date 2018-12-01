package com.example.tailor.kandoraexpress.CRM.customer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.CRM.customer.modal.SellerCustomer;
import com.example.tailor.kandoraexpress.CRM.customer.viewmodal.CRMCustomerVm;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityCrmnewcustomerBinding;

public class ActivityCRMCustomer extends AppCompatActivity {

    ActivityCrmnewcustomerBinding binding;

    CRMCustomerVm crmCustomerVm;

    SellerCustomer sellerCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindview();
    }

    private void bindview() {

        binding= DataBindingUtil.setContentView(this, R.layout.activity_crmnewcustomer);
        sellerCustomer=new SellerCustomer();
        crmCustomerVm=new CRMCustomerVm(this,sellerCustomer,binding);
        binding.setCRMCustomerVm(crmCustomerVm);
        binding.setSellercustomer(sellerCustomer);

    }
}
