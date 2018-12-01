package com.example.tailor.kandoraexpress.CRM.customerdetails.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.CRM.modal.Customerorderlist;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.CustomerlistRecentorderadaptorBinding;

import java.util.List;

public class CustomerDetailAdaptor extends RecyclerView.Adapter<CustomerDetailAdaptor.ViewHolder> {
    Activity activity;
    List<Customerorderlist> orderlist;

    public CustomerDetailAdaptor(Activity activity, List<Customerorderlist> orderlist) {
        this.activity=activity;
        this.orderlist=orderlist;
    }

    @Override
    public CustomerDetailAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        CustomerlistRecentorderadaptorBinding binding= DataBindingUtil.inflate(inflater, R.layout.customerlist_recentorderadaptor,parent,false);

        return new CustomerDetailAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CustomerDetailAdaptor.ViewHolder holder, int position) {

        Customerorderlist list=orderlist.get(position);

        holder.binding.orderId.setText(list.getIncrement_id());
        holder.binding.date.setText(list.getCreated_at());
        holder.binding.value.setText(list.getSub_order_total()+ "AED");
    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CustomerlistRecentorderadaptorBinding binding;
        public ViewHolder(CustomerlistRecentorderadaptorBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
