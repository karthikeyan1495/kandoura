package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.viewmodal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.WhiteverySoftAdaptor;
import com.example.tailor.kandoraexpress.databinding.StorepurchasefabricstabBinding;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.adaptor.StorePurchaseKandorafabricsAdaptor;

public class StorePurchaseFabricsVm {

    Activity activity;

    StorepurchasefabricstabBinding binding;

    String name[]={"AED 100","AED 160","AED 100"};

    int whiteverysoft[] = {R.drawable.fabric2, R.drawable.fabric2, R.drawable.fabric2};

    String whitesoftname[] = {"Blue White", "Blue White", "Blue White"};

    public StorePurchaseFabricsVm(Activity activity, StorepurchasefabricstabBinding binding) {

        this.activity=activity;
        this.binding=binding;

        setupRecycleview();
    }

    private void setupRecycleview() {

        binding.fabricTypeRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayout.HORIZONTAL,false));
        binding.fabricstabWhiteSoftRecycleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.fabricstabWhiteHardRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.fabrictabColoredRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));

        StorePurchaseKandorafabricsAdaptor adaptor=new StorePurchaseKandorafabricsAdaptor(activity,name);
        binding.fabricTypeRecycvleview.setAdapter(adaptor);

        WhiteverySoftAdaptor whiteverySoftAdaptor=new WhiteverySoftAdaptor(activity,whiteverysoft,whitesoftname);
        binding.fabricstabWhiteSoftRecycleview.setAdapter(whiteverySoftAdaptor);
        binding.fabricstabWhiteHardRecycvleview.setAdapter(whiteverySoftAdaptor);
        binding.fabrictabColoredRecycvleview.setAdapter(whiteverySoftAdaptor);









    }


}
