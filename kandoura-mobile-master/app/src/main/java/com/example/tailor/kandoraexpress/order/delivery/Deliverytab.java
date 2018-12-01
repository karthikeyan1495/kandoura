package com.example.tailor.kandoraexpress.order.delivery;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentDeliverytabBinding;
import com.example.tailor.kandoraexpress.order.delivery.viewmodal.DeliverytabVm;

public class Deliverytab extends Fragment {

    FragmentDeliverytabBinding binding;

    DeliverytabVm deliverytabVm;
    public Deliverytab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_deliverytab,container,false);
        deliverytabVm=new DeliverytabVm(getActivity(),binding);
        binding.setDeletedVm(deliverytabVm);


    }


}
