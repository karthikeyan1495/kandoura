package com.example.tailor.kandoraexpress.products.addproducts.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.products.addproducts.AddImageFragment;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ImageURI;


public class ImageAddItemVM {
    Activity activity;
    AddImageFragment productImageFragment;

    public ImageAddItemVM(Activity activity, AddImageFragment productImageFragment) {
        this.activity = activity;
        this.productImageFragment = productImageFragment;
    }

    public void onClickImageAdd(View view, ImageURI imageURI) {

        if (imageURI.getType() == 2) {
            openMultipleImageChooser();
        }
    }

    public void onClickImageRemove(View view, ImageURI imageURI) {

        productImageFragment.list.remove(imageURI);
        productImageFragment.adapter.notifyDataSetChanged();
    }

    public void openMultipleImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        productImageFragment.startActivityForResult(Intent.createChooser(intent, activity.getString(R.string.select_customer)), productImageFragment.SELECT_MULTIPLE_PICTURE);
    }
}
