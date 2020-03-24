package com.example.abeer.quarantine.viewmodel.treatmentStatement;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;
import com.example.abeer.quarantine.model.TreatmentType;

import java.util.ArrayList;

public class ListTreatmentType extends BaseObservable {

    public String $id;
    public int state_Code;
    public  ArrayList<Plant> obj = new ArrayList<>();




    public ListTreatmentType() {

    }

    public ListTreatmentType(ListTreatmentType listTreatmentType) {

        this.$id = listTreatmentType.$id;
        this.state_Code = listTreatmentType.state_Code;
        this.obj = listTreatmentType.obj;
        notifyPropertyChanged(BR.treatmentType);
    }

    @Bindable
    public ArrayList<String> getListTreatmentType() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void setListTreatmentType(ListTreatmentType listTreatmentType) {
        this.$id = listTreatmentType.$id;
        this.state_Code = listTreatmentType.state_Code;
        this.obj =listTreatmentType.obj;
        notifyPropertyChanged(BR.treatmentType);

    }

//    ArrayList<TreatmentType> treatmentArrayList=new ArrayList<>();
//    ListTreatmentType(){
//    }
//    public  ListTreatmentType(ListTreatmentType listTreatment) {
//        this.treatmentArrayList =listTreatment.treatmentArrayList;
//       notifyPropertyChanged(BR.treatmentType);
//    }
//
//    @Bindable
//    public ArrayList<String> getArrayListTreatment_Type(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<treatmentArrayList.size();i++){
//            arrayList.add(treatmentArrayList.get(i).Ar_Name);
//        }
//
//        return arrayList;
//    }
//
//    @Bindable
//    public ArrayList<String> getArrayListTreatment_Type_Value(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<treatmentArrayList.size();i++){
//            arrayList.add(String.valueOf(treatmentArrayList.get(i).ID));
//        }
//
//        return arrayList;
//    }
//    public void setTreatmentArrayList(ListTreatmentType listTreatment){
//        this.treatmentArrayList= listTreatment.treatmentArrayList;
//        notifyPropertyChanged(BR.treatmentType);
//    }


}
