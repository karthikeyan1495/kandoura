package com.example.tailor.kandoraexpress.user.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityLoginBinding;
import com.example.tailor.kandoraexpress.home.MainActivity;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.user.login.modal.Login;
import com.example.tailor.kandoraexpress.user.login.viewmodal.LoginVm;

public class ActivityLogin extends AppCompatActivity{

    ActivityLoginBinding binding;
    LoginVm loginVm;
    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginstatus();


    }

    private void loginstatus() {
        if(MySession.getInstance(this).isLogin()){
            finish();
            startActivity(new Intent(ActivityLogin.this, MainActivity.class));
        }else {
            bindview();
        }
    }

    private void bindview() {
        binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
        login=new Login();
        loginVm=new LoginVm(this,login,binding);
        binding.setLoginVm(loginVm);
        binding.setLogin(login);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
