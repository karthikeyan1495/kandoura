package com.example.tailor.kandoraexpress.custom_kandora.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FabricstypeAdaptorBinding;

public class Fabricstype_adaptor extends RecyclerView.Adapter<Fabricstype_adaptor.ViewHolder> {

    Activity activity;

    String []fabrics;

    public Fabricstype_adaptor(Activity activity, String[] fabricsimages) {
        this.activity = activity;
        this.fabrics=fabricsimages;
    }
    @Override
    public Fabricstype_adaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        FabricstypeAdaptorBinding binding= DataBindingUtil.inflate(inflater, R.layout.fabricstype_adaptor,parent,false);
        return new Fabricstype_adaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(Fabricstype_adaptor.ViewHolder holder, int position) {

        holder.binding.fabricTypename.setText(fabrics[position]);
    }

    @Override
    public int getItemCount() {
        return fabrics.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FabricstypeAdaptorBinding binding;
        public ViewHolder( FabricstypeAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
