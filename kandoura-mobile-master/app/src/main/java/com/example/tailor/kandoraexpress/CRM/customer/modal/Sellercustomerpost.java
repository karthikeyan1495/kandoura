package com.example.tailor.kandoraexpress.CRM.customer.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sellercustomerpost {


    @SerializedName("firstname")
    @Expose
    String firstname;


    @SerializedName("lastname")
    @Expose
    String lastname;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("telephone")
    @Expose
    String telephone;

    @SerializedName("password")
    @Expose
    String password;

    @SerializedName("street")
    @Expose
    String street;

    @SerializedName("country")
    @Expose
    String country;

    @SerializedName("region")
    @Expose
    String region;

    @SerializedName("city")
    @Expose
    String city;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
    String message;
}