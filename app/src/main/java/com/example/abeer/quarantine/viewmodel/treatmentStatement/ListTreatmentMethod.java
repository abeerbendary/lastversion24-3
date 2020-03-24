package com.example.abeer.quarantine.viewmodel.treatmentStatement;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.TreatmentMethod;

import java.util.ArrayList;

public class ListTreatmentMethod extends BaseObservable {

    public String $id;
    public int state_Code;
    public  ArrayList<TreatmentMethod> obj = new ArrayList<>();

    ListTreatmentMethod(){
    }

    public ListTreatmentMethod(ListTreatmentMethod listTreatmentMethod) {
        this.$id = listTreatmentMethod.$id;
        this.state_Code = listTreatmentMethod.state_Code;
        this.obj = listTreatmentMethod.obj;
        notifyPropertyChanged(BR.treatmentMethod);
    }

    @Bindable
    public ArrayList<String> getListTreatmentMethod() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).Ar_Name);
        }
        return ArrayDisplayText;
    }

    public void setListTreatmentMethod(ListTreatmentMethod listTreatmentMethod) {
        this.$id = listTreatmentMethod.$id;
        this.state_Code = listTreatmentMethod.state_Code;
        this.obj =listTreatmentMethod.obj;
        notifyPropertyChanged(BR.treatmentMethod);
    }
//    ArrayList<TreatmentMethod> treatmentArrayList=new ArrayList<>();
//    ListTreatmentMethod(){
//    }
//    public  ListTreatmentMethod(ListTreatmentMethod listTreatmentMethod) {
//        this.treatmentArrayList =listTreatmentMethod.treatmentArrayList;
//        notifyPropertyChanged(BR.treatmentMethod);
//    }
//
//    @Bindable
//    public ArrayList<String> getArrayListTreatment_Method(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<treatmentArrayList.size();i++){
//            arrayList.add(treatmentArrayList.get(i).Ar_Name);
//        }
//
//        return arrayList;
//    }
//
//    public void setTreatmentArrayList(ListTreatmentMethod listTreatmentMethod){
//
//        this.treatmentArrayList= listTreatmentMethod.treatmentArrayList;
//        notifyPropertyChanged(BR.treatmentMethod);
//    }
}
