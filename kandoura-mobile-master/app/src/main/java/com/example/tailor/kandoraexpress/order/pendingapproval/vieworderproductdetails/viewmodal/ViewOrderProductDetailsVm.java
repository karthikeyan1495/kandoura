package com.example.tailor.kandoraexpress.order.pendingapproval.vieworderproductdetails.viewmodal;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.api.APICall;
import com.example.tailor.kandoraexpress.api.APIConfiguration;
import com.example.tailor.kandoraexpress.api.APIErrorHandler;
import com.example.tailor.kandoraexpress.databinding.FragmentOrderproductdetailsBinding;
import com.example.tailor.kandoraexpress.deshboard.adaptor.OrderListViewAdaptor;
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

public class ViewOrderProductDetailsVm {
    Activity activity;

    FragmentOrderproductdetailsBinding binding;
    String  orderId;
    MyProgressDialog myProgressDialog;

    public ViewOrderProductDetailsVm(Activity activity, FragmentOrderproductdetailsBinding binding, String orderId) {
        this.activity = activity;
        this.binding=binding;
        this.orderId=orderId;
        myProgressDialog=new MyProgressDialog();
        orderlistViewApiCall();
    }

    private void orderlistViewApiCall() {


        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);
            APICall api = APIConfiguration.getInstance().createService(APICall.class);
            Observable<Response<OrderItem>> observable = api.orderlistdetailsinfo(orderId, MySession.getInstance(activity).getUser().getToken());
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();
                        Log.e("response_orderInfo",""+responses.code());

                        if (responses.code() == 200) {
                            OrderItem orderItem=responses.body();
                            setUprecycleview(orderItem);

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

    private void setUprecycleview(OrderItem orderItem) {

        binding.orderListId.setText("#"+orderItem.getOrderlistinfo().getIncrement_id());

        binding.orderListMobileNo.setText(orderItem.getOrderlistinfo().getAddresses().get(0).getTelephone());

        binding.orderListDate.setText(orderItem.getOrderlistinfo().getCreated_at());

        binding.orderListName.setText(orderItem.getOrderlistinfo().getAddresses().get(0).getFirstname()+" "+orderItem.getOrderlistinfo().getAddresses().get(0).getLastname());

        binding.orderListAddress.setText(orderItem.getOrderlistinfo().getAddresses().get(0).getStreet()+", "+orderItem.getOrderlistinfo().getAddresses().get(0).getCity()
        +", "+orderItem.getOrderlistinfo().getAddresses().get(0).getCountry_id());

        binding.orderListPayment.setText(orderItem.getOrderlistinfo().getPaymentmethod());

        binding.orderListPrice.setText(orderItem.getOrderlistinfo().getOrder_total()+" AED");

        binding.orderlistProductViewRecycleview.setLayoutManager(new GridLayoutManager(activity,3));

        OrderListViewAdaptor adaptor=new OrderListViewAdaptor(activity,orderItem.getOrderlistinfo().getProductDetails());

        binding.orderlistProductViewRecycleview.setAdapter(adaptor);


    }

    public void OnClickClose(View view) {
        activity.finish();
    }
}
