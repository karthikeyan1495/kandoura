package com.example.tailor.kandoraexpress.products.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    @SerializedName("products")
    List<ProductDetails>productDetails;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    String message;
}
