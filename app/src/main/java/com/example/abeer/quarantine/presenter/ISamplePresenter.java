package com.example.abeer.quarantine.presenter;

import android.view.View;
import android.widget.AdapterView;

import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.Checkup_Result;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Sample_Result;

public interface ISamplePresenter {
    public  void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id ,Sample_Result sample_result);
    public  void OnItemSelectedSpinner_laboratory(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result);
    public  void OnClickSaveLots(View view,Sample_Result  sampleResult);
    public  void OnClickcancel( View view,Sample_Result sampleResult);
}
