package com.example.tailor.kandoraexpress.custom_kandora.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.WhiteverysoftAdaptorBinding;

public class WhiteverySoftAdaptor extends RecyclerView.Adapter<WhiteverySoftAdaptor.ViewHolder> {

    Activity activity;

    int [] whitesoft;

    String[] whitesoftname;

    public WhiteverySoftAdaptor(Activity activity, int[] whiteverysoft, String[] whitesoftname) {

        this.activity=activity;
        this.whitesoft=whiteverysoft;
        this.whitesoftname=whitesoftname;
    }

    @NonNull
    @Override
    public WhiteverySoftAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        WhiteverysoftAdaptorBinding binding= DataBindingUtil.inflate(inflater, R.layout.whiteverysoft_adaptor,parent,false);
        return new WhiteverySoftAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WhiteverySoftAdaptor.ViewHolder holder, int position) {

        holder.binding.whitesoftimageviewType.setImageResource(whitesoft[position]);

        holder.binding.whitesoftTypename.setText(whitesoftname[position]);
    }

    @Override
    public int getItemCount() {
        return whitesoft.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        WhiteverysoftAdaptorBinding binding;
        public ViewHolder(WhiteverysoftAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
