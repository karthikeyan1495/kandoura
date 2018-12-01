package com.example.tailor.kandoraexpress.CRM.modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CustomerList implements Serializable {

    @SerializedName("firstname")
    String firstname;
    @SerializedName("lastname")
    String lastname;

    @SerializedName("city")
    String city;

    @SerializedName("telephone")
    String telephone;

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    @SerializedName("country_id")
    String country_id;


    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    @SerializedName("parent_id")
    String parent_id;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @SerializedName("street")
    String street;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @SerializedName("email")
    String email;

}
