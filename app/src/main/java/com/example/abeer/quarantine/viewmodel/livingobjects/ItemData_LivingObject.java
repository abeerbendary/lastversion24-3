package com.example.abeer.quarantine.viewmodel.livingobjects;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


public class ItemData_LivingObject extends BaseObservable {

    public String  Item_number;
    public String  Item_Name;
    public String Item_Type;
    public String Item_Cat_Name;
    public String  ItemPartTypeName;
    public String  ItemStatus;
    public String ItemPurpose;
    public String Item_ShortName;
    public String  Item_Strain;
   public int IsExport;

    @Bindable
    public String getItem_number() {
        return Item_number;
    }
@Bindable
    public int getIsExport() {
        return IsExport;
    }

    public void setIsExport(int isExport) {
        IsExport = isExport;
    }

    @Bindable
    public String getItem_Strain() {
        return Item_Strain;
    }
    public void setItem_number(String item_number) {
        Item_number = item_number;
    }
    @Bindable
    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }
    @Bindable
    public String getItem_Type() {
        return Item_Type;
    }

    public void setItem_Type(String item_Type) {
        Item_Type = item_Type;
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

    public void setItem_Strain(String item_Strain) {
        Item_Strain = item_Strain;
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
}
