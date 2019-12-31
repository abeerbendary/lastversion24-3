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
import com.example.abeer.quarantine.activity.Generate_barcode;
import com.example.abeer.quarantine.activity.Sample_Lots;
import com.example.abeer.quarantine.adapter.MyAdapterforRecycler;
import com.example.abeer.quarantine.databinding.ActivitySampleWithDrawBinding;
import com.example.abeer.quarantine.presenter.Clickcustum;
import com.example.abeer.quarantine.presenter.ISamplePresenter;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.ListAnalysis;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.ListLabName;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Sample_Result;
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

public class SampleWithDraw extends AppCompatActivity   implements LocationListener{

    ActivitySampleWithDrawBinding ActivitySampleWithDrawBinding;
    DataManger dataManger;
    Gson gson;
    String ID_itemSelected;
    RadioGroup radioGroup_Samples;
    LinearLayout linear_Layout_Sample_full;
    LinearLayout linear_Layout_Sample_part;
    LinearLayout linear_Layout_btns_Sample;
    LinearLayout linear_Layout_num_talab;
    LinearLayout linear_Layout_num_sample;
    LocationManager manager;
    TextView title_radio_group;
    String data;
    String ipadrass;

    boolean checked;
    Sample_Result sampleResult;
    final ListLabName[] listLabs = new ListLabName[1];
    final ListAnalysis[] listAnalysis = new ListAnalysis[1];
    final List<SampleData_LOts>[] SampleData_LOts = new List[1];
    Address address;
    Context context = this;
    double lat,longg;
    JSONObject datas;
    View viewforbutton;
    JSONObject ValuesPopUpLots ;
    TextView value_sample;

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            dataManger = new DataManger(this);
        ActivitySampleWithDrawBinding = DataBindingUtil.setContentView(this, R.layout.activity_sample_with_draw);
        sampleResult=new Sample_Result();
        radioGroup_Samples  = findViewById(R.id.radioGroup_Samples);
        text=findViewById(R.id.txt);
        linear_Layout_Sample_full =  findViewById(R.id.linear_Layout_Sample_full);
        linear_Layout_Sample_part = findViewById(R.id.linear_Layout_Sample_part);
        linear_Layout_btns_Sample =findViewById(R.id.btns_Sample);
        linear_Layout_num_talab =findViewById(R.id.num);
        linear_Layout_num_sample=findViewById(R.id.num_sample);
        title_radio_group =findViewById(R.id.title_radio_group_Sample);
        ipadrass= getIntent().getStringExtra("ipadrass");
        value_sample=findViewById(R.id.value_sample);
        value_sample.setText(getIntent().getStringExtra("num_Request"));
//        radioGroup_Samples.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int id = radioGroup_Samples.getCheckedRadioButtonId();
//                if (id == R.id.radio_Sample_part) {
//                    linear_Layout_Sample_full.setVisibility(View.GONE);
//                } else if (id == R.id.radio_Sample_full) {
//                    linear_Layout_Sample_full.setVisibility(View.VISIBLE);
//                }
//            }
//        });



//        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ApiCall.AnalysisType, new IDataValue() {
//            @Override
//            public void Success(Object response) throws JSONException {
//                gson = new Gson();
//                String data = response.toString();
//                JSONArray jsonArray = new JSONArray(data);
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("AnalysisType_Data", jsonArray);
//                try {
//                    listAnalysis[0] = gson.fromJson(jsonObject.toString(), ListAnalysis.class);
//                    ActivitySampleWithDrawBinding.setAnalysis(listAnalysis[0]);
//                }
//                catch (Exception ex){
//                    Toast.makeText(withdrawSample.this, ex.getMessage().toString(), Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void Error(VolleyError error) {
//
//            }
//        });


//        ActivitySampleWithDrawBinding.setInpresenter(new INPresenter() {
//            @Override
//            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id) {
//                String itemSelected =parent.getItemAtPosition(pos).toString();
//                ID_itemSelected=listAnalysis[0].getArrayListTreatment_Type_Value().get(pos);
//                Toast.makeText(withdrawSample.this, ""+ID_itemSelected, Toast.LENGTH_SHORT).show();
//
//                dataManger.SendVollyRequestJsonArrayGet(withdrawSample.this, Request.Method.GET, ApiCall.UrlLabName+ID_itemSelected, new IDataValue() {
//                    @Override
//                    public void Success(Object response) {
//                        try {
//                            gson = new Gson();
//                            String data = response.toString();
//                            JSONArray jsonArray = new JSONArray(data);
//                            JSONObject jsonObject = new JSONObject();
//                            jsonObject.put("listDisplay", jsonArray);
//                            listLabss[0] = gson.fromJson(jsonObject.toString(), ListLabName.class);
//                            ActivitySampleWithDrawBinding.setLabs(listLabss[0]);
//                        }
//                        catch (JSONException ex)
//                        {
//                            ex.printStackTrace();
//                            Toast.makeText(withdrawSample.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    @Override
//                    public void Error(VolleyError error) {
//                        Toast.makeText(withdrawSample.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//            }
//        });
//

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
        // super.onActivityResult(requestCode, resultCode, data);
    }
    public void Sample_full()
    {

        dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, "http://"+ipadrass+ApiCall.AnalysisType, new IDataValue() {
            @Override
            public void Success(Object response) {
                data=response.toString();
                gson = new Gson();
                listAnalysis[0] = gson.fromJson(data, ListAnalysis.class);
                ActivitySampleWithDrawBinding.setAnalysis(listAnalysis[0]);
            }
            @Override
            public void Error(VolleyError error) {


            }
        });
        ActivitySampleWithDrawBinding.setSampleResult(sampleResult);
        ActivitySampleWithDrawBinding.setISamplePresenter(new ISamplePresenter() {
            @Override
            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result) {

               // CheckUpResult.setKingdom_ID(Integer.parseInt(IDItemSelect));
                ID_itemSelected =String.valueOf(listAnalysis[0].obj.get(pos).Value);
                sample_result.setAnalysisType_ID(Short.parseShort(ID_itemSelected));
                Toast.makeText(SampleWithDraw.this, ""+ID_itemSelected, Toast.LENGTH_SHORT).show();

                dataManger.SendVollyRequestJsonObjectGet(SampleWithDraw.this, Request.Method.GET, ApiCall.UrlLabName+ID_itemSelected, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data = response.toString();
                        gson = new Gson();
                        listLabs[0] = gson.fromJson(data, ListLabName.class);
                        ActivitySampleWithDrawBinding.setLabs(listLabs[0]);
                    }
                    @Override
                    public void Error(VolleyError error) {
                        Toast.makeText(SampleWithDraw.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
              sampleResult.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date()));
           //     sampleResult.setAddress(""+address.getAddressLine(0));
                sampleResult.setLatitude(lat);
                sampleResult.setLongitude(longg);
                String jsonInString = gson.toJson(sampleResult);
                text.setText(jsonInString);

            }

            @Override
            public void OnClickcancel(View view, Sample_Result sampleResult) {

                linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.GONE);
                title_radio_group.setText("سحب العينات ");
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

        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlEx_SampleData+getIntent().getStringExtra("num_Request"), new IDataValue() {
            @Override
            public void Success(Object response) {
                data = response.toString();
                gson = new Gson();
                SampleData_LOts[0] = Arrays.asList(gson.fromJson(data, SampleData_LOts[].class));

                MyAdapterforRecycler dd=new MyAdapterforRecycler(SampleData_LOts[0], context, new Clickcustum() {
                    @Override
                    public void button_click(View view,SampleData_LOts sampleData_lOts) {
                        Intent i= new Intent(context, Sample_Lots.class);
                        i.putExtra("ID", "" + sampleData_lOts.getLot_Id());
                        i.putExtra("LOTS_NUM", "" + sampleData_lOts.getLot_Number());
                        i.putExtra("ipadrass",ipadrass);
                        viewforbutton=view;
                        startActivityForResult(i,1);
                    }

//                    @Override
//                    public void Generat_barcod_click(View view, com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts sampleData_lOts) {
//                        Intent i= new Intent(context, Generate_barcode.class);
//                        startActivity(i);
//                    }
                }
                );
                ActivitySampleWithDrawBinding.setMyAdapter(dd);
                ActivitySampleWithDrawBinding.recyclerViewSample.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void Error(VolleyError error) {

            }
        });

        ActivitySampleWithDrawBinding.setSampleResult(sampleResult);
        ActivitySampleWithDrawBinding.setISamplePresenter(new ISamplePresenter() {
            @Override
            public void OnItemSelectedSpinner_Treatment(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result) {

            }

            @Override
            public void OnItemSelectedSpinner_laboratory(AdapterView<?> parent, View view, int pos, long id, Sample_Result sample_result) {

            }

            @Override
            public void OnClickSaveLots(View view, Sample_Result sampleResult) {
                text.setText(ValuesPopUpLots.toString());
                //send request to save data in database
                finish();
            }

            @Override
            public void OnClickcancel(View view, Sample_Result sampleResult) {
                linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.GONE);
                title_radio_group.setText("سحب العينات ");
                linear_Layout_num_talab.setVisibility(View.GONE);
                radioGroup_Samples.setVisibility(View.VISIBLE);
                linear_Layout_Sample_part.setVisibility(View.GONE);
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
                btn_generat.setVisibility(View.VISIBLE);
                radioGroup_Samples.setVisibility(View.GONE);
                linear_Layout_Sample_part.setVisibility(View.GONE);
                linear_Layout_num_talab.setVisibility(View.VISIBLE);
                linear_Layout_num_sample.setVisibility(View.VISIBLE);
                Sample_full();
                break;
            case R.id.radio_Sample_part:
                if (checked)
                    linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.VISIBLE);
                radioGroup_Samples.setVisibility(View.GONE);
                title_radio_group.setText("سحب عينات للوطات");
                btn_generat.setVisibility(View.GONE);
                Sample_part();
                linear_Layout_Sample_part.setVisibility(View.VISIBLE);
                linear_Layout_num_talab.setVisibility(View.VISIBLE);
               linear_Layout_num_sample.setVisibility(View.VISIBLE);
                break;

            default:
                linear_Layout_Sample_full.setVisibility(View.GONE);
                linear_Layout_btns_Sample.setVisibility(View.GONE);
                title_radio_group.setText("سحب العينات ");
                btn_generat.setVisibility(View.GONE);
                radioGroup_Samples.setVisibility(View.VISIBLE);
                linear_Layout_Sample_part.setVisibility(View.GONE);
                linear_Layout_num_talab.setVisibility(View.GONE);
                linear_Layout_num_talab.setVisibility(View.GONE);
                linear_Layout_num_sample.setVisibility(View.GONE);
                btn_generat.setVisibility(View.GONE);
                break;

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

    public void Generat_Barcode(View view) {

        Intent i= new Intent(context, Generate_barcode.class);
        startActivity(i);
    }
}
