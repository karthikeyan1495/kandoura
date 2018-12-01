package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.adaptor;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.StorepurchasekandoraadaptorBinding;

public class StoreppurchasekandoraTypeAdaptor extends RecyclerView.Adapter<StoreppurchasekandoraTypeAdaptor.ViewHolder> {

    Activity activity;
    String[] name;

    public StoreppurchasekandoraTypeAdaptor(Activity activity, String[] name) {

        this.activity = activity;
        this.name = name;
    }

    @Override
    public StoreppurchasekandoraTypeAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        StorepurchasekandoraadaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.storepurchasekandoraadaptor, parent, false);

        return new StoreppurchasekandoraTypeAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(StoreppurchasekandoraTypeAdaptor.ViewHolder holder, int position) {
        holder.binding.kandoraTypename.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        StorepurchasekandoraadaptorBinding binding;

        public ViewHolder(StorepurchasekandoraadaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
