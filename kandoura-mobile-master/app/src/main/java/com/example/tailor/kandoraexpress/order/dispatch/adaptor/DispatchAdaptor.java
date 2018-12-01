package com.example.tailor.kandoraexpress.order.dispatch.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentDispatchAdaptorBinding;
import com.example.tailor.kandoraexpress.order.dispatch.DispatchItemstatusChanges;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class DispatchAdaptor extends RecyclerView.Adapter<DispatchAdaptor.ViewHolder> implements Observer {

    Activity activity;
    List<OrderList> orderLists;

    public DispatchAdaptor(Activity activity, List<OrderList> orderLists) {
        this.activity = activity;
        this.orderLists = orderLists;
    }

    @Override
    public DispatchAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        FragmentDispatchAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dispatch_adaptor, parent, false);

        return new DispatchAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DispatchAdaptor.ViewHolder holder, int position) {

        holder.statuschanges(orderLists.get(position));
        setUpObserver(holder.dispatchItemstatusChanges);
        OrderList orderList = orderLists.get(position);
        holder.binding.orderIdno.setText("#" + orderList.getIncrement_id());
        holder.binding.customerName.setText(orderList.getAddresses().get(0).getFirstname() + " " + orderList.getAddresses().get(0).getLastname());
        holder.binding.orderSummary.setText(orderList.getAddresses().get(0).getStreet() + "," + orderList.getAddresses().get(0).getCity());
        holder.binding.prices.setText("AED " + orderList.getOrder_total());

        holder.binding.customerName.setText(orderList.getAddresses().get(0).getFirstname() + " " + orderList.getAddresses().get(0).getLastname());

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

        if (observable instanceof DispatchItemstatusChanges) {

            OrderList items = (OrderList) object;
            orderLists.remove(items);
            notifyDataSetChanged();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FragmentDispatchAdaptorBinding binding;

        DispatchItemstatusChanges dispatchItemstatusChanges;

        public ViewHolder(FragmentDispatchAdaptorBinding binding) {

            super(binding.getRoot());

            this.binding = binding;
        }

        public void statuschanges(OrderList orderList) {
            dispatchItemstatusChanges = new DispatchItemstatusChanges(activity, orderList);
            binding.setDispatchstatuschanges(dispatchItemstatusChanges);
            binding.executePendingBindings();
        }

    }
}
