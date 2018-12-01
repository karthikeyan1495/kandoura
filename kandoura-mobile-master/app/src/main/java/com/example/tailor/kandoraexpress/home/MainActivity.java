package com.example.tailor.kandoraexpress.home;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.databinding.DataBindingUtil;


import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.example.tailor.kandoraexpress.CRM.FragmentCRM;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.custom_kandora.AddCustomKandoraFragment;
import com.example.tailor.kandoraexpress.custom_kandora.CustomKandoraFragment;
import com.example.tailor.kandoraexpress.databinding.ActivityMainBinding;
import com.example.tailor.kandoraexpress.databinding.NavigationLayoutBinding;
import com.example.tailor.kandoraexpress.deshboard.DeshboardFragment;
import com.example.tailor.kandoraexpress.home.viewmodal.MainActivityVm;
import com.example.tailor.kandoraexpress.order.OrderFragment;
import com.example.tailor.kandoraexpress.order.modal.OrderList;
import com.example.tailor.kandoraexpress.products.ProductslistFragment;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;
import com.example.tailor.kandoraexpress.storepurchase.StorepurchaseFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    MainActivityVm mainActivityVm;

    NavigationLayoutBinding navigationLayoutBinding;

    public OrderList orderList=new OrderList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();

    }

    private void bindview() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityVm = new MainActivityVm(this, binding);
        binding.setMainVm(mainActivityVm);
        setupNavigationView();

        pushscreen(new DeshboardFragment());

        binding.naviHomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pushscreen(new DeshboardFragment());
                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        binding.naviCrm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pushscreen(new FragmentCRM());

                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });


        binding.naviOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setUporderposition(0);

                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });


        binding.naviProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pushscreen(new ProductslistFragment());

                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        binding.naviPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pushscreen(new StorepurchaseFragment());

                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });


        binding.naviCustomKandora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pushscreen(new AddCustomKandoraFragment());

                binding.drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

    }

    private void setUporderposition(int tabPosition) {

        OrderFragment ordersTabFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tabPosition", tabPosition);
        ordersTabFragment.setArguments(bundle);
        pushscreen(ordersTabFragment);
    }

    private void pushscreen(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_layout, fragment)
                .commit();

    }

    private void setupNavigationView() {

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.setDrawerIndicatorEnabled(false);

        binding.toogleAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
