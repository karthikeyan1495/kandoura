package com.example.tailor.kandoraexpress.editcustomkandpora.tab.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.tailor.kandoraexpress.custom_kandora.adaptor.WhiteverySoftAdaptor;
import com.example.tailor.kandoraexpress.databinding.EditkandoratypetabBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.tab.adaptor.EditKandoraTypeAdaptor;


public class EditKandoraTypeVm {
    Activity activity;
    EditkandoratypetabBinding binding;
  String name[]={"EMARATI","KUWATI","SAUDI","QATARI","OMANI"};

    public EditKandoraTypeVm(Activity activity, EditkandoratypetabBinding binding) {

        this.activity = activity;
        this.binding=binding;

        setuprecycleView();
    }

    private void setuprecycleView() {

        binding.editKandoraTypeRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        EditKandoraTypeAdaptor adaptor = new EditKandoraTypeAdaptor(activity,name);
        binding.editKandoraTypeRecycvleview.setAdapter(adaptor);


    }
}
