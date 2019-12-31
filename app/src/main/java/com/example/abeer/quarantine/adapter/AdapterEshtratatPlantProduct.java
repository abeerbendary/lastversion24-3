package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.PlantProductDatatabinding;
import com.example.abeer.quarantine.viewmodel.ItemConstrainsData;
import com.example.abeer.quarantine.viewmodel.ItemData;
import com.example.abeer.quarantine.viewmodel.plantProduct.ItemData_PlantProduct;

import java.util.ArrayList;
import java.util.List;
public class AdapterEshtratatPlantProduct extends RecyclerView.Adapter<AdapterEshtratatPlantProduct.Holder>  {
    List<ItemConstrainsData> itemData;
    Context context;
    ItemData_PlantProduct Isexportcolor;
    public AdapterEshtratatPlantProduct(List<ItemConstrainsData> itemDatas, Context context,ItemData_PlantProduct fullitem) {
        itemData = itemDatas;
        this.context = context;
        this.Isexportcolor=fullitem;
    }
    public AdapterEshtratatPlantProduct(ArrayList<ItemConstrainsData> itemDatas, Context context,ItemData_PlantProduct fullitem) {
        itemData = itemDatas;
        this.context = context;
        this.Isexportcolor=fullitem;
    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlantProductDatatabinding plantProductDatatabinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.cardeshtratatplant,parent,false);
        return new Holder(plantProductDatatabinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ItemConstrainsData itemConstrainsData=itemData.get(position);
        holder.bind(itemConstrainsData);
    }

    @Override
    public int getItemCount()
    {
        return itemData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        PlantProductDatatabinding plantProductDatatabinding;
        public Holder(PlantProductDatatabinding plantProductDatatabinding) {
            super(plantProductDatatabinding.getRoot());
            this.plantProductDatatabinding=plantProductDatatabinding;
        }

        public void bind(Object o) {
            plantProductDatatabinding.setDetailItemPlantList2((ItemConstrainsData)o);
            plantProductDatatabinding.setPlantproductItem(Isexportcolor);

        }
    }
}