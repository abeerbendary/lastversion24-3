package com.example.abeer.quarantine.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;

public class ItemLotatData  extends BaseObservable {
    public  String  Lot_Number;
    public  String   Item_number;
    public  String   Package_Count;
    public  String   Net_Weight;
    public  String   Gross_Weight;
    public  String   IsAccepted;
    public  String    Package_Material_Name;
    public  String    Package_Type_Name;
    public  String    tem_number;

////////////////////

    public ItemLotatData() {
    }

    public ItemLotatData(ItemLotatData ItemLotatData) {
        this.Lot_Number = ItemLotatData.Lot_Number;
        this.Item_number=ItemLotatData.Item_number;
        this.Package_Count = ItemLotatData.Package_Count;
        this.Net_Weight = ItemLotatData.Net_Weight;
        this.Gross_Weight = ItemLotatData.Gross_Weight;
        this.IsAccepted = ItemLotatData.IsAccepted;
        this.Package_Material_Name = ItemLotatData.Package_Material_Name;
        this.Package_Type_Name = ItemLotatData.Package_Type_Name;
        this.tem_number = ItemLotatData.tem_number;
    }
    ////////////////
    public ItemLotatData(String lot_Number, String package_Count, String net_Weight, String gross_Weight, String isAccepted, String package_Material_Name, String package_Type_Name, String tem_number) {
        this.Lot_Number = lot_Number;
        this.Package_Count = package_Count;
        this.Net_Weight = net_Weight;
        this.Gross_Weight = gross_Weight;
        this.IsAccepted = isAccepted;
        this.Package_Material_Name = package_Material_Name;
        this.Package_Type_Name = package_Type_Name;
        this.tem_number = tem_number;
    }

    public String getItem_number() {
        return Item_number;
    }

    public void setItem_number(String item_number) {
        Item_number = item_number;
    }

    @Bindable
    public String getLot_Number() {
        return Lot_Number;
    }

    public void setLot_Number(String lot_Number) {
        Lot_Number = lot_Number;
    }
    @Bindable
    public String getPackage_Count() {
        return Package_Count;
    }

    public void setPackage_Count(String package_Count) {
        Package_Count = package_Count;
    }
    @Bindable
    public String getNet_Weight() {
        return Net_Weight;
    }

    public void setNet_Weight(String net_Weight) {
        Net_Weight = net_Weight;
    }
    @Bindable
    public String getGross_Weight() {
        return Gross_Weight;
    }

    public void setGross_Weight(String gross_Weight) {
        Gross_Weight = gross_Weight;
    }
    @Bindable
    public String getIsAccepted() {
        return IsAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        IsAccepted = isAccepted;
    }
    @Bindable
    public String getPackage_Material_Name() {
        return Package_Material_Name;
    }

    public void setPackage_Material_Name(String package_Material_Name) {
        Package_Material_Name = package_Material_Name;
       // notifyPropertyChanged(BR.package_Material_Name);
    }
    @Bindable
    public String getPackage_Type_Name() {
        return Package_Type_Name;
    }

    public void setPackage_Type_Name(String package_Type_Name) {
        Package_Type_Name = package_Type_Name;
    }
    @Bindable
    public String getTem_number() {
        return tem_number;
    }

    public void setTem_number(String tem_number) {
        this.tem_number = tem_number;
    }
}
