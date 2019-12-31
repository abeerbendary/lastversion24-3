package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.LivingObjectsbinding;
import com.example.abeer.quarantine.presenter.ClicikItemLiving;
import com.example.abeer.quarantine.viewmodel.livingobjects.ItemData_LivingObject;

import java.util.List;




public class AdapterLivingObjects extends RecyclerView.Adapter<AdapterLivingObjects.Holder>  {

    List<ItemData_LivingObject> itemData_livingObject;
    Context context;
    ClicikItemLiving clickLivingObjects;
    public AdapterLivingObjects( List<ItemData_LivingObject>  itemData_livingObjects, Context context, ClicikItemLiving clickLivingObject) {
        itemData_livingObject = itemData_livingObjects;
        this.context = context;
        this.clickLivingObjects = clickLivingObject;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LivingObjectsbinding livingObjectsbinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.cardlivingobject,parent,false);
        return new Holder(livingObjectsbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ItemData_LivingObject livingObject=itemData_livingObject.get(position);
        holder.bind(livingObject,clickLivingObjects);
        holder.livingObjectsbinding.setClickkks(clickLivingObjects);
    }

    @Override
    public int getItemCount() {
        return itemData_livingObject.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        LivingObjectsbinding livingObjectsbinding;

        public Holder(@NonNull LivingObjectsbinding livingObjectsbinding) {
            super(livingObjectsbinding.getRoot() );
            this.livingObjectsbinding=livingObjectsbinding;
        }

        public void bind(Object OBJ,final ClicikItemLiving clickLivingObjectss){
            livingObjectsbinding.setLivingObjectItem((ItemData_LivingObject) OBJ);
            livingObjectsbinding.executePendingBindings();
        }

    }
}
