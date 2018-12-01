package com.example.tailor.kandoraexpress.CRM.customerdetails;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.CRM.customerdetails.viewmodal.CustomerDetailsVm;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerList;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityCustomerdetailsBinding;

public class CustomerDetailsActivity extends AppCompatActivity {

    ActivityCustomerdetailsBinding binding;
    CustomerDetailsVm customerDetailsVm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();
    }

    private void bindview() {

        Intent intent = getIntent();

        CustomerList customerList = (CustomerList) intent.getSerializableExtra("customer_details");
        binding= DataBindingUtil.setContentView(this, R.layout.activity_customerdetails);

        customerDetailsVm=new CustomerDetailsVm(this,binding,customerList);
        binding.setCustomerdetailsVm(customerDetailsVm);


    }
}
