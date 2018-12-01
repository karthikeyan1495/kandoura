package com.example.tailor.kandoraexpress.products.addproducts.viewmodal;

import android.app.Activity;
import android.view.View;

import com.example.tailor.kandoraexpress.databinding.FragmentAddimagesBinding;

public class ImageProductFragment  {
    Activity activity;
    FragmentAddimagesBinding binding;

    public ImageProductFragment(Activity activity, FragmentAddimagesBinding binding) {

        this.activity=activity;
        this.binding=binding;


    }

    public void Onclickbackpress(View view){
        activity.finish();
    }

}
