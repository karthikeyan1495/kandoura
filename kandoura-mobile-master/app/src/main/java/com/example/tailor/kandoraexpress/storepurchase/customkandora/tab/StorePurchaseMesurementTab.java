package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.StorepurchasemeasurementtabBinding;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.viewmodal.StorePurchaseMeasurementTabVm;

public class StorePurchaseMesurementTab extends Fragment {

    StorepurchasemeasurementtabBinding binding;

    StorePurchaseMeasurementTabVm storePurchaseMeasurementTabVm;

    public  StorePurchaseMesurementTab(){

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.storepurchasemeasurementtab,container,false);

        storePurchaseMeasurementTabVm=new StorePurchaseMeasurementTabVm(getActivity(),binding);
        binding.setMeasurementtabVm(storePurchaseMeasurementTabVm);




    }
}
