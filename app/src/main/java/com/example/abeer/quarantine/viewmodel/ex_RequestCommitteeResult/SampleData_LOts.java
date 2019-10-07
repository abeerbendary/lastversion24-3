package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;


public class SampleData_LOts extends BaseObservable {


//     "$id": "4",
//             "Lot_Number": "70",
//             "Lot_Id": 30030,
//             "Item_Name": "عصير بطيخ",
//             "Item_Type_Id": 5,
//             "Item_Type": "منتج"
    String $id;
    String Lot_Number;
    Long Lot_Id;
    String Item_Name;
    int Item_Type_Id;
    String  Item_Type;

    public SampleData_LOts(SampleData_LOts SampleData_LOts) {
        this.$id = SampleData_LOts.$id;
        Lot_Number = SampleData_LOts.Lot_Number;
        this.Lot_Id = SampleData_LOts.Lot_Id;
        Item_Name = SampleData_LOts.Item_Name;
        Item_Type_Id=SampleData_LOts.Item_Type_Id;
        Item_Type=SampleData_LOts.Item_Type;
     notifyPropertyChanged(BR.LOTS);

    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    @Bindable
    public String getLot_Number() {
        return Lot_Number;
    }

    public void setLot_Number(String lot_Number) {
        Lot_Number = lot_Number;
     notifyPropertyChanged(BR.lot_Number);
    }

    public Long getLot_Id() {
        return Lot_Id;
    }

    public void setLot_Id(Long Lot_Id) {
        this.Lot_Id = Lot_Id;
    }

    @Bindable
    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String Item_Name) {

        this.Item_Name = Item_Name;
       // notifyPropertyChanged(BR.Item_Name);
    }

    public int getItem_Type_Id() {
        return Item_Type_Id;
    }

    public void setItem_Type_Id(int item_Type_Id) {
        Item_Type_Id = item_Type_Id;
    }

    public String getItem_Type() {
        return Item_Type;
    }

    public void setItem_Type(String item_Type) {
        Item_Type = item_Type;
    }
}
