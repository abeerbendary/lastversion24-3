package com.example.abeer.quarantine.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.ActivityCheckUpLotsBinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.model.Checkup_Result_Model;
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
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//112121
public class CheckUp_Lots extends AppCompatActivity //implements LocationListener
{

    ActivityCheckUpLotsBinding ActivityCheckUpLotsBinding;
    TextView Lotsvalue;
    Gson gson;
    String data;
    DataManger DataManger;
    Context context = this;
    String IDItemSelect;
    Checkup_Result checkup_result;
    LinearLayout linear_Layout_Damaged;
    final LISTMKingdom[] LISTMKingdom = new LISTMKingdom[1];
    final LISTPhylum[] LISTPhylum = new LISTPhylum[1];
    final LISTOrder[] LISTOrder = new LISTOrder[1];
    final LISTFamily[] LISTFamily = new LISTFamily[1];
    final CommitteeResultType[] CommitteeResultTypeLIST = new CommitteeResultType[1];
    final LISTIm_ProcedureType[] LISTIm_ProcedureType = new LISTIm_ProcedureType[1];
    String Num_Lots;
    LocationManager manager;
    Location location;
    long ID_lots;
    String ipadrass;
    double lat, longg;
    SharedPreferences sharedPreferences;
    Checkup_Result_Model checkupResultModel;
    TextView num_Request;
    Public_function public_function;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkup_result = new Checkup_Result();
        DataManger = new DataManger(this);
        ActivityCheckUpLotsBinding =
                DataBindingUtil.setContentView((Activity) context, R.layout.activity_check_up__lots);
        Intent intent = getIntent();
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference", 0);
        public_function=new Public_function();
        // ID_lots =  sharedPreferences.getLong("ID",0);
//        Num_Lots = sharedPreferences.getString("LOTS_NUM","");
        num_Request = findViewById(R.id.value);
        ipadrass = sharedPreferences.getString("ipadrass", "");
        ID_lots = intent.getLongExtra("ID", 0);
        Num_Lots = intent.getStringExtra("LOTS_NUM");
//          ipadrass= getIntent().getStringExtra("ipadrass");
        Lotsvalue = findViewById(R.id.Lots_value);
        Lotsvalue.setText(Num_Lots);
        num_Request.setText(sharedPreferences.getString("num_Request", ""));
        linear_Layout_Damaged = findViewById(R.id.damaged);

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == 100) {
//            if (grantResults != null && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                try {
//                    manager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, (LocationListener) this, null);
//                    Toast.makeText(this, "phase 2", Toast.LENGTH_SHORT).show();
//
//                } catch (SecurityException e) {
//
//                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();

//        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            String[] permissions={Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION};
//            ActivityCompat.requestPermissions(this,permissions,100);
//
//            Toast.makeText(this, "phase 1", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            manager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, (LocationListener) this,null);
//            Toast.makeText(this, "sent direct", Toast.LENGTH_SHORT).show();
//        }
        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass + ApiCall.UrlCommitteeResultType, new IDataValue() {
            @Override
            public void Success(Object response) {
                data = response.toString();
                gson = new Gson();
                CommitteeResultTypeLIST[0] = gson.fromJson(data, CommitteeResultType.class);
                ActivityCheckUpLotsBinding.setCommitteeResultType(CommitteeResultTypeLIST[0]);

            }

            @Override
            public void Error(VolleyError error) {

            }
        });

        ActivityCheckUpLotsBinding.setCheckUpResult(checkup_result);

        ActivityCheckUpLotsBinding.setPresenter(new IPresenter() {


            @Override
            public void OnItemSelectedSpinner_CommitteeResultType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {
                if (pos != 0) {
                    IDItemSelect = String.valueOf(CommitteeResultTypeLIST[0].obj.get(pos).Value);
                    CheckUpResult.setResult_ID(Integer.parseInt(IDItemSelect));
                    if (IDItemSelect.equals("1") || IDItemSelect.equals("6")) {
                        linear_Layout_Damaged.setVisibility(View.GONE);
                    } else {
                        linear_Layout_Damaged.setVisibility(View.VISIBLE);
                        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass + ApiCall.UrlPlantKingdom, new IDataValue() {
                            @Override
                            public void Success(Object response) {
                                data = response.toString();
                                gson = new Gson();
                                LISTMKingdom[0] = gson.fromJson(data, LISTMKingdom.class);
                                ActivityCheckUpLotsBinding.setLISTMKingdom((LISTMKingdom[0]));
                            }

                            @Override
                            public void Error(VolleyError error) {

                            }
                        });

                        DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass + ApiCall.UrlIm_ProcedureType, new IDataValue() {
                            @Override
                            public void Success(Object response) {
                                data = response.toString();
                                gson = new Gson();
                                LISTIm_ProcedureType[0] = gson.fromJson(data, LISTIm_ProcedureType.class);
                                ActivityCheckUpLotsBinding.setLISTImProcedureType(LISTIm_ProcedureType[0]);
                            }

                            @Override
                            public void Error(VolleyError error) {

                            }
                        });
                    }
                }
            }

            @Override
            public void OnItemSelectedSpinner_Kingdom(AdapterView<?> parent, View view, int pos, long id, Checkup_Result checkupResult) {
                IDItemSelect = String.valueOf(LISTMKingdom[0].obj.get(pos).Value);
                checkupResult.setKingdom_ID(Integer.parseInt(IDItemSelect));
                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass + ApiCall.UrlPlantPhylum + IDItemSelect, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data = response.toString();
                        gson = new Gson();
                        LISTPhylum[0] = gson.fromJson(data, LISTPhylum.class);
                        ActivityCheckUpLotsBinding.setLISTPhylums(LISTPhylum[0]);
                    }

                    @Override
                    public void Error(VolleyError error) {

                    }
                });
            }

            @Override
            public void OnItemSelectedSpinner_Phylum(AdapterView<?> parent, View view, int pos, long id, Checkup_Result checkupResult) {
                IDItemSelect = String.valueOf(LISTPhylum[0].obj.get(pos).Value);
                checkupResult.setPhylum_ID(Integer.parseInt(IDItemSelect));
                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass + ApiCall.UrlPlantOrder + IDItemSelect, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data = response.toString();
                        gson = new Gson();
                        LISTOrder[0] = gson.fromJson(data, LISTOrder.class);
                        ActivityCheckUpLotsBinding.setLISTOrder(LISTOrder[0]);
                    }

                    @Override
                    public void Error(VolleyError error) {

                    }
                });
            }

            @Override
            public void OnItemSelectedSpinner_Order(AdapterView<?> parent, View view, int pos, long id, Checkup_Result checkupResult) {
                IDItemSelect = String.valueOf(LISTOrder[0].obj.get(pos).Value);
                checkupResult.setOrder_ID(Integer.parseInt(IDItemSelect));
                DataManger.SendVollyRequestJsonObjectGet(context, Request.Method.GET, ipadrass + ApiCall.UrlPlantFamily + IDItemSelect, new IDataValue() {
                    @Override
                    public void Success(Object response) {
                        data = response.toString();
                        gson = new Gson();
                        LISTFamily[0] = gson.fromJson(data, LISTFamily.class);
                        ActivityCheckUpLotsBinding.setLISTFamily(LISTFamily[0]);
                    }

                    @Override
                    public void Error(VolleyError error) {

                    }
                });
            }

            @Override
            public void OnItemSelectedSpinner_Family(AdapterView<?> parent, View view, int pos, long id, Checkup_Result checkupResult) {
                IDItemSelect = String.valueOf(LISTFamily[0].obj.get(pos).Value);
                checkupResult.setFamily_ID(Integer.parseInt(IDItemSelect));
            }

            @Override
            public void OnItemSelectedSpinner_Im_ProcedureType(AdapterView<?> parent, View view, int pos, long id, Checkup_Result CheckUpResult) {

                IDItemSelect = String.valueOf(LISTIm_ProcedureType[0].obj.get(pos).Value);
                CheckUpResult.setResult_injury(Integer.parseInt(IDItemSelect));
            }


            @Override
            public void OnClickSaveLots(View view, Checkup_Result checkupResult) {
                checkupResult.setlot_ID(ID_lots);
//                manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
//                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 200);
//                }
//                Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                if(location==null){
//                    location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                }
                manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                if (Build.VERSION.SDK_INT >= 23 &&
//                        ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                        ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
//                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 200);
//
//                }
//                Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//
//                if(location==null){
//                    location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//                }
               location=public_function.getlocation(context,manager);
                if(location.getLatitude()==0&&location.getLongitude()==0){
                    location.setLatitude(sharedPreferences.getLong("Latitude",0));
                    location.setLongitude(sharedPreferences.getLong("Longitude",0));
                }
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
                    checkupResultModel.setLongitude(location.getLongitude());
                    checkupResultModel.setLatitude( location.getLatitude());
                    String jsonInString = gson.toJson(checkupResultModel);
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("ValuesPopUpLots", jsonInString);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }

            @Override
            public void OnClickcancel(View view, Checkup_Result CheckUpResult) {
                checkup_result=null;
                finish();
            }

        });
    }

//    @Override
//    public void onLocationChanged(Location location) {
//        lat = location.getLatitude();
//        longg = location.getLongitude();
//        ///////////////////////address in arabic/////////////////////////////
////        Locale loc=new Locale("ar");
////        Geocoder geocoder = new Geocoder(this,loc);
////        try {
////            address = geocoder.getFromLocation(lat, longg, 1).get(0);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//    }
//
//    @Override
//    public void onStatusChanged(String provider, int status, Bundle extras) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String provider) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String provider) {
//
//    }
}
