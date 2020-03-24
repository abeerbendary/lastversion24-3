package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.example.abeer.quarantine.model.Plant;

import java.util.ArrayList;

public class LISTPhylum  extends BaseObservable {

    public String $id;
    public int state_Code;
    public ArrayList<Plant> obj = new ArrayList<>();

    public LISTPhylum()
    {

    }
    public LISTPhylum(LISTPhylum LISTPhylums) {
        this.$id =  LISTPhylums.$id;
        this.state_Code =  LISTPhylums.state_Code;
        this.obj =  LISTPhylums.obj;
      notifyPropertyChanged(BR.lISTPhylums);
    }

    @Bindable
    public ArrayList<String> getLISTPhylum() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void setLISTPhylum(LISTPhylum LISTPhylums) {
        this.$id = LISTPhylums.$id;
        this.state_Code = LISTPhylums.state_Code;
        this.obj =LISTPhylums.obj;
        notifyPropertyChanged(BR.lISTPhylums);
    }

}
