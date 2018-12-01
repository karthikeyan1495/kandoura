package com.example.tailor.kandoraexpress.CRM.modal;

import com.google.gson.annotations.SerializedName;

public class Customerorderlist {

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIncrement_id() {
        return increment_id;
    }

    public void setIncrement_id(String increment_id) {
        this.increment_id = increment_id;
    }

    public String getSub_order_total() {
        return sub_order_total;
    }

    public void setSub_order_total(String sub_order_total) {
        this.sub_order_total = sub_order_total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @SerializedName("orderId")
    String orderId;

    @SerializedName("increment_id")
    String  increment_id;

    @SerializedName("sub_order_total")
    String sub_order_total;

    @SerializedName("status")
    String status;

    @SerializedName("customer_id")
    String customer_id;

    @SerializedName("created_at")
    String created_at;


}
