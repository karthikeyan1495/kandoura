package com.example.tailor.kandoraexpress.home.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragementDeshboardBinding;
import com.example.tailor.kandoraexpress.databinding.OngoingOrderAdaptorBinding;
import com.example.tailor.kandoraexpress.deshboard.OngoingItemChanges;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class OngoingOrderAdaptor extends RecyclerView.Adapter<OngoingOrderAdaptor.ViewHolder> implements Observer {

    Activity activity;
    List<OrderList> orderList;
    FragementDeshboardBinding fragementDeshboardBinding;

    public OngoingOrderAdaptor(Activity activity, List<OrderList> orderList, FragementDeshboardBinding binding) {

        this.activity = activity;
        this.orderList = orderList;
        this.fragementDeshboardBinding=binding;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        OngoingOrderAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.ongoing_order_adaptor, parent, false);
        return new OngoingOrderAdaptor.ViewHolder(binding);
    }

 /*   public void setData(List<OrderList> list) {
        orderList.clear();
        orderList.addAll(list);
        notifyDataSetChanged();
    }*/

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.statuschanges(orderList.get(position));
        setUPObserver(holder.ongoingItemChanges);
        OrderList orderLists = orderList.get(position);
        position=position+1;
        fragementDeshboardBinding.ongoingOrderCount.setText("("+position+")");
        holder.binding.orderIdName.setText("#" + orderLists.getIncrement_id());
        holder.binding.customerName.setText(orderLists.getAddresses().get(0).getFirstname() + " " + orderLists.getAddresses().get(0).getLastname());
        holder.binding.deliveryDate.setText(orderLists.getCreated_at());



    }

    private void setUPObserver(Observable observable) {
        observable.addObserver(this);

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    @Override
    public void update(java.util.Observable observable, Object object) {

        if (observable instanceof OngoingItemChanges) {

            OrderList item = (OrderList) object;
            orderList.remove(item);
            notifyDataSetChanged();

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        OngoingOrderAdaptorBinding binding;
        OngoingItemChanges ongoingItemChanges;

        public ViewHolder(OngoingOrderAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void statuschanges(OrderList orderList) {
            ongoingItemChanges = new OngoingItemChanges(activity, orderList);
            binding.setOngoingstatuschanges(ongoingItemChanges);
            binding.executePendingBindings();
        }
    }

}
