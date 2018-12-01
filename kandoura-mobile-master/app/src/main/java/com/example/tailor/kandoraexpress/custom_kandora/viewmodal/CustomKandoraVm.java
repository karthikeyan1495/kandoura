package com.example.tailor.kandoraexpress.custom_kandora.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.CustomColoredAdaptor;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.EmbroideryAdaptor;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.Fabricstype_adaptor;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.KandoratypeAdaptor;
import com.example.tailor.kandoraexpress.custom_kandora.adaptor.WhiteverySoftAdaptor;
import com.example.tailor.kandoraexpress.databinding.CustomkandorafragmentBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.ActivityEditCustomKandora;

public class CustomKandoraVm {
    Activity activity;

    int images[] = {R.drawable.product, R.drawable.product, R.drawable.product, R.drawable.product, R.drawable.product};

    String name[] = {"EMARATI", "KUWAITI", "SAUDI", "QATARI", "OMANI"};

    int whiteverysoft[] = {R.drawable.fabric2, R.drawable.fabric2, R.drawable.fabric2, R.drawable.fabric2,};
    String fabric[] = {"Classic -  AED 100", "Classic -  AED 100", "Classic -  AED 100"};

    String whitesoftname[] = {"Blue White", "Blue White", "Blue White", "Blue White"};

    int colored[] = {R.drawable.colored, R.drawable.colored, R.drawable.colored};

    int emborite[]={R.drawable.embrite,R.drawable.embrite,R.drawable.embrite};


    CustomkandorafragmentBinding binding;

    public CustomKandoraVm(Activity activity, CustomkandorafragmentBinding binding) {

        this.activity = activity;
        this.binding = binding;
        setupRecycleView();
    }

    private void setupRecycleView() {

        binding.kandoraTypeRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.fabricTypeRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.whiteSoftRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.whiteHardRecycvleview.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        binding.coloredRecycvleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.embroideryRecycleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.sidelinesRecycleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.stitchesRecycleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));
        binding.tarbooshRecycleview.setLayoutManager(new LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false));

        KandoratypeAdaptor kandoratypeAdaptor = new KandoratypeAdaptor(activity, images, name);
        binding.kandoraTypeRecycvleview.setAdapter(kandoratypeAdaptor);

        Fabricstype_adaptor fabricstype_adaptor = new Fabricstype_adaptor(activity, fabric);
        binding.fabricTypeRecycvleview.setAdapter(fabricstype_adaptor);

        WhiteverySoftAdaptor whiteverySoftAdaptor = new WhiteverySoftAdaptor(activity, whiteverysoft, whitesoftname);
        binding.whiteSoftRecycvleview.setAdapter(whiteverySoftAdaptor);
        binding.whiteHardRecycvleview.setAdapter(whiteverySoftAdaptor);


        CustomColoredAdaptor coloredAdaptor = new CustomColoredAdaptor(activity, colored);
        binding.coloredRecycvleview.setAdapter(coloredAdaptor);

        EmbroideryAdaptor embroideryAdaptor=new EmbroideryAdaptor(activity,emborite);
        binding.embroideryRecycleview.setAdapter(embroideryAdaptor);
        binding.sidelinesRecycleview.setAdapter(embroideryAdaptor);
        binding.stitchesRecycleview.setAdapter(embroideryAdaptor);
        binding.tarbooshRecycleview.setAdapter(embroideryAdaptor);


    }

    public void OnClickEdit(View view){

        activity.startActivity(new Intent(activity, ActivityEditCustomKandora.class));

    }

    public void onClickclose(View view){
        activity.finish();
    }
}
