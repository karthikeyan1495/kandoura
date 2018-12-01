package com.example.tailor.kandoraexpress.CRM.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Customers {

    public List<CustomerList> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<CustomerList> customerList) {
        this.customerList = customerList;
    }

    @SerializedName("customers")
    List<CustomerList> customerList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    String message;





}
