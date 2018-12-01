package com.example.tailor.kandoraexpress.products.addproducts.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.AddProductSizeAdaptorBinding;

import java.util.List;

public class AddSizeAdaptor extends RecyclerView.Adapter<AddSizeAdaptor.ViewHolder> {

    Activity activity;

List<Integer>addproductsize;

    public AddSizeAdaptor(Activity activity, List<Integer> addproductsize) {

        this.activity = activity;
        this.addproductsize = addproductsize;
    }

    @Override
    public AddSizeAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        AddProductSizeAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.add_product_size_adaptor, parent, false);

        return new AddSizeAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AddSizeAdaptor.ViewHolder holder, int position) {

        Integer integer=addproductsize.get(position);

        holder.binding.addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addproductsize.remove(integer);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return  addproductsize.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AddProductSizeAdaptorBinding binding;
        public ViewHolder( AddProductSizeAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
