package com.example.tailor.kandoraexpress.editcustomkandpora.tab.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.EditfabricsadaptorBinding;

public class EditfabricsAdaptor extends RecyclerView.Adapter<EditfabricsAdaptor.ViewHolder> {
    Activity activity;
    String[] fabricsname;

    public EditfabricsAdaptor(Activity activity, String[] fabricstpename) {

        this.activity = activity;
        this.fabricsname = fabricstpename;
    }

    @NonNull
    @Override
    public EditfabricsAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        EditfabricsadaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.editfabricsadaptor, parent, false);
        return new EditfabricsAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(EditfabricsAdaptor.ViewHolder holder, int position) {
        holder.binding.classicName.setText(fabricsname[position]);

    }

    @Override
    public int getItemCount() {
        return fabricsname.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditfabricsadaptorBinding binding;

        public ViewHolder(EditfabricsadaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
