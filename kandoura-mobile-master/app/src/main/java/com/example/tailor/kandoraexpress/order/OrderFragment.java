package com.example.tailor.kandoraexpress.order;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragementOrderListBinding;
import com.example.tailor.kandoraexpress.order.tab.OrderviewpageAdaptor;
import com.example.tailor.kandoraexpress.order.viewmodal.OrderVm;

import android.support.v4.app.Fragment;

public class OrderFragment extends Fragment {


    FragementOrderListBinding binding;
    OrderVm orderVm;
    public static boolean isFirstTime = true;
    int tabPosition = 0;


    public OrderFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getIntentData();
        isFirstTime = true;
        bindView(inflater, container);
        setupViewPager(binding.orderViewPage);
        return binding.getRoot();

    }


    private void getIntentData() {

        Bundle bundle = getArguments();
        if (bundle != null) {
            tabPosition = bundle.getInt("tabPosition");
        }
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragement_order_list, container, false);
        orderVm = new OrderVm(getActivity());
        binding.setOrdervm(orderVm);

    }

    private void setupViewPager(ViewPager viewPager) {
        OrderviewpageAdaptor adapter = new OrderviewpageAdaptor(getActivity(), getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(tabPosition);
        binding.orderTabs.setupWithViewPager(viewPager);
        binding.orderViewPage.setOffscreenPageLimit(4);

    }


}
