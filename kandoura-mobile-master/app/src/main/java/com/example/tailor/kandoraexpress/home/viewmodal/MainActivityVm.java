package com.example.tailor.kandoraexpress.home.viewmodal;


import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.ActivityMainBinding;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.user.ActivityEditprofile;
import com.example.tailor.kandoraexpress.user.login.ActivityLogin;

public class MainActivityVm {

    ActivityMainBinding binding;

    Activity activity;

    public MainActivityVm(Activity activity, ActivityMainBinding binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public void OnClickprofile(View view) {

        final PopupMenu popupMenu = new PopupMenu(activity, view);

        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int id = item.getItemId();

                if (R.id.editprofile == id) {

                    activity.startActivity(new Intent(activity, ActivityEditprofile.class));
                    popupMenu.dismiss();

                } else {

                    MySession.getInstance(activity).clearUserData();
                    activity.startActivity(new Intent(activity, ActivityLogin.class));
                    popupMenu.dismiss();

                }

                return true;
            }
        });

        popupMenu.show();

    }


}
