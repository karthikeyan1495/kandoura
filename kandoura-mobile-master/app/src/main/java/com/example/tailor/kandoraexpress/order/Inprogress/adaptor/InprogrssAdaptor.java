package com.example.tailor.kandoraexpress.order.Inprogress.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentInprogressAdaptorBinding;
import com.example.tailor.kandoraexpress.order.Inprogress.InProgressItemchanges;
import com.example.tailor.kandoraexpress.order.Inprogress.viewmodal.InProgrssTabVm;
import com.example.tailor.kandoraexpress.order.OrderStatus;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class InprogrssAdaptor extends RecyclerView.Adapter<InprogrssAdaptor.ViewHolder> implements Observer {
    Activity activity;
    List<OrderList> orderLists;

    public InprogrssAdaptor(Activity activity, List<OrderList> orderLists) {
        this.activity = activity;
        this.orderLists = orderLists;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        FragmentInprogressAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_inprogress_adaptor, parent, false);

        return new InprogrssAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(orderLists.get(position));
        setUpObserver(holder.itemchanges);
        OrderList orderList = orderLists.get(position);
        holder.binding.orderIdno.setText("#"+orderList.getIncrement_id());
        holder.binding.customerName.setText(orderList.getAddresses().get(0).getFirstname()+" "+orderList.getAddresses().get(0).getLastname());
        holder.binding.orderSummary.setText(orderList.getAddresses().get(0).getStreet()+","+orderList.getAddresses().get(0).getCity());
        holder.binding.prices.setText("AED "+orderList.getOrder_total());

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

        if(observable instanceof InProgressItemchanges){

            OrderList items= (OrderList) object;
            orderLists.remove(items);
            notifyDataSetChanged();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        FragmentInprogressAdaptorBinding binding;
        InProgressItemchanges itemchanges;

        public ViewHolder(FragmentInprogressAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(OrderList orderList) {

            itemchanges = new InProgressItemchanges(activity, orderList);
            binding.setInprogressitemchanes(itemchanges);

        }
    }
}
