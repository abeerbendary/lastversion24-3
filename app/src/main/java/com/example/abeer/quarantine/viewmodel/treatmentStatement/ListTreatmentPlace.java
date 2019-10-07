package com.example.abeer.quarantine.viewmodel.treatmentStatement;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;

import java.util.ArrayList;

public class ListTreatmentPlace extends BaseObservable {

    public String $id;
    public int state_Code;
    public  ArrayList<Plant> obj = new ArrayList<>();

    //  ArrayList<Plant> treatmentArrayList=new ArrayList<>();


    public ListTreatmentPlace() {

    }

    public ListTreatmentPlace(ListTreatmentPlace listTreatmentPlace) {
        this.$id = listTreatmentPlace.$id;
        this.state_Code = listTreatmentPlace.state_Code;
        this.obj = listTreatmentPlace.obj;
        notifyPropertyChanged(BR.treatmentPlace);
    }

    @Bindable
    public ArrayList<String> getListTreatmentPlace() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void setListTreatmentPlace(ListTreatmentPlace listTreatmentPlace) {
        this.$id = listTreatmentPlace.$id;
        this.state_Code = listTreatmentPlace.state_Code;
        this.obj =listTreatmentPlace.obj;
        notifyPropertyChanged(BR.treatmentPlace);
    }
//    ArrayList<Plant> treatmentArrayList=new ArrayList<>();
//    ListTreatmentPlace(){
//    }
//    public  ListTreatmentPlace(ListTreatmentPlace listTreatmentPlace) {
//        this.treatmentArrayList =listTreatmentPlace.treatmentArrayList;
//        notifyPropertyChanged(BR.treatmentPlace);
//    }
//
//    @Bindable
//    public ArrayList<String> getArrayListTreatment_Company(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<treatmentArrayList.size();i++){
//            arrayList.add(treatmentArrayList.get(i).DisplayText);
//        }
//
//        return arrayList;
//    }
//
//    public void setTreatmentArrayList(ListTreatmentPlace listTreatmentPlace){
//
//        this.treatmentArrayList= listTreatmentPlace.treatmentArrayList;
//        notifyPropertyChanged(BR.treatmentPlace);
//    }
}
