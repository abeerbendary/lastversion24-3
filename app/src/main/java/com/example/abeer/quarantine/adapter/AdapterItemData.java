package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.CheckRequestdatabinding;
import com.example.abeer.quarantine.databinding.ItemDatadatabinding;
import com.example.abeer.quarantine.presenter.ClickCustomItemData;
import com.example.abeer.quarantine.viewmodel.ItemData;

import java.util.ArrayList;
import java.util.List;


public class AdapterItemData extends RecyclerView.Adapter<AdapterItemData.Holder>  {

    List<ItemData> itemData=new ArrayList<>();

    Context context;
    ClickCustomItemData clickCustomItemData;
    public AdapterItemData(List<ItemData> itemDatas, Context context, ClickCustomItemData clickCustomItemData) {
        itemData = itemDatas;
        this.context = context;
        this.clickCustomItemData = clickCustomItemData;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDatadatabinding  itemDatadatabinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),R.layout.card,parent,false);
        return new Holder(itemDatadatabinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ItemData i=itemData.get(position);
        holder.bind(i,clickCustomItemData);
        holder.itemDatadatabinding.setClicked(clickCustomItemData);
    }

//    @NonNull
    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ItemDatadatabinding itemDatadatabinding;
        public Holder(@NonNull ItemDatadatabinding itemDatadatabinding) {
            super(itemDatadatabinding.getRoot());
            this.itemDatadatabinding =itemDatadatabinding;

        }

        public void bind(Object OBJ,final ClickCustomItemData clickCustomItemData){
            itemDatadatabinding.setPlantItem((ItemData) OBJ);
            itemDatadatabinding.executePendingBindings();
        }
    }
//    List<ItemData> itemData;
//    Context context;
//    ClickCustomItemData clickCustomItemData;
//
//    public AdapterItemData(List<ItemData> itemDatas, Context context, ClickCustomItemData clickCustomItemData) {
//        itemData = itemDatas;
//        this.context = context;
//        this.clickCustomItemData = clickCustomItemData;
//    }
//    @NonNull
//    @Override
//    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ItemDatadatabinding  itemDatadatabinding= DataBindingUtil.inflate(
//                LayoutInflater.from(parent.getContext()),R.layout.card,parent,false);
//        return new Holder(itemDatadatabinding);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull Holder holder, int position) {
//
//        ItemData i=itemData.get(position);
//            holder.bind(i,clickCustomItemData);
//            holder.itemDatadatabinding.setClicked(clickCustomItemData);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemData.size();
//    }
//
//    public class Holder extends RecyclerView.ViewHolder {
//        ItemDatadatabinding itemDatadatabinding;
//        public Holder(@NonNull ItemDatadatabinding itemDatadatabinding) {
//            super(itemDatadatabinding.getRoot());
//           this.itemDatadatabinding =itemDatadatabinding;
//
//        }
//
//        public void bind(Object OBJ,final ClickCustomItemData clickCustomItemData){
//            itemDatadatabinding.setPlantItem((ItemData) OBJ);
//            itemDatadatabinding.executePendingBindings();
//        }
//    }
}
