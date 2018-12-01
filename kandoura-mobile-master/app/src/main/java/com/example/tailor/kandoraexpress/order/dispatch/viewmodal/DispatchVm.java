package com.example.tailor.kandoraexpress.order.dispatch.viewmodal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.FragmentDispatchtabBinding;
import com.example.tailor.kandoraexpress.order.dispatch.adaptor.DispatchAdaptor;
import com.example.tailor.kandoraexpress.order.modal.OrderItem;
import com.example.tailor.kandoraexpress.order.modal.OrderList;
import com.example.tailor.kandoraexpress.sharedpreferences.MySession;
import com.example.tailor.kandoraexpress.util.InternetChecker;
import com.example.tailor.kandoraexpress.util.MyProgressDialog;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class DispatchVm {

    Activity activity;
    FragmentDispatchtabBinding binding;
    OrderList orderList;
    MyProgressDialog myProgressDialog;

    List<OrderList>orderLists;

    public DispatchVm(Activity activity, FragmentDispatchtabBinding binding) {
        this.activity=activity;
        this.binding=binding;
        myProgressDialog=new MyProgressDialog();
        dispatchApiCall();
    }

    private void dispatchApiCall() {
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
        binding.orderDispatchRecycleview.setLayoutManager(new LinearLayoutManager(activity));
        DispatchAdaptor adaptor=new DispatchAdaptor(activity,orderLists);
        binding.orderDispatchRecycleview.setAdapter(adaptor);
    }
}
