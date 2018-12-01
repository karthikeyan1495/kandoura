package com.example.tailor.kandoraexpress.storepurchase.tailor.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.CustomOptionItemBinding;
import com.example.tailor.kandoraexpress.databinding.TailorproductAdaptorBinding;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;

import java.util.List;

public class TailorproductAdaptor extends RecyclerView.Adapter<TailorproductAdaptor.ViewHolder> {


    Activity activity;
    List<ProductDetails> productDetails;

    public TailorproductAdaptor(Activity activity, List<ProductDetails> productDetails) {

        this.activity = activity;
        this.productDetails = productDetails;

    }

    @Override
    public TailorproductAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TailorproductAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.tailorproduct_adaptor, parent, false);
        return new TailorproductAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TailorproductAdaptor.ViewHolder holder, int position) {

        ProductDetails productDetails1 = productDetails.get(position);
        holder.binding.tailorproductName.setText(productDetails1.getProductNameEN());
        holder.binding.tailorproductPrice.setText(productDetails1.getFinalPrice() + " AED");
        Glide.with(activity)
                .load(productDetails1.getMedia_galleryList().get(0))
                .into(holder.binding.producttailorImage);


        holder.binding.tailorproductsAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                optionvalueslisted(productDetails1);
            }
        });

    }

    private void optionvalueslisted(ProductDetails productDetails1) {

        AlertDialog.Builder builder=new AlertDialog.Builder(activity,R.style.MyDialogTheme);

        LayoutInflater inflater = LayoutInflater.from(activity.getApplicationContext());

        CustomOptionItemBinding binding=DataBindingUtil.inflate(inflater,R.layout.custom_option_item,null,false);

        binding.productOptionName.setText(productDetails1.getProductNameEN());

        binding.productOptionPrice.setText(productDetails1.getPrice()+" AED");


        binding.customOptionRecycleView.setLayoutManager(new LinearLayoutManager(activity));

        CustomeroptionAdaptor customoptionAdaptor=new CustomeroptionAdaptor(activity,productDetails1.getOptions());

        binding.customOptionRecycleView.setAdapter(customoptionAdaptor);


        builder.setView(binding.getRoot());

        binding.executePendingBindings();


        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public int getItemCount() {

        return productDetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TailorproductAdaptorBinding binding;

        public ViewHolder(TailorproductAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }
    }
}
