package com.example.tailor.kandoraexpress.products.addproducts;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentAddimagesBinding;
import com.example.tailor.kandoraexpress.products.addproducts.adaptor.ProductImageAdapter;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ImageURI;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ProductModel;
import com.example.tailor.kandoraexpress.products.addproducts.viewmodal.ImageProductFragment;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.List;

import static android.app.Activity.RESULT_OK;


public class AddImageFragment extends Fragment {


    FragmentAddimagesBinding binding;

    ImageProductFragment imageProductFragment;

    public ProductImageAdapter adapter;
    public static final int SELECT_SINGLE_PICTURE = 100;
    public static final int SELECT_MULTIPLE_PICTURE = 200;

    public List<ImageURI> list;
    public ImageURI imageURI;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getActivity() instanceof AddNewProducts) {
            AddNewProducts addProductActivity = (AddNewProducts) getActivity();
            list = addProductActivity.productModel.getImageURIList();
            imageURI = addProductActivity.productModel.getImageURI();
            if (list.size() == 0) {
                list.add(getAddView());
            }
        }
        bindView(inflater, container);
        setRecyclerView();

        return binding.getRoot();
    }

    private ImageURI getAddView() {
        ImageURI imageURI = new ImageURI();
        imageURI.setType(2);
        return imageURI;
    }

    private void setRecyclerView() {

        /*   adapter = new ProductImageAdapter(getActivity(), this, list);*/

        adapter = new ProductImageAdapter(getActivity(), this, list);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.recyclerView.setAdapter(adapter);
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_addimages, container, false);
        imageProductFragment = new ImageProductFragment(getActivity(), binding);
        imageURI = new ImageURI();
        binding.setImageFragmentVm(imageProductFragment);
        binding.setImageuri(imageURI);


        binding.previewImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() instanceof AddNewProducts) {
                    AddNewProducts productActivity = (AddNewProducts) getActivity();
                    ImageValidation(productActivity);

                }

            }
        });


    }

    private void ImageValidation(AddNewProducts addProductActivity) {

      List<ImageURI> list=addProductActivity.productModel.getImageURIList();
        if (list.size()-1 == 0) {
            MySnackBar.getInstance().showNagativeSnackBar(getActivity(), "Please add the image");
        } else {

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.preview_layout, new ProductPreviewFragment()).commit();
        }


    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (data != null) {
                ClipData clipData = data.getClipData();
                if (clipData != null) {
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        Uri uri = item.getUri();
                        ImageURI imageURI = new ImageURI();
                        imageURI.setUri(uri.toString());
                        imageURI.setType(1);
                        imageURI.setImage(true);
                        if (requestCode == SELECT_SINGLE_PICTURE) {
                            this.imageURI = imageURI;
                            setImageURI(this.imageURI);

                            binding.setImageuri(this.imageURI);
                        } else {
                            list.remove(list.size() - 1);
                            list.add(imageURI);
                            list.add(getAddView());
                        }
                    }
                } else {
                    Uri uri = data.getData();
                    ImageURI imageURI = new ImageURI();
                    imageURI.setUri(uri.toString());
                    imageURI.setType(1);
                    imageURI.setImage(true);
                    if (requestCode == SELECT_SINGLE_PICTURE) {
                        this.imageURI = imageURI;
                        setImageURI(this.imageURI);
                        binding.setImageuri(this.imageURI);

                    } else {
                        list.remove(list.size() - 1);
                        list.add(imageURI);
                        list.add(getAddView());
                    }
                }
                setRecyclerView();
            }
        }

    }

    private void setImageURI(ImageURI imageURI) {

        if (getActivity() instanceof AddNewProducts) {
            AddNewProducts addProductActivity = (AddNewProducts) getActivity();
            addProductActivity.productModel.setImageURI(imageURI);

        }
    }


}
