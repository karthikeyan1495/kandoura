package com.example.tailor.kandoraexpress.mycart;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.CRM.viewmodal.FragmentCRMVm;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityMycartitemBinding;
import com.example.tailor.kandoraexpress.mycart.adaptor.MycartAdaptor;
import com.example.tailor.kandoraexpress.mycart.viewmodal.MycartVm;

public class ActivityMycart extends Fragment {

    ActivityMycartitemBinding binding;
    MycartVm mycartVm;

    int images[]={R.drawable.product,R.drawable.product};
    public ActivityMycart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_mycartitem, container, false);
        mycartVm=new MycartVm(getActivity());
        binding.setMycartVm(mycartVm);
        setuprecycleView();
    }

    private void setuprecycleView() {

        binding.recycleViewMycart.setLayoutManager(new LinearLayoutManager(getActivity()));

        MycartAdaptor mycartAdaptor=new MycartAdaptor(getActivity(),images);

        binding.recycleViewMycart.setAdapter(mycartAdaptor);

    }

}
