package com.example.tailor.kandoraexpress.products.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetails {

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductNameEN() {
        return productNameEN;
    }

    public void setProductNameEN(String productNameEN) {
        this.productNameEN = productNameEN;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSpecial_price() {
        return special_price;
    }

    public void setSpecial_price(String special_price) {
        this.special_price = special_price;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }


    public List<ItemOption> getOptions() {
        return options;
    }

    public void setOptions(List<ItemOption> options) {
        this.options = options;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @SerializedName("productID")
    String productID;

    @SerializedName("sku")
    String sku;

    @SerializedName("productNameEN")
    String productNameEN;

    @SerializedName("price")
    String price;

    @SerializedName("special_price")
    String special_price;

    @SerializedName("finalPrice")
    String finalPrice;

    public List<String> getMedia_galleryList() {
        return media_galleryList;
    }

    public void setMedia_galleryList(List<String> media_galleryList) {
        this.media_galleryList = media_galleryList;
    }

    @SerializedName("media_gallery")
    List<String>media_galleryList;



    @SerializedName("options")
    List<ItemOption>options;


    public String getProductNameAR() {
        return productNameAR;
    }

    public void setProductNameAR(String productNameAR) {
        this.productNameAR = productNameAR;
    }

    public String getDescriptionEN() {
        return descriptionEN;
    }

    public void setDescriptionEN(String descriptionEN) {
        this.descriptionEN = descriptionEN;
    }

    public String getDescriptionAR() {
        return descriptionAR;
    }

    public void setDescriptionAR(String descriptionAR) {
        this.descriptionAR = descriptionAR;
    }

    public String getProcessingtime() {
        return processingtime;
    }

    public void setProcessingtime(String processingtime) {
        this.processingtime = processingtime;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @SerializedName("productNameAR")
    String productNameAR;

    @SerializedName("descriptionEN")
    String descriptionEN;

    @SerializedName("descriptionAR")
    String descriptionAR;

    @SerializedName("processingtime")
    String processingtime;

    @SerializedName("qty")
    String qty;


    public String getMainCategoryName() {
        return mainCategoryName;
    }

    public void setMainCategoryName(String mainCategoryName) {
        this.mainCategoryName = mainCategoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getMainCategoryId() {
        return mainCategoryId;
    }

    public void setMainCategoryId(String mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @SerializedName("mainCategoryName")
    String mainCategoryName;

    @SerializedName("subCategoryName")
    String subCategoryName;

    @SerializedName("mainCategoryId")
    String mainCategoryId;

    @SerializedName("subCategoryId")
    String subCategoryId;


}
