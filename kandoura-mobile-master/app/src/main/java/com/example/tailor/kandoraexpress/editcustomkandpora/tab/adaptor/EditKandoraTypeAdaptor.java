package com.example.tailor.kandoraexpress.editcustomkandpora.tab.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.EditkandoratypeadaptorBinding;

public class EditKandoraTypeAdaptor extends RecyclerView.Adapter<EditKandoraTypeAdaptor.ViewHolder> {

    Activity activity;
    String name[];



    public EditKandoraTypeAdaptor(Activity activity, String[] name) {

        this.activity = activity;
        this.name = name;
    }

    @Override
    public EditKandoraTypeAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        EditkandoratypeadaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.editkandoratypeadaptor, parent, false);
        return new EditKandoraTypeAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(EditKandoraTypeAdaptor.ViewHolder holder, int position) {
        holder.binding.editKandoraTypename.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        EditkandoratypeadaptorBinding binding;

        public ViewHolder(EditkandoratypeadaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
