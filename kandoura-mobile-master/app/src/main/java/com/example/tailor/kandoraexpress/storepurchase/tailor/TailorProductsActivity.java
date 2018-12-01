package com.example.tailor.kandoraexpress.storepurchase.tailor;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityTailorproductsBinding;
import com.example.tailor.kandoraexpress.mycart.ActivityMycart;
import com.example.tailor.kandoraexpress.storepurchase.tailor.viewmodal.TailorProductsVm;

public class TailorProductsActivity extends AppCompatActivity {

    ActivityTailorproductsBinding binding;
    TailorProductsVm tailorProductsVm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();
    }

    private void bindview() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_tailorproducts);
        tailorProductsVm = new TailorProductsVm(this,binding);
        binding.setTailorproductVm(tailorProductsVm);

        binding.cartItemclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_cart, new ActivityMycart())
                        .commit();
            }
        });
    }
}
