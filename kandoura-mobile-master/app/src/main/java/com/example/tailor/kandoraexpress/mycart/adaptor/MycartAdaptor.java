package com.example.tailor.kandoraexpress.mycart.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.MycartAdaptorBinding;
import com.example.tailor.kandoraexpress.storepurchase.tailor.adaptor.TailorproductAdaptor;

public class MycartAdaptor extends RecyclerView.Adapter<MycartAdaptor.ViewHolder> {

    Activity activity;

    int [] images;

    public MycartAdaptor(Activity activity, int[] images) {

        this.activity=activity;
        this.images=images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MycartAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.mycart_adaptor, parent, false);
        return new MycartAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        holder.binding.mycartImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        MycartAdaptorBinding binding;

        public ViewHolder( MycartAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;

        }
    }
}
