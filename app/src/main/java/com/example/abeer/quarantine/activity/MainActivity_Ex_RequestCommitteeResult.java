package com.example.abeer.quarantine.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.abeer.quarantine.adapter.MyAdapterforRecycler;
import com.example.abeer.quarantine.databinding.ActivityMainExRequestCommitteeResultBinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.model.Checkup_Result_Model;
import com.example.abeer.quarantine.presenter.Clickcustum;
import com.example.abeer.quarantine.presenter.IPresenter;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.Checkup_Result;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.CommitteeResultType;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTFamily;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTIm_ProcedureType;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTMKingdom;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTOrder;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.LISTPhylum;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity_Ex_RequestCommitteeResult extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,LocationListener {
Context context=this;
    String num_Request;
    String Request_id;
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
   //JSONArray popupdata=new JSONArray();
  JSONArray  datasendarray=new JSONArray();
    RadioButton Radio_full;
    RadioButton  Radio_part;
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
    Checkup_Result_Model checkupResultModel;
    Public_function public_function =new Public_function();
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor   prefsEditor;


    ActivityMainExRequestCommitteeResultBinding activityMainExRequestCommitteeResultBinding;
   // ActivityMainListofchipmentBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main__ex__request_committee_result);
        DataManger = new DataManger(this);
        checkup_result =new Checkup_Result();

        activityMainExRequestCommitteeResultBinding =
                DataBindingUtil.setContentView((Activity) context, R.layout.activity_main__ex__request_committee_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        //  sharedPreferences = context.getSharedPreferences("SharedPreference",MODE_PRIVATE);
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);

        num_Request = sharedPreferences.getString("num_Request","");
        Request_id = sharedPreferences.getString("checkRequest_Id","");
        ipadrass= sharedPreferences.getString("ipadrass","");
        linear_Layout_Examination_full=findViewById(R.id.linear_Layout_Examination_full);
        linear_Layout_btns=findViewById(R.id.btns);
        linear_Layout_Damaged=findViewById(R.id.damaged);
        linear_Layout_Examination_part=findViewById(R.id.linear_Layout_Examination_part);
        radioGroup=findViewById(R.id.radioGroup_Examination);
        Radio_full=findViewById(R.id.radio_Examination_full);
      //  LinearLayoutnum_request =findViewById(R.id.num_request);
        Radio_part=findViewById(R.id.radio_Examination_part);
        title_radio_group= findViewById(R.id.title_radio_group);
        sample =findViewById(R.id.sample);
        treatment=findViewById(R.id.treatment);
        value_request=findViewById(R.id.value_request);
        value_request.setText(num_Request);


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
                    if(datasendarray!=null){
                        datasendarray.put(datas);
                    }
                    else {
                        datasendarray=new JSONArray();
                        datasendarray.put(datas);
                    }
                    //popupdata.put(datas);
                }
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                ///////////////data of gps/////
//                ValuesPopUpLots =new JSONObject();
//                try {
//                    ValuesPopUpLots.put("Latitude",lat);
//                    ValuesPopUpLots.put("Longitude",longg);
//                    ValuesPopUpLots.put("Address",""+address.getAddressLine(0));
//                    ValuesPopUpLots.put("ValuesPopUpLots",popupdata);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                ///////////////////////

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void Examination_full()
    {

     //   DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ ApiCall.UrlCommitteeResultType, new IDataValue() {
          DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlCommitteeResultType, new IDataValue() {
            @Override
            public void Success(Object response) {
                data=response.toString();
                gson=new Gson();
                CommitteeResultTypeLIST[0]=gson.fromJson(data,CommitteeResultType.class);

                activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setCommitteeResultType(CommitteeResultTypeLIST[0]);
            }

            @Override
            public void Error(VolleyError error) {

            }
        });

        activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setCheckUpResult(checkup_result);

        activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setPresenter(new IPresenter() {

            @Override
            public void OnItemSelectedSpinner_CommitteeResultType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
                if(pos!=0){
                    IDItemSelect = String.valueOf(CommitteeResultTypeLIST[0].obj.get(pos).Value);
                    CheckUpResult.setResult_ID(Integer.parseInt(IDItemSelect));
                    if (IDItemSelect.equals("1") || IDItemSelect.equals("6")) {
                        linear_Layout_Damaged.setVisibility(View.GONE);

                    } else {
                        linear_Layout_Damaged.setVisibility(View.VISIBLE);
                       // DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantKingdom, new IDataValue() {

                        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlPlantKingdom, new IDataValue() {
                            @Override
                            public void Success(Object response) {
                                data = response.toString();
                                gson = new Gson();
                                LISTMKingdom[0] = gson.fromJson(data, LISTMKingdom.class);
                                activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setLISTMKingdom((LISTMKingdom[0]));
                            }

                            @Override
                            public void Error(VolleyError error) {

                            }
                        });

                       // DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlIm_ProcedureType, new IDataValue() {

                        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlIm_ProcedureType, new IDataValue() {
                            @Override
                            public void Success(Object response) {
                                data=response.toString();
                                gson=new Gson();
                                LISTIm_ProcedureType[0]=gson.fromJson(data,LISTIm_ProcedureType.class);
                                activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setLISTImProcedureType(LISTIm_ProcedureType[0]);
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
              //  DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantPhylum+IDItemSelect, new IDataValue() {

                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlPlantPhylum+IDItemSelect, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data=response.toString();
                        gson=new Gson();
                        LISTPhylum[0] = gson.fromJson(data , LISTPhylum.class);
                        activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setLISTPhylums(LISTPhylum[0]);
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
            //    DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantOrder + IDItemSelect, new IDataValue() {

                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlPlantOrder + IDItemSelect, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data=response.toString();
                        gson=new Gson();
                        LISTOrder[0]=gson.fromJson(data,LISTOrder.class);
                        activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setLISTOrder(LISTOrder[0]);
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
           //     DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlPlantFamily+IDItemSelect, new IDataValue() {

                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlPlantFamily+IDItemSelect, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data=response.toString();
                        gson=new Gson();
                        LISTFamily[0]=gson.fromJson(data,LISTFamily.class);
                        activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setLISTFamily(LISTFamily[0]);
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

                //
//                checkupResult.setCheckup(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
//                checkupResult.setlot_ID(0);
//                checkupResult.setCommittee_ID(sharedPreferences.getLong("Committee_ID",0));
//                checkupResult.setEmployeeId(sharedPreferences.getLong("EmpId",0));
//                checkupResultModel=new Checkup_Result_Model(checkupResult);
///
                checkupResult.setlot_ID(0);
                checkupResultModel=new Checkup_Result_Model(checkupResult);
                if( linear_Layout_Damaged.getVisibility()==View.VISIBLE && (checkupResultModel.getItem__OrderID()==0 ||checkupResultModel.getResult_injuryID()==0)) {
                    public_function.AlertDialog("برجاء تحديد نوع الاصابة ونتيجة الاصابة",context,false);
                }else if(linear_Layout_Damaged.getVisibility()==View.GONE &&(checkupResultModel.getWeight()==0||checkupResultModel.getQuantitySize()==0||checkupResultModel.getCommitteeResultType_ID()==0)){

                    public_function.AlertDialog(" برجاءإستكمال البيانات ",context,false);

                } else if(linear_Layout_Damaged.getVisibility()==View.VISIBLE &&(checkupResultModel.getWeight()==0||checkupResultModel.getQuantitySize()==0)){

                    public_function.AlertDialog(" برجاءإستكمال البيانات العدد والوزن ",context,false);

                }
                else {
                    checkupResultModel.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
                    checkupResultModel.setCommittee_ID(sharedPreferences.getLong("Committee_ID",0));
                    checkupResultModel.setEmployeeId(sharedPreferences.getLong("EmpId",0));
                    final String json = new Gson().toJson(checkupResultModel);
                    //  final String json = "{\"CommitteeResultType_ID\":2,\"Committee_ID\":40010,\"Date\":\"2019-08-19 09:04:12\",\"EmployeeId\":30580,\"Ex_RequestLotData_ID\":0,\"ID\":0,\"Item_ID\":1,\"Item__OrderID\":65,\"QuantitySize\":21,\"Result_injuryID\":6,\"Weight\":3}";
                    try {
                        JSONObject datasend = new JSONObject(json);
                    // JSONArray datasendarray = new JSONArray();
                        if(datasendarray!=null){
                            datasendarray.put(datasend);
                        }
                        else {
                            datasendarray=new JSONArray();
                            datasendarray.put(datasend);
                        }
                        //public_function.senddataonlinetoserver(datasendarray,context, ApiCall.UrlCommitteeResult,findViewById(R.id.btns));
                       prefsEditor=sharedPreferences.edit();
                        prefsEditor.putInt("request_data",0);
                        prefsEditor.putInt("totalprocess",sharedPreferences.getInt("totalprocess",0)-1);
                        prefsEditor.apply();
                        prefsEditor.commit();
//                        int treatmentprocess=sharedPreferences.getInt("treatment_data",0);
//                        int sampleprocess=sharedPreferences.getInt("sample_data",0);
                      if(sharedPreferences.getInt("totalprocess",-2)==0){
                           // public_function.senddataonlinetoserver(datasendarray, context, ipadrass + ApiCall.UrlCommitteeResult);
                           JSONObject jsonObject=new JSONObject();
                           jsonObject.put("Committe_Dto",datasendarray);
                           jsonObject.put("SampleDto","");
                           jsonObject.put("Treatment_Dto","");
                           public_function.senddataonlinetoserverformoreprocess(jsonObject,context,ipadrass+ApiCall.UrlSavemultprocess);
                        }else{
                          //totalprocess != 0
                            prefsEditor = sharedPreferences.edit();
                            prefsEditor.putString("Committe_Dto", String.valueOf(datasendarray));
                            prefsEditor.apply();
                            prefsEditor.commit();
                            public_function.AlertDialog("برجاء اتمام العمليات ",context,true);

                        }
                      datasendarray=null;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
//                checkupResult.setAddress(""+address.getAddressLine(0));
//                checkupResult.setLatitude(lat);
//               checkupResult.setLongitude(longg);
//                String jsonInString = gson.toJson(checkupResult);
                //   Textsss.setText(jsonInString);
                //send request to save data in database

            }

            @Override
            public void OnClickcancel(View view, Checkup_Result CheckUpResult) {
                checkup_result=null;
               datasendarray=null;
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
        DataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ipadrass+ApiCall.UrlEx_SampleData+Request_id, new IDataValue() {
            @Override
            public void Success(Object response) {
                data = response.toString();
                gson = new Gson();
                SampleData_LOts[0] = Arrays.asList(gson.fromJson(data, SampleData_LOts[].class));

                MyAdapterforRecycler dd=new MyAdapterforRecycler(SampleData_LOts[0], context, new Clickcustum() {
                    @Override
                    public void button_click(View view,SampleData_LOts sampleData_lOts) {
                        Intent i= new Intent(context, CheckUp_Lots.class);
                        i.putExtra("ID",sampleData_lOts.getLot_Id());
                        i.putExtra("LOTS_NUM", "" + sampleData_lOts.getLot_Number());
//                        i.putExtra("ipadrass",ipadrass);

//                        prefsEditor = sharedPreferences.edit();
//                        prefsEditor.putLong("ID",sampleData_lOts.getLot_Id());
//                        prefsEditor.putString("LOTS_NUM",sampleData_lOts.getLot_Number());
//                       Long s=sharedPreferences.getLong("ID",0);
//                       String sss=sharedPreferences.getString("LOTS_NUM","");
                        viewforbutton=view;
                        startActivityForResult(i,1);
                    }

//                    @Override
//                    public void Generat_barcod_click(View view, com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts sampleData_lOts) {
//
//                    }
                }
                );
                activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setMyAdapter(dd);
                activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.resycler.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void Error(VolleyError error) {

            }
        });

        activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setCheckUpResult(checkup_result);
        activityMainExRequestCommitteeResultBinding.contentrequestCommitteeResult.setPresenter(new IPresenter() {
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

                prefsEditor=sharedPreferences.edit();
                prefsEditor.putInt("request_data",0);
                prefsEditor.putInt("totalprocess",sharedPreferences.getInt("totalprocess",0)-1);
                prefsEditor.apply();
                prefsEditor.commit();
               try {
                       if(sharedPreferences.getInt("totalprocess",-2)==0) {
                            // public_function.senddataonlinetoserver(datasendarray, context, ipadrass + ApiCall.UrlCommitteeResult);
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("Committe_Dto", datasendarray);
                            jsonObject.put("SampleDto", "");
                            jsonObject.put("Treatment_Dto", "");
                            public_function.senddataonlinetoserverformoreprocess(jsonObject, context, ipadrass + ApiCall.UrlSavemultprocess);
                        } else{
                        //totalprocess != 0
                        prefsEditor = sharedPreferences.edit();
                        prefsEditor.putString("Committe_Dto", String.valueOf(datasendarray));
                        prefsEditor.apply();
                        prefsEditor.commit();
                        public_function.AlertDialog("برجاء اتمام العمليات ",context,true);
                      }

               } catch (JSONException e) {
                        e.printStackTrace();
                    }

                datasendarray=null;
//                int treatmentprocess=sharedPreferences.getInt("treatment_data",0);
//                int sampleprocess=sharedPreferences.getInt("sample_data",0);
//                if(treatmentprocess==0 && sampleprocess==0) {
//                    public_function.senddataonlinetoserver(datasendarray, context, ipadrass + ApiCall.UrlCommitteeResult);
//                }else if(treatmentprocess !=0||sampleprocess !=0){
//                    prefsEditor = sharedPreferences.edit();
//                    prefsEditor.putString("EX_Request", String.valueOf(datasendarray));
//                    prefsEditor.putInt("request_data", 0);
//                    prefsEditor.apply();
//                    prefsEditor.commit();
//                    public_function.AlertDialog("برجاء اتمام العمليات ",context,true);
//                }
//                //////////////
////                else if(treatmentprocess!=0&&sampleprocess==0){
////                    //treanment activity we need alert
////                    Intent intent=new Intent(context,MainActivity_TreatmentStatement.class);
////                    intent.putExtra("EX_Request", (Serializable) datasendarray);
////                    startActivity(intent);
////                    //    intent.putExtra()
////
////                }else  if(treatmentprocess==0&&sampleprocess!=0){
////                    //sample activity we need alert
////                    Intent intent=new Intent(context,MainActivity_SampleWithDraw.class);
////                    intent.putExtra("EX_Request", (Serializable) datasendarray);
////                    startActivity(intent);
////                }
////                else if( treatmentprocess!=0 && sampleprocess!=0 ){
////                    //
////                    Intent intent=new Intent(context,MainActivity_TreatmentStatement.class);
////                    intent.putExtra("EX_Request", (Serializable) datasendarray);
////                    startActivity(intent);
////                }
//////////
//                datasendarray=null;

//            CheckUpResult.setCheckup(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
//
                //String jsonInString = gson.toJson(nb);
                //Textsss.setText(ValuesPopUpLots.toString());
                //send request to save data in database
                // finish();
            }

            @Override
            public void OnClickcancel(View view, Checkup_Result CheckUpResult) {

                checkup_result=null;
                datasendarray=null;
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
             //   LinearLayoutnum_request.setVisibility(View.VISIBLE);
                //  sample.setVisibility(View.VISIBLE);
                break;
            case R.id.radio_Examination_part:
                if(checked)
                    linear_Layout_Examination_full.setVisibility(View.GONE);
                linear_Layout_btns.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.GONE);
                title_radio_group.setText("فحص اللوطات");
                Examination_part();
             //   LinearLayoutnum_request.setVisibility(View.VISIBLE);
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
               // LinearLayoutnum_request.setVisibility(View.GONE);
                break;

        }
        //  Textsss.setText(result);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main_activity__ex__request_committee_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        try {
            public_function.NavMenuClick(id,context,sharedPreferences.getString("Token","")
                    ,sharedPreferences.getBoolean("ISAdmin",false)
                    ,sharedPreferences.getInt("RequestCommittee_Status_Id",0),
                    sharedPreferences.getInt("treatment_data",-1),
                    sharedPreferences.getInt("sample_data",-1),
                    sharedPreferences.getInt("request_data",-1),
                    sharedPreferences.getInt("Committee_Type_Id",0),ipadrass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        if (id == R.id.language) {
//            // Handle the camera action
//        } else if (id == R.id.sample_title) {
//            Intent i=new Intent(context,MainActivity_SampleWithDraw.class);
//           // i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        } else if (id == R.id.treatment_title) {
//            Intent i=new Intent(context,MainActivity_TreatmentStatement.class);
//          //  i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//
//
//        } else if (id == R.id.Committee_title) {
//            Intent i=new Intent(context,MainActivity_Ex_RequestCommitteeResult.class);
//            //i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        }else if (id == R.id.todolist) {
//            Intent i=new Intent(context,MainActivity_Listofchipment.class);
//           // i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        }
//        else if (id == R.id.logout) {
//            Intent i=new Intent(context,LogIn.class);
//            startActivity(i);
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
