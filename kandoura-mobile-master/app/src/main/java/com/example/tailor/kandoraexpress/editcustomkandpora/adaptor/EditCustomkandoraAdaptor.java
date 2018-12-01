package com.example.tailor.kandoraexpress.editcustomkandpora.adaptor;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityEditcustomkandoraBinding;
import com.example.tailor.kandoraexpress.editcustomkandpora.ActivityEditCustomKandora;
import com.example.tailor.kandoraexpress.editcustomkandpora.tab.EditFabricsTab;
import com.example.tailor.kandoraexpress.editcustomkandpora.tab.EditFrontTab;
import com.example.tailor.kandoraexpress.editcustomkandpora.tab.EditKandoratypeTab;

public class EditCustomkandoraAdaptor extends FragmentPagerAdapter {

    Activity activity;

    public EditCustomkandoraAdaptor(Activity activity, FragmentManager fm, ActivityEditcustomkandoraBinding binding) {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if (position == 0) {
            fragment = new EditKandoratypeTab();
        } else if (position == 1) {
            fragment = new EditFabricsTab();
        } else {
            fragment = new EditFrontTab();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";

        if (position == 0) {
            title = activity.getString(R.string.KANDORA_TYPE);
        } else if (position == 1) {
            title = activity.getString(R.string.FABRICS);
        }  else {
            title = activity.getString(R.string.FRONT);
        }
        return title;
    }


}
