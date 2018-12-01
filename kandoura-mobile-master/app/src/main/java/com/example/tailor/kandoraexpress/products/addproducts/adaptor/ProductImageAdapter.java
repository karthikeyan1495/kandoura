package com.example.tailor.kandoraexpress.products.addproducts.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ImageAddItemBinding;
import com.example.tailor.kandoraexpress.products.addproducts.AddImageFragment;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ImageURI;
import com.example.tailor.kandoraexpress.products.addproducts.viewmodal.ImageAddItemVM;


import java.util.List;


public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ViewHolder> {

    Activity activity;
    AddImageFragment productImageFragment;
    List<ImageURI> list;

    public ProductImageAdapter(Activity activity, AddImageFragment productImageFragment, List<ImageURI> list) {
        this.activity = activity;
        this.productImageFragment = productImageFragment;
        this.list = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ImageAddItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.image_add_item, parent, false);
        return new ProductImageAdapter.ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
         holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageAddItemBinding binding;

        public ViewHolder(ImageAddItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ImageURI imageURI) {
            binding.setImageAddItemVM(new ImageAddItemVM(activity, productImageFragment));
            binding.setImageURI(imageURI);
            binding.executePendingBindings();
        }
    }

}
