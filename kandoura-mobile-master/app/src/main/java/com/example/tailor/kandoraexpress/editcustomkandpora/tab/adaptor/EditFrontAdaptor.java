package com.example.tailor.kandoraexpress.editcustomkandpora.tab.adaptor;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.EditfronttabBinding;

public class EditFrontAdaptor extends RecyclerView.Adapter<EditFrontAdaptor.ViewHolder> {


    @Override
    public EditFrontAdaptor.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        EditfronttabBinding binding= DataBindingUtil.inflate(inflater, R.layout.editfronttabadaptor,parent,false);
        return new EditFrontAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(EditFrontAdaptor.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        EditfronttabBinding binding;
        public ViewHolder( EditfronttabBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
