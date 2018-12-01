package com.example.tailor.kandoraexpress.storepurchase.customkandora;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityStorepurchasecustomkandoraBinding;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.adaptor.CustomKandoraAdaptorTab;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.viewmodal.StrorepurchaseCustomKandoraVm;

public class StorePurchaeCustomKandora extends AppCompatActivity {

    ActivityStorepurchasecustomkandoraBinding binding;
    StrorepurchaseCustomKandoraVm strorepurchaseCustomKandoraVm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindview();
    }

    private void bindview() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_storepurchasecustomkandora);
        strorepurchaseCustomKandoraVm = new StrorepurchaseCustomKandoraVm(this, binding);
        binding.setCustomkandoraVm(strorepurchaseCustomKandoraVm);
        setupViewPager(binding.customkandoraViewpage);

    }

    private void setupViewPager(ViewPager viewPager) {

        CustomKandoraAdaptorTab adapter = new CustomKandoraAdaptorTab(StorePurchaeCustomKandora.this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        binding.customkandoraTab.setupWithViewPager(viewPager);
        binding.customkandoraViewpage.setOffscreenPageLimit(4);


    }
}
