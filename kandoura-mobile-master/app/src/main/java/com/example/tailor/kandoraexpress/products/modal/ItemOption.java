package com.example.tailor.kandoraexpress.products.modal;

import com.google.gson.annotations.SerializedName;

public class ItemOption {

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption_id() {
        return option_id;
    }

    public void setOption_id(String option_id) {
        this.option_id = option_id;
    }

    public String getCustom_option_values() {
        return Custom_option_values;
    }

    public void setCustom_option_values(String custom_option_values) {
        Custom_option_values = custom_option_values;
    }

    public String getCustom_option_ids() {
        return Custom_option_ids;
    }

    public void setCustom_option_ids(String custom_option_ids) {
        Custom_option_ids = custom_option_ids;
    }

    @SerializedName("entity_id")
    String entity_id;

    @SerializedName("name")
    String name;

    @SerializedName("option_id")
    String option_id;

    @SerializedName("Custom_option_values")
    String Custom_option_values;

    @SerializedName("Custom_option_ids")
    String Custom_option_ids;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @SerializedName("price")
    String price;


}
