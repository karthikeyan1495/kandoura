package com.example.tailor.kandoraexpress.editcustomkandpora.tab.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.WhiteverySoftAdaptor;
import com.example.tailor.kandoraexpress.databinding.EditfabricsttabBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.tab.EditFabricsTab;
import com.example.tailor.kandoraexpress.editcustomkandpora.tab.adaptor.EditfabricsAdaptor;

public class EditFabricsVm {

    Activity activity;

    EditfabricsttabBinding binding;

    int whiteverysoft[] = {R.drawable.fabric2, R.drawable.fabric2, R.drawable.fabric2};

    String whitesoftname[] = {"Blue White", "Blue White", "Blue White"};

    String fabricstpename[]={"Classic","Classic","Classic"};


    public EditFabricsVm(Activity activity, EditfabricsttabBinding binding) {

        this.activity = activity;
        this.binding = binding;

        setUpRecycleView();
    }

    private void setUpRecycleView() {

        binding.editFabricTypeRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.editWhiteSoftRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.editWhiteHardRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.editColoredRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

        EditfabricsAdaptor adaptor=new EditfabricsAdaptor(activity,fabricstpename);
        binding.editFabricTypeRecycvleview.setAdapter(adaptor);


        WhiteverySoftAdaptor whiteverySoftAdaptor=new WhiteverySoftAdaptor(activity,whiteverysoft,whitesoftname);

        binding.editWhiteSoftRecycvleview.setAdapter(whiteverySoftAdaptor);
        binding.editWhiteHardRecycvleview.setAdapter(whiteverySoftAdaptor);
        binding.editColoredRecycvleview.setAdapter(whiteverySoftAdaptor);





    }
}
