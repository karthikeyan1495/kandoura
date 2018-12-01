package com.example.tailor.kandoraexpress.order;

public enum OrderStatus {

    PENDING("PENDING"),ACCEPT("ACCEPT"),PROCESSING("PROCESSING"),DISPATCH("DISPATCH"),COMPLETE("COMPLETE");

    String status;
    OrderStatus(String status) {
        this.status=status;
    }

    public String getStatus(){
        return getStatus();
    }
}
