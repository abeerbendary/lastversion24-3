package com.example.abeer.quarantine.remote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.abeer.quarantine.model.RequestTreatmentData;
import com.example.abeer.quarantine.viewmodel.Emp_Committe;
import com.example.abeer.quarantine.viewmodel.ExportCheckRequest;

import java.util.ArrayList;

public class PlantQurDBHelper {

    private Engine engine;
    private SQLiteDatabase database;
    Long ID_RequestCommittee;
    long ID_Emp;
    Long ID_RequestCommitteeEmployee;
    ContentValues values;
    private static final String ENCODING_SETTING = "PRAGMA encoding ='windows-1256'";
    public PlantQurDBHelper(Context context) {
        engine = new Engine(context);
//        database.execSQL(ENCODING_SETTING);
    }

    //    UsersData data=new UsersData(this);
//            if (data.insert(name,yes,no)) {
//        Toast.makeText(this, "result completed with yes "+yes+" and no is "+no, Toast.LENGTH_SHORT).show();
//    }
//    database=engine.getReadableDatabase();
    //    database=engine.getWritableDatabase();
    //    public boolean insert(String name, byte yes, byte no) {
//        ContentValues values= new ContentValues();
//        values.put("name",name);
//        values.put("yes",yes);
//        values.put("no",no);
//        long id = database.insert("users", null, values);
//        return id==-1?false:true;
//
//    }
    public void Insert_resultlots() {
        //used it to insert check result and sample and treatment

    }


    public boolean Insert_CommitteeRequestEmployee(Context context, ExportCheckRequest exportCheckRequest, ArrayList<Emp_Committe> emp_committeArrayList) {
        //used it to insert committee request and employee and employee_requestcommittee
        boolean Result;
        Cursor cursor = engine.getReadableDatabase().rawQuery("select _id from RequestCommittee where _id=" + exportCheckRequest.getCheckRequest_Id(), null);
        int count = cursor.getCount();
        if (count == 0) {
            ID_RequestCommittee = Insert_CommitteeReques(exportCheckRequest);
        } else {
            ID_RequestCommittee = exportCheckRequest.getCheckRequest_Id();
        }

        if (ID_RequestCommittee != -1) {
            for (Emp_Committe Emp_Committe : emp_committeArrayList) {
                cursor = engine.getReadableDatabase().rawQuery("select _id from Employee where _id=" + Emp_Committe.getEmployee_Id(), null);
                count = cursor.getCount();
                if (count == 0) {
                    ID_Emp = Insert_Employee(Emp_Committe);
                } else {
                    ID_Emp = Emp_Committe.getEmployee_Id();
                }
                if (ID_Emp != -1) {
                    cursor = engine.getReadableDatabase().rawQuery("select _id from RequestCommitteeEmployee where EmployeeId=" + ID_Emp + " and CommitteeID=" + ID_RequestCommittee, null);
                    count = cursor.getCount();
                    if (count == 0) {
                        ID_RequestCommitteeEmployee = Insert_Emp_request(Emp_Committe);
                    } else {

                    }
                }
            }
            Result = true;
        } else {
            Result = false;
//            Toast.makeText(context, " حدث خطا ما ", Toast.LENGTH_SHORT).show();
        }
        return Result;
    }

    public int Select_Emp_User() {
        Cursor cursor = engine.getReadableDatabase().rawQuery("select _id from RequestCommittee where _id=" , null);
        int count = cursor.getCount();
        return 1;
    }

    public long Insert_CommitteeReques(ExportCheckRequest exportCheckRequest) {
        database = engine.getWritableDatabase();
        ContentValues values = new ContentValues();
        RequestTreatmentData requestTreatmentData = new RequestTreatmentData();
        requestTreatmentData = exportCheckRequest.getRequest_Treatment_Data();
        int treatment_data = requestTreatmentData.getTreatment_Total();
        int sample_data = requestTreatmentData.getAnalysis_Total();
        int total = 0;
        int Check_data = requestTreatmentData.getCheck_Total();
        if (treatment_data == -1) {
            treatment_data = 0;
        }
        if (sample_data == -1) {
            sample_data = 0;
        }
        if (Check_data == -1) {
            Check_data = 0;
        }
        total = treatment_data + sample_data + Check_data;
        values.put("_id", exportCheckRequest.getCheckRequest_Id());
        values.put("CheckRequest_Number", exportCheckRequest.getCheckRequest_Number());
        values.put("BarCode", exportCheckRequest.getBarCode());
        values.put("Committee_Type_Id", exportCheckRequest.getCommittee_Type_Id());
        values.put("Total_process", total);
        values.put("checkdate", exportCheckRequest.getCheck_Date());
        values.put("IsExport", exportCheckRequest.getIsExport());
        values.put("Committee_ID", exportCheckRequest.getCommittee_ID());
        values.put("RequestCommittee_Status_Id", exportCheckRequest.getRequestCommittee_Status_Id());
        ID_RequestCommittee = database.insert("RequestCommittee", null, values);
        return ID_RequestCommittee;
    }

    public long Insert_Employee(Emp_Committe Emp_Committe) {
        values = new ContentValues();
        values.put("_id", Emp_Committe.getEmployee_Id());
        values.put("Name", Emp_Committe.getFullName());
        values.put("Password", Emp_Committe.getPassword());
        values.put("Username", Emp_Committe.getLoginName());
        ID_Emp = database.insert("Employee", null, values);

        return ID_Emp;
    }

    public long Insert_Emp_request(Emp_Committe Emp_Committe) {
        values = new ContentValues();
        values.put("EmployeeId", ID_Emp);
        values.put("CommitteeID", ID_RequestCommittee);
        values.put("Isadmin", Emp_Committe.getISAdmin());
        ID_RequestCommitteeEmployee = database.insert("RequestCommitteeEmployee", null, values);
        return ID_RequestCommitteeEmployee;
    }

    public void Insert_Items() {
        //used it to insert items
    }
}
