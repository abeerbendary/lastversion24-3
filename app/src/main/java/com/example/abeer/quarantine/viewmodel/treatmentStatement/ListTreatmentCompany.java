package com.example.abeer.quarantine.viewmodel.treatmentStatement;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;
import com.example.abeer.quarantine.model.TreatmentCompany;

import java.util.ArrayList;

public class ListTreatmentCompany extends BaseObservable {


    public String $id;
    public int state_Code;
    public  ArrayList<Plant> obj = new ArrayList<>();

    public ListTreatmentCompany() {

    }

    public ListTreatmentCompany(ListTreatmentCompany listTreatmentCompany) {
        this.$id = listTreatmentCompany.$id;
        this.state_Code = listTreatmentCompany.state_Code;
        this.obj = listTreatmentCompany.obj;
        notifyPropertyChanged(BR.treatmentCompany);
    }

    @Bindable
    public ArrayList<String> getListTreatmentCompany() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void setListTreatmentCompany(ListTreatmentCompany listTreatmentCompany) {
        this.$id = listTreatmentCompany.$id;
        this.state_Code = listTreatmentCompany.state_Code;
        this.obj =listTreatmentCompany.obj;
        notifyPropertyChanged(BR.treatmentCompany);
    }
//    ArrayList<TreatmentCompany> treatmentArrayList=new ArrayList<>();
//    ListTreatmentCompany(){
//    }
//    public  ListTreatmentCompany(ListTreatmentCompany listTreatmentCompany) {
//        this.treatmentArrayList =listTreatmentCompany.treatmentArrayList;
//        notifyPropertyChanged(BR.treatmentCompany);
//    }
//
//    @Bindable
//    public ArrayList<String> getArrayListTreatment_Company(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<treatmentArrayList.size();i++){
//            arrayList.add(treatmentArrayList.get(i).Name_Ar);
//        }
//
//        return arrayList;
//    }
//
//    public void setTreatmentArrayList(ListTreatmentCompany listTreatmentCompany){
//
//        this.treatmentArrayList= listTreatmentCompany.treatmentArrayList;
//        notifyPropertyChanged(BR.treatmentCompany);
//    }
}
