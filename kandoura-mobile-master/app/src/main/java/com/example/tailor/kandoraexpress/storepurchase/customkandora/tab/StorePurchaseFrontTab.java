package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.StorepurchasefronttabBinding;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.viewmodal.StorePruchaseFrontVm;

public class StorePurchaseFrontTab extends Fragment {

    StorepurchasefronttabBinding binding;
    StorePruchaseFrontVm storePruchaseFrontVm;

    public StorePurchaseFrontTab() {
        // Required empty public constructor
    }

  @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
       bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.storepurchasefronttab,container,false);

        storePruchaseFrontVm=new StorePruchaseFrontVm(getActivity(),binding);
        binding.setFrotVm(storePruchaseFrontVm);


    }


}
