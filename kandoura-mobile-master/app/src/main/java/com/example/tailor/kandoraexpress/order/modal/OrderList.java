package com.example.tailor.kandoraexpress.order.modal;


import com.example.tailor.kandoraexpress.products.modal.ProductDetails;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class OrderList implements Serializable {

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSub_order_total() {
        return sub_order_total;
    }

    public void setSub_order_total(String sub_order_total) {
        this.sub_order_total = sub_order_total;
    }

    public String getOrder_total() {
        return order_total;
    }

    public void setOrder_total(String order_total) {
        this.order_total = order_total;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    @SerializedName("order_id")
    String order_id;

    @SerializedName("status")
    String status;

    @SerializedName("sub_order_total")
    String sub_order_total;

    @SerializedName("order_total")
    String order_total;

    @SerializedName("paymentmethod")
    String paymentmethod;

    @SerializedName("created_at")
    String created_at;


    @SerializedName("address")
    List<Addresses>addresses;


    @SerializedName("item")
    List<ProductDetails>productDetails;


    public String getIncrement_id() {
        return increment_id;
    }

    public void setIncrement_id(String increment_id) {
        this.increment_id = increment_id;
    }

    @SerializedName("increment_id")
    String increment_id;




}
