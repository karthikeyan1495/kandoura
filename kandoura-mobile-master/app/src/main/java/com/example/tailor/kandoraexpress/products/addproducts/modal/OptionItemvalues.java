package com.example.tailor.kandoraexpress.products.addproducts.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OptionItemvalues {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @SerializedName("value")
    @Expose
    String value;

    @SerializedName("price")
    @Expose
    String price;
}
