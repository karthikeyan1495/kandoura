package com.example.tailor.kandoraexpress.deshboard.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.OrderListViewProductAdaptorBinding;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;

import java.util.List;

public class OrderListViewAdaptor extends RecyclerView.Adapter<OrderListViewAdaptor.ViewHolder> {

    Activity activity;
    List<ProductDetails> productdetails;
    public OrderListViewAdaptor(Activity activity, List<ProductDetails> productDetails) {

        this.activity=activity;
        this.productdetails=productDetails;
    }

    @Override
    public OrderListViewAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        OrderListViewProductAdaptorBinding binding= DataBindingUtil.inflate(inflater, R.layout.order_list_view_product_adaptor,parent,false);

        return new OrderListViewAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(OrderListViewAdaptor.ViewHolder holder, int position) {

        ProductDetails productDetails=productdetails.get(position);

        holder.binding.orderProductName.setText(productDetails.getProductNameEN());

        holder.binding.orderListPrice.setText(productDetails.getPrice()+" AED");

        Glide.with(activity)
                .load(productDetails.getMedia_galleryList().get(0))
                .into(holder.binding.orderListImage);

    }

    @Override
    public int getItemCount() {
        return productdetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        OrderListViewProductAdaptorBinding binding;

        public ViewHolder( OrderListViewProductAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
