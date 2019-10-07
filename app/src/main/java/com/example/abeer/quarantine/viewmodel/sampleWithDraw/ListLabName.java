package com.example.abeer.quarantine.viewmodel.sampleWithDraw;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.LabName;

import java.util.ArrayList;

public class ListLabName extends BaseObservable {


    public String $id;
    public int state_Code;
    public ArrayList<LabName> obj = new ArrayList<>();

    public ListLabName()
    {

    }
    public ListLabName(ListLabName Result) {
        this.$id =  Result.$id;
        this.state_Code =  Result.state_Code;
        this.obj =  Result.obj;
        notifyPropertyChanged(BR.labs);
    }

    @Bindable
    public ArrayList<String> getListLabName() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).Name_Ar);
        }
        return ArrayDisplayText;
    }

    public void setListLabName(ListLabName listLabName) {
        this.$id = listLabName.$id;
        this.state_Code = listLabName.state_Code;
        this.obj =listLabName.obj;
        notifyPropertyChanged(BR.labs);
    }
//    ArrayList<LabName> listDisplay=new ArrayList<>();
//
//    public ListLabName(){
//
//    }
//
//    public ListLabName(ListLabName listLabs) {
//
//        this.listDisplay= listLabs.listDisplay;
//         notifyPropertyChanged(BR.labs);
//    }
//
//    @Bindable
//    public ArrayList<String> getListLabs() {
//        ArrayList<String> ArrayDisplayText = new ArrayList<>();
//        for (int i = 0; i < listDisplay.size(); i++)
//        {
//            ArrayDisplayText.add(listDisplay.get(i).Name_Ar);
//        }
//        return ArrayDisplayText;
//    }
//
//
//    @Bindable
//    public ArrayList<String> getArrayListLab_Value(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<listDisplay.size();i++){
//            arrayList.add(String.valueOf(listDisplay.get(i).ID));
//        }
//        return arrayList;
//    }
//
//
//    public void setLISTLabs(ListLabName listLabs)
//    {
//        this.listDisplay = listLabs.listDisplay;
//          notifyPropertyChanged(BR.labs);
//    }


}
