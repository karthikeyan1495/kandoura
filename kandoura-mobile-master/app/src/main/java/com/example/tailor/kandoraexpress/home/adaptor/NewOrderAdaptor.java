package com.example.tailor.kandoraexpress.home.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.NewOrderAdaptorBinding;
import com.example.tailor.kandoraexpress.deshboard.NewOrderItemChanges;
import com.example.tailor.kandoraexpress.order.modal.OrderList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class NewOrderAdaptor extends RecyclerView.Adapter<NewOrderAdaptor.ViewHolder> implements Observer {

    Activity activity;

    List<OrderList> orderLists;

    public NewOrderAdaptor(Activity activity, List<OrderList> orderList) {

        this.activity = activity;
        this.orderLists = orderList;
    }

    @Override
    public NewOrderAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NewOrderAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.new_order_adaptor, parent, false);
        return new NewOrderAdaptor.ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.statuschanges(orderLists.get(position));
        setUpObservar(holder.newOrderItemChanges);
        OrderList orderList = orderLists.get(position);

        holder.binding.orderIdName.setText("#"+orderList.getIncrement_id());

        holder.binding.productName.setText(orderList.getProductDetails().get(0).getProductNameEN());

        holder.binding.customerName.setText(orderList.getAddresses().get(0).getFirstname()+" "+orderList.getAddresses().get(0).getLastname());



    }

    private void setUpObservar(Observable observable) {

        observable.addObserver(this);
    }

  /*  public void setData(List<OrderList> list) {
        orderLists.clear();
        orderLists.addAll(list);
        notifyDataSetChanged();
    }*/

    @Override
    public int getItemCount() {
        return orderLists.size();
    }

    @Override
    public void update(Observable observable, Object object) {

        if(observable instanceof NewOrderItemChanges){

            OrderList items= (OrderList) object;
            orderLists.remove(items);
            notifyDataSetChanged();
        }


    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        NewOrderAdaptorBinding binding;
        NewOrderItemChanges newOrderItemChanges;
        public ViewHolder(NewOrderAdaptorBinding binding) {
            super(binding.getRoot());

            this.binding = binding;

        }


        public void statuschanges(OrderList orderList) {

           newOrderItemChanges =new NewOrderItemChanges(activity,orderList);
            binding.setNeworderstatuschanges(newOrderItemChanges);

        }
    }
}
