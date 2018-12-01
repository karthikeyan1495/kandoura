package com.example.tailor.kandoraexpress.order.adaptor;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.OrderstatusAdaptorBinding;
import com.example.tailor.kandoraexpress.order.modal.OrderList;
import com.example.tailor.kandoraexpress.order.pendingapproval.PendingApprovalTabstatuschanges;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class OrderAdaptor extends RecyclerView.Adapter<OrderAdaptor.ViewHolder> implements Observer {
    Activity activity;
    List<OrderList> orderLists;

    public OrderAdaptor(Activity activity, List<OrderList> orderLists) {

        this.activity = activity;
        this.orderLists = orderLists;
    }

    @Override
    public OrderAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        OrderstatusAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.orderstatus_adaptor, parent, false);

        return new OrderAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(OrderAdaptor.ViewHolder holder, int position) {

        holder.statuschanges(orderLists.get(position));
        setUpObserver(holder.pending);
        OrderList orderList = orderLists.get(position);
        holder.binding.orderIdno.setText("#" + orderList.getIncrement_id());
        holder.binding.customerName.setText(orderList.getAddresses().get(0).getFirstname() + " " + orderList.getAddresses().get(0).getLastname());
        holder.binding.orderSummary.setText(orderList.getAddresses().get(0).getStreet() + "," + orderList.getAddresses().get(0).getCity());
        holder.binding.prices.setText("AED " + orderList.getOrder_total());
    }

    private void setUpObserver(Observable observable) {

        observable.addObserver(this);
    }

    @Override
    public int getItemCount() {
        return orderLists.size();
    }

    @Override
    public void update(Observable observable, Object object) {

        if(observable instanceof PendingApprovalTabstatuschanges){

            OrderList item= (OrderList) object;
            orderLists.remove(item);
            notifyDataSetChanged();

        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        OrderstatusAdaptorBinding binding;
        PendingApprovalTabstatuschanges pending;

        public ViewHolder(OrderstatusAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void statuschanges(OrderList orderList) {

            pending = new PendingApprovalTabstatuschanges(activity, orderList);
            binding.setPendingstatuschanges(pending);
        }
    }
}
