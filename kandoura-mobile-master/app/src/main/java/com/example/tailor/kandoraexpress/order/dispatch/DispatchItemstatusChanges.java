package com.example.tailor.kandoraexpress.order.dispatch;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.api.GeneralResponse;
import com.example.tailor.kandoraexpress.order.modal.OrderList;
import com.example.tailor.kandoraexpress.order.pendingapproval.vieworderproductdetails.ViewOrderProductDetail;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class DispatchItemstatusChanges extends java.util.Observable {
    Activity activity;
    OrderList orderList;

    MyProgressDialog myProgressDialog;

    public DispatchItemstatusChanges(Activity activity, OrderList orderList) {
        this.activity = activity;
        this.orderList = orderList;
        myProgressDialog = new MyProgressDialog();

    }

    public void OnClickstatuschanges(View view) {


        final PopupMenu popupMenu = new PopupMenu(activity, view);

        popupMenu.getMenuInflater().inflate(R.menu.dispatchtab, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int id = item.getItemId();

                if (R.id.dispatch == id) {
                    popupMenu.dismiss();
                } else {
                    updateAPICall(orderList.getOrder_id(), "complete");
                    popupMenu.dismiss();
                }

                return true;
            }
        });

        popupMenu.show();
    }

    private void updateAPICall(String order_id, String processing) {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<GeneralResponse>> observable = api.orderststuschange(order_id, processing, MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();

                        if (responses.code() == 200) {
                            MySnackBar.getInstance().showPositiveSnackBar(activity, responses.body().getMessage());
                            setChanged();
                            notifyObservers(orderList);


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

    public void OnClickorderinfo(View view){

        activity.startActivity(new Intent(activity, ViewOrderProductDetail.class).putExtra("orderId",orderList.getOrder_id()));
    }
}
