package com.example.tailor.kandoraexpress.user.forgotpassword;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityForgotpasswordBinding;
import com.example.tailor.kandoraexpress.user.forgotpassword.modal.Forgotmail;
import com.example.tailor.kandoraexpress.user.forgotpassword.viewmodal.ForgotVm;

public class ForgotActivity extends AppCompatActivity {

    
    ActivityForgotpasswordBinding binding;

    ForgotVm forgotVm;
    Forgotmail forgotmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        bindview();
    }

    private void bindview() {

        binding= DataBindingUtil.setContentView(this, R.layout.activity_forgotpassword);
        forgotmail=new Forgotmail();
        forgotVm=new ForgotVm(this,forgotmail,binding);
        binding.setForgotpasswordVm(forgotVm);
        binding.setForgotemail(forgotmail);




    }
}
