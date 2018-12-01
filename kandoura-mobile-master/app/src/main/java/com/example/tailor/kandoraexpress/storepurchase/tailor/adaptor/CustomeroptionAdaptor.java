package com.example.tailor.kandoraexpress.storepurchase.tailor.adaptor;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.databinding.CustomOptionitemAdaptorBinding;
import com.example.tailor.kandoraexpress.products.modal.ItemOption;
import java.util.List;

public class CustomeroptionAdaptor extends RecyclerView.Adapter<CustomeroptionAdaptor.ViewHolder> {

    List<ItemOption>optionsItem;

    Activity activity;

    CharSequence[] customerarray;



    public CustomeroptionAdaptor(Activity activity, List<ItemOption> options) {

        this.activity=activity;
        this.optionsItem=options;

    }

    @Override
    public CustomeroptionAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        CustomOptionitemAdaptorBinding binding= DataBindingUtil.inflate(inflater, R.layout.custom_optionitem_adaptor,parent,false);
        return new CustomeroptionAdaptor.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CustomeroptionAdaptor.ViewHolder holder, int position) {

        ItemOption itemOption=optionsItem.get(position);


        holder.binding.itemOptions.setText(itemOption.getName());


        holder.binding.itemOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                itemoptions(itemOption,holder);
            }
        });

    }

    private void itemoptions(ItemOption itemOption, ViewHolder holder) {


        String [] item = itemOption.getCustom_option_values().split(",", 5);

        String [] values= itemOption.getCustom_option_ids().split(",",5);

        customerarray=item;

     /*  final CharSequence[] customerarray = {itemOption.getCustom_option_values()};*/

        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.MyDialogTheme);
        builder.setItems(customerarray, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                dialog.dismiss();

                holder.binding.itemOptions.setText(customerarray[item]);



              //  Toast.makeText(activity,""+values[item],Toast.LENGTH_LONG).show();


            }
        });
        AlertDialog alert = builder.create();
        alert.show();




    }

    @Override
    public int getItemCount() {
        return optionsItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CustomOptionitemAdaptorBinding binding;

        public ViewHolder(  CustomOptionitemAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
