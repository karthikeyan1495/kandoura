package com.example.tailor.kandoraexpress.order.modal;

import com.google.gson.annotations.SerializedName;

public class Addresses {

    @SerializedName("postcode")
    String postcode;

    @SerializedName("street")
    String street;

    @SerializedName("city")
    String city;

    @SerializedName("email")
    String email;

    @SerializedName("telephone")
    String telephone;

    @SerializedName("country_id")
    String country_id;

    @SerializedName("address_type")
    String address_type;


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

    @SerializedName("firstname")
    String firstname;

    @SerializedName("lastname")
    String lastname;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getAddress_type() {
        return address_type;
    }

    public void setAddress_type(String address_type) {
        this.address_type = address_type;
    }
}
