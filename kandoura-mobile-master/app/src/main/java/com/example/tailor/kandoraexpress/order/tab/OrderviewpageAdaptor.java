package com.example.tailor.kandoraexpress.order.tab;


import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.order.Inprogress.InProgressTab;
import com.example.tailor.kandoraexpress.order.accepted.AcceptedTab;
import com.example.tailor.kandoraexpress.order.delivery.Deliverytab;
import com.example.tailor.kandoraexpress.order.dispatch.DispatchTab;
import com.example.tailor.kandoraexpress.order.pendingapproval.PendingApprovalTab;

public class OrderviewpageAdaptor extends FragmentPagerAdapter {

    Activity activity;

    public OrderviewpageAdaptor(Activity activity, FragmentManager manager) {
        super(manager);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment;
        if (position == 0) {
            fragment = new PendingApprovalTab();

        } else if (position == 1) {
            fragment = new AcceptedTab();
        } else if (position == 2) {
            fragment = new InProgressTab();
        } else if (position == 3) {
            fragment = new DispatchTab();
        } else {
            fragment = new Deliverytab();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";

        if (position == 0) {
            title = activity.getString(R.string.pending_approval);
        } else if (position == 1) {
            title = activity.getString(R.string.accepted);
        } else if (position == 2) {
            title = activity.getString(R.string.in_progress);
        } else if (position == 3) {
            title = activity.getString(R.string.ready);
        } else {
            title = activity.getString(R.string.delivery);
        }
        return title;
    }
}
