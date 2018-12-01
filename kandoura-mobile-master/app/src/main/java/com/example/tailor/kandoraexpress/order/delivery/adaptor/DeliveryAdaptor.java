package com.example.tailor.kandoraexpress.order.delivery.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentDeliveryAdaptorBinding;
import com.example.tailor.kandoraexpress.order.delivery.DeliverystatusChanges;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

import java.util.List;

public class DeliveryAdaptor extends RecyclerView.Adapter<DeliveryAdaptor.ViewHolder> {
    Activity activity;
    List<OrderList> orderLists;

    public DeliveryAdaptor(Activity activity, List<OrderList> orderLists) {
        this.activity = activity;
        this.orderLists = orderLists;

    }

    @NonNull
    @Override
    public DeliveryAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        FragmentDeliveryAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_delivery_adaptor, parent, false);

        return new DeliveryAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.statuschanges(orderLists.get(position));
        OrderList orderList = orderLists.get(position);

        holder.binding.orderIdno.setText("#" + orderList.getIncrement_id());
        holder.binding.customerName.setText(orderList.getAddresses().get(0).getFirstname() + " " + orderList.getAddresses().get(0).getLastname());
        holder.binding.orderSummary.setText(orderList.getAddresses().get(0).getStreet() + "," + orderList.getAddresses().get(0).getCity());
        holder.binding.prices.setText("AED " + orderList.getOrder_total());

    }

    @Override
    public int getItemCount() {
        return orderLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FragmentDeliveryAdaptorBinding binding;

        public ViewHolder(FragmentDeliveryAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void statuschanges(OrderList orderList) {

            binding.setDeliveyItemchanges(new DeliverystatusChanges(activity, orderList));
        }
    }
}
