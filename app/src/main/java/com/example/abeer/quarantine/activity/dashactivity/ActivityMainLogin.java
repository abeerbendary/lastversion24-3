package com.example.abeer.quarantine.activity.dashactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.activity.MainActivity_Listofchipment;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityMainLogin extends AppCompatActivity {
    String login;
    TextView test;
    Context context;
    EditText ipadrass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        context=this;
        // test  =findViewById(R.id.test);
        String USername="iscc";
        String Password="123";
        login="{LoginName:'iscc',Password:'123'}";
        ipadrass=findViewById(R.id.ipadarss);
    }

    public void login(View view) {

        JSONObject jsonObject=new JSONObject();
        try {

            jsonObject.put("LoginName","iscc");
            jsonObject.put("Password","123");

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        Intent i=new Intent(LogIn.this,ListOfChipments.class);
//        i.putExtra("ipadrass",String.valueOf(ipadrass.getText().toString()));
//        startActivity(i);
        ipadrass.setText("10.5.1.6:9090");
        Intent i=new Intent(this, MainActivity_Listofchipment.class);
        i.putExtra("ipadrass",String.valueOf(ipadrass.getText().toString()));

        startActivity(i);


//        DataManger   DataManger = new DataManger(this);
//
//        DataManger.SendVolleyRequestJsonObjectpost(this, Request.Method.POST, ApiCall.UrlLogin,jsonObject, new IDataValue() {
//            @Override
//            public void Success(Object response) {
//                String RR=response.toString();
//                test.setText(RR);
////                    Intent i=new Intent(LogIn.this,Ex_RequestCommitteeResult.class);
////                      startActivity(i);
//
//                Intent i=new Intent(LogIn.this,ListOfChipments.class);
//                   startActivity(i);
//            }
//
//            @Override
//            public void Error(VolleyError error) {
//                int d=0;
//            }
//        });

    }

    public void imageclick(View view) {
        ipadrass.setVisibility(View.GONE);
    }

//    public void kk(View view) {
//        Intent i=new Intent(LogIn.this,withdrawSample.class);
//        startActivity(i);
//    }
    }

