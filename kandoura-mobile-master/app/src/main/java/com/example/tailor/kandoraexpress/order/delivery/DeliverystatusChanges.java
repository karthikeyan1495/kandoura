package com.example.tailor.kandoraexpress.order.delivery;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.example.tailor.kandoraexpress.order.modal.OrderList;
import com.example.tailor.kandoraexpress.order.pendingapproval.vieworderproductdetails.ViewOrderProductDetail;

public class DeliverystatusChanges {
    Activity activity;
    OrderList orderList;

    public DeliverystatusChanges(Activity activity, OrderList orderList) {

        this.activity=activity;
        this.orderList=orderList;

    }

    public void OnClickstatuschanges(View view){
/*
        final PopupMenu popupMenu = new PopupMenu(activity, view);

        popupMenu.getMenuInflater().inflate(R.menu.deliverytab, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int id = item.getItemId();

                if (R.id.complete == id) {
                    popupMenu.dismiss();
                }

                return true;
            }
        });

        popupMenu.show();*/
    }

    public void OnClickorderinfo(View view){

        activity.startActivity(new Intent(activity, ViewOrderProductDetail.class).putExtra("orderId",orderList.getOrder_id()));
    }
}
