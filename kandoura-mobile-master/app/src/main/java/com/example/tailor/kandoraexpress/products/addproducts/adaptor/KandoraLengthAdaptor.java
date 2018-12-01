package com.example.tailor.kandoraexpress.products.addproducts.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.AddProductKandoralengthAdaptorBinding;

import java.util.List;

public class KandoraLengthAdaptor extends RecyclerView.Adapter<KandoraLengthAdaptor.ViewHolder> {

    Activity activity;
    List<CharSequence> kandoralengthlist;

    public KandoraLengthAdaptor(Activity activity, List<CharSequence> kandoralengthlist) {
        this.activity = activity;
        this.kandoralengthlist = kandoralengthlist;
    }

    @Override
    public KandoraLengthAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AddProductKandoralengthAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.add_product_kandoralength_adaptor, parent, false);

        return new KandoraLengthAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(KandoraLengthAdaptor.ViewHolder holder, int position) {

        String name = (String) kandoralengthlist.get(position);

            holder.binding.kandoralengthText.setText(name);


        holder.binding.kandoralengthText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kandoralengthlist.remove(name);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return kandoralengthlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AddProductKandoralengthAdaptorBinding binding;

        public ViewHolder(AddProductKandoralengthAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
