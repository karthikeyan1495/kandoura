package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.StorepurchasefabricstabBinding;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.viewmodal.StorePurchaseFabricsVm;

public class StorePurchaseFabricsTab extends Fragment {

    StorepurchasefabricstabBinding binding;
    StorePurchaseFabricsVm fabricsVm;
    public StorePurchaseFabricsTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.storepurchasefabricstab, container, false);
        fabricsVm=new StorePurchaseFabricsVm(getActivity(),binding);
        binding.setFabricstabVm(fabricsVm);

    }

}
