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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.MyAdapterforRecycler;
import com.example.abeer.quarantine.databinding.ActivityMainTreatmentStatementBinding;
import com.example.abeer.quarantine.databinding.ActivityTreatmentStatementBinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.model.Sample_Result_Model;
import com.example.abeer.quarantine.model.Treatment_Result_Model;
import com.example.abeer.quarantine.presenter.Clickcustum;
import com.example.abeer.quarantine.presenter.ITreatmentPresenter;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts;
import com.example.abeer.quarantine.viewmodel.treatmentStatement.ListTreatmentCompany;
import com.example.abeer.quarantine.viewmodel.treatmentStatement.ListTreatmentMaterial;
import com.example.abeer.quarantine.viewmodel.treatmentStatement.ListTreatmentMethod;
import com.example.abeer.quarantine.viewmodel.treatmentStatement.ListTreatmentPlace;
import com.example.abeer.quarantine.viewmodel.treatmentStatement.ListTreatmentType;
import com.example.abeer.quarantine.viewmodel.treatmentStatement.TreatmentResult;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity_TreatmentStatement extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,LocationListener {
    Context context=this;
    ActivityMainTreatmentStatementBinding activityMainTreatmentStatementBinding;
  //  ActivityTreatmentStatementBinding;
    DataManger dataManger;
    TreatmentResult treatmentResult;
    RadioGroup radioGroup_Treatment;
    LinearLayout linear_Layout_Treatment_full;
    LinearLayout linear_Layout_Treatment_part;
    LinearLayout linear_Layout_btns_Treatment;
   // LinearLayout linear_Layout_num_treatment;
    TextView title_radio_group;
    double lat,longg;
    LocationManager manager;
    String num_Request;
    boolean checked;
    Gson gson;
    String data;
    final ListTreatmentType[] ListTreatmentType = new ListTreatmentType[1];
    final ListTreatmentCompany[] ListTreatmentCompany = new ListTreatmentCompany[1];
    final ListTreatmentMethod[] listTreatmentMethods = new ListTreatmentMethod[1];
    final ListTreatmentMaterial[] listTreatmentMaterials = new ListTreatmentMaterial[1];
    final ListTreatmentPlace[] listTreatmentPlaces = new ListTreatmentPlace[1];
    final List<SampleData_LOts>[] SampleData_LOts = new List[1];
    TextView text;
    TextView treatment_value;
    JSONArray datasendarray = new JSONArray();
    Address address;
    View viewforbutton;
    SharedPreferences.Editor prefsEditor;
    JSONObject ValuesPopUpLots;
    JSONObject datas;
    String ID_itemSelected;
    SharedPreferences sharedPreferences;
    Public_function public_function;
    String Request_id;
    String ipadrass;
    Treatment_Result_Model treatmentResultModel;
    JSONArray treatmentalldata=new JSONArray();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main__treatment_statement);
        activityMainTreatmentStatementBinding = DataBindingUtil.setContentView((Activity) context, R.layout.activity_main__treatment_statement);
        dataManger=new DataManger(this);
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

        dataManger = new DataManger(this);
        treatmentResult =new TreatmentResult();
        context=this;
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
        num_Request = sharedPreferences.getString("num_Request","");
        Request_id = sharedPreferences.getString("checkRequest_Id","");
        ipadrass= sharedPreferences.getString("ipadrass","");

        //  num_Request=getIntent().getStringExtra("num_Request");
        radioGroup_Treatment  = findViewById(R.id.radioGroup_Treatment);
       text=findViewById(R.id.text);
        linear_Layout_Treatment_full =  findViewById(R.id.linear_Layout_Treatment_full);
        linear_Layout_Treatment_part = findViewById(R.id.linear_Layout_Treatment_part);
        linear_Layout_btns_Treatment =findViewById(R.id.btns_Treatment);
     //   linear_Layout_num_treatment =findViewById(R.id.num_treatment);
        title_radio_group =findViewById(R.id.title_radio_group_Treatment);
        treatment_value=findViewById(R.id.title_value);
        treatment_value.setText(num_Request);
        public_function=new Public_function();

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
        //JSONArray popupdata=new JSONArray();
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
              //  Textsss.setText(ValuesPopUpLots.toString());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                viewforbutton.findViewById(R.id.buttsss).setVisibility(View.VISIBLE);
                //Write your code if there's no result
             //   Toast.makeText(this, "nhvgbn", Toast.LENGTH_SHORT).show();
            }
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
     //   getMenuInflater().inflate(R.menu.main_activity__treatment_statement, menu);
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
//        } else if (id == R.id.treatment_title) {
//            Intent i=new Intent(context,MainActivity_TreatmentStatement.class);
//            startActivity(i);
//        } else if (id == R.id.Committee_title) {
//            Intent i=new Intent(context,MainActivity_Ex_RequestCommitteeResult.class);
//            startActivity(i);
//
//        }else if (id == R.id.todolist) {
//            Intent i=new Intent(context,MainActivity_Listofchipment.class);
//            startActivity(i);
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

    public void onRadioButtonClicked(View view) {

        checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {

            case R.id.radio_Treatment_full:
                if (checked)
                    linear_Layout_Treatment_full.setVisibility(View.VISIBLE);
                linear_Layout_btns_Treatment.setVisibility(View.VISIBLE);
                title_radio_group.setText("بيان معالجة للشحنة");
                radioGroup_Treatment.setVisibility(View.GONE);
                linear_Layout_Treatment_part.setVisibility(View.GONE);
             //   linear_Layout_num_treatment.setVisibility(View.VISIBLE);
                Treatment_full();
                break;
            case R.id.radio_Treatment_part:
                if (checked)
                    linear_Layout_Treatment_full.setVisibility(View.GONE);
                linear_Layout_btns_Treatment.setVisibility(View.VISIBLE);
                radioGroup_Treatment.setVisibility(View.GONE);
                title_radio_group.setText("بيان معالجة للوطات");
                Treatment_part();
                linear_Layout_Treatment_part.setVisibility(View.VISIBLE);
             //   linear_Layout_num_treatment.setVisibility(View.VISIBLE);
                break;

            default:
                linear_Layout_Treatment_full.setVisibility(View.GONE);
                linear_Layout_btns_Treatment.setVisibility(View.GONE);
                title_radio_group.setText("بيان المعالجة");
                radioGroup_Treatment.setVisibility(View.VISIBLE);
                linear_Layout_Treatment_part.setVisibility(View.GONE);
             //   linear_Layout_num_treatment.setVisibility(View.GONE);
                break;

        }
    }
    private void Treatment_part() {
       // dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ApiCall.UrlEx_SampleData, new IDataValue() {

        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ipadrass+ApiCall.UrlEx_SampleData+Request_id, new IDataValue() {
            @Override
            public void Success(Object response) throws JSONException {
                data=response.toString();
                gson=new Gson();
                SampleData_LOts[0] = Arrays.asList(gson.fromJson(data, SampleData_LOts[].class));
                MyAdapterforRecycler dd=new MyAdapterforRecycler(SampleData_LOts[0], context, new Clickcustum() {
                    @Override
                    public void button_click(View view,SampleData_LOts sampleData_lOts) {
                        Intent i= new Intent(context, Treatment_Lots.class);
                        i.putExtra("ID",  sampleData_lOts.getLot_Id());
                        i.putExtra("LOTS_NUM", "" + sampleData_lOts.getLot_Number());
//                        SharedPreferences.Editor   prefsEditor = sharedPreferences.edit();
//                        prefsEditor.putLong("ID",sampleData_lOts.getLot_Id());
//                        prefsEditor.putString("LOTS_NUM",sampleData_lOts.getLot_Number());
                        viewforbutton=view;
                        startActivityForResult(i,1);
                    }

//                    @Override
//                    public void Generat_barcod_click(View view, SampleData_LOts sampleData_lOts) {
//
//                    }
                });
                activityMainTreatmentStatementBinding.contentTreatmentStatement.setMyAdapter(dd);
                activityMainTreatmentStatementBinding.contentTreatmentStatement.recyclerViewTreatment.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
        activityMainTreatmentStatementBinding.contentTreatmentStatement.setTreatmentResult(treatmentResult);
        activityMainTreatmentStatementBinding.contentTreatmentStatement.setITreatmentPresenter(new ITreatmentPresenter() {
            @Override
            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {

            }

            @Override
            public void OnItemSelectedSpinner_Treatmentcompany(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {

            }

            @Override
            public void OnItemSelectedSpinner_treatmentplace(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {

            }

            @Override
            public void OnItemSelectedSpinner_treatmentmethod(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {

            }

            @Override
            public void OnItemSelectedSpinner_treatmentmaterial(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {

            }

            @Override
            public void OnClickSaveTreatment(View view, TreatmentResult TreatmentResult) {
             //   Textsss.setText(ValuesPopUpLots.toString());
//                public_function.senddataonlinetoserver(datasendarray,context, ipadrass+ApiCall.UrlTreatmentsResult);
//                datasendarray=null;
//                finish();
                try {
                prefsEditor=sharedPreferences.edit();
                prefsEditor.putInt("treatment_data",sharedPreferences.getInt("treatment_data",-2)-1);
                prefsEditor.putInt("totalprocess",sharedPreferences.getInt("totalprocess",-2)-1);
                    prefsEditor.apply();
                    String Treatment_Dto = sharedPreferences.getString("Treatment_Dto","");
                    if(Treatment_Dto==""){
                        prefsEditor=sharedPreferences.edit();
                        prefsEditor.putString("Treatment_Dto",String.valueOf(datasendarray));
                        prefsEditor.apply();

                    }else {
                        JSONArray jsonArray = new JSONArray(Treatment_Dto);
                        for (int i = 0; i < datasendarray.length(); i++) {
                            JSONObject jsonObject = datasendarray.getJSONObject(i);
                            jsonArray.put(jsonObject);
                        }
                        prefsEditor=sharedPreferences.edit();
                        prefsEditor.putString("Treatment_Dto",String.valueOf(jsonArray));
                        prefsEditor.apply();
                    }

                int totalprocess=sharedPreferences.getInt("totalprocess",0);

                if(totalprocess==0){
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("Committe_Dto", sharedPreferences.getString("Committe_Dto",""));
                    jsonObject.put("SampleDto", sharedPreferences.getString("SampleDto",""));
                    jsonObject.put("Treatment_Dto", sharedPreferences.getString("Treatment_Dto",""));
                    public_function.senddataonlinetoserverformoreprocess(jsonObject,context,ipadrass + ApiCall.UrlSavemultprocess);

                }else {

                    public_function.AlertDialog("برجاء اتمام العمليات ",context,true);

                }
                    datasendarray=null;
                } catch (JSONException e) {
                e.printStackTrace();
            }
            }

            @Override
            public void OnClickcancel(View view, TreatmentResult TreatmentResult) {
                linear_Layout_Treatment_full.setVisibility(View.GONE);
                linear_Layout_btns_Treatment.setVisibility(View.GONE);
                title_radio_group.setText("بيان المعالجة ");
                datasendarray=null;
                //  linear_Layout_num_treatment.setVisibility(View.GONE);
                radioGroup_Treatment.setVisibility(View.VISIBLE);
                linear_Layout_Treatment_part.setVisibility(View.GONE);
            }
        });


    }

    private void Treatment_full() {
       // dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, ApiCall.UrlTreatmentType, new IDataValue() {

        dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET,ipadrass+ApiCall.UrlTreatmentType, new IDataValue() {
            @Override
            public void Success(Object response) {
                data=response.toString();
                gson = new Gson();
                ListTreatmentType[0] = gson.fromJson(data, ListTreatmentType.class);
                activityMainTreatmentStatementBinding.contentTreatmentStatement.setTreatmentType(ListTreatmentType[0]);
            }
            @Override
            public void Error(VolleyError error) {


            }
        });
      //  dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, ApiCall.UrlTreatmentCompany, new IDataValue() {
        dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, ipadrass+ApiCall.UrlTreatmentCompany, new IDataValue() {
            @Override
            public void Success(Object response) {

                data=response.toString();
                gson = new Gson();
                ListTreatmentCompany[0] = gson.fromJson(data, ListTreatmentCompany.class);
                activityMainTreatmentStatementBinding.contentTreatmentStatement.setTreatmentCompany(ListTreatmentCompany[0]);

            }
            @Override
            public void Error(VolleyError error) {


            }
        });

        activityMainTreatmentStatementBinding.contentTreatmentStatement.setTreatmentResult(treatmentResult);
        activityMainTreatmentStatementBinding.contentTreatmentStatement.setITreatmentPresenter(new ITreatmentPresenter() {
            @Override
            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {

                ID_itemSelected =String.valueOf(ListTreatmentType[0].obj.get(pos).Value);
                treatmentResult.setTreatment_Type_ID(Byte.parseByte(ID_itemSelected));
              //  dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlTreatmentMethod+ID_itemSelected, new IDataValue() {
                dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlTreatmentMethod+ID_itemSelected, new IDataValue() {
                    @Override
                    public void Success(Object response) {

                        gson=new Gson();
                        data = response.toString();
                        listTreatmentMethods[0] = gson.fromJson(data, ListTreatmentMethod.class);
                        activityMainTreatmentStatementBinding.contentTreatmentStatement.setTreatmentMethod (listTreatmentMethods[0]);
                    }
                    @Override
                    public void Error(VolleyError error) {

                    }
                });
               // dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlTreatmentMaterial + ID_itemSelected, new IDataValue() {

                dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass+ApiCall.UrlTreatmentMaterial + ID_itemSelected, new IDataValue() {
                    @Override
                    public void Success(Object response) throws JSONException {

                        gson=new Gson();
                        data = response.toString();
                        listTreatmentMaterials[0] = gson.fromJson(data, ListTreatmentMaterial.class);
                        activityMainTreatmentStatementBinding.contentTreatmentStatement.setTreatmentMaterial (listTreatmentMaterials[0]);

                    }

                    @Override
                    public void Error(VolleyError error) {

                    }
                });

            }

            @Override
            public void OnItemSelectedSpinner_Treatmentcompany(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {
                treatmentResult.setTreatment_company_ID(Integer.parseInt(""+ListTreatmentCompany[0].obj.get(pos).Value));
            }

            @Override
            public void OnItemSelectedSpinner_treatmentplace(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {
                treatmentResult.setCertified_place_ID(Long.parseLong(""+listTreatmentPlaces[0].obj.get(pos).Value));
            }

            @Override
            public void OnItemSelectedSpinner_treatmentmethod(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {
                treatmentResult.setTreatment_method_ID(Byte.parseByte(""+listTreatmentMethods[0].obj.get(pos).ID));
            }

            @Override
            public void OnItemSelectedSpinner_treatmentmaterial(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {
                treatmentResult.setTreatment_material_ID(Byte.parseByte(""+listTreatmentMaterials[0].obj.get(pos).ID));
            }

            @Override
            public void OnClickSaveTreatment(View view, TreatmentResult TreatmentResult) {
                //////////////////
                if(TreatmentResult.getTreatment_Type_ID()==0){

                    public_function.AlertDialog(" برجاء تحديد نوع المعالجه ",context,false);
                }else if(TreatmentResult.getTreatment_company_ID()==0)
                {
                    public_function.AlertDialog(" برجاء تحديد شركه المعالجة",context,false);
                }
                else if(!((RadioButton)findViewById( R.id.certified_place)).isChecked()&& !((RadioButton)findViewById( R.id.uncertified_place)).isChecked())
                {
                    public_function.AlertDialog(" برجاء تحديد شركه المعالجة معتمدة او غير معتمدة",context,false);
                }
                else if(findViewById(R.id.spinner_treatment_place).getVisibility()==View.VISIBLE&&TreatmentResult.getCertified_place_ID()==0 )
                {
                    public_function.AlertDialog(" برجاء تسجيل مكان المعالجه المعتمد  ",context,false);
                }
                else if(findViewById(R.id.treatment_place).getVisibility()==View.VISIBLE&& TreatmentResult.getUncertified_place()==null)
                {
                    public_function.AlertDialog(" برجاء تسجيل مكان المعالجه الغير معتمدة  ",context,false);
                }
                else  if(TreatmentResult.getTreatment_Type_ID()==0)
                {
                    public_function.AlertDialog(" برجاء تحديد طرق المعالجة ",context,false);

                }
                else if (TreatmentResult.getResala_size()==0)
                {
                    public_function.AlertDialog(" برجاء تحديد حجم الرسالة ",context,false);

                }
                else if (TreatmentResult.getTreatment_material_ID()==0)
                {
                    public_function.AlertDialog(" برجاء تحديد مادة المعالجة ",context,false);
                }
                else if (TreatmentResult.getDosage()==0)
                {
                    public_function.AlertDialog(" برجاء ادخال الجرعة ",context,false);

                }
                else if (TreatmentResult.getExposure_Day()==0 && TreatmentResult.getExposure_Hour()==0 && TreatmentResult.getExposure_Minute()==0 )
                {
                    public_function.AlertDialog(" برجاء تحديد مدة التعرض ",context,false);

                }
                else if (TreatmentResult.getTemperature()==0)
                {
                    public_function.AlertDialog(" برجاء تحديد درجة الحرارة",context,false);

                }
                else if(TreatmentResult.getThermalSealNumber()==0)
                {
                    public_function.AlertDialog(" برجاءادخال رقم الختم الحراري",context,false);

                }
                else if (TreatmentResult.getQuantity_material()==0)
                {
                    public_function.AlertDialog(" برجاء تحديد كمية المادة المستخدمة",context,false);

                }
                 else{
                ///////////////////////
                     TreatmentResult.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
//                   TreatmentResult.setAddress(""+address.getAddressLine(0));
//                   TreatmentResult.setLatitude(lat);
//                   TreatmentResult.setLongitude(longg);
                     TreatmentResult.setCommittee_ID(sharedPreferences.getLong("Committee_ID", 0));
                     TreatmentResult.setEmployeeId(sharedPreferences.getLong("EmpId", 0));
                     TreatmentResult.setLot_ID((long) 0);
                     treatmentResultModel = new Treatment_Result_Model(TreatmentResult);
                     treatmentResultModel.setIsLot(18);
//                if(sampleResult.getAnalysisType_ID()==0) {
//
//                    public_function.AlertDialog("برجاء تحديد نوع التحليل ",context);
//                }
//                else {
                     final String json = new Gson().toJson(treatmentResultModel);
                    //  final String json = "{\"CommitteeResultType_ID\":2,\"Committee_ID\":40010,\"Date\":\"2019-08-19 09:04:12\",\"EmployeeId\":30580,\"Ex_RequestLotData_ID\":0,\"ID\":0,\"Item_ID\":1,\"Item__OrderID\":65,\"QuantitySize\":21,\"Result_injuryID\":6,\"Weight\":3}";
                    try {
                        JSONObject datasend = new JSONObject(json);
//////////////
//                        if(datasendarray!=null){
//                            datasendarray.put(datasend);
//                        }
//                        else {
//                            datasendarray=new JSONArray();
//                            datasendarray.put(datasend);
//                        }
                       // public_function.senddataonlinetoserver(datasendarray, context, ipadrass + ApiCall.UrlTreatmentsResult);
                        //////////////
//                        if(datasendarray==null) {
//                          datasendarray=new JSONArray();
//                        }
                        prefsEditor=sharedPreferences.edit();
                        prefsEditor.putInt("treatment_data",sharedPreferences.getInt("treatment_data",-2)-1);
                        prefsEditor.putInt("totalprocess",sharedPreferences.getInt("totalprocess",-2)-1);
                        prefsEditor.apply();
                        String Treatment_Dto=sharedPreferences.getString("Treatment_Dto","");
                        if(Treatment_Dto==""){
                            JSONArray jsonArray=new JSONArray();
                            jsonArray.put(datasend);
                            prefsEditor=sharedPreferences.edit();
                            prefsEditor.putString("Treatment_Dto",String.valueOf(jsonArray));
                            prefsEditor.apply();

                        }else {
                            JSONArray jsonArray=new JSONArray(Treatment_Dto);
                            jsonArray.put(datasend);
                            prefsEditor=sharedPreferences.edit();
                            prefsEditor.putString("Treatment_Dto",String.valueOf(jsonArray));
                            prefsEditor.apply();
                        }

                        int totalprocess=sharedPreferences.getInt("totalprocess",0);

                        if(totalprocess==0){
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("Committe_Dto", sharedPreferences.getString("Committe_Dto",""));
                            jsonObject.put("SampleDto", sharedPreferences.getString("SampleDto",""));
                            jsonObject.put("Treatment_Dto", sharedPreferences.getString("Treatment_Dto",""));
                            public_function.senddataonlinetoserverformoreprocess(jsonObject,context,ipadrass + ApiCall.UrlSavemultprocess);

                        }else {

                            public_function.AlertDialog("برجاء اتمام العمليات ",context,true);

                        }

//                        if(Committee_Type_Id==1 && treatmentprocess!=0 ) {
//
//                            String Treatment_Dto=sharedPreferences.getString("Treatment_Dto","");
//                            JSONArray Treatment_DtoArray=new JSONArray(Treatment_Dto);
//                            Treatment_DtoArray.put(datasend);
//                            prefsEditor = sharedPreferences.edit();
//                            prefsEditor.putString("Treatment_Dto", String.valueOf(Treatment_DtoArray));
//                            prefsEditor.putInt("treatment_data",treatmentprocess);
//                            prefsEditor.apply();
//                            prefsEditor.commit();
//                            public_function.AlertDialog("برجاء اتمام العمليات ",context,true);
//
//                       } else if(Committee_Type_Id==6&&treatmentprocess==0){
//
//                        }
//                        if(treatmentprocess==0 && sampleprocess==0){
//                           JSONObject jsonObject=new JSONObject();
//                           String Committe_Dto=sharedPreferences.getString("Committe_Dto","");
//                           String SampleDto=sharedPreferences.getString("SampleDto","");
//                           String Treatment_Dto=sharedPreferences.getString("Treatment_Dto","");
//                           jsonObject.put("Treatment_Dto",Treatment_Dto);
//                           jsonObject.put("Committe_Dto",Committe_Dto);
//                           jsonObject.put("SampleDto",SampleDto);
//                           public_function.senddataonlinetoserverformoreprocess(jsonObject,context,ipadrass+ ApiCall.UrlSavemultprocess);
//
//                       }

//                        else if(treatmentprocess>1&&Committee_Type_Id==1&&counttreatmentprocess!=0) {
//                            Intent intent=new Intent(context,MainActivity_TreatmentStatement.class);
//                         //   intent.putExtra("EX_Request",(Serializable)datasendarray);
//                            prefsEditor = sharedPreferences.edit();
//                            prefsEditor.putInt("counttreatmentprocess",treatmentprocess-1);
//                            prefsEditor.commit();
//                            startActivityForResult(intent,context,datasend);
//                        }else if(treatmentprocess>1&&Committee_Type_Id==1&&counttreatmentprocess==0){
//                         //   public_function.senddataonlinetoserver(datasendarray, context, ipadrass + ApiCall.UrlCommitteeResult);
//                            text.setText(datasendarray.toString());
//
//                            //  public_function.senddataonlinetoserverformoreprocess();
//                        }
//                        else if(Committee_Type_Id==1&&treatmentprocess!=0&&sampleprocess==0&&counttreatmentprocess==-1){
//                            //treanment activity we need alert
//                     //      public_function
//                            //    intent.putExtra()
//
//                        }
//                         else  if(treatmentprocess==0&&sampleprocess!=0){
//                            //sample activity we need alert
//                            Intent intent=new Intent(context,MainActivity_SampleWithDraw.class);
//                            intent.putExtra("EX_Request", (Serializable) datasendarray);
//                            startActivity(intent);
//                        }
//                        else if( treatmentprocess!=0 && sampleprocess!=0 ){
//                            //
//                            Intent intent=new Intent(context,MainActivity_TreatmentStatement.class);
//                            intent.putExtra("EX_Request", (Serializable) datasendarray);
//                            startActivity(intent);
//                        }
                        datasendarray = null;

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //    String jsonInString = gson.toJson(TreatmentResult);
                  //  Textsss.setText(jsonInString);
                }
           // }

            @Override
            public void OnClickcancel(View view, TreatmentResult TreatmentResult) {
                linear_Layout_Treatment_full.setVisibility(View.GONE);
                linear_Layout_btns_Treatment.setVisibility(View.GONE);
                title_radio_group.setText("بيان المعالجة ");
                datasendarray=null;
                radioGroup_Treatment.setVisibility(View.VISIBLE);
                linear_Layout_Treatment_part.setVisibility(View.GONE);
            }
        });
    }

    private void startActivityForResult(Intent intent, Context context,JSONObject jsonObject ) {
        if(context instanceof MainActivity_TreatmentStatement){
           // treatmentalldata.put(jsonObject);
            datasendarray.put(jsonObject);
        }
    }

    public void onRadioButtonClickedplace(View view) {
        checked = ((RadioButton) view).isChecked();
        final EditText edittext_place = findViewById(R.id.treatment_place);
        final Spinner spinner_place = findViewById(R.id.spinner_treatment_place);
        final LinearLayout linear_treatment_place = findViewById(R.id.linear_treatment_place);


        switch (view.getId()) {

            case R.id.certified_place:
                if (checked)
                    linear_treatment_place.setVisibility(View.VISIBLE);
                spinner_place.setVisibility(View.VISIBLE);
                edittext_place.setVisibility(View.INVISIBLE);
               // dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ApiCall.UrlTreatmentPlace, new IDataValue() {
                dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET,ipadrass+ApiCall.UrlTreatmentPlace, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        try {
                            data=response.toString();
                            gson = new Gson();
                            listTreatmentPlaces[0] = gson.fromJson(data , ListTreatmentPlace.class);
                            activityMainTreatmentStatementBinding.contentTreatmentStatement.setTreatmentPlace(listTreatmentPlaces[0]);
                        } catch (Exception ex) {
                        }
                    }
                    @Override
                    public void Error(VolleyError error) {
                    }
                });
                break;
            case R.id.uncertified_place:
                if (checked)
                    linear_treatment_place.setVisibility(View.VISIBLE);
                edittext_place.setVisibility(View.VISIBLE);
                spinner_place.setVisibility(View.INVISIBLE);
                break;
            default:
                linear_treatment_place.setVisibility(View.VISIBLE);
                edittext_place.setVisibility(View.GONE);
                spinner_place.setVisibility(View.GONE);
        }
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
 }

