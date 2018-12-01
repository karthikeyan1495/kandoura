package com.example.tailor.kandoraexpress.custom_kandora.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ColoredAdaptorBinding;

public class CustomColoredAdaptor extends RecyclerView.Adapter<CustomColoredAdaptor.ViewHolder> {

    Activity activity;
    int[] colored;

    public CustomColoredAdaptor(Activity activity, int[] colored) {
        this.activity = activity;
        this.colored = colored;

    }

    @Override
    public CustomColoredAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ColoredAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.colored_adaptor, parent, false);
        return new CustomColoredAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CustomColoredAdaptor.ViewHolder holder, int position) {


        holder.binding.coloredimageviewType.setImageResource(colored[position]);

    }

    @Override
    public int getItemCount() {
        return colored.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ColoredAdaptorBinding binding;

        public ViewHolder(ColoredAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
