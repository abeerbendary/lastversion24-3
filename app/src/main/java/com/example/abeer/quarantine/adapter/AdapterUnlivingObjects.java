package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.LivingObjectsbinding;
import com.example.abeer.quarantine.databinding.UnLivingObjectsbinding;
import com.example.abeer.quarantine.presenter.ClicikItemLiving;
import com.example.abeer.quarantine.presenter.ClickItemUnliving;
import com.example.abeer.quarantine.viewmodel.livingobjects.ItemData_LivingObject;

import java.util.List;

public class AdapterUnlivingObjects extends RecyclerView.Adapter<AdapterUnlivingObjects.Holder> {
    List<ItemData_LivingObject> itemData_livingObject;
    Context context;
 ClickItemUnliving clickItemUnliving;
    public AdapterUnlivingObjects( List<ItemData_LivingObject>  itemData_livingObjects, Context context, ClickItemUnliving clickItemUnlivings) {
        itemData_livingObject = itemData_livingObjects;
        this.context = context;
        this.clickItemUnliving = clickItemUnlivings;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UnLivingObjectsbinding unlivingObjectsbinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.cardunlivingobject,parent,false);
        return new Holder(unlivingObjectsbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ItemData_LivingObject livingObject=itemData_livingObject.get(position);
        holder.bind(livingObject,clickItemUnliving);
        holder.unLivingObjectsbinding.setClickun(clickItemUnliving);
    }

    @Override
    public int getItemCount() {
        return itemData_livingObject.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        UnLivingObjectsbinding unLivingObjectsbinding;
        public Holder(@NonNull UnLivingObjectsbinding unLivingObjectsbinding1) {
            super(unLivingObjectsbinding1.getRoot());
            this.unLivingObjectsbinding=unLivingObjectsbinding1;
        }

        public void bind(Object OBJ,final ClickItemUnliving clickunLivingObjectss){
            unLivingObjectsbinding.setUnLivingObjectItem((ItemData_LivingObject) OBJ);
            unLivingObjectsbinding.executePendingBindings();
        }
    }
}
