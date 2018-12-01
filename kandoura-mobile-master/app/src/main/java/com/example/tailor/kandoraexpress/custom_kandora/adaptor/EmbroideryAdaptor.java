package com.example.tailor.kandoraexpress.custom_kandora.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.EmbaratiAdaptorBinding;

public class EmbroideryAdaptor extends RecyclerView.Adapter<EmbroideryAdaptor.ViewHolder> {

    Activity activity;

    int emborite[];

    public EmbroideryAdaptor(Activity activity, int[] emborite) {

        this.activity = activity;
        this.emborite = emborite;

    }

    @Override
    public EmbroideryAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        EmbaratiAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.embarati_adaptor, parent, false);
        return new EmbroideryAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmbroideryAdaptor.ViewHolder holder, int position) {


        holder.binding.wmbratiimageviewType.setImageResource(emborite[position]);


    }

    @Override
    public int getItemCount() {
        return emborite.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EmbaratiAdaptorBinding binding;

        public ViewHolder(EmbaratiAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
