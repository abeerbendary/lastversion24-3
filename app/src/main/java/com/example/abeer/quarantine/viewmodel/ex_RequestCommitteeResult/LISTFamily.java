package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;

import java.util.ArrayList;

public class LISTFamily extends BaseObservable {
    public String $id;
    public int state_Code;
    public ArrayList<Plant> obj = new ArrayList<>();

    public LISTFamily() {

    }

    public LISTFamily(LISTFamily LISTFamilys) {
        this.$id = LISTFamilys.$id;
        this.state_Code = LISTFamilys.state_Code;
        this.obj = LISTFamilys.obj;
      notifyPropertyChanged(BR.LISTFamily);
    }
    @Bindable
    public ArrayList<String> getLISTFamily() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void setLISTFamily(LISTFamily LISTFamilys) {
        this.$id = LISTFamilys.$id;
        this.state_Code = LISTFamilys.state_Code;
        this.obj =LISTFamilys.obj;
        notifyPropertyChanged(BR.LISTFamily);
    }
}
