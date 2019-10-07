package com.example.abeer.quarantine.presenter;

import android.view.View;
import android.widget.AdapterView;
import com.example.abeer.quarantine.viewmodel.treatmentStatement.TreatmentResult;

public interface ITreatmentPresenter {

    public  void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id ,TreatmentResult treatmentResult);
    public  void OnItemSelectedSpinner_Treatmentcompany(AdapterView<?> parent, View view, int pos, long id ,TreatmentResult treatmentResult);
    public  void OnItemSelectedSpinner_treatmentplace(AdapterView<?> parent, View view, int pos, long id ,TreatmentResult treatmentResult);
    public  void OnItemSelectedSpinner_treatmentmethod(AdapterView<?> parent, View view, int pos, long id ,TreatmentResult treatmentResult);
    public  void OnItemSelectedSpinner_treatmentmaterial(AdapterView<?> parent, View view, int pos, long id ,TreatmentResult treatmentResult);



    public  void OnClickSaveTreatment(View view, TreatmentResult TreatmentResult);
    public  void OnClickcancel( View view,TreatmentResult TreatmentResult);
}
