package com.example.tailor.kandoraexpress.order.accepted;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentAcceptedtabBinding;
import com.example.tailor.kandoraexpress.order.Inprogress.viewmodal.InProgrssTabVm;
import com.example.tailor.kandoraexpress.order.accepted.viewnodal.AcceptedTabVm;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

public class AcceptedTab extends Fragment {

    FragmentAcceptedtabBinding binding;

    OrderList orderList;

    AcceptedTabVm acceptedTabVm;

    public AcceptedTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bindView(inflater, container);
        return binding.getRoot();

    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_acceptedtab, container, false);
        orderList=new OrderList();
        acceptedTabVm=new AcceptedTabVm(getActivity(),orderList,binding);
        binding.setAcceptedtabVm(acceptedTabVm);


    }
}
