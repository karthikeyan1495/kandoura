package com.example.tailor.kandoraexpress.payment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.PaymentAdaptorBinding;

public class PaymentAdaptor extends RecyclerView.Adapter<PaymentAdaptor.ViewHolder> {

    Activity activity;

    String  name[];

    public PaymentAdaptor(Activity activity, String[] name) {

        this.activity=activity;
        this.name=name;
    }

    @NonNull
    @Override
    public PaymentAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        PaymentAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.payment_adaptor, parent, false);
        return new PaymentAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentAdaptor.ViewHolder holder, int position) {

        holder.binding.total.setText(name[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        PaymentAdaptorBinding binding;
        public ViewHolder( PaymentAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding=binding;
        }
    }
}
