package com.example.tailor.kandoraexpress.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.products.addproducts.modal.Addproductmodal;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ImageURI;
import com.example.tailor.kandoraexpress.products.addproducts.modal.OptionItemvalues;
import com.example.tailor.kandoraexpress.products.addproducts.modal.OptionNames;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;


import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class APIUtil {


    public static Addproductmodal generateAddProduct(Context context, ProductModel productModel) {

        Addproductmodal addproductmodal = new Addproductmodal();

        if (productModel.getProductID() != null && productModel.getProductID().trim().length() != 0) {
            productModel.setProductID(productModel.getProductID());
        }

        addproductmodal.setProductName(productModel.getProductName());
        addproductmodal.setProductNameAr(productModel.getProductNameAr());
        addproductmodal.setPrice(productModel.getPrice());
        addproductmodal.setQty(productModel.getQty());

        OptionItemvalues optionItemvalues = new OptionItemvalues();
        optionItemvalues.setPrice(productModel.getOptionprice());
        optionItemvalues.setValue(productModel.getOptionsize());

        List<OptionItemvalues> optionsizelist = new ArrayList<>();
        optionsizelist.add(optionItemvalues);

        OptionNames optionNames = new OptionNames();

        optionNames.setOptionItemvalues(optionsizelist);

        addproductmodal.setOptionNames(optionNames);


        List<String> categorylist = new ArrayList<>();
        categorylist.add(productModel.getCategoryId());
        categorylist.add(productModel.getSubcategoryId());
        addproductmodal.setCategory(categorylist);
        addproductmodal.setProcessingtime(productModel.getProcessingtime());
        addproductmodal.setDescription(productModel.getDescription());
        addproductmodal.setDescriptionAr(productModel.getDescriptionAr());


        addproductmodal.setImages(getByteConvertedImages(context, productModel));

        return addproductmodal;

    }

    private static ArrayList<String> getByteConvertedImages(Context context, ProductModel productModel) {

        ArrayList<String> byteImages = new ArrayList<>();
        List<ImageURI> productImagesUri = new ArrayList<>();

        // productImagesUri.add(productModel.getImageURI());

        for (int i = 0; i < productModel.getImageURIList().size() - 1; i++) {
            productImagesUri.add(productModel.getImageURIList().get(i));

            Log.e("image_uri:", "" + productImagesUri.get(i).getUri());
        }

        for (ImageURI eachImageUri : productImagesUri) {
            try {
                byteImages.add(getEncodedString(context, Uri.parse(eachImageUri.getUri())));
            } catch (IOException e) {
                //byteImages.add("");
            }
        }

        return byteImages;
    }

    public static String getImageByte(Context context, Uri uri) {
        try {
            return getEncodedString(context, uri);
        } catch (IOException e) {
            return "";
        }
    }

    public static String getEncodedString(Context context, Uri uri) throws IOException {
        Bitmap bitmap = getImage(context, uri);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
        byte[] bytes = baos.toByteArray();
        String encoded = Base64.encodeToString(bytes, Base64.NO_WRAP);
        return encoded;
    }

    public static Bitmap getImage(Context context, Uri uri) throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptor =
                context.getContentResolver().openFileDescriptor(uri, "r");

        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();

        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        try {
            parcelFileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
