package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.LivingDatatabinding;
import com.example.abeer.quarantine.viewmodel.ItemConstrainsData;
import com.example.abeer.quarantine.viewmodel.livingobjects.ItemData_LivingObject;

import java.util.ArrayList;
import java.util.List;
public class AdapterEshtratatObjectliving  extends RecyclerView.Adapter<AdapterEshtratatObjectliving.Holder> {
    List<ItemConstrainsData> itemData;
    Context context;
    ItemData_LivingObject Isexportcolor;

    public AdapterEshtratatObjectliving(List<ItemConstrainsData> itemDatas, Context context,ItemData_LivingObject item) {
        itemData = itemDatas;
        this.context = context;
        Isexportcolor=item;
    }
    public AdapterEshtratatObjectliving(ArrayList<ItemConstrainsData> itemDatas, Context context,ItemData_LivingObject item) {
        itemData = itemDatas;
        this.context = context;
        Isexportcolor=item;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LivingDatatabinding  livingDatatabinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.cardeshtratatlivingobjects,parent,false);
        return new AdapterEshtratatObjectliving.Holder(livingDatatabinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ItemConstrainsData itemConstrainsData=itemData.get(position);
        holder.bind(itemConstrainsData);
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        LivingDatatabinding livingDatas;

        public Holder( LivingDatatabinding livingData) {
            super(livingData.getRoot());
            this.livingDatas=livingData;
        }
        public void bind(Object o) {
            livingDatas.setSetDetailItem((ItemConstrainsData)o);
            livingDatas.setLivingObjectItem(Isexportcolor);


        }
    }
}
