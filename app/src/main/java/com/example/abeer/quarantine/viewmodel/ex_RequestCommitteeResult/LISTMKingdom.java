package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;
import com.example.abeer.quarantine.model.Plant;

import java.util.ArrayList;


public class LISTMKingdom extends BaseObservable {

    public String $id;
   public int state_Code;
   public  ArrayList<Plant> obj = new ArrayList<>();

   public LISTMKingdom()
   {

   }
    public LISTMKingdom(LISTMKingdom listMKingdoms) {
        this.$id =  listMKingdoms.$id;
        this.state_Code =  listMKingdoms.state_Code;
        this.obj =  listMKingdoms.obj;
       notifyPropertyChanged(BR.lIST_M_Kingdoms);
    }

    @Bindable
    public ArrayList<String> getLIST_M_Kingdoms() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
            for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).DisplayText);
        }
        return ArrayDisplayText;
    }

 public void setLIST_M_Kingdoms(LISTMKingdom listMKingdoms) {
        this.$id = listMKingdoms.$id;
        this.state_Code = listMKingdoms.state_Code;
        this.obj =listMKingdoms.obj;
        notifyPropertyChanged(BR.lIST_M_Kingdoms);
    }

}

