package com.example.tailor.kandoraexpress.CRM;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.CRM.adaptor.CRMAdaptor;
import com.example.tailor.kandoraexpress.CRM.viewmodal.FragmentCRMVm;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentCrmBinding;

public class FragmentCRM extends Fragment {

    FragmentCrmBinding binding;
    FragmentCRMVm fragmentCRMVm;

    public FragmentCRM() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_crm, container, false);
        fragmentCRMVm=new FragmentCRMVm(getActivity(),binding);
        binding.setCRMVm(fragmentCRMVm);

    }

}
