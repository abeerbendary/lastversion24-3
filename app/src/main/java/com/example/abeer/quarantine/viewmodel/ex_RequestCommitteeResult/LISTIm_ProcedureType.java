package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.example.abeer.quarantine.model.Plant;

import java.util.ArrayList;

public class LISTIm_ProcedureType  extends BaseObservable {
    public String $id;
    public int state_Code;
    public ArrayList<Plant> obj = new ArrayList<>();

    public LISTIm_ProcedureType()
    {

    }
    public LISTIm_ProcedureType(LISTIm_ProcedureType LISTIm_ProcedureType) {
        this.$id =  LISTIm_ProcedureType.$id;
        this.state_Code =  LISTIm_ProcedureType.state_Code;
        this.obj =  LISTIm_ProcedureType.obj;
        notifyPropertyChanged(BR.lISTIm_ProcedureType);
    }

    @Bindable
    public ArrayList<String> getLISTIm_ProcedureType() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }



    public void setLISTIm_ProcedureType(LISTIm_ProcedureType LISTIm_ProcedureType) {
        this.$id = LISTIm_ProcedureType.$id;
        this.state_Code = LISTIm_ProcedureType.state_Code;
        this.obj =LISTIm_ProcedureType.obj;
        notifyPropertyChanged(BR.lISTIm_ProcedureType);
    }
}
