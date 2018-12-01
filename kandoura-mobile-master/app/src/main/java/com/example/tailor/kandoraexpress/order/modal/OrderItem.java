package com.example.tailor.kandoraexpress.order.modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderItem implements Serializable {

    public List<OrderList> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderList> orders) {
        this.orders = orders;
    }

    @SerializedName("orders")
    List<OrderList>orders;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @SerializedName("message")
    String message;

    public OrderList getOrderlistinfo() {
        return orderlistinfo;
    }

    public void setOrderlistinfo(OrderList orderlistinfo) {
        this.orderlistinfo = orderlistinfo;
    }

    @SerializedName("order")
    OrderList orderlistinfo;
}
