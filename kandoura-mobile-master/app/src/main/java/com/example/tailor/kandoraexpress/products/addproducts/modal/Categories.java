package com.example.tailor.kandoraexpress.products.addproducts.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Categories {

    public List<CategoryList> getCategoryLists() {
        return categoryLists;
    }

    public void setCategoryLists(List<CategoryList> categoryLists) {
        this.categoryLists = categoryLists;
    }

    @SerializedName("categories")
    List<CategoryList>categoryLists;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    String message;
}
