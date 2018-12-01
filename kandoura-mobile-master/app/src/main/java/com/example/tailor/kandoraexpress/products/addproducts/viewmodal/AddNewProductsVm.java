package com.example.tailor.kandoraexpress.products.addproducts.viewmodal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.ActivityAddtoproductBinding;
import com.example.tailor.kandoraexpress.products.addproducts.adaptor.AddSizeAdaptor;
import com.example.tailor.kandoraexpress.products.addproducts.adaptor.CollarThicknessAdaptor;
import com.example.tailor.kandoraexpress.products.addproducts.adaptor.KandoraLengthAdaptor;
import com.example.tailor.kandoraexpress.products.addproducts.adaptor.PenPocketAdaptor;
import com.example.tailor.kandoraexpress.products.addproducts.modal.Categories;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;
import com.example.tailor.kandoraexpress.products.modal.ProductDetails;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


public class AddNewProductsVm {

    Activity activity;
    ActivityAddtoproductBinding binding;
    MyProgressDialog myProgressDialog;
    ProductDetails productDetails;
    ProductModel productModel;
    String parentId = "";
    int itemposition = 0;

    List<CharSequence> kandoralengthlist;

    List<CharSequence> collarthicknesslist;

    List<CharSequence> penpocketlist;

    List<Integer>addproductsize;

    int add=0;


    public AddNewProductsVm(Activity activity, ActivityAddtoproductBinding binding, ProductModel productModal) {
        this.activity = activity;
        this.binding = binding;
        this.productModel = productModal;
        myProgressDialog = new MyProgressDialog();
        productDetails = new ProductDetails();
        kandoralengthlist = new ArrayList<>();
        collarthicknesslist = new ArrayList<>();
        penpocketlist = new ArrayList<>();

        addproductsize=new ArrayList<>();

        CategoryapiCall();

    }

    private void CategoryapiCall() {


        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<Categories>> observable = api.getCategory();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            if (productModel.getProductID() == null) {

                                productModel.setCategoryName(responses.body().getCategoryLists().get(0).getName());
                                productModel.setCategoryId(responses.body().getCategoryLists().get(0).getId());

                                productModel.setSubcategoryId(responses.body().getCategoryLists().get(1).getId());

                                productModel.setSubCategoryName(responses.body().getCategoryLists().get(0).getCategoryListList().get(0).getName());

                                productModel.setCategory(responses.body().getCategoryLists());

                                parentId = responses.body().getCategoryLists().get(0).getId();

                            } else {


                                productModel.setCategory(responses.body().getCategoryLists());

                                parentId = responses.body().getCategoryLists().get(0).getId();
                            }

                        } else {
                            if (responses.body() != null) {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.body().getMessage());
                            } else {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.errorBody().string());
                            }
                        }
                    }, throwable -> {
                        myProgressDialog.dismissDialog();
                        MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.something_went_wrong_while_retrieving_information));

                    });
        } else {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.no_internet));
        }

    }


    public void OnClickBackpress(View view) {

        activity.finish();
    }

    public void OnClickAddedthePrice(View view) {

        add=add+1;

        Log.e("add_view",""+add);

        binding.addSizeRecycleView.setLayoutManager(new LinearLayoutManager(activity));

        addproductsize.add(add);

        AddSizeAdaptor addSizeAdaptor = new AddSizeAdaptor(activity, addproductsize);
        binding.addSizeRecycleView.setAdapter(addSizeAdaptor);


    }

    public void OnClicksubCategory(View view, ProductModel productModel) {

        CharSequence item[] = null;

        item = new CharSequence[productModel.getCategory().get(itemposition).getCategoryListList().size()];


        for (int i = 0; i < productModel.getCategory().get(itemposition).getCategoryListList().size(); i++) {

            if (parentId.equals(productModel.getCategory().get(itemposition).getCategoryListList().get(i).getParent_id())) {

                item[i] = productModel.getCategory().get(itemposition).getCategoryListList().get(i).getName();

                Log.e("category_listed", productModel.getCategory().get(itemposition).getCategoryListList().get(i).getName());
            }
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setItems(item, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                //  saveCategory(productModel, item);

                productModel.setSubCategoryName(productModel.getCategory().get(itemposition).getCategoryListList().get(item).getName());
                productModel.setSubcategoryId(productModel.getCategory().get(itemposition).getCategoryListList().get(item).getId());


            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void OnClickChooseCategory(View view, ProductModel productModel) {

        CharSequence item[] = null;

        item = new CharSequence[productModel.getCategory().size()];

        for (int i = 0; i < productModel.getCategory().size(); i++) {
            item[i] = productModel.getCategory().get(i).getName();
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setItems(item, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                saveCategory(productModel, item);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void saveCategory(ProductModel productModel, int item) {

        productModel.setCategoryName(productModel.getCategory().get(item).getName());
        productModel.setSubCategoryName(productModel.getCategory().get(item).getCategoryListList().get(0).getName());
        productModel.setCategoryId(productModel.getCategory().get(item).getId());
        parentId = productModel.getCategory().get(item).getId();
        itemposition = item;


    }

    public void OnClickcollarthickness(View view) {

        binding.collarThicknessRecycleView.setLayoutManager(new LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false));

        final CharSequence[] customerarray = activity.getResources().getStringArray(R.array.coller_thickness);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.MyDialogTheme);
        builder.setItems(customerarray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                collarthicknesslist.add(customerarray[item]);

                CollarThicknessAdaptor adaptor = new CollarThicknessAdaptor(activity, collarthicknesslist);
                binding.collarThicknessRecycleView.setAdapter(adaptor);

                dialog.dismiss();


            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void OnClickkandoralength(View view) {

        binding.kandoraLengthRecycleView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));

        final CharSequence[] customerarray = activity.getResources().getStringArray(R.array.kandora_length_array);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.MyDialogTheme);
        builder.setItems(customerarray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                kandoralengthlist.add(customerarray[item]);

                KandoraLengthAdaptor adaptor = new KandoraLengthAdaptor(activity, kandoralengthlist);
                binding.kandoraLengthRecycleView.setAdapter(adaptor);


                dialog.dismiss();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void OnClickpenpocket(View view) {

        binding.penPocketRecycleView.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false));
        final CharSequence[] customerarray = activity.getResources().getStringArray(R.array.pen_pocket);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.MyDialogTheme);
        builder.setItems(customerarray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                penpocketlist.add(customerarray[item]);

                PenPocketAdaptor adaptor = new PenPocketAdaptor(activity, penpocketlist);
                binding.penPocketRecycleView.setAdapter(adaptor);

                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();


    }


}
