package com.example.abeer.quarantine.activity.dashactivity;

import android.Manifest;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
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
import com.example.abeer.quarantine.activity.Treatment_Lots;
import com.example.abeer.quarantine.adapter.MyAdapterforRecycler;
import com.example.abeer.quarantine.databinding.ActivityTreatmentStatementBinding;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TreatmentStatement extends AppCompatActivity  implements LocationListener {

    ActivityTreatmentStatementBinding  ActivityTreatmentStatementBinding;
    DataManger dataManger;
    TreatmentResult treatmentResult;
    RadioGroup radioGroup_Treatment;
    LinearLayout linear_Layout_Treatment_full;
    LinearLayout linear_Layout_Treatment_part;
    LinearLayout linear_Layout_btns_Treatment;
    LinearLayout linear_Layout_num_treatment;
    TextView title_radio_group;
    double lat,longg;
    LocationManager manager;
    boolean checked;
    Gson gson;
    String ipadrass;

    String data;
    final ListTreatmentType[] ListTreatmentType = new ListTreatmentType[1];
    final ListTreatmentCompany[] ListTreatmentCompany = new ListTreatmentCompany[1];
    final ListTreatmentMethod[] listTreatmentMethods = new ListTreatmentMethod[1];
    final ListTreatmentMaterial[] listTreatmentMaterials = new ListTreatmentMaterial[1];
    final ListTreatmentPlace[] listTreatmentPlaces = new ListTreatmentPlace[1];
    final List<SampleData_LOts>[] SampleData_LOts = new List[1];
    TextView text;
    Address address;
    View viewforbutton;
    JSONObject ValuesPopUpLots;
    JSONObject datas;
    String ID_itemSelected;
    Context context;
    TextView  value_treatment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_treatment_statement);
        dataManger = new DataManger(this);
        treatmentResult =new TreatmentResult();
        context=this;

        ActivityTreatmentStatementBinding = DataBindingUtil.setContentView(this,R.layout.activity_treatment_statement);
        radioGroup_Treatment  = findViewById(R.id.radioGroup_Treatment);
        text=findViewById(R.id.text);
        linear_Layout_Treatment_full =  findViewById(R.id.linear_Layout_Treatment_full);
        linear_Layout_Treatment_part = findViewById(R.id.linear_Layout_Treatment_part);
        linear_Layout_btns_Treatment =findViewById(R.id.btns_Treatment);
        linear_Layout_num_treatment =findViewById(R.id.num_treatment);
        title_radio_group =findViewById(R.id.title_radio_group_Treatment);

        ipadrass= getIntent().getStringExtra("ipadrass");
        value_treatment=findViewById(R.id.title_value);
        value_treatment.setText(getIntent().getStringExtra("num_Request"));
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

        JSONArray popupdata=new JSONArray();
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
                text.setText(ValuesPopUpLots.toString());


            }
            if (resultCode == Activity.RESULT_CANCELED) {
                viewforbutton.findViewById(R.id.buttsss).setVisibility(View.VISIBLE);
                //Write your code if there's no result
                Toast.makeText(this, "nhvgbn", Toast.LENGTH_SHORT).show();
            }
        }
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
                linear_Layout_num_treatment.setVisibility(View.VISIBLE);
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
                linear_Layout_num_treatment.setVisibility(View.VISIBLE);
                break;

            default:
                linear_Layout_Treatment_full.setVisibility(View.GONE);
                linear_Layout_btns_Treatment.setVisibility(View.GONE);
                title_radio_group.setText("بيان المعالجة");
                radioGroup_Treatment.setVisibility(View.VISIBLE);
                linear_Layout_Treatment_part.setVisibility(View.GONE);
                linear_Layout_num_treatment.setVisibility(View.GONE);
                break;

        }
    }

    private void Treatment_part() {
      String sss=  "http://10.5.1.6:9090/api/Ex_SampleData?index=0&pageSize=100&CheckRequestNumber=1212562019";
      String s=getIntent().getStringExtra("num_Request");

      String ss="http://"+ipadrass+ApiCall.UrlEx_SampleData+s;
        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ss, new IDataValue() {
                  @Override
              public void Success(Object response) throws JSONException {
                  data=response.toString();
                  gson=new Gson();
                  SampleData_LOts[0] = Arrays.asList(gson.fromJson(data, SampleData_LOts[].class));
                  MyAdapterforRecycler dd=new MyAdapterforRecycler(SampleData_LOts[0], context, new Clickcustum() {
                    @Override
                    public void button_click(View view,SampleData_LOts sampleData_lOts) {
                        Intent i= new Intent(context, Treatment_Lots.class);
                        i.putExtra("ID", "" + sampleData_lOts.getLot_Id());
                        i.putExtra("LOTS_NUM", "" + sampleData_lOts.getLot_Number());
                        i.putExtra("ipadrass",ipadrass);
                        viewforbutton=view;
                        startActivityForResult(i,1);
                    }

//                      @Override
//                      public void Generat_barcod_click(View view, com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts sampleData_lOts) {
//
//                      }
                  });
                ActivityTreatmentStatementBinding.setMyAdapter(dd);
                ActivityTreatmentStatementBinding.recyclerViewTreatment.setLayoutManager(new LinearLayoutManager(context));
              }

              @Override
              public void Error(VolleyError error) {

              }
          });
        ActivityTreatmentStatementBinding.setTreatmentResult(treatmentResult);
        ActivityTreatmentStatementBinding.setITreatmentPresenter(new ITreatmentPresenter() {
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
                text.setText(ValuesPopUpLots.toString());
                //send request to save data in database
             //   finish();
            }

            @Override
            public void OnClickcancel(View view, TreatmentResult TreatmentResult) {
                linear_Layout_Treatment_full.setVisibility(View.GONE);
                linear_Layout_btns_Treatment.setVisibility(View.GONE);
                title_radio_group.setText("بيان المعالجة ");
                linear_Layout_num_treatment.setVisibility(View.GONE);
                radioGroup_Treatment.setVisibility(View.VISIBLE);
                linear_Layout_Treatment_part.setVisibility(View.GONE);

            }
        });


    }

    private void Treatment_full() {

        dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, ApiCall.UrlTreatmentType, new IDataValue() {
            @Override
            public void Success(Object response) {
                data=response.toString();
                gson = new Gson();
                ListTreatmentType[0] = gson.fromJson(data, ListTreatmentType.class);
                ActivityTreatmentStatementBinding.setTreatmentType(ListTreatmentType[0]);
            }
            @Override
            public void Error(VolleyError error) {


            }
        });

        dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlTreatmentCompany, new IDataValue() {
            @Override
            public void Success(Object response) {

                data=response.toString();
                gson = new Gson();
                ListTreatmentCompany[0] = gson.fromJson(data, ListTreatmentCompany.class);
                ActivityTreatmentStatementBinding.setTreatmentCompany(ListTreatmentCompany[0]);

            }
            @Override
            public void Error(VolleyError error) {


            }
        });

        ActivityTreatmentStatementBinding.setTreatmentResult(treatmentResult);
        ActivityTreatmentStatementBinding.setITreatmentPresenter(new ITreatmentPresenter() {
            @Override
            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id, TreatmentResult treatmentResult) {

                ID_itemSelected =String.valueOf(ListTreatmentType[0].obj.get(pos).Value);
                treatmentResult.setTreatment_Type_ID(Byte.parseByte(ID_itemSelected));
                dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlTreatmentMethod+ID_itemSelected, new IDataValue() {
                    @Override
                    public void Success(Object response) {

                            gson=new Gson();
                            data = response.toString();
                            listTreatmentMethods[0] = gson.fromJson(data, ListTreatmentMethod.class);
                            ActivityTreatmentStatementBinding.setTreatmentMethod (listTreatmentMethods[0]);
                    }
                    @Override
                    public void Error(VolleyError error) {

                    }
                });

                dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlTreatmentMaterial + ID_itemSelected, new IDataValue() {
                     @Override
                     public void Success(Object response) throws JSONException {

                         gson=new Gson();
                         data = response.toString();
                         listTreatmentMaterials[0] = gson.fromJson(data, ListTreatmentMaterial.class);
                         ActivityTreatmentStatementBinding.setTreatmentMaterial (listTreatmentMaterials[0]);

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

                TreatmentResult.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
                TreatmentResult.setAddress(""+address.getAddressLine(0));
                TreatmentResult.setLatitude(lat);
                TreatmentResult.setLongitude(longg);
                String jsonInString = gson.toJson(TreatmentResult);
                text.setText(jsonInString);
            }

            @Override
            public void OnClickcancel(View view, TreatmentResult TreatmentResult) {

                linear_Layout_Treatment_full.setVisibility(View.GONE);
                linear_Layout_btns_Treatment.setVisibility(View.GONE);
                title_radio_group.setText("بيان المعالجة ");
                radioGroup_Treatment.setVisibility(View.VISIBLE);
                linear_Layout_Treatment_part.setVisibility(View.GONE);
            }
        });
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
                dataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlTreatmentPlace, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        try {
                            data=response.toString();
                            gson = new Gson();
                            listTreatmentPlaces[0] = gson.fromJson(data , ListTreatmentPlace.class);
                            ActivityTreatmentStatementBinding.setTreatmentPlace(listTreatmentPlaces[0]);
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
}
