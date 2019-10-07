package com.example.abeer.quarantine.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


public class ConstraintsData extends BaseObservable {
    public String Item_number;
    public String Item_Type;
    public String  Item_Name;
    public String Item_Cat_Name;
    public String ItemPartTypeName;
    public String  ItemStatus;
    public String ItemPurpose;
    public String Item_ShortName;
    public Object Constrain_Data;
    public Object Lot_Data;
    public ConstraintsData(ConstraintsData constraintsData){
        this.Item_number=constraintsData.Item_number;
        this.Item_Cat_Name   = constraintsData.Item_Cat_Name;
        this.Item_Name  = constraintsData.Item_Name;
        this.Item_Type  =  constraintsData.Item_Type;
        this.ItemPartTypeName = constraintsData.ItemPartTypeName;
        this.ItemPurpose  = constraintsData.ItemPurpose;
        this.ItemStatus =constraintsData.ItemStatus;
        this.Item_ShortName=constraintsData.Item_ShortName;
        this.Constrain_Data=constraintsData.Constrain_Data;
        this.Lot_Data=constraintsData.Lot_Data;

    }

    public void setConstrain_Data(Object constrain_Data) {
        Constrain_Data = constrain_Data;
    }

    public Object getLot_Data() {
        return Lot_Data;
    }

    public void setLot_Data(Object lot_Data) {
        Lot_Data = lot_Data;
    }

    @Bindable
    public String getItem_number() {
        return Item_number;
    }

    public void setItem_number(String item_number) {
        Item_number = item_number;
    }

    @Bindable
    public String getItem_Type() {
        return Item_Type;
    }

    public void setItem_Type(String item_Type) {
        Item_Type = item_Type;
    }
    @Bindable
    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }
    @Bindable
    public String getItem_Cat_Name() {
        return Item_Cat_Name;
    }

    public void setItem_Cat_Name(String item_Cat_Name) {
        Item_Cat_Name = item_Cat_Name;
    }
    @Bindable
    public String getItemPartTypeName() {
        return ItemPartTypeName;
    }

    public void setItemPartTypeName(String itemPartTypeName) {
        ItemPartTypeName = itemPartTypeName;
    }
    @Bindable
    public String getItemStatus() {
        return ItemStatus;
    }

    public void setItemStatus(String itemStatus) {
        ItemStatus = itemStatus;
    }
    @Bindable
    public String getItemPurpose() {
        return ItemPurpose;
    }

    public void setItemPurpose(String itemPurpose) {
        ItemPurpose = itemPurpose;
    }
    @Bindable
    public String getItem_ShortName() {
        return Item_ShortName;
    }

    public void setItem_ShortName(String item_ShortName) {
        Item_ShortName = item_ShortName;
    }
    @Bindable
    public Object getConstrain_Data() {
        return Constrain_Data;
    }

    public void setConstrain_Data(String constrain_Data) {
        Constrain_Data = constrain_Data;
    }
}
