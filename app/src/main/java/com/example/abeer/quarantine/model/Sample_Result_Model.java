package com.example.abeer.quarantine.model;

import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Sample_Result;

public class Sample_Result_Model {
//    public long ID { get; set; }
//    public Nullable<int> AnalysisLabType_ID { get; set; }
//    public long Committee_ID { get; set; }
//    public System.DateTime WithdrawDate { get; set; }
//    public long User_Creation_Id { get; set; }
//    public string Sample_BarCode { get; set; }
//    public double SampleSize { get; set; }
//    public double SampleRatio { get; set; }
//    public bool IsAccepted { get; set; }
//    public string WithDrawPlace { get; set; }

    Long ID;
    Short AnalysisTypeID ;
    int AnalysisLabType_ID;
    Long Committee_ID;
    String WithdrawDate;
    Long User_Creation_Id;
    String Sample_BarCode;
     double SampleSize;
     double SampleRatio;
     boolean IsAccepted;
    String WithDrawPlace;
    String RejectReason_Ar;
    String RejectReason_En ;
    String Notes_Ar;
    String Notes_En;

    public Sample_Result_Model(Sample_Result_Model sample_result_model) {
        ID=sample_result_model.ID;
        AnalysisLabType_ID=sample_result_model.AnalysisLabType_ID;
        Committee_ID=sample_result_model.Committee_ID;
        WithdrawDate=sample_result_model.WithdrawDate;
        User_Creation_Id=sample_result_model.User_Creation_Id;
        Sample_BarCode=sample_result_model.Sample_BarCode;
        SampleSize=sample_result_model.SampleSize;
        SampleRatio=sample_result_model.SampleRatio;
        IsAccepted=sample_result_model.IsAccepted;
        WithDrawPlace=sample_result_model.WithDrawPlace;
        AnalysisTypeID=sample_result_model.AnalysisTypeID;
        Notes_Ar=sample_result_model.Notes_Ar;
        Notes_En="";
        RejectReason_Ar="";
        RejectReason_En="";
    }

    public Sample_Result_Model(Sample_Result sampleResult) {
        ID=sampleResult.getLot_ID();
        AnalysisLabType_ID=sampleResult.getLaboratory_ID();
        Committee_ID=sampleResult.getCommittee_ID();
        WithdrawDate=sampleResult.getDate();
        Sample_BarCode=sampleResult.getBarCode();
        Notes_Ar=sampleResult.getComment();
        AnalysisTypeID=sampleResult.getAnalysisType_ID();
        User_Creation_Id= sampleResult.getEmployeeId();
        SampleSize=sampleResult.getSampleSize();
        SampleRatio=sampleResult.getSampleUnderSize();
        IsAccepted=false;
        Notes_En="";
        RejectReason_Ar="";
        RejectReason_En="";
        WithDrawPlace=sampleResult.getPlace();

    }

    public Short getAnalysisTypeID() {
        return AnalysisTypeID;
    }

    public void setAnalysisTypeID(Short analysisTypeID) {
        AnalysisTypeID = analysisTypeID;
    }

    public String getRejectReason_Ar() {
        return RejectReason_Ar;
    }

    public void setRejectReason_Ar(String rejectReason_Ar) {
        RejectReason_Ar = rejectReason_Ar;
    }

    public String getRejectReason_En() {
        return RejectReason_En;
    }

    public void setRejectReason_En(String rejectReason_En) {
        RejectReason_En = rejectReason_En;
    }

    public String getNotes_Ar() {
        return Notes_Ar;
    }

    public void setNotes_Ar(String notes_Ar) {
        Notes_Ar = notes_Ar;
    }

    public String getNotes_En() {
        return Notes_En;
    }

    public void setNotes_En(String notes_En) {
        Notes_En = notes_En;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getAnalysisLabType_ID() {
        return AnalysisLabType_ID;
    }

    public void setAnalysisLabType_ID(int analysisLabType_ID) {
        AnalysisLabType_ID = analysisLabType_ID;
    }

    public Long getCommittee_ID() {
        return Committee_ID;
    }

    public void setCommittee_ID(Long committee_ID) {
        Committee_ID = committee_ID;
    }

    public String getWithdrawDate() {
        return WithdrawDate;
    }

    public void setWithdrawDate(String withdrawDate) {
        WithdrawDate = withdrawDate;
    }

    public Long getUser_Creation_Id() {
        return User_Creation_Id;
    }

    public void setUser_Creation_Id(Long user_Creation_Id) {
        User_Creation_Id = user_Creation_Id;
    }

    public String getSample_BarCode() {
        return Sample_BarCode;
    }

    public void setSample_BarCode(String sample_BarCode) {
        Sample_BarCode = sample_BarCode;
    }

    public double getSampleSize() {
        return SampleSize;
    }

    public void setSampleSize(double sampleSize) {
        SampleSize = sampleSize;
    }

    public double getSampleRatio() {
        return SampleRatio;
    }

    public void setSampleRatio(double sampleRatio) {
        SampleRatio = sampleRatio;
    }

    public boolean isAccepted() {
        return IsAccepted;
    }

    public void setAccepted(boolean accepted) {
        IsAccepted = accepted;
    }

    public String getWithDrawPlace() {
        return WithDrawPlace;
    }

    public void setWithDrawPlace(String withDrawPlace) {
        WithDrawPlace = withDrawPlace;
    }
}
