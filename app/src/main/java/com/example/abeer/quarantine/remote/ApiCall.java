package com.example.abeer.quarantine.remote;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.abeer.quarantine.activity.LogIn;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by abeer on 27/03/2019.
 */

public class ApiCall  {

//    public static String UrlLogin="/api/Login_out";
//    public static String UrlPlantKingdom="/api/PlantKingdom?List=2";
//    public static String UrlPlantPhylum="/api/PhylumSubphylum?List=2&Kingdom_ID=";
//    public static String UrlPlantOrder="/api/PlantOrder?List=2&Phylum_ID=";
//    public static String UrlPlantFamily="/api/PlantFamily?List=2&Order_ID=";
//    public static String UrlIm_ProcedureType="/api/Im_ProcedureType?List=2";
//    public static String UrlCommitteeResultType="/api/CommitteeResultType?List=2";
//
//
//    public static String UrlLabName="/api/AnalysisLabType?AnalysisType=";
//    public static String AnalysisType="/api/AnalysisType?List=1";
//    public static String UrlTreatmentType="/api/TreatmentType?List=1";
//    public static String UrlTreatmentMethod="/api/TreatmentMethod?TreatmentType_ID=";
//    public static String UrlTreatmentMaterial ="/api/TreatmentMaterial?TreatmentType_ID=";
//    public static String UrlTreatmentCompany= "/api/Company_National?List=1&IsTreatment=true";
//    public static String UrlTreatmentPlace="/api/Station?Accridated=1";
//    public static String UrlEx_SampleData="/api/Ex_SampleData?index=0&pageSize=100&CheckRequestNumber=";
//  // public static String UrlListOfChipment  ="http://10.5.1.61:9090/api/Export_CheckRequest?User_Id=1&Check_Date=06-25-2019";
// // public static String UrlListOfChipment  ="/api/Export_CheckRequest?User_Id=1&Check_Date=06-25-2019";
//    /////running but not data added///
//    public static String UrlListOfChipment  ="/api/Export_CheckRequest?User_Id=20002&Check_Date=";
//////////////



  //  public static String UrlLogin="http://41.33.237.71:3030/api/Login_out";
    public static String UrlLogin="/api/Login_out";
    public static String UrlPlantKingdom="/api/PlantKingdom?List=2";
    public static String UrlPlantPhylum="/api/PhylumSubphylum?List=2&Kingdom_ID=";
    public static String UrlPlantOrder="/api/PlantOrder?List=2&Phylum_ID=";
    public static String UrlPlantFamily="/api/PlantFamily?List=2&Order_ID=";
    public static String UrlIm_ProcedureType="/api/Im_ProcedureType?List=2";
    public static String UrlCommitteeResultType="/api/CommitteeResultType?List=2";
    public static String UrlLabName="/api/AnalysisLabType?AnalysisType=";
    public static String AnalysisType="/api/AnalysisType?List= 1";
    public static String UrlTreatmentType="/api/TreatmentType?List=1";
    public static String UrlTreatmentMethod="/api/TreatmentMethod?TreatmentType_ID=";
    public static String UrlTreatmentMaterial ="/api/TreatmentMaterial?TreatmentType_ID=";
    public static String UrlTreatmentCompany= "/api/Company_National?List=1&IsTreatment=true";
    public static String UrlTreatmentPlace="/api/Station?Accridated=1";
    public static String UrlEx_SampleData="/api/RequestLotData?CheckRequestNumber_Id=";
    public static String UrlDetailsCheckRequest="/api/Export_CheckRequest?CheckRequest_Id=";
    public static String UrlCommitteeResult="/api/CommitteeResult";
    public static String UrlSampleDataResult="/api/Ex_SampleData";
    public static String UrlTreatmentsResult="/api/RequestTreatments";
    public static String UrlListOfChipment  ="/api/Export_CheckRequest?";
    public static String UrlSavemultprocess="/api/CommitteeResult?x=1";

}

