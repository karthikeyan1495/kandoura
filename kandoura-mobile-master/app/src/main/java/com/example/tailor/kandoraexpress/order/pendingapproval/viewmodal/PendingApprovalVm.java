package com.example.tailor.kandoraexpress.order.pendingapproval.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.FragemntpendingapprovalBinding;
import com.example.tailor.kandoraexpress.order.adaptor.OrderAdaptor;
import com.example.tailor.kandoraexpress.order.modal.OrderItem;
import com.example.tailor.kandoraexpress.order.modal.OrderList;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class PendingApprovalVm {

    Activity activity;
    FragemntpendingapprovalBinding binding;
    MyProgressDialog myProgressDialog;
    List<OrderList> orderLists = new ArrayList<>();

    public PendingApprovalVm(Activity activity, FragemntpendingapprovalBinding binding) {
        this.activity = activity;
        this.binding = binding;
        myProgressDialog = new MyProgressDialog();
        pendingAPICall();

    }

    private void setUprecycleView(List<OrderList> orderLists) {

        binding.orderpendingRecycleview.setLayoutManager(new LinearLayoutManager(activity));
        OrderAdaptor orderFragment = new OrderAdaptor(activity, orderLists);
        binding.orderpendingRecycleview.setAdapter(orderFragment);

    }

    private void pendingAPICall() {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<OrderItem>> observable = api.orderlist("pending", MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();

                        Log.e("pending_order_tab", "" + responses.code());
                        if (responses.code() == 200) {

                            orderLists = responses.body().getOrders();
                            setUprecycleView(orderLists);

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

}
