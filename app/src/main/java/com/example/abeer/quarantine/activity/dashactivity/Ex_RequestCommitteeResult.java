package com.example.abeer.quarantine.activity.dashactivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.activity.CheckUp_Lots;
import com.example.abeer.quarantine.adapter.MyAdapterforRecycler;
import com.example.abeer.quarantine.databinding.ActivityExRequestCommitteeResultBinding;
import com.example.abeer.quarantine.presenter.Clickcustum;
import com.example.abeer.quarantine.presenter.IPresenter;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.Checkup_Result;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.CommitteeResultType;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTIm_ProcedureType;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTFamily;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTMKingdom;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTOrder;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTPhylum;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Ex_RequestCommitteeResult extends AppCompatActivity implements LocationListener{
    ActivityExRequestCommitteeResultBinding activityExRequestCommitteeResultBinding;
    private DataManger DataManger;
    Gson gson;
    String data;
    String IDItemSelect;
    LinearLayout linear_Layout_Examination_full ;
    LinearLayout linear_Layout_btns;
    LinearLayout linear_Layout_Examination_part ;
    LinearLayout linear_Layout_Damaged;
    LinearLayout LinearLayoutnum_request;
    TextView title_radio_group;
    RadioGroup radioGroup;
    boolean checked;
  //  TextView Textsss;
  String ipadrass;

    int num_row;
    JSONObject datas;
    Address address;
    double lat,longg;
    LocationManager manager;
    JSONArray popupdata=new JSONArray();
    RadioButton  Radio_full;
    RadioButton  Radio_part;
    Context context = this;
   Checkup_Result checkup_result;
    final LISTMKingdom[] LISTMKingdom = new LISTMKingdom[1];
    final LISTPhylum[] LISTPhylum = new LISTPhylum[1];
    final LISTOrder[] LISTOrder=new LISTOrder[1];
    final LISTFamily[] LISTFamily=new LISTFamily[1];
    final CommitteeResultType[] CommitteeResultTypeLIST=new CommitteeResultType[1];
    final LISTIm_ProcedureType[] LISTIm_ProcedureType=new LISTIm_ProcedureType[1];
    final List<SampleData_LOts>[] SampleData_LOts = new List[1];
    String result;
    View viewforbutton;
    JSONObject ValuesPopUpLots ;
    Button sample ;
    Button treatment;
    TextView value_request;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataManger = new DataManger(this);
         checkup_result =new Checkup_Result();

        activityExRequestCommitteeResultBinding =
                DataBindingUtil.setContentView((Activity) context, R.layout.activity_ex__request_committee_result);

    //    Textsss = findViewById(R.id.text1);
        linear_Layout_Examination_full=findViewById(R.id.linear_Layout_Examination_full);
        linear_Layout_btns=findViewById(R.id.btns);
        linear_Layout_Damaged=findViewById(R.id.damaged);
        linear_Layout_Examination_part=findViewById(R.id.linear_Layout_Examination_part);
        radioGroup=findViewById(R.id.radioGroup_Examination);
        Radio_full=findViewById(R.id.radio_Examination_full);
        LinearLayoutnum_request =findViewById(R.id.num_request);
       Radio_part=findViewById(R.id.radio_Examination_part);
        title_radio_group= findViewById(R.id.title_radio_group);
        sample =findViewById(R.id.sample);
        treatment=findViewById(R.id.treatment);
        ipadrass= getIntent().getStringExtra("ipadrass");

        value_request=findViewById(R.id.value_request);
        value_request.setText(getIntent().getStringExtra("num_Request"));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults != null && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                try {
                    manager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, null);
                    Toast.makeText(this, "phase 2", Toast.LENGTH_SHORT).show();

                } catch (SecurityException e) {

                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            String[] permissions={Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION};
            ActivityCompat.requestPermissions(this,permissions,100);

            Toast.makeText(this, "phase 1", Toast.LENGTH_SHORT).show();
        }
        else{
            manager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, (LocationListener) this,null);
            Toast.makeText(this, "sent direct", Toast.LENGTH_SHORT).show();
        }
        //Button sample =findViewById(R.id.sample);

//        sample.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i= new Intent(context, SampleWithDraw.class);
//                startActivity(i);
//            }
//        });
//        treatment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i= new Intent(context, TreatmentStatement.class);
//                startActivity(i);
//            }
//        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                result=data.getStringExtra("ValuesPopUpLots");
                try {
                    datas=new JSONObject(result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (datas != null) {
                        popupdata.put(datas);
            }
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                ValuesPopUpLots =new JSONObject();
                try {
                    ValuesPopUpLots.put("Latitude",lat);
                    ValuesPopUpLots.put("Longitude",longg);
                    ValuesPopUpLots.put("Address",""+address.getAddressLine(0));
                    ValuesPopUpLots.put("ValuesPopUpLots",popupdata);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                viewforbutton.findViewById(R.id.buttsss).setVisibility(View.GONE);
             //  Textsss.setText(ValuesPopUpLots.toString());


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                viewforbutton.findViewById(R.id.buttsss).setVisibility(View.VISIBLE);
                //Write your code if there's no result
                Toast.makeText(this, "nhvgbn", Toast.LENGTH_SHORT).show();
            }
        }
        // super.onActivityResult(requestCode, resultCode, data);
    }
public void Examination_full()
{

    DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlCommitteeResultType, new IDataValue() {
        @Override
        public void Success(Object response) {
            data=response.toString();
            gson=new Gson();
            CommitteeResultTypeLIST[0]=gson.fromJson(data,CommitteeResultType.class);
            activityExRequestCommitteeResultBinding.setCommitteeResultType(CommitteeResultTypeLIST[0]);
        }

        @Override
        public void Error(VolleyError error) {

        }
    });

    activityExRequestCommitteeResultBinding.setCheckUpResult(checkup_result);

    activityExRequestCommitteeResultBinding.setPresenter(new IPresenter() {

        @Override
    public void OnItemSelectedSpinner_CommitteeResultType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
            if(pos!=0){
            IDItemSelect = String.valueOf(CommitteeResultTypeLIST[0].obj.get(pos).Value);
            CheckUpResult.setResult_ID(Integer.parseInt(IDItemSelect));
            if (IDItemSelect.equals("1") || IDItemSelect.equals("6")) {
                linear_Layout_Damaged.setVisibility(View.GONE);

            } else {
                linear_Layout_Damaged.setVisibility(View.VISIBLE);
                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantKingdom, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data = response.toString();
                        gson = new Gson();
                        LISTMKingdom[0] = gson.fromJson(data, LISTMKingdom.class);
                        activityExRequestCommitteeResultBinding.setLISTMKingdom((LISTMKingdom[0]));
                    }

                    @Override
                    public void Error(VolleyError error) {

                    }
                });

                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlIm_ProcedureType, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data=response.toString();
                        gson=new Gson();
                        LISTIm_ProcedureType[0]=gson.fromJson(data,LISTIm_ProcedureType.class);
                        activityExRequestCommitteeResultBinding.setLISTImProcedureType(LISTIm_ProcedureType[0]);
                    }

                    @Override
                    public void Error(VolleyError error) {

                    }
                });
            }
            }
            }


        @Override
        public void OnItemSelectedSpinner_Kingdom(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
            IDItemSelect = String.valueOf( LISTMKingdom[0].obj.get(pos).Value);
            CheckUpResult.setKingdom_ID(Integer.parseInt(IDItemSelect));
            DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantPhylum+IDItemSelect, new IDataValue() {
                @Override
                public void Success(Object response) {
                    data=response.toString();
                    gson=new Gson();
                    LISTPhylum[0] = gson.fromJson(data , LISTPhylum.class);
                    activityExRequestCommitteeResultBinding.setLISTPhylums(LISTPhylum[0]);
                }

                @Override
                public void Error(VolleyError error) {

                }
            });
        }
        @Override
        public void OnItemSelectedSpinner_Phylum(AdapterView<?> parent, View view, int pos, long id,Checkup_Result CheckUpResult) {
            IDItemSelect = String.valueOf(LISTPhylum[0].obj.get(pos).Value);
            CheckUpResult.setPhylum_ID(Integer.parseInt(IDItemSelect));
            DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantOrder + IDItemSelect, new IDataValue() {
                @Override
                public void Success(Object response) {
                    data=response.toString();
                    gson=new Gson();
                    LISTOrder[0]=gson.fromJson(data,LISTOrder.class);
                    activityExRequestCommitteeResultBinding.setLISTOrder(LISTOrder[0]);
                }

                @Override
                public void Error(VolleyError error) {

                }
            });
        }

        @Override
        public void OnItemSelectedSpinner_Order(AdapterView<?> parent, View view, int pos, long id,Checkup_Result CheckUpResult) {
            IDItemSelect=String.valueOf(LISTOrder[0].obj.get(pos).Value);
            CheckUpResult.setOrder_ID(Integer.parseInt(IDItemSelect));
            DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantFamily+IDItemSelect, new IDataValue() {
                @Override
                public void Success(Object response) {
                    data=response.toString();
                    gson=new Gson();
                    LISTFamily[0]=gson.fromJson(data,LISTFamily.class);
                    activityExRequestCommitteeResultBinding.setLISTFamily(LISTFamily[0]);
                }

                @Override
                public void Error(VolleyError error) {

                }
            });
        }

        @Override
        public void OnItemSelectedSpinner_Family(AdapterView<?> parent, View view, int pos, long id,Checkup_Result CheckUpResult) {
            IDItemSelect=String.valueOf(LISTFamily[0].obj.get(pos).Value);
            CheckUpResult.setFamily_ID(Integer.parseInt(IDItemSelect));
        }

        @Override
        public void OnItemSelectedSpinner_Im_ProcedureType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
            IDItemSelect=String.valueOf(LISTIm_ProcedureType[0].obj.get(pos).Value);
            CheckUpResult.setResult_injury(Integer.parseInt(IDItemSelect));

        }


        @Override
        public void OnClickSaveLots(View view,Checkup_Result checkupResult) {
      //      checkupResult.setCheckup(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
            checkupResult.setAddress(""+address.getAddressLine(0));
            checkupResult.setLatitude(lat);
            checkupResult.setLongitude(longg);
            String jsonInString = gson.toJson(checkupResult);
         //   Textsss.setText(jsonInString);
            //send request to save data in database
            //    finish();
        }

        @Override
        public void OnClickcancel(View view, Checkup_Result CheckUpResult) {
            checkup_result=null;
            linear_Layout_Examination_full.setVisibility(View.GONE);
            linear_Layout_btns.setVisibility(View.GONE);
            title_radio_group.setText("نوع الفحص");
            radioGroup.setVisibility(View.VISIBLE);
            linear_Layout_Examination_part.setVisibility(View.GONE);
        }

    });

}
public  void Examination_part(){
  //  Intent intent = getIntent();
 //   String ss = intent.getStringExtra("num_Request");
    DataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlEx_SampleData+getIntent().getStringExtra("num_Request"), new IDataValue() {
        @Override
        public void Success(Object response) {
            data = response.toString();
            gson = new Gson();
            SampleData_LOts[0] = Arrays.asList(gson.fromJson(data, SampleData_LOts[].class));

            MyAdapterforRecycler dd=new MyAdapterforRecycler(SampleData_LOts[0], context, new Clickcustum() {
                @Override
                public void button_click(View view,SampleData_LOts sampleData_lOts) {
                    Intent i= new Intent(context, CheckUp_Lots.class);
                    i.putExtra("ID", "" + sampleData_lOts.getLot_Id());
                    i.putExtra("LOTS_NUM", "" + sampleData_lOts.getLot_Number());
                    i.putExtra("ipadrass",ipadrass);
                    viewforbutton=view;
                    startActivityForResult(i,1);
                }

//                @Override
//                public void Generat_barcod_click(View view, com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts sampleData_lOts) {
//
//                }
            }
            );
            activityExRequestCommitteeResultBinding.setMyAdapter(dd);
            activityExRequestCommitteeResultBinding.resycler.setLayoutManager(new LinearLayoutManager(context));
        }

        @Override
        public void Error(VolleyError error) {

        }
    });

    activityExRequestCommitteeResultBinding.setCheckUpResult(checkup_result);
    activityExRequestCommitteeResultBinding.setPresenter(new IPresenter() {
        @Override
        public void OnItemSelectedSpinner_Kingdom(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {

        }

        @Override
        public void OnItemSelectedSpinner_Phylum(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {

        }

        @Override
        public void OnItemSelectedSpinner_Order(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {

        }

        @Override
        public void OnItemSelectedSpinner_Family(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {

        }

        @Override
        public void OnItemSelectedSpinner_Im_ProcedureType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {

        }

        @Override
        public void OnItemSelectedSpinner_CommitteeResultType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {

        }

        @Override
        public void OnClickSaveLots(View view, Checkup_Result CheckUpResult) {
//            CheckUpResult.setCheckup(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
//
            //String jsonInString = gson.toJson(nb);
          //Textsss.setText(ValuesPopUpLots.toString());
          //send request to save data in database
          finish();
        }

        @Override
        public void OnClickcancel(View view, Checkup_Result CheckUpResult) {

            checkup_result=null;
            linear_Layout_Examination_full.setVisibility(View.GONE);
            linear_Layout_btns.setVisibility(View.GONE);
            title_radio_group.setText("نوع الفحص");
            radioGroup.setVisibility(View.VISIBLE);
            linear_Layout_Examination_part.setVisibility(View.GONE);
        }
    });
}

    public void onRadioButtonClicked(View view) {
         checked =((RadioButton)view).isChecked();

        switch (view.getId()){

            case R.id.radio_Examination_full:
                if(checked)
                    linear_Layout_Examination_full.setVisibility(View.VISIBLE);
                    linear_Layout_btns.setVisibility(View.VISIBLE);
                    title_radio_group.setText("فحص كلي");
                    radioGroup.setVisibility(View.GONE);
                    linear_Layout_Examination_part.setVisibility(View.GONE);
                    Examination_full();
                LinearLayoutnum_request.setVisibility(View.VISIBLE);
                  //  sample.setVisibility(View.VISIBLE);
                    break;
            case R.id.radio_Examination_part:
                if(checked)
                    linear_Layout_Examination_full.setVisibility(View.GONE);
                    linear_Layout_btns.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.GONE);
                    title_radio_group.setText("فحص اللوطات");
                    Examination_part();
                LinearLayoutnum_request.setVisibility(View.VISIBLE);
                //    sample.setVisibility(View.VISIBLE);
                    linear_Layout_Examination_part.setVisibility(View.VISIBLE);
                break;

                default:
                    linear_Layout_Examination_full.setVisibility(View.GONE);
                    linear_Layout_btns.setVisibility(View.GONE);
                    title_radio_group.setText("نوع الفحص");
                    radioGroup.setVisibility(View.VISIBLE);
                   // sample.setVisibility(View.GONE);
                    linear_Layout_Examination_part.setVisibility(View.GONE);
                    LinearLayoutnum_request.setVisibility(View.GONE);
                    break;

        }
      //  Textsss.setText(result);
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        longg = location.getLongitude();

        Locale loc=new Locale("ar");
        Geocoder geocoder = new Geocoder(this,loc);

        try {
            address = geocoder.getFromLocation(lat, longg, 1).get(0);
//            Textsss.setText(location.getLatitude()+"\n" );
//            Textsss.append(location.getLongitude()+"\n");
//            Textsss.append(address.getAddressLine(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
