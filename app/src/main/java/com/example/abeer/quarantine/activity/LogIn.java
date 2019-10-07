package com.example.abeer.quarantine.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.ActivityLogInBinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.model.Subclass_Response_Login;
import com.example.abeer.quarantine.presenter.IClickLogin;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.CommitteeResultType;
import com.example.abeer.quarantine.viewmodel.login.Request_login;
import com.example.abeer.quarantine.viewmodel.login.Response_login;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class LogIn extends AppCompatActivity {

    String login;
   TextView test;
   Context context;
   EditText ipadrass;
   EditText name;
    ActivityLogInBinding activityLogInBinding;
    Request_login requestLogin;
    DataManger DataManger;
    Gson gson;
    String data;
    Response_login responseLogin;
    SharedPreferences sharedPreferences;
   SharedPreferences.Editor prefsEditor;
   Public_function public_function =new Public_function();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
      activityLogInBinding =
               DataBindingUtil.setContentView((Activity) context, R.layout.activity_log_in);
         sharedPreferences = context.getSharedPreferences("SharedPreference",MODE_PRIVATE);
        DataManger = new DataManger(this);
        requestLogin=new Request_login();
        responseLogin=new Response_login();
        gson = new Gson();
       // setContentView(R.layout.activity_log_in);

//          name=findViewById(R.id.name);
//   // test  =findViewById(R.id.test);
//    String USername="iscc";
//    String Password="123";
//    login="{LoginName:'iscc',Password:'123'}";
  ipadrass=findViewById(R.id.ipadarss);
}

//    public void login(View view) {
////
////        JSONObject  jsonObject=new JSONObject();
////        try {
////
////            jsonObject.put("LoginName","iscc");
////            jsonObject.put("Password","123");
////
////        } catch (JSONException e) {
////            e.printStackTrace();
////        }
////        Intent i=new Intent(LogIn.this,ListOfChipments.class);
////        i.putExtra("ipadrass",String.valueOf(ipadrass.getText().toString()));
////        startActivity(i);
//   ipadrass.setText("192.168.38.30:8012");
//        if(name.getText().toString().equals("admin")) {
//            Intent i = new Intent(LogIn.this, Admin.class);
//            startActivity(i);
//        }else {
//            Intent i = new Intent(LogIn.this, MainActivity_Listofchipment.class);
//            i.putExtra("ipadrass", String.valueOf(ipadrass.getText().toString()));
//            startActivity(i);
//        }
//
////        DataManger   DataManger = new DataManger(this);
////
////        DataManger.SendVolleyRequestJsonObjectpost(this, Request.Method.POST, ApiCall.UrlLogin,jsonObject, new IDataValue() {
////            @Override
////            public void Success(Object response) {
////                String RR=response.toString();
////                test.setText(RR);
//////                    Intent i=new Intent(LogIn.this,Ex_RequestCommitteeResult.class);
//////                      startActivity(i);
////
////                Intent i=new Intent(LogIn.this,ListOfChipments.class);
////                   startActivity(i);
////            }
////
////            @Override
////            public void Error(VolleyError error) {
////                int d=0;
////            }
////        });
//
//    }


    @Override
    protected void onStart() {
        super.onStart();

        activityLogInBinding.setLoginRequest(requestLogin);
        activityLogInBinding.setClicLogin(new IClickLogin() {
            @Override
            public void OnClickLogin(View view, final Request_login requestLogin)  {
             //   Toast.makeText(context, requestLogin.toString(), Toast.LENGTH_LONG).show();
                if(requestLogin.getLoginName().equals("admin")) {
                    Intent i = new Intent(LogIn.this, Admin.class);
                    startActivity(i);
                }else if(requestLogin.getLoginName().equals("")||requestLogin.getPassword().equals("")) {
                    public_function.AlertDialog("أدخل إسم المستخدم وكلمه المرور",context,false);

                }
                else if(requestLogin.getLoginName()!=""&&requestLogin.getPassword()!="") {
                    data = gson.toJson(requestLogin);
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(data);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//try {
    //DataManger.SendVolleyRequestJsonObjectpost(context, Request.Method.POST, "http://                                                                                                                                                                                                          " + ipadrass.getText().toString() + ApiCall.UrlLogin, jsonObject, new IDataValue() {
   DataManger.SendVolleyRequestJsonObjectpost(context, Request.Method.POST, "http://"+ipadrass.getText().toString()+ApiCall.UrlLogin, jsonObject, new IDataValue() {

        @Override
        public void Success(Object response) {
            //   Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
            data = response.toString();
            responseLogin = gson.fromJson(data, Response_login.class);
            if (responseLogin.getState_Code() == 1) {

                prefsEditor = sharedPreferences.edit();
                //ده صح بس هما محتاجين يعدلو الlogin وهشتغل موقت بالسطر التاني
                //  prefsEditor.putLong("UserId", responseLogin.getObj().getUserId());// Saving boolean - true/false
                ///////////////////////
                // prefsEditor.putLong("UserId", 31810);
                prefsEditor.putLong("UserId", responseLogin.getObj().getUserId());
                prefsEditor.putLong("EmpId", responseLogin.getObj().getEmpId());
                prefsEditor.putString("FullName", responseLogin.getObj().getFullName());        // Saving integer
                prefsEditor.putString("Token", responseLogin.getObj().getToken());
                prefsEditor.putString("ipadrass", "http://" + ipadrass.getText().toString());
                prefsEditor.commit();
                // ipadrass.setText(responseLogin.getObj().getToken());

                Intent intent = new Intent(context, MainActivity_Listofchipment.class);
                startActivity(intent);

            } else if (responseLogin.getState_Code() == 2) {
                //not right username password
                public_function.AlertDialog("اسم المستخدم وكلمه المرور خطا", context,false);
            } else if (responseLogin.getState_Code() == 5) {
                // user register from ather device
                public_function.AlertDialog("تم تسجيل الدخول من جهاز اخر", context,false);
            } else {
                public_function.AlertDialog("حدث خطا ما", context,false);
            }
        }

        @Override
        public void Error(VolleyError error) {

        }
    });
//}catch (Exception ex)
//{
//    int x=0;
//}
                }

              // ipadrass.setText(String.valueOf(sharedPreferences.getLong("UserId",0)));
            }
        });
    }

    public void imageclick(View view) {
       // ipadrass.setVisibility(View.GONE);
    }
//    public void AlertDialog(String massage) {
//        final Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.alertdialog);
//        Button dialogButton = dialog.findViewById(R.id.btnalert);
//       TextView dialogtext=dialog.findViewById(R.id.detailspopup);
//       dialogtext.setText(massage);
//       dialogtext.setTextSize(20);
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.getWindow().setLayout(1200 , 635);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.show();
//    }

}
