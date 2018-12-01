package com.example.tailor.kandoraexpress.products.addproducts;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityAddtoproductBinding;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;
import com.example.tailor.kandoraexpress.products.addproducts.viewmodal.AddNewProductsVm;
import com.example.tailor.kandoraexpress.util.MySnackBar;

public class AddNewProducts extends AppCompatActivity {

    ActivityAddtoproductBinding binding;
    AddNewProductsVm addNewProductsVm;


    public ProductModel productModel = new ProductModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getIntentData();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_addtoproduct);
        addNewProductsVm = new AddNewProductsVm(this, binding, productModel);
        binding.setProductmodal(productModel);
        binding.setAddtoproductVm(addNewProductsVm);
        AddImageclickaction();


    }

    private void AddImageclickaction() {

        binding.addedImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productModel.getProductName().isEmpty() && productModel.getProductName().trim().length() == 0) {
                    MySnackBar.getInstance().showNagativeSnackBar(AddNewProducts.this, getApplicationContext().getString(R.string.please_enter_the_name_in_english));
                } else if (productModel.getProductNameAr().isEmpty() && productModel.getProductNameAr().trim().length() == 0) {
                    MySnackBar.getInstance().showNagativeSnackBar(AddNewProducts.this, getApplicationContext().getString(R.string.please_enter_the_name_in_arabic));
                } else if (productModel.getDescription().isEmpty() && productModel.getDescription().length() == 0) {
                    MySnackBar.getInstance().showNagativeSnackBar(AddNewProducts.this, getApplicationContext().getString(R.string.please_enter_the_product_description_in_english));

                } else if (productModel.getDescriptionAr().isEmpty() && productModel.getDescriptionAr().trim().length() == 0) {

                    MySnackBar.getInstance().showNagativeSnackBar(AddNewProducts.this, getApplicationContext().getString(R.string.please_enter_the_product_description_in_arabic));
                } else if (productModel.getPrice().isEmpty() && productModel.getPrice().trim().length() == 0) {

                    MySnackBar.getInstance().showNagativeSnackBar(AddNewProducts.this, getApplicationContext().getString(R.string.please_enter_the_price));
                } else if (productModel.getProcessingtime().isEmpty() && productModel.getProcessingtime().length() == 0) {
                    MySnackBar.getInstance().showNagativeSnackBar(AddNewProducts.this, getApplicationContext().getString(R.string.please_enter_the_processing_time));
                } else if (productModel.getQty().isEmpty() && productModel.getQty().trim().length() == 0) {
                    MySnackBar.getInstance().showNagativeSnackBar(AddNewProducts.this, getApplicationContext().getString(R.string.please_enter_the_qty));
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame_contents_layout, new AddImageFragment())
                            .commit();

                }
            }
        });

    }


    private void getIntentData() {

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            productModel = (ProductModel) bundle.getSerializable("productModel");
        }
    }
}
