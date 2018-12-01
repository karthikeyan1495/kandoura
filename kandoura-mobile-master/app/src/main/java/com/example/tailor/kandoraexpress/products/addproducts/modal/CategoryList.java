package com.example.tailor.kandoraexpress.products.addproducts.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class CategoryList implements Serializable {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryList> getCategoryListList() {
        return categoryListList;
    }

    public void setCategoryListList(List<CategoryList> categoryListList) {
        this.categoryListList = categoryListList;
    }

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("parent_id")
    @Expose
    String parent_id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("children_data")
    @Expose
    List<CategoryList> categoryListList;

}
