package com.example.abeer.quarantine.viewmodel;

import com.example.abeer.quarantine.BR;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class ItemData extends BaseObservable {
    public String  Item_number;
    public String Item_Type;
    public String  Item_Name;
    public String Item_Cat_Name;
    public String ItemPartTypeName;
    public String  ItemStatus;
    public String ItemPurpose;
    public String Item_ShortName;
    public int IsExport;
    public ItemData(){

    }
    public ItemData(ItemData itemData){
        this.Item_number=itemData.Item_number;
    this.Item_Cat_Name   = itemData.Item_Cat_Name;
     this.Item_Name  = itemData.Item_Name;
    this.Item_Type  =  itemData.Item_Type;
      this.ItemPartTypeName = itemData.ItemPartTypeName;
     this.ItemPurpose  = itemData.ItemPurpose;
    this.ItemStatus =itemData.ItemStatus;
    this.Item_ShortName=itemData.Item_ShortName;
    this.IsExport=itemData.IsExport;
    notifyPropertyChanged(BR.itemm);
    }
@Bindable
    public int getIsExport() {
        return IsExport;
    }

    public void setIsExport(int isExport) {
        IsExport = isExport;
    }

    @Bindable
    public String getItem_ShortName() {
        return Item_ShortName;
    }

    public void setItem_ShortName(String item_ShortName) {
        Item_ShortName = item_ShortName;
        notifyPropertyChanged(BR.item_ShortName);
    }
@Bindable
    public String getItem_Type() {
        return Item_Type;
    }

    public void setItem_Type(String item_Type) {
        Item_Type = item_Type;
        notifyPropertyChanged(BR.item_Type);
    }

    @Bindable
    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
        notifyPropertyChanged(BR.item_Name);
    }
    @Bindable
    public String getItem_Cat_Name() {
        return Item_Cat_Name;
    }

    public void setItem_Cat_Name(String item_Cat_Name) {
        Item_Cat_Name = item_Cat_Name;
       notifyPropertyChanged(BR.item_Cat_Name);
    }
    @Bindable
    public String getItemPartTypeName() {
        return ItemPartTypeName;
    }

    public void setItemPartTypeName(String itemPartTypeName) {
        ItemPartTypeName = itemPartTypeName;
        notifyPropertyChanged(BR.itemPartTypeName);
    }
    @Bindable
    public String getItemStatus() {
        return ItemStatus;
    }

    public void setItemStatus(String itemStatus) {
        ItemStatus = itemStatus;
        notifyPropertyChanged(BR.itemStatus);
    }
    @Bindable
    public String getItemPurpose() {
        return ItemPurpose;
    }

    public void setItemPurpose(String itemPurpose) {
        ItemPurpose = itemPurpose;
        notifyPropertyChanged(BR.itemPurpose);
    }

    @Bindable
    public String getItem_number() {
        return Item_number;
    }

    public void setItem_number(String item_number) {
        Item_number = item_number;
        notifyPropertyChanged(BR.item_number);
    }
}
