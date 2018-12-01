package com.example.tailor.kandoraexpress.products.addproducts;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.api.GeneralResponse;
import com.example.tailor.kandoraexpress.databinding.FragmentPreviewimageBinding;
import com.example.tailor.kandoraexpress.products.addproducts.adaptor.ImagePreviewAdapter;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ImageURI;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;
import com.example.tailor.kandoraexpress.products.addproducts.viewmodal.ProductPreviewVm;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.APIUtil;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class ProductPreviewFragment extends Fragment {

    FragmentPreviewimageBinding bindings;
    ProductPreviewVm productPreviewVM;
    ProductModel productmodel;
    MyProgressDialog myProgressDialog;


    public ProductPreviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bindView(inflater, container);
        return bindings.getRoot();
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_previewimage, container, false);
        productmodel = new ProductModel();
        myProgressDialog = new MyProgressDialog();
        productPreviewVM = new ProductPreviewVm(getActivity(), productmodel);
        bindings.setProductprviewVm(productPreviewVM);
        if (getActivity() instanceof AddNewProducts) {
            AddNewProducts productActivity = (AddNewProducts) getActivity();
            bindings.setProductModel(productActivity.productModel);
            setImageViewPager(productActivity.productModel);
            ///  setproductapicall(productActivity);

        }
        productapicall();

    }

    private void productapicall() {

        bindings.addProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getActivity() instanceof AddNewProducts) {
                    AddNewProducts productActivity = (AddNewProducts) getActivity();
                    setproductapicall(productActivity.productModel);
                }

            }
        });
    }

    private void setproductapicall(ProductModel productModel) {

        addproductAPICall(productModel);

    }

    private void addproductAPICall(ProductModel addproductmodal) {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(getActivity());
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<GeneralResponse>> observable;

            if (addproductmodal.getProductID() == null) {
                observable = api.addproduct(MySession.getInstance(getActivity()).getUser().getToken(), APIUtil.generateAddProduct(getActivity(), addproductmodal));
            } else {
                observable = api.updateProduct(addproductmodal.getProductID(), MySession.getInstance(getActivity()).getUser().getToken(), APIUtil.generateAddProduct(getActivity(), addproductmodal));
            }
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {

                        Log.e("update_products", "" + addproductmodal.getImageURIList().size());

                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {
                            MySnackBar.getInstance().showPositiveSnackBar(getActivity(), responses.body().getMessage());
                            getActivity().finish();

                        } else {
                            if (responses.body() != null) {
                                APIErrorHandler.getInstance().errorHandler(getActivity(), responses.code(), responses.body().getMessage());
                            } else {
                                APIErrorHandler.getInstance().errorHandler(getActivity(), responses.code(), responses.errorBody().string());
                            }
                        }
                    }, throwable -> {
                        myProgressDialog.dismissDialog();
                        MySnackBar.getInstance().showNagativeSnackBar(getActivity(), getActivity().getString(R.string.something_went_wrong_while_retrieving_information));

                    });
        } else {
            MySnackBar.getInstance().showNagativeSnackBar(getActivity(), getActivity().getString(R.string.no_internet));
        }

    }

    private void setImageViewPager(ProductModel productModel) {

        List<ImageURI> list = new ArrayList<>();

        list.addAll(productModel.getImageURIList());
        list.remove(list.size() - 1);

        bindings.sliderPager.setAdapter(new ImagePreviewAdapter(getActivity(), list));
        bindings.sliderIndicator.setViewPager(bindings.sliderPager);
    }
}
