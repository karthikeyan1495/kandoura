package com.example.tailor.kandoraexpress.CRM.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerDetail {
    public CustomerList getCustomerList() {
        return customerList;
    }

    public void setCustomerList(CustomerList customerList) {
        this.customerList = customerList;
    }

    @SerializedName("customer")
    CustomerList customerList;

    public List<Customerorderlist> getCustomerorderlists() {
        return customerorderlists;
    }

    public void setCustomerorderlists(List<Customerorderlist> customerorderlists) {
        this.customerorderlists = customerorderlists;
    }

    @SerializedName("orders")
    List<Customerorderlist>customerorderlists;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    String message;
}
