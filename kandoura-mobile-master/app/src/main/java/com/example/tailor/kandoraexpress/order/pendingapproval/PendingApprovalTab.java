package com.example.tailor.kandoraexpress.order.pendingapproval;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragemntpendingapprovalBinding;
import com.example.tailor.kandoraexpress.order.OrderFragment;
import com.example.tailor.kandoraexpress.order.adaptor.OrderAdaptor;
import com.example.tailor.kandoraexpress.order.pendingapproval.viewmodal.PendingApprovalVm;

public class PendingApprovalTab extends Fragment {

    FragemntpendingapprovalBinding binding;

    PendingApprovalVm pendingApprovalVm;


    public PendingApprovalTab() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragemntpendingapproval, container, false);
        pendingApprovalVm=new PendingApprovalVm(getActivity(),binding);
        binding.setPendingapprovalVm(pendingApprovalVm);
        //setrecycleview();
    }

 /*   private void setrecycleview() {
        binding.orderpendingRecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        OrderAdaptor orderFragment=new OrderAdaptor(getActivity(),orderid,name,ordersummery,price);
        binding.orderpendingRecycleview.setAdapter(orderFragment);

    }*/


}
