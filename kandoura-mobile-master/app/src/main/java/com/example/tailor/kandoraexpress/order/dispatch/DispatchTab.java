package com.example.tailor.kandoraexpress.order.dispatch;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentDispatchtabBinding;
import com.example.tailor.kandoraexpress.order.dispatch.viewmodal.DispatchVm;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

public class DispatchTab extends Fragment {

    FragmentDispatchtabBinding binding;
    DispatchVm dispatchVm;
    OrderList orderList;


    public DispatchTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dispatchtab, container, false);
        orderList=new OrderList();
        dispatchVm=new DispatchVm(getActivity(),binding);
        binding.setDispatchVm(dispatchVm);


    }

}
