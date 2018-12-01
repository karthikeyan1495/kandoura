package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.example.tailor.kandoraexpress.databinding.StorepurchasekandoratypetabBinding;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.adaptor.StoreppurchasekandoraTypeAdaptor;


public class StorepurchasekandoraTypeVm {

    Activity activity;
    StorepurchasekandoratypetabBinding binding;

    String name[]={"EMARATI","KUWATI","SAUDI","QATARI","OMANI"};

   public StorepurchasekandoraTypeVm(Activity activity,StorepurchasekandoratypetabBinding binding) {

        this.activity=activity;
        this.binding=binding;

        setUpRecycleview();
    }

    private void setUpRecycleview() {

       binding.storeppurchaseCustomkandoraRecycleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayout.HORIZONTAL,false));
        StoreppurchasekandoraTypeAdaptor storeppurchasekandoraTypeAdaptor=new StoreppurchasekandoraTypeAdaptor(activity,name);
        binding.storeppurchaseCustomkandoraRecycleview.setAdapter(storeppurchasekandoraTypeAdaptor);


    }

}
