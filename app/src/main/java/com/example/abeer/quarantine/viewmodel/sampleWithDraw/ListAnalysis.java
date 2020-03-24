package com.example.abeer.quarantine.viewmodel.sampleWithDraw;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;
import java.util.ArrayList;

public class ListAnalysis extends BaseObservable {

    public String $id;
    public int state_Code;
    public ArrayList<Plant> obj = new ArrayList<>();

    public ListAnalysis()
    {

    }
    public ListAnalysis(ListAnalysis listAnalysis) {
        this.$id =  listAnalysis.$id;
        this.state_Code =  listAnalysis.state_Code;
        this.obj =  listAnalysis.obj;
        notifyPropertyChanged(BR.listAnalysis);
    }


    @Bindable
    public ArrayList<String> getListAnalysis() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void setListAnalysis(ListAnalysis listAnalysis) {
        this.$id = listAnalysis.$id;
        this.state_Code = listAnalysis.state_Code;
        this.obj =listAnalysis.obj;
        notifyPropertyChanged(BR.listAnalysis);
    }


//    ArrayList<Plant> AnalysisType_Data= new ArrayList<>();
//
//    public ListAnalysis() {
//
//    }
//
//    public ListAnalysis(ListAnalysis listAnalysis) {
//        this.AnalysisType_Data=listAnalysis.AnalysisType_Data;
//        notifyPropertyChanged(BR.lIST_analysis);
//    }
//
//
//    @Bindable
//    public ArrayList<String> getLIST_analysis() {
//        ArrayList<String> ArrayDisplayText=new ArrayList<>();
//        for (int i = 0; i <AnalysisType_Data.size(); i++) {
//            ArrayDisplayText.add(AnalysisType_Data.get(i).DisplayText);
//        }
//        return ArrayDisplayText;
//    }
//
//
//@Bindable
//    public ArrayList<String> getArrayListTreatment_Type_Value(){
//
//        ArrayList<String>arrayList=new ArrayList<>();
//        for(int i=0;i<AnalysisType_Data.size();i++){
//            arrayList.add(String.valueOf(AnalysisType_Data.get(i).Value));
//        }
//
//        return arrayList;
//    }
//
//    public void setLIST_analysis(ListAnalysis listAnalysis) {
//        this.AnalysisType_Data=listAnalysis.AnalysisType_Data;
//        notifyPropertyChanged(BR.lIST_analysis);
//    }
}
