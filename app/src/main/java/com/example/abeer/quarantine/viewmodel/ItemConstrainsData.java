package com.example.abeer.quarantine.viewmodel;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;

public class ItemConstrainsData extends BaseObservable {
    public String  Item_number;
    public float count_all;
    public String ConstrainText_Ar;
    public float IsTreatment;
    public String CountryConstrain_Type;
    public String union_Name;
    public float ConstrainOwner_ID;
    public float IsAnalysis;

    public ItemConstrainsData(String constrainText_Ar) {
        this.ConstrainText_Ar = constrainText_Ar;
    }

    public ItemConstrainsData(ItemConstrainsData itemConstrainsData) {
        this.count_all = itemConstrainsData.count_all;
        this.Item_number=itemConstrainsData.Item_number;
        this.ConstrainText_Ar = itemConstrainsData.ConstrainText_Ar;
        this.IsTreatment = itemConstrainsData.IsTreatment;
        this.CountryConstrain_Type = itemConstrainsData.CountryConstrain_Type;
        this.union_Name = itemConstrainsData.union_Name;
        this.ConstrainOwner_ID = itemConstrainsData.ConstrainOwner_ID;
        this.IsAnalysis = itemConstrainsData.IsAnalysis;
        notifyPropertyChanged(BR.detailItemDataList2);

    }

    @Bindable
    public String getItem_number() {
        return Item_number;
    }

    public void setItem_number(String item_number) {
        Item_number = item_number;
    }

    @Bindable
    public float getCount_all() {
        return count_all;
    }

    public void setCount_all(float count_all) {
        this.count_all = count_all;
    }
    @Bindable
    public String getConstrainText_Ar() {
        return ConstrainText_Ar;
    }

    public void setConstrainText_Ar(String constrainText_Ar) {
        ConstrainText_Ar = constrainText_Ar;
        notifyPropertyChanged(BR.constrainText_Ar);
    }

    public float isTreatment() {
        return IsTreatment;
    }

    public void setTreatment(float treatment) {
        IsTreatment = treatment;
    }
    @Bindable
    public String getCountryConstrain_Type() {
        return CountryConstrain_Type;
    }

    public void setCountryConstrain_Type(String countryConstrain_Type) {
        CountryConstrain_Type = countryConstrain_Type;
    }
    @Bindable
    public String getUnion_Name() {
        return union_Name;
    }

    public void setUnion_Name(String union_Name) {
        this.union_Name = union_Name;
    }
    @Bindable
    public float getConstrainOwner_ID() {
        return ConstrainOwner_ID;
    }

    public void setConstrainOwner_ID(float constrainOwner_ID) {
        ConstrainOwner_ID = constrainOwner_ID;
    }
    public float isAnalysis() {
        return IsAnalysis;
    }

    public void setAnalysis(float analysis) {
        IsAnalysis = analysis;
    }
}
