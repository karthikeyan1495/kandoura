package com.example.tailor.kandoraexpress.products.addproducts.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.AddProductPenpocketAddaptorBinding;

import java.util.List;

public class PenPocketAdaptor extends RecyclerView.Adapter<PenPocketAdaptor.ViewHolder> {
    Activity activity;
    List<CharSequence> penpocketlist;

    public PenPocketAdaptor(Activity activity, List<CharSequence> penpocketlist) {

        this.activity = activity;
        this.penpocketlist = penpocketlist;

    }

    @Override
    public PenPocketAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AddProductPenpocketAddaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.add_product_penpocket_addaptor, parent, false);

        return new PenPocketAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder( PenPocketAdaptor.ViewHolder holder, int position) {

        String penpocketname = (String) penpocketlist.get(position);

        holder.binding.penpocketText.setText(penpocketname);


        holder.binding.penpocketText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                penpocketlist.remove(penpocketname);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return penpocketlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AddProductPenpocketAddaptorBinding binding;

        public ViewHolder(AddProductPenpocketAddaptorBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
