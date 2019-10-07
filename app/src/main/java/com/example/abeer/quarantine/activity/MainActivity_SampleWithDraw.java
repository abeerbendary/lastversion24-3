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
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import com.example.abeer.quarantine.databinding.ActivityMainSampleWithDrawBinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.model.Checkup_Result_Model;
import com.example.abeer.quarantine.model.Sample_Result_Model;
import com.example.abeer.quarantine.presenter.Clickcustum;
import com.example.abeer.quarantine.presenter.ISamplePresenter;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Barcod_Card;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.ListAnalysis;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.ListLabName;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Sample_Result;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity_SampleWithDraw extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,LocationListener {
Context context=this;
    String num_Request;
ActivityMainSampleWithDrawBinding activityMainSampleWithDrawBinding;
    DataManger dataManger;
    Gson gson;
    String ID_itemSelected;
    RadioGroup radioGroup_Samples;
    LinearLayout linear_Layout_Sample_full;
    LinearLayout linear_Layout_Sample_part;
    LinearLayout linear_Layout_btns_Sample;
    LinearLayout linear_Layout_num_talab;
 //   LinearLayout linear_Layout_num_sample;
    LocationManager manager;
    TextView title_radio_group;
    String data;
    String ipadrass;
    Sample_Result_Model sampleResultModel;
    boolean checked;
    Sample_Result sampleResult;
    final ListLabName[] listLabs = new ListLabName[1];
    final ListAnalysis[] listAnalysis = new ListAnalysis[1];
    final List<SampleData_LOts>[] SampleData_LOts = new List[1];
    Address address;
    double lat,longg;
    JSONObject datas;
    View viewforbutton;
    JSONObject ValuesPopUpLots ;
    TextView value_sample;
    String EX_Request;
    TextView text;
    SharedPreferences sharedPreferences;
    JSONArray datasendarray = new JSONArray();
    Public_function public_function;
    SharedPreferences.Editor prefsEditor;
    List<Barcod_Card>barcod_cards=new ArrayList<>();
    String Request_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainSampleWithDrawBinding = DataBindingUtil.setContentView(this,R.layout.activity_main__sample_with_draw);
        dataManger = new DataManger(this);
        sampleResult=new Sample_Result();
        radioGroup_Samples  = findViewById(R.id.radioGroup_Samples);
        text=findViewById(R.id.txt);
        linear_Layout_Sample_full =  findViewById(R.id.linear_Layout_Sample_full);
        linear_Layout_Sample_part = findViewById(R.id.linear_Layout_Sample_part);
        linear_Layout_btns_Sample =findViewById(R.id.btns_Sample);
        linear_Layout_num_talab =findViewById(R.id.num);
       // linear_Layout_num_sample=findViewById(R.id.num_sample);
        title_radio_group =findViewById(R.id.title_radio_group_Sample);
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
        num_Request = sharedPreferences.getString("num_Request","");
        Request_id = sharedPreferences.getString("checkRequest_Id","");
        ipadrass= sharedPreferences.getString("ipadrass","");
      //  EX_Request=sharedPreferences.getString("Committe_Dto","");
      //  Toast.makeText(context, EX_Request, Toast.LENGTH_LONG).show();
        value_sample=findViewById(R.id.value_sample);
        value_sample.setText(num_Request);
        public_function=new Public_function();
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
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 100) {
            if (grantResults != null && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                try {
                    manager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, (LocationListener) this, null);
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
        String result;

     //   JSONArray popupdata=new JSONArray();
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
                    try {
                        barcod_cards.add(new Barcod_Card(num_Request,datas.getString("ID"),datas.getString("Sample_BarCode")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // popupdata.put(datas);
                }
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
//                ValuesPopUpLots =new JSONObject();
//                try {
//                    ValuesPopUpLots.put("Latitude",lat);
//                    ValuesPopUpLots.put("Longitude",longg);
//                    ValuesPopUpLots.put("Address",""+address.getAddressLine(0));
//                    ValuesPopUpLots.put("ValuesPopUpLots",popupdata);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                viewforbutton.findViewById(R.id.buttsss).setVisibility(View.GONE);
             //   Textsss.setText(ValuesPopUpLots.toString());


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                viewforbutton.findViewById(R.id.buttsss).setVisibility(View.VISIBLE);
                //Write your code if there's no result
                Toast.makeText(this, "nhvgbn", Toast.LENGTH_SHORT).show();
            }
        }
        // super.onActivityResult(requestCode, resultCode, data);
    }
    public void Sample_full()
    {

       // dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, "http://"+ipadrass+ ApiCall.AnalysisType, new IDataValue() {
        dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, ipadrass+ApiCall.AnalysisType, new IDataValue() {

                @Override
            public void Success(Object response) {
                data=response.toString();
                gson = new Gson();
                listAnalysis[0] = gson.fromJson(data, ListAnalysis.class);
                activityMainSampleWithDrawBinding.contentSampleWithDraw.setAnalysis(listAnalysis[0]);
            }
            @Override
            public void Error(VolleyError error) {


            }
        });


        activityMainSampleWithDrawBinding.contentSampleWithDraw.setSampleResult(sampleResult);
        activityMainSampleWithDrawBinding.contentSampleWithDraw.setISamplePresenter(new ISamplePresenter() {
            @Override
            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result) {

                // CheckUpResult.setKingdom_ID(Integer.parseInt(IDItemSelect));
                ID_itemSelected = String.valueOf(listAnalysis[0].obj.get(pos).Value);
                sample_result.setAnalysisType_ID(Short.parseShort(ID_itemSelected));
                Toast.makeText(MainActivity_SampleWithDraw.this, ""+ID_itemSelected, Toast.LENGTH_SHORT).show();

               // dataManger.SendVollyRequestJsonObjectGet(MainActivity_SampleWithDraw.this, Request.Method.GET, ApiCall.UrlLabName+ID_itemSelected, new IDataValue() {

                dataManger.SendVollyRequestJsonObjectGet(MainActivity_SampleWithDraw.this, Request.Method.GET, ipadrass+ApiCall.UrlLabName+ID_itemSelected, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data = response.toString();
                        gson = new Gson();
                        listLabs[0] = gson.fromJson(data, ListLabName.class);
                        activityMainSampleWithDrawBinding.contentSampleWithDraw.setLabs(listLabs[0]);
                    }
                    @Override
                    public void Error(VolleyError error) {
                        Toast.makeText(MainActivity_SampleWithDraw.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void OnItemSelectedSpinner_laboratory(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result) {

                ID_itemSelected = String.valueOf(listLabs[0].obj.get(pos).ID);
                sample_result.setLaboratory_ID(Integer.parseInt(ID_itemSelected));
            }

            @Override
            public void OnClickSaveLots(View view, Sample_Result sampleResult) {

//                sampleResult.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
//                sampleResult.setAddress(""+address.getAddressLine(0));
//                sampleResult.setLatitude(lat);
//                sampleResult.setLongitude(longg);
//                String jsonInString = gson.toJson(sampleResult);
//                Textsss.setText(jsonInString);

                sampleResult.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
                sampleResult.setLot_ID((long) 0);
                sampleResult.setBarCode(sharedPreferences.getString("BarCode","")+0);
                sampleResult.setCommittee_ID(sharedPreferences.getLong("Committee_ID",0));
                sampleResult.setEmployeeId(sharedPreferences.getLong("EmpId",0));
                sampleResultModel=new Sample_Result_Model(sampleResult);
                if(sampleResult.getAnalysisType_ID()==0) {

                    public_function.AlertDialog("برجاء تحديد نوع التحليل ",context,false);
                }
                else {
                    final String json = new Gson().toJson(sampleResultModel);
                    //  final String json = "{\"CommitteeResultType_ID\":2,\"Committee_ID\":40010,\"Date\":\"2019-08-19 09:04:12\",\"EmployeeId\":30580,\"Ex_RequestLotData_ID\":0,\"ID\":0,\"Item_ID\":1,\"Item__OrderID\":65,\"QuantitySize\":21,\"Result_injuryID\":6,\"Weight\":3}";
                    try {
                        JSONObject datasend = new JSONObject(json);
//                        if(datasendarray==null){
//                            datasendarray=new JSONArray();
//                        }
                        //public_function.senddataonlinetoserver(datasendarray,context, ApiCall.UrlCommitteeResult,findViewById(R.id.btns));
                        barcod_cards.add(new Barcod_Card(num_Request,"0",sampleResult.getBarCode()+"0"));
                       // public_function.senddataonlinetoserver(datasendarray,context, ipadrass+ApiCall.UrlSampleDataResult,barcod_cards);
                        prefsEditor=sharedPreferences.edit();
                        prefsEditor.putInt("sample_data",sharedPreferences.getInt("sample_data",-2)-1);
                        prefsEditor.putInt("totalprocess",sharedPreferences.getInt("totalprocess",-2)-1);
                        prefsEditor.apply();
                        String SampleDto=sharedPreferences.getString("SampleDto","");
                        if(SampleDto==""){
                            JSONArray jsonArray=new JSONArray();
                            jsonArray.put(datasend);
                            prefsEditor=sharedPreferences.edit();
                            prefsEditor.putString("SampleDto",String.valueOf(jsonArray));
                            prefsEditor.apply();
                        }else {
                            JSONArray jsonArray=new JSONArray(SampleDto);
                            jsonArray.put(datasend);
                            prefsEditor=sharedPreferences.edit();
                            prefsEditor.putString("SampleDto",String.valueOf(jsonArray));
                            prefsEditor.apply();
                        }

                        int totalprocess=sharedPreferences.getInt("totalprocess",0);

                        if(totalprocess==0){
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("Committe_Dto", sharedPreferences.getString("Committe_Dto",""));
                            jsonObject.put("SampleDto", sharedPreferences.getString("SampleDto",""));
                            jsonObject.put("Treatment_Dto", sharedPreferences.getString("Treatment_Dto",""));
                            public_function.senddataonlinetoserverformoreprocess(jsonObject,context,ipadrass + ApiCall.UrlSavemultprocess,barcod_cards);

                        }else {
                            public_function.showbarcodelist(context,barcod_cards);
                            public_function.AlertDialog("برجاء اتمام العمليات ",context,true);

                        }
                        barcod_cards=null;
                        datasendarray=null;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void OnClickcancel(View view, Sample_Result sampleResult) {

                linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.GONE);
                title_radio_group.setText("سحب العينات ");
                datasendarray=null;
                linear_Layout_num_talab.setVisibility(View.GONE);
                radioGroup_Samples.setVisibility(View.VISIBLE);
                linear_Layout_Sample_part.setVisibility(View.GONE);

            }
        });
//        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlCommitteeResultType, new IDataValue() {
//            @Override
//            public void Success(Object response) {
//                data=response.toString();
//                gson=new Gson();
//                CommitteeResultTypeLIST[0]=gson.fromJson(data, CommitteeResultType.class);
//                activityExRequestCommitteeResultBinding.setCommitteeResultType(CommitteeResultTypeLIST[0]);
//            }
//
//            @Override
//            public void Error(VolleyError error) {
//
//            }
//        });
//
//        activityExRequestCommitteeResultBinding.setCheckUpResult(checkup_result);
//
//        activityExRequestCommitteeResultBinding.setPresenter(new IPresenter() {
//
//            @Override
//            public void OnItemSelectedSpinner_CommitteeResultType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//                if(pos!=0){
//                    IDItemSelect = String.valueOf(CommitteeResultTypeLIST[0].obj.get(pos).Value);
//                    CheckUpResult.setResult_ID(Integer.parseInt(IDItemSelect));
//                    if (IDItemSelect.equals("1") || IDItemSelect.equals("6")) {
//                        linear_Layout_Damaged.setVisibility(View.GONE);
//
//                    } else {
//                        linear_Layout_Damaged.setVisibility(View.VISIBLE);
//                        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlPlantKingdom, new IDataValue() {
//                            @Override
//                            public void Success(Object response) {
//                                data = response.toString();
//                                gson = new Gson();
//                                LISTMKingdom[0] = gson.fromJson(data, LISTMKingdom.class);
//                                activityExRequestCommitteeResultBinding.setLISTMKingdom((LISTMKingdom[0]));
//                            }
//
//                            @Override
//                            public void Error(VolleyError error) {
//
//                            }
//                        });
//
//                        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlIm_ProcedureType, new IDataValue() {
//                            @Override
//                            public void Success(Object response) {
//                                data=response.toString();
//                                gson=new Gson();
//                                LISTIm_ProcedureType[0]=gson.fromJson(data, LISTIm_ProcedureType.class);
//                                activityExRequestCommitteeResultBinding.setLISTImProcedureType(LISTIm_ProcedureType[0]);
//                            }
//
//                            @Override
//                            public void Error(VolleyError error) {
//
//                            }
//                        });
//                    }
//                }
        //          }

//
//            @Override
//            public void OnItemSelectedSpinner_Kingdom(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//                IDItemSelect = String.valueOf( LISTMKingdom[0].obj.get(pos).Value);
//                CheckUpResult.setKingdom_ID(Integer.parseInt(IDItemSelect));
//                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlPlantPhylum+IDItemSelect, new IDataValue() {
//                    @Override
//                    public void Success(Object response) {
//                        data=response.toString();
//                        gson=new Gson();
//                        LISTPhylum[0] = gson.fromJson(data , LISTPhylum.class);
//                        activityExRequestCommitteeResultBinding.setLISTPhylums(LISTPhylum[0]);
//                    }
//
//                    @Override
//                    public void Error(VolleyError error) {
//
//                    }
//                });
//            }
//            @Override
//            public void OnItemSelectedSpinner_Phylum(AdapterView<?> parent, View view, int pos, long id,Checkup_Result CheckUpResult) {
//                IDItemSelect = String.valueOf(LISTPhylum[0].obj.get(pos).Value);
//                CheckUpResult.setPhylum_ID(Integer.parseInt(IDItemSelect));
//                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlPlantOrder + IDItemSelect, new IDataValue() {
//                    @Override
//                    public void Success(Object response) {
//                        data=response.toString();
//                        gson=new Gson();
//                        LISTOrder[0]=gson.fromJson(data, LISTOrder.class);
//                        activityExRequestCommitteeResultBinding.setLISTOrder(LISTOrder[0]);
//                    }
//
//                    @Override
//                    public void Error(VolleyError error) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_Order(AdapterView<?> parent, View view, int pos, long id,Checkup_Result CheckUpResult) {
//                IDItemSelect=String.valueOf(LISTOrder[0].obj.get(pos).Value);
//                CheckUpResult.setOrder_ID(Integer.parseInt(IDItemSelect));
//                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlPlantFamily+IDItemSelect, new IDataValue() {
//                    @Override
//                    public void Success(Object response) {
//                        data=response.toString();
//                        gson=new Gson();
//                        LISTFamily[0]=gson.fromJson(data, LISTFamily.class);
//                        activityExRequestCommitteeResultBinding.setLISTFamily(LISTFamily[0]);
//                    }
//
//                    @Override
//                    public void Error(VolleyError error) {
//
//                    }
//                });
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_Family(AdapterView<?> parent, View view, int pos, long id,Checkup_Result CheckUpResult) {
//                IDItemSelect=String.valueOf(LISTFamily[0].obj.get(pos).Value);
//                CheckUpResult.setFamily_ID(Integer.parseInt(IDItemSelect));
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_Im_ProcedureType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//                IDItemSelect=String.valueOf(LISTIm_ProcedureType[0].obj.get(pos).Value);
//                CheckUpResult.setResult_injury(Integer.parseInt(IDItemSelect));
//
//            }
//
//
//            @Override
//            public void OnClickSaveLots(View view,Checkup_Result checkupResult) {
//                checkupResult.setCheckup(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
//                checkupResult.setAddress(""+address.getAddressLine(0));
//                checkupResult.setLatitude(lat);
//                checkupResult.setLongitude(longg);
//                String jsonInString = gson.toJson(checkupResult);
//                Textsss.setText(jsonInString);
//                //send request to save data in database
//                //    finish();
//            }
//
//            @Override
//            public void OnClickcancel(View view, Checkup_Result CheckUpResult) {
//                checkup_result=null;
//                linear_Layout_Examination_full.setVisibility(View.GONE);
//                linear_Layout_btns.setVisibility(View.GONE);
//                title_radio_group.setText("نوع الفحص");
//                radioGroup.setVisibility(View.VISIBLE);
//                linear_Layout_Examination_part.setVisibility(View.GONE);
//            }
//
//        });

    }
    public  void Sample_part(){
     //   dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlEx_SampleData+getIntent().getStringExtra("num_Request"), new IDataValue() {

        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ipadrass+ApiCall.UrlEx_SampleData+Request_id, new IDataValue() {
            @Override
            public void Success(Object response) {
                data = response.toString();
                gson = new Gson();
                SampleData_LOts[0] = Arrays.asList(gson.fromJson(data, SampleData_LOts[].class));

                MyAdapterforRecycler dd=new MyAdapterforRecycler(SampleData_LOts[0], context, new Clickcustum() {
                    @Override
                    public void button_click(View view,SampleData_LOts sampleData_lOts) {
                        Intent i= new Intent(context, Sample_Lots.class);
//                        SharedPreferences.Editor   prefsEditor = sharedPreferences.edit();
//                        prefsEditor.putLong("ID",sampleData_lOts.getLot_Id());
//                        prefsEditor.putString("LOTS_NUM",sampleData_lOts.getLot_Number());
                        i.putExtra("ID",  sampleData_lOts.getLot_Id());
                        i.putExtra("LOTS_NUM", "" + sampleData_lOts.getLot_Number());
//                        i.putExtra("ipadrass",ipadrass);
                        viewforbutton=view;
                        startActivityForResult(i,1);
                    }

//                    @Override
//                    public void Generat_barcod_click(View view, com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts sampleData_lOts) {
//                        Intent i= new Intent(context, Generate_barcode.class);
//                        i.putExtra("barcode",sharedPreferences.getString("BarCode","")+sampleData_lOts.getLot_Number());
//
//                       // i.putExtra("barcod",sampleData_lOts.)
//                        startActivity(i);
//                    }
                });
                activityMainSampleWithDrawBinding.contentSampleWithDraw.setMyAdapter(dd);
                activityMainSampleWithDrawBinding.contentSampleWithDraw.recyclerViewSample.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void Error(VolleyError error) {

            }
        });

        activityMainSampleWithDrawBinding.contentSampleWithDraw.setSampleResult(sampleResult);
        activityMainSampleWithDrawBinding.contentSampleWithDraw.setISamplePresenter(new ISamplePresenter() {
            @Override
            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result) {

            }

            @Override
            public void OnItemSelectedSpinner_laboratory(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result) {

            }

            @Override
            public void OnClickSaveLots(View view, Sample_Result sampleResult) {
//                Textsss.setText(ValuesPopUpLots.toString());
//                //send request to save data in database
//                finish();

                //////////////
//                public_function.senddataonlinetoserver(datasendarray,context, ipadrass+ApiCall.UrlSampleDataResult,barcod_cards);
                try {
                prefsEditor=sharedPreferences.edit();
                prefsEditor.putInt("sample_data",sharedPreferences.getInt("sample_data",-2)-1);
                prefsEditor.putInt("totalprocess",sharedPreferences.getInt("totalprocess",-2)-1);
                prefsEditor.apply();
                String SampleDto=sharedPreferences.getString("SampleDto","");
                if(SampleDto==""){
                        prefsEditor=sharedPreferences.edit();
                        prefsEditor.putString("SampleDto",String.valueOf(datasendarray));
                        prefsEditor.apply();
                    }else {
                    JSONArray  jsonArray = new JSONArray(SampleDto);
                    for (int i = 0; i < datasendarray.length(); i++) {
                        JSONObject jsonObject = datasendarray.getJSONObject(i);
                        jsonArray.put(jsonObject);
                    }
                    prefsEditor=sharedPreferences.edit();
                    prefsEditor.putString("SampleDto",String.valueOf(jsonArray));
                    prefsEditor.apply();

                }
                int totalprocess=sharedPreferences.getInt("totalprocess",0);

                if(totalprocess==0){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("Committe_Dto", sharedPreferences.getString("Committe_Dto",""));
                    jsonObject.put("SampleDto", sharedPreferences.getString("SampleDto",""));
                    jsonObject.put("Treatment_Dto", sharedPreferences.getString("Treatment_Dto",""));
                    public_function.senddataonlinetoserverformoreprocess(jsonObject,context,ipadrass + ApiCall.UrlSavemultprocess,barcod_cards);

                } else {
                    public_function.showbarcodelist(context,barcod_cards);
                    public_function.AlertDialog("برجاء اتمام العمليات ",context,true);

                }
               datasendarray=null;
                barcod_cards=null;

                } catch (JSONException e) {
                e.printStackTrace();
            }
                //////////////////
            }

            @Override
            public void OnClickcancel(View view, Sample_Result sampleResult) {
                linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.GONE);
                title_radio_group.setText("سحب العينات ");
                datasendarray=null;
                linear_Layout_num_talab.setVisibility(View.GONE);
                radioGroup_Samples.setVisibility(View.VISIBLE);
                linear_Layout_Sample_part.setVisibility(View.GONE);
            }
        });
//        activityExRequestCommitteeResultBinding.setPresenter(new IPresenter() {
//            @Override
//            public void OnItemSelectedSpinner_Kingdom(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_Phylum(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_Order(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_Family(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_Im_ProcedureType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//
//            }
//
//            @Override
//            public void OnItemSelectedSpinner_CommitteeResultType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
//
//            }
//
//            @Override
//            public void OnClickSaveLots(View view, Checkup_Result CheckUpResult) {
////            CheckUpResult.setCheckup(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
////
//                //String jsonInString = gson.toJson(nb);
//                Textsss.setText(ValuesPopUpLots.toString());
//                //send request to save data in database
//                finish();
//            }
//
//            @Override
//            public void OnClickcancel(View view, Checkup_Result CheckUpResult) {
//
//                checkup_result=null;
//                linear_Layout_Examination_full.setVisibility(View.GONE);
//                linear_Layout_btns.setVisibility(View.GONE);
//                title_radio_group.setText("نوع الفحص");
//                radioGroup.setVisibility(View.VISIBLE);
//                linear_Layout_Examination_part.setVisibility(View.GONE);
//            }
//        });
    }

    public void onRadioButtonClicked(View view) {
        checked = ((RadioButton) view).isChecked();
        Button btn_generat= findViewById(R.id.btn_generat);
        switch (view.getId()) {

            case R.id.radio_Sample_full:
                if (checked)
                    linear_Layout_Sample_full.setVisibility(View.VISIBLE);
                linear_Layout_btns_Sample.setVisibility(View.VISIBLE);
                title_radio_group.setText("سحب عينة للشحنة");
              //  btn_generat.setVisibility(View.VISIBLE);
                radioGroup_Samples.setVisibility(View.GONE);
                linear_Layout_Sample_part.setVisibility(View.GONE);
                linear_Layout_num_talab.setVisibility(View.VISIBLE);
            //    linear_Layout_num_sample.setVisibility(View.VISIBLE);
                Sample_full();
                break;
            case R.id.radio_Sample_part:
                if (checked)
                    linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.VISIBLE);
                radioGroup_Samples.setVisibility(View.GONE);
                title_radio_group.setText("سحب عينات للوطات");
               // btn_generat.setVisibility(View.GONE);
                Sample_part();
                linear_Layout_Sample_part.setVisibility(View.VISIBLE);
                linear_Layout_num_talab.setVisibility(View.VISIBLE);
                //   linear_Layout_num_sample.setVisibility(View.VISIBLE);
                break;

            default:
                linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.GONE);
                title_radio_group.setText("سحب العينات ");
                //btn_generat.setVisibility(View.GONE);
                radioGroup_Samples.setVisibility(View.VISIBLE);
                linear_Layout_Sample_part.setVisibility(View.GONE);
                linear_Layout_num_talab.setVisibility(View.GONE);
            //    linear_Layout_num_sample.setVisibility(View.GONE);
              //  btn_generat.setVisibility(View.GONE);
                break;

        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     //   getMenuInflater().inflate(R.menu.main_activity__sample_with_draw, menu);
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
                    ,sharedPreferences.getBoolean("ISAdmin",false),
                    sharedPreferences.getInt("RequestCommittee_Status_Id",0),
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
//            startActivity(i);
//
//
//        } else if (id == R.id.treatment_title) {
//            Intent i=new Intent(context,MainActivity_TreatmentStatement.class);
//            startActivity(i);
//
//
//        } else if (id == R.id.Committee_title) {
//            Intent i=new Intent(context,MainActivity_Ex_RequestCommitteeResult.class);
//            startActivity(i);
//
//
//        }else if (id == R.id.todolist) {
//            Intent i=new Intent(context,MainActivity_Listofchipment.class);
//            startActivity(i);
//
//        }
//        else if (id == R.id.logout) {
//
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
    public void Generat_Barcode() {

        Intent i= new Intent(context, Generate_barcode.class);
        i.putExtra("barcode",sharedPreferences.getString("BarCode","")+0);
        startActivity(i);
    }
//    public void Generat_Barcode(View view) {
//
//        Intent i= new Intent(context, Generate_barcode.class);
//        i.putExtra("barcode",sharedPreferences.getString("BarCode","")+0);
//        startActivity(i);
//    }
}
