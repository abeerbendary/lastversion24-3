package com.example.abeer.quarantine.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.Plantproductbinding;
import com.example.abeer.quarantine.presenter.ClickCustomItemData_plantproduct;
import com.example.abeer.quarantine.viewmodel.plantProduct.ItemData_PlantProduct;

import java.util.List;


public class AdapterPlantProduct extends RecyclerView.Adapter<AdapterPlantProduct.Holder> {
    List<ItemData_PlantProduct> itemData_plantProduct;
    Context context;
   ClickCustomItemData_plantproduct clickCustomItemData_plantproduct;
    public AdapterPlantProduct(List<ItemData_PlantProduct> itemData_plantProducts, Context context, ClickCustomItemData_plantproduct clickCustomItemData_plantproduct)
    {
        itemData_plantProduct =itemData_plantProducts;
       this.context=context;
     this.clickCustomItemData_plantproduct=clickCustomItemData_plantproduct;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Plantproductbinding plantproductbinding= DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.cardplantproduct,parent,false);
        return new Holder(plantproductbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ItemData_PlantProduct item_plantProduct=itemData_plantProduct.get(position);
        holder.bind(item_plantProduct,clickCustomItemData_plantproduct);
        holder.plantproductbinding.setClicked(clickCustomItemData_plantproduct);
    }

    @Override
    public int getItemCount() {
        return itemData_plantProduct.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        Plantproductbinding plantproductbinding;
        public Holder(@NonNull Plantproductbinding itemView) {
            super(itemView.getRoot());
            this.plantproductbinding=itemView;
        }
        public void bind(Object OBJ,final ClickCustomItemData_plantproduct clickCustom){
            plantproductbinding.setPlantproductItem((ItemData_PlantProduct) OBJ);
            plantproductbinding.executePendingBindings();
        }

    }
}
