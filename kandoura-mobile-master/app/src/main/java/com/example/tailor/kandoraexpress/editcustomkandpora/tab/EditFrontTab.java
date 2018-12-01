package com.example.tailor.kandoraexpress.editcustomkandpora.tab;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.EditfronttabBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.tab.viewmodal.EditFrontVm;

public class EditFrontTab extends Fragment {

    EditfronttabBinding binding;
    EditFrontVm editFrontVm;

    public EditFrontTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding = DataBindingUtil.inflate(inflater, R.layout.editfronttab, container, false);
        editFrontVm = new EditFrontVm(getActivity(),binding);
        binding.setEditfrontVm(editFrontVm);

    }

}
