package com.example.abeer.quarantine.viewmodel.plantProduct;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;

public class ItemData_PlantProduct extends BaseObservable {
    public String  Item_number;
    public String Item_Type;
    public String  Item_Name;
    public String Item_Cat_Name;
    public String  ItemPartTypeName;
    public String  ItemStatus;
    public String ItemPurpose;

    public ItemData_PlantProduct(String item_number, String item_Type, String item_Name, String item_Cat_Name,String itemPartTypeName, String itemStatus, String itemPurpose) {
        Item_number = item_number;
        Item_Type = item_Type;
        Item_Name = item_Name;
        Item_Cat_Name = item_Cat_Name;
        ItemPartTypeName= itemPartTypeName;
        ItemStatus = itemStatus;
        ItemPurpose = itemPurpose;
    }
    @Bindable
    public String getItemPartTypeName() {
        return ItemPartTypeName;
    }

    public void setItemPartTypeName(String itemPartTypeName) {
        ItemPartTypeName = itemPartTypeName;
    }

    @Bindable
    public String getItem_number() {
        return Item_number;
    }

    public void setItem_number(String item_number) {
        Item_number = item_number;
      //  notifyPropertyChanged(BR.itemmplant);
    }
    @Bindable
    public String getItem_Type() {
        return Item_Type;
    }

    public void setItem_Type(String item_Type) {
        Item_Type = item_Type;
      //  notifyPropertyChanged(BR.itemmplant);
    }
    @Bindable
    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
       // notifyPropertyChanged(BR.itemmplant);
    }
    @Bindable
    public String getItem_Cat_Name() {
        return Item_Cat_Name;
    }

    public void setItem_Cat_Name(String item_Cat_Name) {
        Item_Cat_Name = item_Cat_Name;
       // notifyPropertyChanged(BR.itemmplant);

    }
    @Bindable
    public String getItemStatus() {
        return ItemStatus;
    }

    public void setItemStatus(String itemStatus) {
        ItemStatus = itemStatus;
     //   notifyPropertyChanged(BR.itemmplant);
    }
    @Bindable
    public String getItemPurpose() {
        return ItemPurpose;
    }

    public void setItemPurpose(String itemPurpose) {
        ItemPurpose = itemPurpose;
      //  notifyPropertyChanged(BR.itemmplant);
    }
}
