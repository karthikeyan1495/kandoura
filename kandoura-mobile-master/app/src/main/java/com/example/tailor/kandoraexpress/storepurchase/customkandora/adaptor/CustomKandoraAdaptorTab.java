package com.example.tailor.kandoraexpress.storepurchase.customkandora.adaptor;

import android.app.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.StorePurchaseFabricsTab;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.StorePurchaseFrontTab;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.StorePurchaseMesurementTab;
import com.example.tailor.kandoraexpress.storepurchase.customkandora.tab.StorePurchasekandoraType;


public class CustomKandoraAdaptorTab  extends FragmentPagerAdapter {

    Activity activity;

    public CustomKandoraAdaptorTab(Activity activity, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.activity=activity;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if(position==0){
            fragment = new StorePurchasekandoraType();

        }else if(position==1){

            fragment = new StorePurchaseFabricsTab();

        }else if(position==2){
            fragment = new StorePurchaseFrontTab();

        }else if(position==3){
            fragment = new StorePurchaseMesurementTab();

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        if(position==0){
            title=activity.getString(R.string.KANDORA_TYPE);
            
        }
        else if(position==1){

            title=activity.getString(R.string.FABRICS);

        }else if(position==2){

            title=activity.getString(R.string.FRONT);

        }else if(position==3){

            title=activity.getString(R.string.MEASUREMENT);
        }

        return title;
    }
}
