package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;

import java.util.ArrayList;

public class CommitteeResultType extends BaseObservable {
    public String $id;
    public int state_Code;
    public ArrayList<Plant> obj = new ArrayList<>();

    public CommitteeResultType()
    {

    }
    public CommitteeResultType(CommitteeResultType Result) {
        this.$id =  Result.$id;
        this.state_Code =  Result.state_Code;
        this.obj =  Result.obj;
       notifyPropertyChanged(BR.committeeResultType);
    }

    @Bindable
    public ArrayList<String> getResult() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void set_Result(CommitteeResultType Result) {
        this.$id = Result.$id;
        this.state_Code = Result.state_Code;
        this.obj =Result.obj;
       notifyPropertyChanged(BR.committeeResultType);
    }

}
