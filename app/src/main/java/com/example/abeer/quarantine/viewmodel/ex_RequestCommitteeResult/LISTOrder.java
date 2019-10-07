package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;

import java.util.ArrayList;

public class LISTOrder extends BaseObservable {
    public String $id;
    public int state_Code;
    public ArrayList<Plant> obj = new ArrayList<>();

    public LISTOrder() {

    }

    public LISTOrder(LISTOrder LISTOrders) {
        this.$id = LISTOrders.$id;
        this.state_Code = LISTOrders.state_Code;
        this.obj = LISTOrders.obj;
       notifyPropertyChanged(BR.LISTOrder);
    }

    @Bindable
    public ArrayList<String> getLISTOrder() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

    public void setLISTOrder(LISTOrder LISTOrders) {
        this.$id = LISTOrders.$id;
        this.state_Code = LISTOrders.state_Code;
        this.obj =LISTOrders.obj;
      notifyPropertyChanged(BR.LISTOrder);
    }

}

