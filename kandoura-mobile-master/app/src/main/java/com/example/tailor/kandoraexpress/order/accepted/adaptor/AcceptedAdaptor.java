package com.example.tailor.kandoraexpress.order.accepted.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentAcceptedadaptorBinding;
import com.example.tailor.kandoraexpress.order.accepted.AcceptedStatusChanges;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AcceptedAdaptor extends RecyclerView.Adapter<AcceptedAdaptor.ViewHolder> implements Observer {
    Activity activity;
    List<OrderList> orderLists;

    public AcceptedAdaptor(Activity activity, List<OrderList> orderLists) {

        this.activity = activity;
        this.orderLists = orderLists;
    }

    @Override
    public AcceptedAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());

        FragmentAcceptedadaptorBinding binding= DataBindingUtil.inflate(layoutInflater, R.layout.fragment_acceptedadaptor,parent,false);

        return new AcceptedAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(AcceptedAdaptor.ViewHolder holder, int position) {
        holder.statuschanges(orderLists.get(position));
        setUpObserver(holder.statusChanges);
        OrderList orderList = orderLists.get(position);
        holder.binding.orderIdno.setText("#"+orderList.getIncrement_id());
        holder.binding.customerName.setText(orderList.getAddresses().get(0).getFirstname()+" "+orderList.getAddresses().get(0).getLastname());
        holder.binding.orderSummary.setText(orderList.getAddresses().get(0).getStreet()+","+orderList.getAddresses().get(0).getCity());
        holder.binding.prices.setText("AED "+orderList.getOrder_total());
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

        if(observable instanceof AcceptedStatusChanges){

            OrderList items=(OrderList) object;
            orderLists.remove(items);
            notifyDataSetChanged();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        FragmentAcceptedadaptorBinding binding;
        AcceptedStatusChanges statusChanges;
        public ViewHolder(FragmentAcceptedadaptorBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        public void statuschanges(OrderList orderList) {

            statusChanges=new AcceptedStatusChanges(activity,orderList);
            binding.setAccepted(statusChanges);


        }
    }
}
