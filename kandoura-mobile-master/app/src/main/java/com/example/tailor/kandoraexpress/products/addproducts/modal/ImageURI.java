package com.example.tailor.kandoraexpress.products.addproducts.modal;

import java.io.Serializable;


public class ImageURI implements Serializable {

    int type;
    String uri;
    boolean isImage;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }
}
