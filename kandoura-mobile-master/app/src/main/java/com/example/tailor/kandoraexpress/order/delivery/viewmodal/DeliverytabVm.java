package com.example.tailor.kandoraexpress.order.delivery.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.FragmentDeliverytabBinding;
import com.example.tailor.kandoraexpress.order.delivery.adaptor.DeliveryAdaptor;
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

public class DeliverytabVm {
    Activity activity;
    FragmentDeliverytabBinding binding;
    MyProgressDialog myProgressDialog;
    List<OrderList>orderLists=new ArrayList<>();
    public DeliverytabVm(Activity activity, FragmentDeliverytabBinding binding) {

        this.activity=activity;
        this.binding=binding;
        myProgressDialog=new MyProgressDialog();
        deliveryApiCall();

    }

    private void deliveryApiCall() {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<OrderItem>> observable = api.orderlist("dispatch", MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        Log.e("order_listcode:", "" + responses.code());
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            orderLists=responses.body().getOrders();
                            setUpreycleView(orderLists);

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

    private void setUpreycleView(List<OrderList> orderLists) {

        binding.orderDeletedRecycleview.setLayoutManager(new LinearLayoutManager(activity));
        DeliveryAdaptor deliveryAdaptor=new DeliveryAdaptor(activity, orderLists);
        binding.orderDeletedRecycleview.setAdapter(deliveryAdaptor);
    }
}
