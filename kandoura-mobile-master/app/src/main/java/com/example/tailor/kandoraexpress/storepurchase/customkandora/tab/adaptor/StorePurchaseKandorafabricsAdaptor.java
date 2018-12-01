package com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.StorepurchasefabricstabadaptorBinding;

public class StorePurchaseKandorafabricsAdaptor extends RecyclerView.Adapter<StorePurchaseKandorafabricsAdaptor.ViewHolder> {

    Activity activity;
    String[] count;

    public StorePurchaseKandorafabricsAdaptor(Activity activity, String[] count) {
        this.activity = activity;
        this.count = count;
    }
    @Override
    public StorePurchaseKandorafabricsAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        StorepurchasefabricstabadaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.storepurchasefabricstabadaptor, parent, false);

        return new StorePurchaseKandorafabricsAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StorePurchaseKandorafabricsAdaptor.ViewHolder holder, int position) {

        holder.binding.fabricsValue.setText(count[position]);

    }

    @Override
    public int getItemCount() {
        return count.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        StorepurchasefabricstabadaptorBinding binding;
        public ViewHolder( StorepurchasefabricstabadaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
