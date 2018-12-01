package com.example.tailor.kandoraexpress.deshboard;


import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.FragementDeshboardBinding;
import com.example.tailor.kandoraexpress.deshboard.viewmodal.DeshboardVm;
import com.example.tailor.kandoraexpress.home.adaptor.OngoingOrderAdaptor;
import com.example.tailor.kandoraexpress.order.OrderFragment;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class DeshboardFragment extends Fragment implements Observer {

    FragementDeshboardBinding binding;
    DeshboardVm deshboardVm;


    ArrayList<String> xaxis = new ArrayList<String>();
    ArrayList<Entry> yaxis = new ArrayList<Entry>();

    ArrayList<String> xaxisrevenue = new ArrayList<>();
    ArrayList<Entry> yaxixsrevenue = new ArrayList<>();

    ArrayList<ILineDataSet> lineDataSets = new ArrayList<ILineDataSet>();

    ArrayList<ILineDataSet> listrevenue = new ArrayList<>();

    OngoingOrderAdaptor ongoingOrderAdaptor;


    public DeshboardFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bindView(inflater, container);
      //  setrecycleview();
        setUpObserver(deshboardVm);
        return binding.getRoot();
    }

    private void setUpObserver(Observable observable) {
        observable.addObserver(this);
    }

    private void bindView(LayoutInflater inflater, ViewGroup container) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragement_deshboard, container, false);
        deshboardVm = new DeshboardVm(getActivity(),binding);
        binding.setDeshboardVm(deshboardVm);

        binding.acceptReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.deshboard_layout, new OrderFragment()).commit();

            }
        });

        chart();
        performanceyear();
    }

    private void performanceyear() {

        xaxisrevenue.add("2016");
        xaxisrevenue.add("2017");
        xaxisrevenue.add("2018");
        xaxisrevenue.add("2019");


        yaxixsrevenue.add(new Entry(25, 0));
        yaxixsrevenue.add(new Entry(50, 1));
        yaxixsrevenue.add(new Entry(75, 2));
        yaxixsrevenue.add(new Entry(100, 3));


        LineDataSet dataset = new LineDataSet(yaxixsrevenue, "");
        dataset.setDrawCircles(true);

        listrevenue.add(dataset);
        dataset.setLineWidth(3f);
        dataset.setCircleRadius(5f);
        dataset.setDrawFilled(true);

        LineData lineDataSe = new LineData(xaxisrevenue, dataset);

        YAxis rightYAxis = binding.yearRevenueChart.getAxisRight();
        rightYAxis.setEnabled(false);

        YAxis rightYAxis1 = binding.yearsOrdersCharts.getAxisRight();
        rightYAxis1.setEnabled(false);

        lineDataSe.setDrawValues(false);

        binding.yearRevenueChart.getXAxis().setDrawGridLines(false);
        binding.yearRevenueChart.setData(lineDataSe);

        binding.yearsOrdersCharts.getXAxis().setDrawGridLines(false);

        binding.yearsOrdersCharts.setData(lineDataSe);


        //years order performance chart

        binding.yearsOrdersCharts.getXAxis().setDrawGridLines(false);
        binding.yearsOrdersCharts.setData(lineDataSe);


        Legend l = binding.yearRevenueChart.getLegend();
        l.setForm(Legend.LegendForm.LINE);

        Legend legend = binding.yearsOrdersCharts.getLegend();
        legend.setForm(Legend.LegendForm.LINE);

        binding.yearRevenueChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        binding.yearsOrdersCharts.setData(lineDataSe);


    }

    private void chart() {
        xaxis.add("Jan");
        xaxis.add("Feb");
        xaxis.add("Mar");
        xaxis.add("Apr");
       /* xaxis.add("May");
        xaxis.add("Jun");
        xaxis.add("Jul");
        xaxis.add("Aug");
        xaxis.add("Sep");
        xaxis.add("Oct");
        xaxis.add("Nov");
        xaxis.add("Dec");*/


        yaxis.add(new Entry(10, 0));
        yaxis.add(new Entry(20, 1));
        yaxis.add(new Entry(35, 2));
        yaxis.add(new Entry(40, 3));


        LineDataSet lineDataSet = new LineDataSet(yaxis, "");
        lineDataSet.setDrawCircles(true);

        lineDataSets.add(lineDataSet);
        lineDataSet.setLineWidth(3f);
        lineDataSet.setCircleRadius(5f);
        lineDataSet.setDrawFilled(true);

        LineData lineDataSet1 = new LineData(xaxis, lineDataSets);

        //point values hide
        lineDataSet1.setDrawValues(false);

        binding.chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);


        binding.chart.setVisibleXRangeMaximum(13);

        YAxis rightYAxis = binding.chart.getAxisRight();
        rightYAxis.setEnabled(false);

        /*XAxis xAxis=binding.chart.getXAxis();
        xAxis.setDrawGridLines(false);


*/

        binding.chart.getXAxis().setDrawGridLines(false);
        binding.chart.setData(lineDataSet1);
        binding.charts.getXAxis().setDrawGridLines(false);
        binding.charts.setData(lineDataSet1);


        Legend l = binding.chart.getLegend();
        l.setForm(Legend.LegendForm.LINE);


        binding.charts.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        binding.yearsOrdersCharts.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis right = binding.charts.getAxisRight();
        right.setEnabled(false);

        binding.charts.setData(lineDataSet1);

        Legend l2 = binding.charts.getLegend();

        l2.setForm(Legend.LegendForm.LINE);


    }

    private void setrecycleview() {

  /*     binding.neworderRecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));

        adaptor = new NewOrderAdaptor(getActivity());
        binding.neworderRecycleview.setAdapter(adaptor);*/

     /*  binding.ongoingRecycleview.setLayoutManager(new LinearLayoutManager(getActivity()));

       ongoingOrderAdaptor = new OngoingOrderAdaptor(getActivity());
        binding.ongoingRecycleview.setAdapter(ongoingOrderAdaptor);*/

    }

    @Override
    public void update(Observable observable, Object object) {

        if(observable instanceof DeshboardVm) {
            //ongoingOrderAdaptor.setData(deshboardVm.getOrderItemList());
        }
    }
}
