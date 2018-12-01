package com.example.tailor.kandoraexpress.user.forgotpassword.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forgotmail {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @SerializedName("email")
    @Expose
    String email = "";
}
