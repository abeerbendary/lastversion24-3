package com.example.abeer.quarantine.viewmodel.treatmentStatement;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.TreatmentMaterial;

import java.util.ArrayList;

public class ListTreatmentMaterial extends BaseObservable {

    public String $id;
    public int state_Code;
    public  ArrayList<TreatmentMaterial> obj = new ArrayList<>();

    public ListTreatmentMaterial() {


    }

    public ListTreatmentMaterial(ListTreatmentMaterial listTreatmentMaterial) {
        this.$id = listTreatmentMaterial.$id;
        this.state_Code = listTreatmentMaterial.state_Code;
        this.obj = listTreatmentMaterial.obj;
        notifyPropertyChanged(BR.treatmentMaterial);
    }

    @Bindable
    public ArrayList<String> getListTreatmentMaterial() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).Ar_Name);
        }
        return ArrayDisplayText;
    }

    public void setListTreatmentMaterial(ListTreatmentMaterial listTreatmentMaterial) {
        this.$id = listTreatmentMaterial.$id;
        this.state_Code = listTreatmentMaterial.state_Code;
        this.obj =listTreatmentMaterial.obj;
        notifyPropertyChanged(BR.treatmentMaterial);
    }
//    ArrayList<TreatmentMaterial> treatmentArrayList=new ArrayList<>();
//    ListTreatmentMaterial(){
//    }
//    public  ListTreatmentMaterial(ListTreatmentMaterial listTreatmentMaterial) {
//        this.treatmentArrayList =listTreatmentMaterial.treatmentArrayList;
//         notifyPropertyChanged(BR.treatmentMaterial);
//    }
//
//    @Bindable
//    public ArrayList<String> getArrayListTreatment_Material(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<treatmentArrayList.size();i++){
//            arrayList.add(treatmentArrayList.get(i).Ar_Name);
//        }
//
//        return arrayList;
//    }
//
//    public void setTreatmentArrayList(ListTreatmentMaterial listTreatmentMaterial){
//
//        this.treatmentArrayList= listTreatmentMaterial.treatmentArrayList;
//          notifyPropertyChanged(BR.treatmentMaterial);
//    }
}
