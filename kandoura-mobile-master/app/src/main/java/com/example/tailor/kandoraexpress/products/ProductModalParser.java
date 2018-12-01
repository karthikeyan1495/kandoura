package com.example.tailor.kandoraexpress.products;

import android.util.Log;


import com.example.tailor.kandoraexpress.products.addproducts.modal.ImageURI;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ProductModalParser {

    public static ProductModel productItemParser(ProductDetails productDetails) {

        ProductModel tempProductModel = new ProductModel();


        tempProductModel.setProductID(productDetails.getProductID());

        tempProductModel.setCategoryName(productDetails.getMainCategoryName());
        tempProductModel.setSubCategoryName(productDetails.getSubCategoryName());

        tempProductModel.setCategoryId(productDetails.getMainCategoryId());
        tempProductModel.setSubcategoryId(productDetails.getSubCategoryId());

        for (int i = 0; i < productDetails.getOptions().size(); i++) {

            if (productDetails.getOptions().get(i).getName().equalsIgnoreCase("Kandora Length")) {

                tempProductModel.setOptionsize(productDetails.getOptions().get(i).getCustom_option_values());

                tempProductModel.setOptionprice(productDetails.getOptions().get(i).getPrice());
            }

        }


        tempProductModel.setProductName(productDetails.getProductNameEN());
        tempProductModel.setProductNameAr(productDetails.getProductNameAR());
        tempProductModel.setDescription(productDetails.getDescriptionEN());
        tempProductModel.setDescriptionAr(productDetails.getDescriptionAR());
        tempProductModel.setProcessingtime(productDetails.getProcessingtime());
        tempProductModel.setQty(productDetails.getQty());
        tempProductModel.setPrice(productDetails.getPrice());

        if (productDetails.getMedia_galleryList() != null && productDetails.getMedia_galleryList().size() != 0) {
            ImageURI imageURI = new ImageURI();
       /*     imageURI.setImage(true);
            imageURI.setType(1);
            imageURI.setUri(productDetails.getMedia_galleryList().get(0));
            tempProductModel.setImageURI(imageURI);*/

            for (int i = 0; i < productDetails.getMedia_galleryList().size(); i++) {

                imageURI.setImage(true);
                imageURI.setType(2);
                imageURI.setUri(productDetails.getMedia_galleryList().get(i));
                tempProductModel.setImageURI(imageURI);
                tempProductModel.getImageURIList().add(imageURI);
                Log.e("product_image_get:", "" + imageURI.getUri());
            }
            imageURI = new ImageURI();
            imageURI.setType(2);
            tempProductModel.getImageURIList().add(imageURI);

        }

        return tempProductModel;
    }


}
