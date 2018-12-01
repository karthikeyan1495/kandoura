package com.example.tailor.kandoraexpress.CRM.adaptor;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.tailor.kandoraexpress.CRM.CustomerListVm;
import com.example.tailor.kandoraexpress.CRM.modal.CustomerList;
import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.CrmadaptorBinding;

import java.util.List;

public class CRMAdaptor extends RecyclerView.Adapter<CRMAdaptor.ViewHolder> {

    Activity activity;
    List<CustomerList> customerList;
    public CRMAdaptor(Activity activity, List<CustomerList> customerLists) {

        this.activity=activity;
        this.customerList=customerLists;

    }

    @Override
    public CRMAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CrmadaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.crmadaptor, parent, false);

        return new CRMAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CRMAdaptor.ViewHolder holder, int position) {

        holder.bind(customerList.get(position));
        CustomerList list=customerList.get(position);
        holder.binding.crmcity.setText(list.getCity());
        holder.binding.custId.setText(list.getParent_id());
        holder.binding.crmcustomerName.setText(list.getFirstname()+" "+list.getLastname());
        holder.binding.crmcontactNo.setText(list.getTelephone());



    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CrmadaptorBinding binding;

        public ViewHolder(CrmadaptorBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        public void bind(CustomerList customerList) {

            binding.setCustomerlistVm(new CustomerListVm(activity,customerList));

        }
    }
}
