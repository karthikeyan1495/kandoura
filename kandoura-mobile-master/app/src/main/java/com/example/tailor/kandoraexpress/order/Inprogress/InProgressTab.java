package com.example.tailor.kandoraexpress.order.Inprogress;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragmentorderInprogresstabBinding;
import com.example.tailor.kandoraexpress.order.Inprogress.adaptor.InprogrssAdaptor;
import com.example.tailor.kandoraexpress.order.Inprogress.viewmodal.InProgrssTabVm;
import com.example.tailor.kandoraexpress.order.OrderStatus;
import com.example.tailor.kandoraexpress.order.modal.OrderItem;
import com.example.tailor.kandoraexpress.order.modal.OrderList;

import java.util.ArrayList;
import java.util.List;

public class InProgressTab extends Fragment  {


    FragmentorderInprogresstabBinding binding;

    InProgrssTabVm inProgrssTabVm;
    List<OrderItem> orderItemList=new ArrayList<>();

    public InProgressTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindView(inflater, container);
        return binding.getRoot();
    }

    private void setUprecycleview() {
/*

        InprogrssAdaptor inprogrssAdaptor=new InprogrssAdaptor(getActivity(), OrderStatus.PROCESSING);
        binding.inProgressRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.inProgressRecycleView.setAdapter(inprogrssAdaptor);
*/

    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding= DataBindingUtil.inflate(inflater, R.layout.fragmentorder_inprogresstab, container, false);
        inProgrssTabVm=new InProgrssTabVm(getActivity(),binding);
        binding.setInprogresVm(inProgrssTabVm);


    }

}
