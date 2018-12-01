package com.example.tailor.kandoraexpress.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityEditprofileBinding;
import com.example.tailor.kandoraexpress.user.viewmodal.EditprofileVm;

public class ActivityEditprofile extends AppCompatActivity {

    ActivityEditprofileBinding binding;
    EditprofileVm editprofileVm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindview();
    }

    private void bindview() {

        binding= DataBindingUtil.setContentView(this, R.layout.activity_editprofile);
        editprofileVm=new EditprofileVm(this);
        binding.setEditprofileVm(editprofileVm);


    }
}
