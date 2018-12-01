package com.example.tailor.kandoraexpress.editcustomkandpora.tab.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.EmbroideryAdaptor;
import com.example.tailor.kandoraexpress.databinding.EditfronttabBinding;


public class EditFrontVm {
    Activity activity;
    EditfronttabBinding binding;
    int emborite[] = {R.drawable.embrite, R.drawable.embrite, R.drawable.embrite};

    public EditFrontVm(Activity activity, EditfronttabBinding binding) {

        this.activity = activity;
        this.binding = binding;

        setUpRecycleView();
    }

    private void setUpRecycleView() {

        binding.editEmbroideryRecycleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.editSidelinesRecycleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.editStitchesRecycleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.editTarbooshRecycleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

        EmbroideryAdaptor embroideryAdaptor = new EmbroideryAdaptor(activity, emborite);
        binding.editEmbroideryRecycleview.setAdapter(embroideryAdaptor);
        binding.editSidelinesRecycleview.setAdapter(embroideryAdaptor);
        binding.editStitchesRecycleview.setAdapter(embroideryAdaptor);
        binding.editTarbooshRecycleview.setAdapter(embroideryAdaptor);


    }

}
