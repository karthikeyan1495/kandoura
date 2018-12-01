package com.example.tailor.kandoraexpress.products.addproducts.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.AddProductCollarThicknessAdaptorBinding;

import java.util.List;

public class CollarThicknessAdaptor extends RecyclerView.Adapter<CollarThicknessAdaptor.ViewHolder> {
    Activity activity;

    List<CharSequence> collarthicknesslist;

    public CollarThicknessAdaptor(Activity activity, List<CharSequence> collarthicknesslist) {

        this.activity=activity;
        this.collarthicknesslist=collarthicknesslist;
    }

    @Override
    public CollarThicknessAdaptor.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        AddProductCollarThicknessAdaptorBinding binding= DataBindingUtil.inflate(inflater, R.layout.add_product_collar_thickness_adaptor,parent,false);

        return new CollarThicknessAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder( CollarThicknessAdaptor.ViewHolder holder, int position) {

        String collarname= (String) collarthicknesslist.get(position);


        holder.binding.collerThicknessText.setText(collarname);

        holder.binding.collerThicknessText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                collarthicknesslist.remove(collarname);
                notifyDataSetChanged();
            }
        });




    }

    @Override
    public int getItemCount() {
        return collarthicknesslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AddProductCollarThicknessAdaptorBinding binding;
        public ViewHolder( AddProductCollarThicknessAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
