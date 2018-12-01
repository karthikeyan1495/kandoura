package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.viewmodal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.EmbroideryAdaptor;
import com.example.tailor.kandoraexpress.databinding.StorepurchasefronttabBinding;

public class StorePruchaseFrontVm {

    Activity activity;
    StorepurchasefronttabBinding binding;

    int emborite[]={R.drawable.embrite,R.drawable.embrite,R.drawable.embrite};

    public StorePruchaseFrontVm(FragmentActivity activity, StorepurchasefronttabBinding binding) {

        this.activity=activity;
        this.binding=binding;

        setuprecycleview();
    }

    private void setuprecycleview() {

        binding.storepurchaseembroideryTypeRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.storepurchaseSideLineRecycleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.storepurchaseStichesRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.storepurchaseTarbooshRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));

        EmbroideryAdaptor  embroideryAdaptor=new EmbroideryAdaptor(activity,emborite);
        binding.storepurchaseembroideryTypeRecycvleview.setAdapter(embroideryAdaptor);
        binding.storepurchaseSideLineRecycleview.setAdapter(embroideryAdaptor);
        binding.storepurchaseStichesRecycvleview.setAdapter(embroideryAdaptor);
        binding.storepurchaseTarbooshRecycvleview.setAdapter(embroideryAdaptor);





    }
}
