package com.example.tailor.kandoraexpress.products.addproducts.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OptionNames {


    public List<OptionItemvalues> getOptionItemvalues() {
        return optionItemvalues;
    }

    public void setOptionItemvalues(List<OptionItemvalues> optionItemvalues) {
        this.optionItemvalues = optionItemvalues;
    }

    @SerializedName("Kandora Size")
    @Expose
    List<OptionItemvalues> optionItemvalues;


}
