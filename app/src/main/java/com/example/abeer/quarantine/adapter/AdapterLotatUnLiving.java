package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.Lotatlivingbinding;
import com.example.abeer.quarantine.databinding.Lotatunlivingbinding;
import com.example.abeer.quarantine.viewmodel.ItemLotatData;
import com.example.abeer.quarantine.viewmodel.livingobjects.ItemData_LivingObject;

import java.util.ArrayList;
import java.util.List;


public class AdapterLotatUnLiving extends RecyclerView.Adapter<AdapterLotatUnLiving.Holder> {

    List<ItemLotatData> itemData;
    Context context;
    ItemData_LivingObject Isexportcolor;
    public AdapterLotatUnLiving(List<ItemLotatData> itemDatas, Context context, ItemData_LivingObject item) {
        itemData = itemDatas;
        this.context = context;
        Isexportcolor =item;
    }
    public AdapterLotatUnLiving(ArrayList<ItemLotatData> itemDatas, Context context, ItemData_LivingObject item) {
        itemData = itemDatas;
        this.context = context;
        Isexportcolor=item;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Lotatunlivingbinding Lotatunlivingbinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.cardlotatunliving,parent,false);
        return new Holder(Lotatunlivingbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ItemLotatData itemConstrainsData=itemData.get(position);
        holder.bind(itemConstrainsData);
    }

    @Override
    public int getItemCount() {
        return itemData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        Lotatunlivingbinding Lotatunlivingbinding;
        public Holder( Lotatunlivingbinding itemDatadaLotattabinding1) {
            super(itemDatadaLotattabinding1.getRoot());
            this.Lotatunlivingbinding=itemDatadaLotattabinding1;
        }
        public void bind(Object o)
        {
            Lotatunlivingbinding.setDataunliving((ItemLotatData)o);
            Lotatunlivingbinding.setUnLivingObjectItem(Isexportcolor);
        }
    }
}
