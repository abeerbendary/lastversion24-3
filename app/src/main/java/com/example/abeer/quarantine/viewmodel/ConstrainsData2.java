package com.example.abeer.quarantine.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;

import java.util.ArrayList;


public class ConstrainsData2  extends BaseObservable {

    public ArrayList<ConstraintsData> _x0040_Item_Data=new ArrayList<>();



    public  ConstrainsData2(ConstrainsData2 constrainsData2){
        this._x0040_Item_Data=constrainsData2._x0040_Item_Data;
    }
    @Bindable
    public Object getList_Constrain_Dataa() {
        return _x0040_Item_Data.get(0).Constrain_Data; }

    @Bindable
    public ArrayList<Object> getList_Constrain_Data()
    {
        ArrayList<Object>  arrayList=new ArrayList<>();
        for(int i=0;i<_x0040_Item_Data.size();i++) {
            arrayList.add(_x0040_Item_Data.get(i).Constrain_Data);

        }
        return arrayList;

    }

    @Bindable
    public ArrayList<Object> getList_Lotat_Data()
    {
        ArrayList<Object>arrayList=new ArrayList<>();

        for(int i=0;i<_x0040_Item_Data.size();i++)
        {

            if(_x0040_Item_Data.get(i).Lot_Data!=null)
            {

                arrayList.add(_x0040_Item_Data.get(i).Lot_Data);
            }
        }
        return arrayList;

    }
//    @Bindable("android:String")
//    public ArrayList<Object> getList_try(String number)
//    {
//        ArrayList<Object>  arrayList=new ArrayList<>();
//
//        for(int i=0;i<_x0040_Item_Data.size();i++) {
//            if((_x0040_Item_Data.get(i).Item_number).toString()==number){
//            arrayList.add(_x0040_Item_Data.get(i).Constrain_Data);
//        }
//        }
//        return arrayList;
//
//    }

    public void set_ListconstrainsData2(ConstrainsData2 constrainsData2) {

        this._x0040_Item_Data=constrainsData2._x0040_Item_Data;
       // notifyPropertyChanged(BR.detailItemDataList2);
    }
}
