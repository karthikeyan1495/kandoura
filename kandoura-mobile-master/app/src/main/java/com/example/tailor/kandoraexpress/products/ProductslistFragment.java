package com.example.tailor.kandoraexpress.products;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragemntProductlistBinding;
import com.example.tailor.kandoraexpress.products.viewmodal.ProductListVm;

import java.util.Observable;
import java.util.Observer;

public class ProductslistFragment extends Fragment implements Observer {

    FragemntProductlistBinding binding;

    ProductListVm productListVm;

    public ProductslistFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        setUpObserver(productListVm);
        return binding.getRoot();
    }

    private void setUpObserver(Observable observable) {

        observable.addObserver(this);

    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragemnt_productlist,container,false);
        productListVm=new ProductListVm(getActivity(),binding);
        binding.setProductlistVm(productListVm);
    }


    @Override
    public void update(Observable observable, Object object) {

        if(observable instanceof ProductListVm){

        }
    }
}
