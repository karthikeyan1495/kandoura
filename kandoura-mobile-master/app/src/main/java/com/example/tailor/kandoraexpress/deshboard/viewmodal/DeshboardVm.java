package com.example.tailor.kandoraexpress.deshboard.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.FragementDeshboardBinding;
import com.example.tailor.kandoraexpress.home.adaptor.NewOrderAdaptor;
import com.example.tailor.kandoraexpress.home.adaptor.OngoingOrderAdaptor;
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

public class DeshboardVm extends java.util.Observable {

    Activity activity;
    FragementDeshboardBinding binding;
    int clickactionorder = 0;

    int clickactionrevenue = 0;
    MyProgressDialog myProgressDialog;

    List<OrderList> orderList = new ArrayList<>();

    public DeshboardVm(Activity activity, FragementDeshboardBinding binding) {
        this.activity = activity;
        this.binding=binding;
        myProgressDialog = new MyProgressDialog();
        neworderlistAPICall();
        ongoingorderlistAPICall();
    }

    public List<OrderList> getOrderItemList(){
        return orderList;
    }

    private void ongoingorderlistAPICall() {


        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<OrderItem>> observable = api.orderlist("processing", MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {
                            orderList=responses.body().getOrders();
                            setupOngoingorderrecycleview(orderList);
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

    private void setupOngoingorderrecycleview(List<OrderList> orderList) {

        binding.ongoingRecycleview.setLayoutManager(new LinearLayoutManager(activity));

        OngoingOrderAdaptor adaptor=new OngoingOrderAdaptor(activity,orderList,binding);
        binding.ongoingRecycleview.setAdapter(adaptor);

    }

    private void neworderlistAPICall() {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<OrderItem>> observable = api.orderlist("pending", MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        if (responses.code() == 200) {

                            orderList = responses.body().getOrders();

                            setuprecycleView(orderList);

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

    private void setuprecycleView(List<OrderList> orderList) {

        binding.neworderRecycleview.setLayoutManager(new LinearLayoutManager(activity));

       NewOrderAdaptor adaptor = new NewOrderAdaptor(activity,orderList);
        binding.neworderRecycleview.setAdapter(adaptor);

    }


    public void OnClickordertime(View view) {

        if (clickactionorder == 0) {
            binding.alltimeOrders.setText("One Year");
            binding.charts.setVisibility(View.INVISIBLE);
            binding.yearsOrdersCharts.setVisibility(View.VISIBLE);
            clickactionorder++;
        } else {
            binding.alltimeOrders.setText("All Time");
            binding.charts.setVisibility(View.VISIBLE);
            binding.yearsOrdersCharts.setVisibility(View.INVISIBLE);
            clickactionorder = 0;
        }

    }


    public void OnClickrevenue(View view) {

        if (clickactionrevenue == 0) {
            binding.alltimeRevenue.setText("One Year");
            binding.chart.setVisibility(View.INVISIBLE);
            binding.yearRevenueChart.setVisibility(View.VISIBLE);
            clickactionrevenue++;

        } else {
            binding.alltimeRevenue.setText("All Time");
            binding.chart.setVisibility(View.VISIBLE);
            binding.yearRevenueChart.setVisibility(View.INVISIBLE);
            clickactionrevenue = 0;
        }


    }


}
