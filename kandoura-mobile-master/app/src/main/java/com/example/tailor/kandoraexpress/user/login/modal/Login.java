package com.example.tailor.kandoraexpress.user.login.modal;

import com.google.gson.annotations.SerializedName;

public class Login {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SerializedName("username")
    String username="";

    @SerializedName("password")
    String password="";
}
