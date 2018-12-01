package com.example.tailor.kandoraexpress.editcustomkandpora;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityEditcustomkandoraBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.adaptor.EditCustomkandoraAdaptor;
import com.example.tailor.kandoraexpress.editcustomkandpora.viewmodal.EditCustomKandoraVm;

public class ActivityEditCustomKandora extends AppCompatActivity {

    EditCustomKandoraVm editCustomKandoraVm;

    ActivityEditcustomkandoraBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();

    }

    private void bindview() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_editcustomkandora);
        editCustomKandoraVm = new EditCustomKandoraVm(this, binding);
        binding.setEditcustomkandoraVm(editCustomKandoraVm);
        setupViewpage(binding.customkandoraViewpage);
    }

    private void setupViewpage(ViewPager viewPager) {

        EditCustomkandoraAdaptor adaptor = new EditCustomkandoraAdaptor(ActivityEditCustomKandora.this, getSupportFragmentManager(),binding);
        viewPager.setAdapter(adaptor);
        viewPager.setCurrentItem(0);
        binding.customkandoraTab.setupWithViewPager(viewPager);
        binding.customkandoraViewpage.setOffscreenPageLimit(3);

    }
}
