package com.example.tailor.kandoraexpress.editcustomkandpora.viewmodal;

import android.app.Activity;
import android.view.View;

import com.example.tailor.kandoraexpress.databinding.ActivityEditcustomkandoraBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.adaptor.EditCustomkandoraAdaptor;

public class EditCustomKandoraVm {

    Activity activity;

    ActivityEditcustomkandoraBinding binding;

    public EditCustomKandoraVm(Activity activity, ActivityEditcustomkandoraBinding binding) {

        this.activity = activity;
        this.binding = binding;
    }

    public void onClickclose(View view) {

        activity.finish();
    }
}
