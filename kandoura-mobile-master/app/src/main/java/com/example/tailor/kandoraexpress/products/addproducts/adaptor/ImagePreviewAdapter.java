package com.example.tailor.kandoraexpress.products.addproducts.adaptor;

import android.app.Activity;

import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ImagePreviewItemBinding;
import com.example.tailor.kandoraexpress.products.addproducts.modal.ImageURI;
import com.example.tailor.kandoraexpress.products.addproducts.viewmodal.ImagePreviewItemVM;

import java.util.List;


public class ImagePreviewAdapter extends PagerAdapter {

    private List<ImageURI> images;
    private LayoutInflater inflater;
    private Activity activity;

    public ImagePreviewAdapter(Activity activity, List<ImageURI> images) {
        this.activity = activity;
        this.images = images;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {


        ImagePreviewItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.image_preview_item, view, false);
        binding.setImagePreviewItemVM(new ImagePreviewItemVM(activity));
        binding.setImageURI(images.get(position));
        view.addView(binding.getRoot(), 0);
        return binding.getRoot();

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }
}