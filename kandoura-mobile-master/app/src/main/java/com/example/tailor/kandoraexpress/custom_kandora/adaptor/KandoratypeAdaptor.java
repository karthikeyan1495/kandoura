package com.example.tailor.kandoraexpress.custom_kandora.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.KandoraTypeadaptorBinding;

public class KandoratypeAdaptor extends RecyclerView.Adapter<KandoratypeAdaptor.ViewHolder> {

    Activity activity;

    int images[];
    String name[];

    public KandoratypeAdaptor(Activity activity, int[] images, String[] name) {

        this.activity = activity;
        this.images = images;
        this.name=name;
    }

    @Override
    public KandoratypeAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        KandoraTypeadaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.kandora_typeadaptor, parent, false);
        return new KandoratypeAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull KandoratypeAdaptor.ViewHolder holder, int position) {

        holder.binding.kandoraimageviewType.setImageResource(images[position]);

        holder.binding.kandoraTypename.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        KandoraTypeadaptorBinding binding;
        public ViewHolder(KandoraTypeadaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
