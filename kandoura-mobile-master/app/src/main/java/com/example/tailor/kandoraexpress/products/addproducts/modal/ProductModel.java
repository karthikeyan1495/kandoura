package com.example.tailor.kandoraexpress.products.addproducts.modal;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tailor.kandoraexpress.BR;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ProductModel extends BaseObservable implements Serializable {


    ImageURI imageURI = new ImageURI();
    List<ImageURI> imageURIList = new ArrayList<>();


    @Bindable
    public ImageURI getImageURI() {
        return imageURI;
    }

    @Bindable
    public void setImageURI(ImageURI imageURI) {
        this.imageURI = imageURI;
        notifyPropertyChanged(BR.imageURI);
    }

    @Bindable
    public List<ImageURI> getImageURIList() {
        return imageURIList;
    }

    @Bindable
    public void setImageURIList(List<ImageURI> imageURIList) {
        this.imageURIList = imageURIList;
        notifyPropertyChanged(BR.imageURIList);
    }

    @Bindable
    public String getProductID() {
        return productID;
    }

    @Bindable
    public void setProductID(String productID) {
        this.productID = productID;
        notifyPropertyChanged(BR.productID);
    }

    @Bindable
    public String getProductName() {
        return productName;
    }

    @Bindable
    public void setProductName(String productName) {
        this.productName = productName;
        notifyPropertyChanged(BR.productName);
    }

    @Bindable
    public String getProductNameAr() {
        return productNameAr;
    }

    @Bindable
    public void setProductNameAr(String productNameAr) {
        this.productNameAr = productNameAr;
        notifyPropertyChanged(BR.productNameAr);
    }

    @Bindable
    public String getPrice() {
        return price;
    }

    @Bindable
    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public String getQty() {
        return qty;
    }

    @Bindable
    public void setQty(String qty) {
        this.qty = qty;
        notifyPropertyChanged(BR.qty);
    }

    @Bindable
    public String getProcessingtime() {
        return processingtime;
    }

    @Bindable
    public void setProcessingtime(String processingtime) {
        this.processingtime = processingtime;
        notifyPropertyChanged(BR.processingtime);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    @Bindable
    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public String getDescriptionAr() {
        return descriptionAr;
    }

    @Bindable
    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
        notifyPropertyChanged(BR.descriptionAr);
    }

    @Bindable
    public List<CategoryList> getCategory() {
        return category;
    }

    @Bindable
    public void setCategory(List<CategoryList> category) {
        this.category = category;
        notifyPropertyChanged(BR.category);
    }

    String productID;

    String productName = "";

    String productNameAr = "";

    String price = "";
    String qty = "";
    String processingtime = "";

    String description = "";

    String descriptionAr = "";

    List<CategoryList> category;

    @Bindable
    public String getCategoryName() {
        return categoryName;
    }

    @Bindable
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        notifyPropertyChanged(BR.categoryName);
    }

    @Bindable
    public String getSubCategoryName() {
        return subCategoryName;
    }

    @Bindable
    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
        notifyPropertyChanged(BR.subCategoryName);
    }

    String categoryName;

    String subCategoryName;


    @Bindable
    public String getCategoryId() {
        return categoryId;
    }

    @Bindable
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        notifyPropertyChanged(BR.categoryId);
    }

    String categoryId;


    @Bindable
    public String getSubcategoryId() {
        return subcategoryId;
    }

    @Bindable
    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
        notifyPropertyChanged(BR.subcategoryId);
    }

    String subcategoryId;


    @Bindable
    public String getOptionsize() {
        return optionsize;
    }

    @Bindable
    public void setOptionsize(String optionsize) {
        this.optionsize = optionsize;
        notifyPropertyChanged(BR.optionsize);
    }

    @Bindable
    public String getOptionprice() {
        return optionprice;
    }

    @Bindable
    public void setOptionprice(String optionprice) {
        this.optionprice = optionprice;
        notifyPropertyChanged(BR.optionprice);
    }

    String optionsize="";

    String optionprice="";



}
