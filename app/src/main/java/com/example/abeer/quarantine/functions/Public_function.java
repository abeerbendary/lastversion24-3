package com.example.abeer.quarantine.functions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.activity.Dashsss;
import com.example.abeer.quarantine.activity.Generate_barcode;
import com.example.abeer.quarantine.activity.LogIn;
import com.example.abeer.quarantine.activity.MainActivity_Confirm;
import com.example.abeer.quarantine.activity.MainActivity_DetailsListOfChimpments;
import com.example.abeer.quarantine.activity.MainActivity_Ex_RequestCommitteeResult;
import com.example.abeer.quarantine.activity.MainActivity_Listofchipment;
import com.example.abeer.quarantine.activity.MainActivity_SampleWithDraw;
import com.example.abeer.quarantine.activity.MainActivity_TreatmentStatement;
import com.example.abeer.quarantine.activity.MainActivity_subdetails;
import com.example.abeer.quarantine.activity.dashactivity.SampleWithDraw;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.login.Response_login;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Barcod_Card;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

public  class  Public_function  {
    DataManger   DataManger;
    public Public_function() {
    }

    public void AlertDialog(String massage , final Context context, final boolean shownavbar) {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.alertdialog);
        Button dialogButton = dialog.findViewById(R.id.btnalert);
        TextView dialogtext = dialog.findViewById(R.id.detailspopup);
        dialogtext.setText(massage);
        dialogtext.setTextSize(20);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
          if (shownavbar){
              ((DrawerLayout) ( (Activity)context). findViewById(R.id.drawer_layout)).setVisibility(View.VISIBLE);
              ((DrawerLayout) ( (Activity)context).findViewById(R.id.drawer_layout)).openDrawer(GravityCompat.START);
//              findViewById(R.id.drawer_layout);
//              .openDrawer(GravityCompat.START);
             }
          }
        });
        dialog.getWindow().setLayout(1200 , 635);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void showbarcodelist(Context context,final List<Barcod_Card>barcod_cards){
        Intent i= new Intent(context,Generate_barcode.class);
        i.putExtra("barcode", (Serializable) barcod_cards);
        ((Activity) context).startActivity(i);
    }
//    public void AlertDialog(String massage , Context context) {
//        final Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.alertdialog);
//        Button dialogButton = dialog.findViewById(R.id.btnalert);
//        TextView dialogtext = dialog.findViewById(R.id.detailspopup);
//        dialogtext.setText(massage);
//        dialogtext.setTextSize(20);
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//
//            }
//        });
//        dialog.getWindow().setLayout(1200 , 635);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.show();
//    }

    public  void senddataonlinetoserver(JSONArray jsonArray, final Context context, String URL)
    {
        DataManger = new DataManger(context);
        DataManger.SendVolleyRequestJsonArraypost(context, Request.Method.POST, URL , jsonArray, new IDataValue() {
            @Override
            public void Success(Object response) throws JSONException {
                int state_Code = ((JSONArray) response).getJSONObject(0).getInt("state_Code");
                if (state_Code == 1) {
                        Toast.makeText(context, "تم الحفظ بنجاح", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(context,MainActivity_Listofchipment.class);
                        ((Activity) context).startActivity(intent);
                } else {
                    Toast.makeText(context, "حدث خطا ما", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
    }

    public  void senddataonlinetoserver(JSONArray jsonArray, final Context context, String URL, final List<Barcod_Card>barcod_cards)
    {
        DataManger = new DataManger(context);
        DataManger.SendVolleyRequestJsonArraypost(context, Request.Method.POST, URL , jsonArray, new IDataValue() {
            @Override
            public void Success(Object response) throws JSONException {
                int state_Code = ((JSONArray) response).getJSONObject(0).getInt("state_Code");
                if (state_Code == 1) {
                        Intent i= new Intent(context,Generate_barcode.class);
                        i.putExtra("barcode", (Serializable) barcod_cards);
                        ((Activity) context).startActivity(i);

//                        Toast.makeText(context, "تم الحفظ بنجاح", Toast.LENGTH_LONG).show();
//                        //  ViewBtnsById.setVisibility(View.GONE);
//                        Intent intent = new Intent(context,MainActivity_Listofchipment.class);
//                        ((Activity) context).startActivity(intent);
                    }
                 else {
                    Toast.makeText(context, "حدث خطا ما", Toast.LENGTH_LONG).show();
                    //   ViewBtnsById.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
    }

    public  void senddataonlinetoserverformoreprocess(JSONObject jsonObject, final Context context, String URL)
    {
        DataManger = new DataManger(context);
        DataManger.SendVolleyRequestJsonObjectpost(context, Request.Method.POST, URL, jsonObject, new IDataValue() {

        @Override
        public void Success(Object response) {
            try {
                int state_Code = ((JSONObject) response).getInt("state_Code");
                if (state_Code==1){
                    Toast.makeText(context, "تم الحفظ بنجاح", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context,MainActivity_Listofchipment.class);
                    ((Activity) context).startActivity(intent);
                } else {
                    Toast.makeText(context, "حدث خطا ما", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void Error(VolleyError error) {

        }
       });
    }
    public  void senddataonlinetoserverformoreprocess(JSONObject jsonObject, final Context context, String URL,final List<Barcod_Card>barcod_cards)
    {
        DataManger = new DataManger(context);
        DataManger.SendVolleyRequestJsonObjectpost(context, Request.Method.POST, URL, jsonObject, new IDataValue() {

            @Override
            public void Success(Object response) {
                try {
                    int state_Code = ((JSONObject) response).getInt("state_Code");
                    if (state_Code==1){
                        Toast.makeText(context, "تم الحفظ بنجاح", Toast.LENGTH_LONG).show();
                        Intent i= new Intent(context,Generate_barcode.class);
                        i.putExtra("barcode", (Serializable) barcod_cards);
                        i.putExtra("contextsample","true");

                        ((Activity) context).startActivity(i);
                    } else {
                        Toast.makeText(context, "حدث خطا ما", Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void Error(VolleyError error) {

            }
        });
    }
    public void NavMenuClick(int id , final Context context, String Token ,Boolean Is_Admin,int RequestCommittee_Status_Id
                           ,int treatment_data,int sample_data,int request_data,int Committee_Type_Id ,String ipadrass) throws JSONException {

    if (id == R.id.language) {
        // Handle the camera action
    }
    else if (id == R.id.sample_title) {
        if(context instanceof MainActivity_Listofchipment){
            AlertDialog("رجاء اختيار الشحنة",context,false);
        } else if(context instanceof MainActivity_Ex_RequestCommitteeResult){
            if(sample_data==-1){
                AlertDialog("لا يوجد بالاشتراطات سحب عينة", context,false);
            } else {
                Intent i = new Intent(context, MainActivity_SampleWithDraw.class);
                ((Activity) context).startActivity(i);
            }
        } else if(context instanceof MainActivity_TreatmentStatement){
            if(sample_data==-1) {
                AlertDialog("لا يوجد سحب عينة", context, false);
            } else  if(sample_data!=0){
                Intent i = new Intent(context, MainActivity_SampleWithDraw.class);
                ((Activity) context).startActivity(i);
            }
        }else if(context instanceof MainActivity_SampleWithDraw){
            if(sample_data > 0) {
                Intent i = new Intent(context, MainActivity_SampleWithDraw.class);
                ((Activity) context).startActivity(i);
            }

        } else if(context instanceof MainActivity_DetailsListOfChimpments || context instanceof MainActivity_subdetails)
          {
            if (Is_Admin) {
                if (RequestCommittee_Status_Id == 1) {
                    if (sample_data != 0) {
                        AlertDialog("تم سحب العينة", context,false);
                    }
                } else{
                    if (sample_data == -1) {
                        AlertDialog("لا يوجد بالاشتراطات سحب عينة", context,false);
                    } else if (sample_data != 0 && Committee_Type_Id == 3) {

                        Intent i = new Intent(context, MainActivity_SampleWithDraw.class);
                        ((Activity) context).startActivity(i);

                    } else  {
                        AlertDialog("برجاء فحص الشحنة اولا ", context,false);
                    }
                }
//                Intent i = new Intent(context, MainActivity_SampleWithDraw.class);
//                        ((Activity) context).startActivity(i);
            } else {
                if (RequestCommittee_Status_Id == 1) {
                        Intent i = new Intent(context, MainActivity_Confirm.class);
                        ((Activity) context).startActivity(i);
                } else if (RequestCommittee_Status_Id == 0) {
                        AlertDialog("لم يتم سحب عينة", context,false);
                }
            }
        }
    } else if (id == R.id.treatment_title) {

        if (context instanceof MainActivity_Listofchipment) {
            AlertDialog("رجاء اختيار الشحنة", context,false);
        }
        else if(context instanceof MainActivity_Ex_RequestCommitteeResult){
             if(treatment_data==-1){
                AlertDialog("لا يوجد بالاشتراطات معالجة", context,false);
              }else{
                 Intent i = new Intent(context, MainActivity_TreatmentStatement.class);
                 ((Activity) context).startActivity(i);
             }
        }
        else if (context instanceof MainActivity_SampleWithDraw){
            if(treatment_data==-1) {
                AlertDialog("لا يوجد بالاشتراطات معالجة", context, false);
            } else if(treatment_data!=0){
                Intent i = new Intent(context, MainActivity_TreatmentStatement.class);
                ((Activity) context).startActivity(i);
            }
        }
        else if(context instanceof MainActivity_TreatmentStatement){

            if(treatment_data > 0) {
                Intent i = new Intent(context, MainActivity_TreatmentStatement.class);
                ((Activity) context).startActivity(i);
            }
        }
        else if(context instanceof MainActivity_DetailsListOfChimpments || context instanceof MainActivity_subdetails)
        {
            if (Is_Admin) {
                if (RequestCommittee_Status_Id == 1) {
                    if (treatment_data != 0) {
                        AlertDialog("تم المعالجة", context,false);
                    }
                } else {
                    if (treatment_data == -1) {
                        AlertDialog("لا يوجد بالاشتراطات معالجة", context, false);
                    } else if (treatment_data != 0 && Committee_Type_Id == 6) {

                        Intent i = new Intent(context, MainActivity_TreatmentStatement.class);
                        ((Activity) context).startActivity(i);
                    } else {
                        AlertDialog("برجاء فحص الشحنة اولا ", context, false);
                    }
                }
//                Intent i = new Intent(context, MainActivity_TreatmentStatement.class);
//                       ((Activity) context).startActivity(i);

            } else {
                if (RequestCommittee_Status_Id == 1) {
                        Intent i = new Intent(context, MainActivity_Confirm.class);
                        ((Activity) context).startActivity(i);
                } else if (RequestCommittee_Status_Id == 0) {
                        AlertDialog("لم يتم معالجة", context,false);
                }
            }
        }
    }else if(id==R.id.Committee_title){
        if (context instanceof MainActivity_Listofchipment) {
            AlertDialog("رجاء اختيار الشحنة", context,false);
        }
       else if(context instanceof MainActivity_TreatmentStatement){

            AlertDialog("تم الفحص  ", context,false);

        }else if (context instanceof MainActivity_SampleWithDraw){
            AlertDialog("تم الفحص ", context,false);
        }
        else if(context instanceof MainActivity_DetailsListOfChimpments || context instanceof MainActivity_subdetails)
        {
            if (Is_Admin) {
                if (RequestCommittee_Status_Id == 1 ) {
                          AlertDialog("تم فحص الشحنة", context,false);
                } else if (RequestCommittee_Status_Id == 0 ) {
                    if(Committee_Type_Id==1) {
                        Intent i = new Intent(context, MainActivity_Ex_RequestCommitteeResult.class);
                        ((Activity) context).startActivity(i);
                    }else if (Committee_Type_Id != 1) {
                        AlertDialog("ليس لديك صلاحية", context,false);
                    }
                }
//                Intent i = new Intent(context, MainActivity_Ex_RequestCommitteeResult.class);
//                  ((Activity) context).startActivity(i);
            } else  {
                if (RequestCommittee_Status_Id == 1) {
                        Intent i = new Intent(context, MainActivity_Confirm.class);
                        ((Activity) context).startActivity(i);
                } else if (RequestCommittee_Status_Id == 0) {
                        AlertDialog("لم يتم فحص الشحنة", context,false);

                }
            }


        }

    }else if (id == R.id.todolist) {
        Intent i=new Intent(context,MainActivity_Listofchipment.class);
        ((Activity)context).startActivity(i);
    }
    else if (id == R.id.logout) {
        JSONObject jsonObject = new JSONObject();
                jsonObject.put("Token",Token);

        DataManger=new DataManger(context);
        DataManger.SendVolleyRequestJsonObjectPut(context, Request.Method.PUT, ipadrass+ApiCall.UrlLogin, jsonObject, new IDataValue() {
            @Override
            public void Success(Object response) {

                   Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
    SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPreference",0);
        SharedPreferences.Editor   prefsEditor = sharedPreferences.edit();
        prefsEditor.clear();
        prefsEditor.commit();
        Intent i=new Intent(context, LogIn.class);
        ((Activity)context).startActivity(i);

    } else if (id == R.id.nav_send) {

    }
}
}
