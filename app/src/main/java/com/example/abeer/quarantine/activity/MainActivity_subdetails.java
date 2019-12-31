package com.example.abeer.quarantine.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.AdapterEshtratat;
import com.example.abeer.quarantine.adapter.AdapterEshtratatObjectliving;
import com.example.abeer.quarantine.adapter.AdapterEshtratatPlantProduct;
import com.example.abeer.quarantine.adapter.AdapterEshtratatUnliving;
import com.example.abeer.quarantine.adapter.AdapterLotat;
import com.example.abeer.quarantine.adapter.AdapterLotatLiving;
import com.example.abeer.quarantine.adapter.AdapterLotatPlantproduct;
import com.example.abeer.quarantine.adapter.AdapterLotatUnLiving;
import com.example.abeer.quarantine.databinding.ActivityDetailOfDetailItemDataBinding;
import com.example.abeer.quarantine.databinding.ActivityMainSubdetailsBinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ConstrainsData2;
import com.example.abeer.quarantine.viewmodel.ItemConstrainsData;
import com.example.abeer.quarantine.viewmodel.ItemData;
import com.example.abeer.quarantine.viewmodel.ItemLotatData;
import com.example.abeer.quarantine.viewmodel.ListDetailsCheckRequestNew;
import com.example.abeer.quarantine.viewmodel.ListItemConstrains;
import com.example.abeer.quarantine.viewmodel.ListItemDataDetail;
import com.example.abeer.quarantine.viewmodel.ListItemLotat;
import com.example.abeer.quarantine.viewmodel.livingobjects.ItemData_LivingObject;
import com.example.abeer.quarantine.viewmodel.plantProduct.ItemData_PlantProduct;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity_subdetails extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Context context;
    boolean clicked;
    LinearLayout linearLayoutconstrans;
    LinearLayout linearLayoutlotss;
    final ConstrainsData2[] itemData = new ConstrainsData2[1];
    final ListItemDataDetail[] itemData2 = new ListItemDataDetail[1];
    final List<ListItemConstrains>[] listItemConstrains = new List[1];
    final List<ListItemLotat>[] listItemLotat = new List[1];
    List<ItemConstrainsData> itemConstrainsData22=null;
    List<ItemLotatData> itemLotatData22=null;
    DrawerLayout drawer;
    final ItemData[] t = new ItemData[1];
    final    ItemData_PlantProduct []itemData_plantProducts=new ItemData_PlantProduct[1];
    final    ItemData_LivingObject []itemData_livingObjects=new ItemData_LivingObject[1];
    final ItemData_LivingObject[] itemData_unlivingObjects = new ItemData_LivingObject[1];
    String ipadrass;
    String num_Request;
    AdapterEshtratat adapterEshtratat;
    AdapterEshtratatPlantProduct adapterEshtratatPlantProduct;
    AdapterEshtratatObjectliving adapterEshtratatObjectliving;
    AdapterLotatLiving adapterLotatLiving;
    AdapterLotatPlantproduct adapterLotat;
    AdapterLotat adapterLotat2;
    AdapterLotatUnLiving AdapterLotatUnLiving;
    AdapterEshtratatUnliving adapterEshtratatUnliving;
    Public_function public_function;
    LocationManager manager;
    Location location;
    Gson gson;
    SharedPreferences sharedPreferences;
    String  jsonObj;
    int typenum;
    ActivityMainSubdetailsBinding activityMainSubdetailsBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainSubdetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_subdetails);

        // setContentView(R.layout.activity_main_subdetails);

        DataManger dataManger = new DataManger(this);
        linearLayoutconstrans=findViewById(R.id.Linearconstrans);
        linearLayoutlotss=findViewById(R.id.Linearlotss);

        context=this;
        gson=new Gson();
       Gson gson2=new Gson();
        Gson gson3=new Gson();
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
        ipadrass= sharedPreferences.getString("ipadrass","");
        num_Request= sharedPreferences.getString("num_Request","");
      //  num_Request=getIntent().getStringExtra("num_Request");
        public_function=new Public_function();
        String g= getIntent().getExtras().getString("itemData");
        jsonObj = getIntent().getExtras().getString("jsonObj");
        typenum=getIntent().getExtras().getInt("typenum");
        if(typenum==1)
        {
            View v = findViewById(R.id.content_main_activity_subdetails);
            v.setVisibility(View.VISIBLE);
            View as=findViewById(R.id.content_main_activity_main_plant_product);
            as.setVisibility(View.GONE);
            t[0] = gson.fromJson(g, ItemData.class);
            activityMainSubdetailsBinding.contentMainActivitySubdetails.setItemm(t[0]);
        }
        else if(typenum==2){
            View v = findViewById(R.id.content_main_activity_subdetails);
            v.setVisibility(View.GONE);
            View as=findViewById(R.id.content_main_activity_main_plant_product);
            as.setVisibility(View.VISIBLE);
            itemData_plantProducts[0] = gson2.fromJson(g, ItemData_PlantProduct.class);
            activityMainSubdetailsBinding.contentMainActivityMainPlantProduct.setItemmplant(itemData_plantProducts[0] );

        }
        else if(typenum==3){
            View v = findViewById(R.id.content_main_activity_subdetails);
            v.setVisibility(View.GONE);
            View as=findViewById(R.id.content_main_activity_main_livingobjects);
            as.setVisibility(View.VISIBLE);
            itemData_livingObjects[0] = gson.fromJson(g, ItemData_LivingObject.class);
            activityMainSubdetailsBinding.contentMainActivityMainLivingobjects.setItemmLiving( itemData_livingObjects[0]);
        }
        else if(typenum==4){
            View v = findViewById(R.id.content_main_activity_subdetails);
            v.setVisibility(View.GONE);
            View as=findViewById(R.id.content_main_activity_main_unlivingobjects);
            as.setVisibility(View.VISIBLE);
            itemData_unlivingObjects[0] = gson.fromJson(g, ItemData_LivingObject.class);
            activityMainSubdetailsBinding.contentMainActivityMainUnlivingobjects.setItemmunLiving(itemData_unlivingObjects[0]);
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
//            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 200);
//        }
//        Location location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        if(location==null){
//            location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        }
        location=public_function.getlocation(context,manager);
        if (location.getLongitude()!=0 && location.getLatitude() !=0)
        {
            SharedPreferences sharedPreferences;
            SharedPreferences.Editor prefsEditor;
            sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
            prefsEditor = sharedPreferences.edit();
            prefsEditor.putLong("Latitude", (long) location.getLatitude());
            prefsEditor.putLong("Longitude", (long) location.getLongitude());
            Toast.makeText(this,""+location.getLatitude()+location.getLongitude(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
      //  getMenuInflater().inflate(R.menu.main_activity_subdetails, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        try {
            public_function.NavMenuClick(id,context,sharedPreferences.getString("Token","")
                    ,sharedPreferences.getBoolean("ISAdmin",false)
                    ,sharedPreferences.getInt("RequestCommittee_Status_Id", 0),
                    sharedPreferences.getInt("treatment_data",-1),
                    sharedPreferences.getInt("sample_data",-1),
                    sharedPreferences.getInt("request_data",-1),
                    sharedPreferences.getInt("Committee_Type_Id",0),ipadrass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onclicktext(View view) throws JSONException {
        clicked = ((TextView) view).isClickable();
        switch (view.getId()) {

            case R.id.constrans:
                if (clicked){
                    findViewById(R.id.Linearconstrans).setVisibility(View.VISIBLE);
                    findViewById(R.id.Linearlotss).setVisibility(View.GONE);
//                    linearLayoutlotss.setVisibility(View.GONE);
//                    linearLayoutconstrans.setVisibility(View.VISIBLE);
                    itemConstrainsData22=new ArrayList<>();
                        String  itemNumber =   t[0].Item_number;
                        itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);
                        Object n = itemData[0].getList_Constrain_Data();
                        Gson g = new Gson();
                        String d = g.toJson(n);
                        listItemConstrains[0] = Arrays.asList(gson.fromJson(d.toString(), ListItemConstrains[].class));
                        Gson g1 = new Gson();
//                        String dat = g1.toJson(n);
                        Gson g2 = new Gson();
                        String ar = g2.toJson(  listItemConstrains[0]);
                        /////////////////////////////////////////////////////////////////////////////////////////
                        Gson j=new Gson();

                        JSONArray jsonArray=new JSONArray(ar);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (!jsonArray.isNull(i)) {
                                JSONObject jsonobject = jsonArray.getJSONObject(i);
                                JSONArray jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Constrain");
                                for (int k = 0; k < jsonArray1.length(); k++) {
                                    JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                                    String item_number = jsonobject2.get("Item_number").toString();
                                    if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number)) {
                                        ItemConstrainsData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemConstrainsData.class);
                                        itemConstrainsData22.add(itemConstrainsData);
                                    }
                                }
                            }
                        }
                        if(itemConstrainsData22.isEmpty()){
                            itemConstrainsData22.add(new ItemConstrainsData("لا توجد اشتراطات"));
                            adapterEshtratat = new AdapterEshtratat(itemConstrainsData22, context,t[0]);
                        }else {
                            adapterEshtratat = new AdapterEshtratat(itemConstrainsData22, context,t[0]);
                        }
                    activityMainSubdetailsBinding.contentMainActivitySubdetails.setAdapter2(adapterEshtratat);
                    activityMainSubdetailsBinding.contentMainActivitySubdetails.detialsconstrans.setLayoutManager(new LinearLayoutManager(context));

                    findViewById(R.id.constrans).setBackgroundResource(R.drawable.btnshadowclicked);
                   findViewById(R.id.constrans).setEnabled(false);
                    findViewById(R.id.lotss).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.lotss).setEnabled(true);
                }

                break;
            case R.id.lotss:
                if (clicked) {
                    itemLotatData22 = new ArrayList<>();
//                    linearLayoutconstrans.setVisibility(View.GONE);
//                    linearLayoutlotss.setVisibility(View.VISIBLE);
                    findViewById(R.id.Linearconstrans).setVisibility(View.GONE);
                    findViewById(R.id.Linearlotss).setVisibility(View.VISIBLE);
                    String itemNumber = t[0].Item_number;
                    itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);
                    Object n = itemData[0].getList_Lotat_Data();
                    Gson g = new Gson();
                    String d = g.toJson(n);
                    listItemLotat[0] = Arrays.asList(gson.fromJson(d, ListItemLotat[].class));
                    Gson g1 = new Gson();
                    String dat = g1.toJson(n);

                    Gson g2 = new Gson();
                    String ar = g2.toJson(listItemLotat[0]);
                    /////////////////////////////////////////////////////////////////////////////////////////
                    Gson j = new Gson();

                    JSONArray jsonArray = new JSONArray(ar);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        if (!jsonArray.isNull(i)) {
                            JSONObject jsonobject = jsonArray.getJSONObject(i);
                            JSONArray jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Lot");
                            for (int k = 0; k < jsonArray1.length(); k++) {
                                JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                                String item_number = jsonobject2.get("Item_number").toString();
                                String Lot_Number = jsonobject2.get("Lot_Number").toString();
                                if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number) && (Float.parseFloat(Lot_Number) != Float.parseFloat("0"))) {
                                    ItemLotatData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemLotatData.class);
                                    itemLotatData22.add(itemConstrainsData);
                                }
                            }
                        }
                    }
                    if (itemLotatData22.isEmpty()) {
                        itemLotatData22.add(new ItemLotatData("لا توجد لوطات"));
                        adapterLotat2 = new AdapterLotat(itemLotatData22, context,t[0]);
                    } else {
                        adapterLotat2 = new AdapterLotat(itemLotatData22, context,t[0]);
                    }
                    activityMainSubdetailsBinding.contentMainActivitySubdetails.setAdapter7(adapterLotat2);
                    activityMainSubdetailsBinding.contentMainActivitySubdetails.detialslotss.setLayoutManager(new LinearLayoutManager(context));
                    findViewById(R.id.lotss).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.lotss).setEnabled(false);
                    findViewById(R.id.constrans).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.constrans).setEnabled(true);
                    break;
                }
        }
    }


    public void CliclPlant(View view) throws JSONException {
        clicked = ((TextView) view).isClickable();
        switch (view.getId()) {
            case R.id.constransplant:
                if (clicked) {
                    try {

//                        linearLayoutlotss.setVisibility(View.GONE);
//                        linearLayoutconstrans.setVisibility(View.VISIBLE);
                        findViewById(R.id.Linearconstransplant).setVisibility(View.VISIBLE);
                        findViewById(R.id.Linearlotssplant).setVisibility(View.GONE);
                        String itemNumber = itemData_plantProducts[0].Item_number;
                        itemConstrainsData22=new ArrayList<>();
                        itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);

                        Object n = itemData[0].getList_Constrain_Data();
                        Gson g = new Gson();
                        String d = g.toJson(n);
                        listItemConstrains[0] = Arrays.asList(gson.fromJson(d.toString(), ListItemConstrains[].class));
                        Gson g1 = new Gson();
                        String dat = g1.toJson(n);
                        Gson g2 = new Gson();
                        String ar = g2.toJson(listItemConstrains[0]);
                        /////////////////////////////////////////////////////////////////////////////////////////
                        Gson j = new Gson();

                        JSONArray jsonArray = new JSONArray(ar);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            if (!jsonArray.isNull(i)) {
                                JSONObject jsonobject = jsonArray.getJSONObject(i);
                                JSONArray jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Constrain");
                                for (int k = 0; k < jsonArray1.length(); k++) {
                                    JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                                    String item_number = jsonobject2.get("Item_number").toString();
                                    if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number)) {
                                        ItemConstrainsData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemConstrainsData.class);
                                        itemConstrainsData22.add(itemConstrainsData);
                                    }
                                }
                            }
                        }
                    }
                    catch (Exception ex){
                        Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                    if (itemConstrainsData22.isEmpty()) {
                        itemConstrainsData22.add(new ItemConstrainsData("لا توجد اشتراطات"));

                        adapterEshtratatPlantProduct = new AdapterEshtratatPlantProduct(itemConstrainsData22, context, itemData_plantProducts[0]);
                    }
                    else {
                        adapterEshtratatPlantProduct = new AdapterEshtratatPlantProduct(itemConstrainsData22, context, itemData_plantProducts[0]);
                    }
                    activityMainSubdetailsBinding.contentMainActivityMainPlantProduct.setAdapter3(adapterEshtratatPlantProduct);
                    activityMainSubdetailsBinding.contentMainActivityMainPlantProduct.detialsconstrans.setLayoutManager(new LinearLayoutManager(context));


                    findViewById(R.id.lotssplant).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.lotssplant).setEnabled(true);
                    findViewById(R.id.constransplant).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.constransplant).setEnabled(false);
                }
                break;

        case R.id.lotssplant:
            if(clicked) {
                findViewById(R.id.Linearconstransplant).setVisibility(View.GONE);
                findViewById(R.id.Linearlotssplant).setVisibility(View.VISIBLE);
                itemLotatData22 = new ArrayList<>();
                itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);
                Object n = itemData[0].getList_Lotat_Data();
                Gson g = new Gson();
                String d = g.toJson(n);
                String itemNumber = itemData_plantProducts[0].Item_number;

                listItemLotat[0] = Arrays.asList(gson.fromJson(d, ListItemLotat[].class));
                Gson g1 = new Gson();
                String dat = g1.toJson(n);

                Gson g2 = new Gson();
                String ar = g2.toJson(listItemLotat[0]);
                /////////////////////////////////////////////////////////////////////////////////////////
                Gson j = new Gson();

                JSONArray jsonArray = new JSONArray(ar);
                for (int i = 0; i < jsonArray.length(); i++) {
                    if (!jsonArray.isNull(i)) {
                        JSONObject jsonobject = jsonArray.getJSONObject(i);
                        JSONArray jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Lot");
                        for (int k = 0; k < jsonArray1.length(); k++) {
                            JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                            String item_number = jsonobject2.get("Item_number").toString();
                            String Lot_Number = jsonobject2.get("Lot_Number").toString();
//                            if(! Lot_Number.isEmpty()) {
                                    if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number) && (Float.parseFloat(Lot_Number) != Float.parseFloat("0"))) {
                                    ItemLotatData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemLotatData.class);
                                    itemLotatData22.add(itemConstrainsData);
                                }
//                            }
                        }
                    }
                }

                if (itemLotatData22.isEmpty()) {
                    itemLotatData22.add(new ItemLotatData("لا توجد لوطات"));
                  // itemData_plantProducts[0]=new ItemData_PlantProduct(1);
                   adapterLotat = new AdapterLotatPlantproduct(itemLotatData22, context,itemData_plantProducts[0]);

                } else {
                    adapterLotat = new AdapterLotatPlantproduct(itemLotatData22, context,itemData_plantProducts[0]);
                }
                activityMainSubdetailsBinding.contentMainActivityMainPlantProduct.setAdapter0(adapterLotat);
                activityMainSubdetailsBinding.contentMainActivityMainPlantProduct.detialslotss.setLayoutManager(new LinearLayoutManager(context));
                findViewById(R.id.constransplant).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.constransplant).setEnabled(true);
                findViewById(R.id.lotssplant).setBackgroundResource(R.drawable.btnshadowclicked);
                findViewById(R.id.lotssplant).setEnabled(false);

                break;
            }
        }
    }


    public void ClickLiving(View view) throws JSONException {
        clicked = ((TextView) view).isClickable();
        switch (view.getId())
        {
            case R.id.constransliving:
                if (clicked) {
                    findViewById(R.id.Linearconstransliving).setVisibility(View.VISIBLE);
                    findViewById(R.id.Linearlotssliving).setVisibility(View.GONE);
                    itemConstrainsData22=new ArrayList<>();
                    String  itemNumber=  itemData_livingObjects[0].Item_number;
                    itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);
                    Object n = itemData[0].getList_Constrain_Data();

                    // Object n = itemData[0].getList_try(itemNumber);
                    Gson g = new Gson();
                    String d = g.toJson(n);
                    listItemConstrains[0] = Arrays.asList(gson.fromJson(d.toString(), ListItemConstrains[].class));
                    Gson g1 = new Gson();
                    String dat = g1.toJson(n);

                    Gson g2 = new Gson();
                    String ar = g2.toJson(  listItemConstrains[0]);
                    /////////////////////////////////////////////////////////////////////////////////////////
                    Gson j=new Gson();

                    JSONArray jsonArray=new JSONArray(ar);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        if (!jsonArray.isNull(i)) {
                            JSONObject jsonobject = jsonArray.getJSONObject(i);
                            JSONArray jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Constrain");
                            for (int k = 0; k < jsonArray1.length(); k++) {
                                JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                                String item_number = jsonobject2.get("Item_number").toString();
                                if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number)) {
                                    ItemConstrainsData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemConstrainsData.class);
                                    itemConstrainsData22.add(itemConstrainsData);
                                }
                            }
                        }
                    }
                    if (itemConstrainsData22.isEmpty()) {
                        itemConstrainsData22.add(new ItemConstrainsData("لا توجد اشتراطات"));
                        adapterEshtratatObjectliving=new AdapterEshtratatObjectliving(itemConstrainsData22,context,itemData_livingObjects[0]);

                    }
                    else {
                        adapterEshtratatObjectliving=new AdapterEshtratatObjectliving(itemConstrainsData22,context,itemData_livingObjects[0]);
                    }

                    activityMainSubdetailsBinding.contentMainActivityMainLivingobjects.setAdapteresh(adapterEshtratatObjectliving);
                    activityMainSubdetailsBinding.contentMainActivityMainLivingobjects.detialsconstrans.setLayoutManager(new LinearLayoutManager(context));


                    findViewById(R.id.constransliving).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.constransliving).setEnabled(false);
                    findViewById(R.id.lotssliving).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.lotssliving).setEnabled(true);

                }
                break;
            case R.id.lotssliving:
                if(clicked){
                    findViewById(R.id.Linearconstransliving).setVisibility(View.GONE);
                    findViewById(R.id.Linearlotssliving).setVisibility(View.VISIBLE);
                    String  itemNumber=  itemData_livingObjects[0].Item_number;
                    itemLotatData22=new ArrayList<>();
                    itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);
                    Object n = itemData[0].getList_Lotat_Data();
                    Gson g = new Gson();
                    String d = g.toJson(n);
                    listItemLotat[0]= Arrays.asList( gson.fromJson(d, ListItemLotat[].class));
                    Gson g1 = new Gson();
                    String dat = g1.toJson(n);
                    Gson g2 = new Gson();
                    String ar = g2.toJson(  listItemLotat[0]);
                    /////////////////////////////////////////////////////////////////////////////////////////
                    Gson j=new Gson();
                    JSONArray jsonArray=new JSONArray(ar);
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        if(!jsonArray.isNull(i))
                        {
                            JSONObject jsonobject = jsonArray.getJSONObject(i);
                            JSONArray      jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Lot");
                            for (int k = 0; k < jsonArray1.length(); k++) {
                                JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                                String item_number = jsonobject2.get("Item_number").toString();
                                String Lot_Number = jsonobject2.get("Lot_Number").toString();
                                if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number)&&(Float.parseFloat(Lot_Number)!=Float.parseFloat("0"))) {
                                    // itemConstrainsData.addAll((ItemConstrainsData)jsonobject2)
                                    ItemLotatData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemLotatData.class);
                                    //ItemLotatData itemConstrainsData = j.fromJson(jsonobject2.toString(), ItemLotatData.class);
                                    itemLotatData22.add(itemConstrainsData);
                                }
                            }
                        }
                    }

                    if(itemLotatData22.isEmpty()){
                        itemLotatData22.add(new ItemLotatData("لا توجد لوطات"));
                        adapterLotatLiving=new AdapterLotatLiving(itemLotatData22,context,itemData_livingObjects[0]);

                    }
                    else {
                        adapterLotatLiving=new AdapterLotatLiving(itemLotatData22,context,itemData_livingObjects[0]);
                    }
                    activityMainSubdetailsBinding.contentMainActivityMainLivingobjects.setAdapterlot(adapterLotatLiving);
                    activityMainSubdetailsBinding.contentMainActivityMainLivingobjects.detialslotss.setLayoutManager(new LinearLayoutManager(context));

                    findViewById(R.id.lotssliving).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.lotssliving).setEnabled(false);
                    findViewById(R.id.constransliving).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.constransliving).setEnabled(true);

                break;
           }
        }
    }
    public void ClickUnliving(View view) throws JSONException {
        clicked = ((TextView) view).isClickable();
        switch (view.getId()) {
            case R.id.constransunliving:
                if (clicked) {
                    findViewById(R.id.Linearconstransunliving).setVisibility(View.VISIBLE);
                    findViewById(R.id.Linearlotssunliving).setVisibility(View.GONE);
                    itemConstrainsData22=new ArrayList<>();
                    String  itemNumber =itemData_unlivingObjects[0].Item_number;
                    itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);
                    Object n = itemData[0].getList_Constrain_Data();

                    // Object n = itemData[0].getList_try(itemNumber);
                    Gson g = new Gson();
                    String d = g.toJson(n);
                    listItemConstrains[0] = Arrays.asList(gson.fromJson(d.toString(), ListItemConstrains[].class));
                    Gson g1 = new Gson();
                    String dat = g1.toJson(n);

                    Gson g2 = new Gson();
                    String ar = g2.toJson(  listItemConstrains[0]);
                    /////////////////////////////////////////////////////////////////////////////////////////
                    Gson j=new Gson();

                    JSONArray jsonArray=new JSONArray(ar);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        if (!jsonArray.isNull(i)) {
                            JSONObject jsonobject = jsonArray.getJSONObject(i);
                            JSONArray jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Constrain");
                            for (int k = 0; k < jsonArray1.length(); k++) {
                                JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                                String item_number = jsonobject2.get("Item_number").toString();
                                if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number)) {
                                    // itemConstrainsData.addAll((ItemConstrainsData)jsonobject2)
                                    ItemConstrainsData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemConstrainsData.class);
                                    itemConstrainsData22.add(itemConstrainsData);
                                    // Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                    if (itemConstrainsData22.isEmpty()) {
                        itemConstrainsData22.add(new ItemConstrainsData("لا توجد اشتراطات"));
                        adapterEshtratatUnliving=new AdapterEshtratatUnliving(itemConstrainsData22,context,itemData_unlivingObjects[0]);

                    }
                    else {
                       adapterEshtratatUnliving=new AdapterEshtratatUnliving(itemConstrainsData22,context,itemData_unlivingObjects[0]);

                    }
                    activityMainSubdetailsBinding.contentMainActivityMainUnlivingobjects.setAdapter9(adapterEshtratatUnliving);
                    activityMainSubdetailsBinding.contentMainActivityMainUnlivingobjects.detialsconstrans.setLayoutManager(new LinearLayoutManager(context));

                    findViewById(R.id.constransunliving).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.constransunliving).setEnabled(false);
                    findViewById(R.id.lotssunliving).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.lotssunliving).setEnabled(true);
                }

                break;
            case R.id.lotssunliving:
                if (clicked) {
                    itemLotatData22 = new ArrayList<>();
                    findViewById(R.id.Linearconstransunliving).setVisibility(View.GONE);
                    findViewById(R.id.Linearlotssunliving).setVisibility(View.VISIBLE);
                    String itemNumber = itemData_unlivingObjects[0].Item_number;
                    itemData[0] = gson.fromJson(jsonObj.toString(), ConstrainsData2.class);
                    Object n = itemData[0].getList_Lotat_Data();
                    Gson g = new Gson();
                    String d = g.toJson(n);
                    listItemLotat[0] = Arrays.asList(gson.fromJson(d, ListItemLotat[].class));
                    Gson g1 = new Gson();
                    String dat = g1.toJson(n);

                    Gson g2 = new Gson();
                    String ar = g2.toJson(listItemLotat[0]);
                    /////////////////////////////////////////////////////////////////////////////////////////
                    Gson j = new Gson();

                    JSONArray jsonArray = new JSONArray(ar);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        if (!jsonArray.isNull(i)) {
                            JSONObject jsonobject = jsonArray.getJSONObject(i);
                            JSONArray jsonArray1 = jsonobject.getJSONArray("_x0040_temp_table_Lot");
                            for (int k = 0; k < jsonArray1.length(); k++) {
                                JSONObject jsonobject2 = jsonArray1.getJSONObject(k);
                                String item_number = jsonobject2.get("Item_number").toString();
                                String Lot_Number = jsonobject2.get("Lot_Number").toString();
                                if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number) && (Float.parseFloat(Lot_Number) != Float.parseFloat("0"))) {
                                    ItemLotatData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemLotatData.class);
                                    itemLotatData22.add(itemConstrainsData);
                                }
                            }
                        }
                    }
                    if (itemLotatData22.isEmpty()) {
                        itemLotatData22.add(new ItemLotatData("لا توجد لوطات"));
                        AdapterLotatUnLiving = new AdapterLotatUnLiving(itemLotatData22, context,itemData_unlivingObjects[0]);

                    } else {
                        AdapterLotatUnLiving = new AdapterLotatUnLiving(itemLotatData22, context,itemData_unlivingObjects[0]);
                    }
                    activityMainSubdetailsBinding.contentMainActivityMainUnlivingobjects.setAdapter7(AdapterLotatUnLiving);
                    activityMainSubdetailsBinding.contentMainActivityMainUnlivingobjects.detialslotss.setLayoutManager(new LinearLayoutManager(context));

                    findViewById(R.id.lotssunliving).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.lotssunliving).setEnabled(false);
                    findViewById(R.id.constransunliving).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.constransunliving).setEnabled(true);
                    break;
                }
        }
    }

    public void shownav(View view) {
        drawer.openDrawer(GravityCompat.START);
    }
}
