package com.example.tailor.kandoraexpress.custom_kandora;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.custom_kandora.viewmodal.CustomKandoraVm;
import com.example.tailor.kandoraexpress.databinding.CustomkandorafragmentBinding;

public class CustomKandoraFragment extends AppCompatActivity {

    CustomkandorafragmentBinding binding;
    CustomKandoraVm customKandoraVm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindview();
    }

    private void bindview() {

        binding= DataBindingUtil.setContentView(this ,R.layout.customkandorafragment);
        customKandoraVm=new CustomKandoraVm(this,binding);
        binding.setCustomkandoraVm(customKandoraVm);
    }
}
