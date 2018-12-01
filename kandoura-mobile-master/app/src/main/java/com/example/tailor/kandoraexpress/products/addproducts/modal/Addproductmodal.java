package com.example.tailor.kandoraexpress.products.addproducts.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Addproductmodal implements Serializable {

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNameAr() {
        return productNameAr;
    }

    public void setProductNameAr(String productNameAr) {
        this.productNameAr = productNameAr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getProcessingtime() {
        return processingtime;
    }

    public void setProcessingtime(String processingtime) {
        this.processingtime = processingtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    @SerializedName("productName")
    @Expose
    String productName;

    @SerializedName("productNameAr")
    @Expose
    String productNameAr;

    @SerializedName("price")
    @Expose
    String price;

    @SerializedName("qty")
    @Expose
    String qty;

    @SerializedName("processingtime")
    @Expose
    String processingtime;

    @SerializedName("description")
    String description;

    @SerializedName("descriptionAr")
    @Expose
    String descriptionAr;


    @SerializedName("images")
    @Expose
    List<String> images;

    @SerializedName("category")
    @Expose
    List<String> category;


    public OptionNames getOptionNames() {
        return optionNames;
    }

    public void setOptionNames(OptionNames optionNames) {
        this.optionNames = optionNames;
    }

    @SerializedName("options")
    @Expose
    OptionNames optionNames;


}
