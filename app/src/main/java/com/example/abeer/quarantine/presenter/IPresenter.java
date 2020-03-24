package com.example.abeer.quarantine.presenter;

import android.view.View;
import android.widget.AdapterView;

import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.Checkup_Result;

/**
 * Created by abeer on 27/03/2019.
 */

public interface IPresenter {

    //Write Declaration Of Logic Function That Connect XML With Activity To Use It in DataBinding


    public  void OnItemSelectedSpinner_Kingdom(AdapterView<?> parent, View view,int pos,long id,Checkup_Result CheckUpResult);
    public  void OnItemSelectedSpinner_Phylum(AdapterView<?> parent, View view,int pos,long id,Checkup_Result CheckUpResult);
    public  void OnItemSelectedSpinner_Order(AdapterView<?> parent, View view,int pos,long id,Checkup_Result CheckUpResult);
    public  void OnItemSelectedSpinner_Family(AdapterView<?> parent, View view,int pos,long id,Checkup_Result CheckUpResult);
    public  void OnItemSelectedSpinner_Im_ProcedureType(AdapterView<?> parent, View view,int pos,long id,Checkup_Result CheckUpResult);
    public  void OnItemSelectedSpinner_CommitteeResultType(AdapterView<?> parent, View view,int pos,long id,Checkup_Result CheckUpResult);
//   public  void OnClickSaveLots( View view,String count, String weight, int result_ID,String comment, int kingdom_ID,
//                           int phylum_ID, int order_ID, String lot_num, int family_ID);
    public  void OnClickSaveLots( View view,Checkup_Result CheckUpResult);
    public  void OnClickcancel( View view,Checkup_Result CheckUpResult);
}
