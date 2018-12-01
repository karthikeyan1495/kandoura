package com.example.tailor.kandoraexpress.products.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ProductlistAdaptorBinding;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;
import com.example.tailor.kandoraexpress.products.viewmodal.MyProductItemVm;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductlistAdaptor extends RecyclerView.Adapter<ProductlistAdaptor.ViewHolder> implements Observer {

    Activity activity;
    List<ProductDetails> product;
    MyProgressDialog myProgressDialog;


    public ProductlistAdaptor(Activity activity, List<ProductDetails> productDetails) {
        this.activity = activity;
        this.product = productDetails;
        myProgressDialog=new MyProgressDialog();
    }

    @Override
    public ProductlistAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductlistAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.productlist_adaptor, parent, false);
        return new ProductlistAdaptor.ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductlistAdaptor.ViewHolder holder, int position) {

        holder.bind(product.get(position));
        setUpObserver(holder.myProductItemVM);
        ProductDetails productDetails = product.get(position);


        holder.binding.productName.setText(productDetails.getProductNameEN());

        holder.binding.productFinalPrice.setText(productDetails.getFinalPrice() + " AED");

        holder.binding.productNameCategory.setText("Category:" + productDetails.getMainCategoryName()+", "+productDetails.getSubCategoryName());

        //String value = productDetails.getSpecial_price();


        if (productDetails.getSpecial_price() == null) {

            Log.e("orginal_prce", "" + productDetails.getSpecial_price());

        } else {

            holder.binding.originalPrice.setText(productDetails.getPrice() + " AED");
            holder.binding.viewStrip.setVisibility(View.VISIBLE);
        }

        Glide.with(activity)
                .load(productDetails.getMedia_galleryList().get(0))
                .into(holder.binding.productlistImage);

    }

    private void setUpObserver(Observable observable) {

        observable.addObserver(this);
    }


    @Override
    public int getItemCount() {
        return product.size();
    }

    @Override
    public void update(java.util.Observable observable, Object object) {

        if(observable instanceof MyProductItemVm){

            ProductDetails items=(ProductDetails) object;
            product.remove(items);
            notifyDataSetChanged();
        }

    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ProductlistAdaptorBinding binding;
        MyProductItemVm myProductItemVM;

        public ViewHolder(ProductlistAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ProductDetails productDetails) {

            myProductItemVM = new MyProductItemVm(activity,productDetails);
            binding.setProductItem(productDetails);
            binding.setMyproductItem(myProductItemVM);
            binding.executePendingBindings();

        }
    }
}
