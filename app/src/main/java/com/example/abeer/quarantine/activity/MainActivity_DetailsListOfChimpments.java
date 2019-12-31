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
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.AdapterItemData;
import com.example.abeer.quarantine.adapter.AdapterLivingObjects;
import com.example.abeer.quarantine.adapter.AdapterPlantProduct;
import com.example.abeer.quarantine.adapter.AdapterUnlivingObjects;
import com.example.abeer.quarantine.databinding.ActivityDetailsListOfChimpmentsNewBinding;
import com.example.abeer.quarantine.databinding.ActivityMainDetailsListOfChimpmentsBinding;
import com.example.abeer.quarantine.databinding.Itemsbacodbinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.model.ExportCheckRequestDetail;
import com.example.abeer.quarantine.presenter.ClicikItemLiving;
import com.example.abeer.quarantine.presenter.ClickCustomItemData;
import com.example.abeer.quarantine.presenter.ClickCustomItemData_plantproduct;
import com.example.abeer.quarantine.presenter.ClickItemUnliving;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ItemData;
import com.example.abeer.quarantine.viewmodel.ListDetailsCheckRequest;
import com.example.abeer.quarantine.viewmodel.ListDetailsCheckRequestNew;
import com.example.abeer.quarantine.viewmodel.ListItemDataDetail;
import com.example.abeer.quarantine.viewmodel.livingobjects.ItemData_LivingObject;
import com.example.abeer.quarantine.viewmodel.livingobjects.ListLivingObjects;
import com.example.abeer.quarantine.viewmodel.plantProduct.ItemData_PlantProduct;
import com.example.abeer.quarantine.viewmodel.plantProduct.ListPlantproduct;
import com.example.abeer.quarantine.viewmodel.unlivingobjects.ListUnlivingObject;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_DetailsListOfChimpments extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    boolean clicked;
    WebView webView;
    LinearLayout ChimpmentDetails, plant, part_Plantproduct, unLiving_Objects, Living_Objects, general_admin, outlet, linear_title5, company, person, admin;
    DataManger dataManger;
    Context context = this;
    // ActivityDetailsListOfChimpmentsNewBinding activityDetailsListOfChimpmentsNewBinding;
    final List<ExportCheckRequestDetail>[] exportCheckRequestDetails = new List[1];
    final ListDetailsCheckRequest[] listDetailsCheckRequest = new ListDetailsCheckRequest[1];
    final ListDetailsCheckRequest[] listDetailsCheckRequest2 = new ListDetailsCheckRequest[1];
    final ListDetailsCheckRequestNew[] listDetailsCheckRequestNews = new ListDetailsCheckRequestNew[1];
    final ListDetailsCheckRequestNew[] listDetailsCheckRequestNews2 = new ListDetailsCheckRequestNew[1];
    ListDetailsCheckRequestNew daa;
//    ListDetailsCheckRequestNew[] daa;
    final ListItemDataDetail[] listItemDataDetails = new ListItemDataDetail[1];
    final List<ItemData>[] itemDataa = new List[1];
    final ItemData[] ii = new ItemData[1];
    final ArrayList<ItemData> ItemDatatest = new ArrayList<>();
    final ArrayList<ItemData> ItemDatatest2 = new ArrayList<>();
    final ListItemDataDetail[] itemData = new ListItemDataDetail[1];
    AdapterItemData adapterCheckRequest = null;
    AdapterUnlivingObjects adapterUnlivingObjects =null;
    AdapterPlantProduct adapterPlantProduct =null;
    AdapterLivingObjects adapterLivingObjects = null;
    final ListPlantproduct[] itemData_plant = new ListPlantproduct[1];
    final ArrayList<ItemData_PlantProduct> ItemDatatest_plant = new ArrayList<>();
    final ArrayList<ItemData_PlantProduct> ItemDatatest2_plant = new ArrayList<>();
    final List<ItemData_PlantProduct>[] itemDataa_plant = new List[1];
    final ArrayList<ItemData_LivingObject> ItemDatatest_living = new ArrayList<>();
    final ListLivingObjects[] itemData_Living = new ListLivingObjects[1];
    final ArrayList<ItemData_LivingObject> ItemDatatest2_object = new ArrayList<>();
    final List<ItemData_LivingObject>[] itemDataa_object = new List[1];
    final ListUnlivingObject[] itemData_UnLiving = new ListUnlivingObject[1];
    final ArrayList<ItemData_LivingObject> ItemDatatest_unliving = new ArrayList<>();
    final ArrayList<ItemData_LivingObject> ItemDatatest2_unobject = new ArrayList<>();
    final List<ItemData_LivingObject>[] itemDataa_unobject = new List[1];
    String ipadrass;
    String num_Request;
    String Request_id;
    DrawerLayout drawer;
    JSONObject jsonObj;
    Gson gson;
    SharedPreferences sharedPreferences;
    Public_function public_function;
    LocationManager manager;

    ActivityMainDetailsListOfChimpmentsBinding activityMainDetailsListOfChimpmentsBinding;
//LinearLayout data_manafz,Exporting_Organization,Exporting_Company,Exporting_Pass,
    //   ChimpmentDetails,Examination_Place,attachments ,plant,part_Plantproduct,unLiving_Objects,Living_Objects,linear_title5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        activityMainDetailsListOfChimpmentsBinding =
//                DataBindingUtil.setContentView((Activity) context,R.layout.activity_main__details_list_of_chimpments);

        //    setContentView(R.layout.activity_main__details_list_of_chimpments);
        activityMainDetailsListOfChimpmentsBinding = DataBindingUtil.setContentView((Activity) context, R.layout.activity_main__details_list_of_chimpments);
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
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference", 0);
        num_Request = sharedPreferences.getString("num_Request", "");
        Request_id = sharedPreferences.getString("checkRequest_Id", "");
        ipadrass = sharedPreferences.getString("ipadrass", "");
        public_function = new Public_function();
      //  TextView title_list = findViewById(R.id.title_list);
        dataManger = new DataManger(this);
        plant = findViewById(R.id.plant);
        part_Plantproduct = findViewById(R.id.part_Plantproduct);
        unLiving_Objects = findViewById(R.id.unLiving_Objects);
        Living_Objects = findViewById(R.id.Living_Objects);
        outlet = findViewById(R.id.outlet);
        general_admin = findViewById(R.id.general_admin);
        company = findViewById(R.id.company);
        admin = findViewById(R.id.admin);
        person = findViewById(R.id.person);
        ((TextView)findViewById(R.id.value_request)).setText(num_Request);
        dataManger.SendVollyRequestJsonObjectGet(this, Request.Method.GET, ipadrass + ApiCall.UrlDetailsCheckRequest + Request_id, new IDataValue() {
            @Override
            public void Success(Object response) throws JSONException {
                String result = response.toString();
                gson = new Gson();
           //     daa = gson.fromJson(result, ListDetailsCheckRequestNew[].class);
                daa = gson.fromJson(result, ListDetailsCheckRequestNew.class);
//                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setDetaill(daa[0]);
                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setDetaill(daa);
                gson = new Gson();
                //String item_data = daa[0].getItem_Data();
                String item_data = daa.getItem_Data();
                if(item_data != null){
                jsonObj = null;
                jsonObj = XML.toJSONObject(item_data);
                }else {

                }
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
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
        Location location=public_function.getlocation(context,manager);
        if (location.getLatitude()!=0&&location.getLongitude()!=0)
        {     SharedPreferences sharedPreferences;
            SharedPreferences.Editor prefsEditor;
            sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
            prefsEditor = sharedPreferences.edit();
            prefsEditor.putLong("Latitude", (long) location.getLatitude());
            prefsEditor.putLong("Longitude", (long) location.getLongitude());
            Toast.makeText(this,""+location.getLatitude()+location.getLongitude(), Toast.LENGTH_LONG).show();
        }
    }

    public void stitleclick(View view) throws JSONException {


        clicked = ((TextView) view).isClickable();

        switch (view.getId()) {

            case R.id.stitle1:
                if (clicked) {
                    plant.setVisibility(View.VISIBLE);

                    Object f = jsonObj.get("_x0040_Item_Data");

                    if (f instanceof JSONArray) {
                        itemData[0] = gson.fromJson(jsonObj.toString(), ListItemDataDetail.class);
                        ItemDatatest.addAll(itemData[0].get_ItemData_test());
                        //////////////////////////////////////////////////////////////////////////////////////////////////
                        for (int i = 0; i < ItemDatatest.size(); i++) {
                            String df = ItemDatatest.get(i).Item_Type;
                            if (Float.parseFloat(ItemDatatest.get(i).Item_Type) == Float.parseFloat("4")) {
                                ItemDatatest2.add((ItemDatatest.get(i)));
                                itemDataa[0] = ItemDatatest2;
                                Toast.makeText(context, "item", Toast.LENGTH_SHORT).show();
                            }
                        }

                        if (adapterCheckRequest == null) {
                            if(itemDataa[0]!=null) {
                                findViewById(R.id.recycler1).setVisibility(View.VISIBLE);
                                findViewById(R.id.notext1).setVisibility(View.GONE);
                                adapterCheckRequest = new AdapterItemData(itemDataa[0], context, new ClickCustomItemData() {
                                    @Override
                                    public void plant_click(View view, ItemData itemData) {
                                        Intent i = new Intent(MainActivity_DetailsListOfChimpments.this, MainActivity_subdetails.class);
                                        gson = new Gson();
                                        String data_detail = gson.toJson(itemData);
                                        i.putExtra("jsonObj", jsonObj.toString());
                                        i.putExtra("itemData", data_detail);
                                        i.putExtra("typenum", 1);
                                        startActivity(i);

                                    }
                                });
                                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setAdapter(adapterCheckRequest);
                                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.recycler1.setLayoutManager(new LinearLayoutManager(context));

                            }else {
                                findViewById(R.id.recycler1).setVisibility(View.GONE);
                                findViewById(R.id.notext1).setVisibility(View.VISIBLE);
                            }
                             }
                             else {

                        }

                        part_Plantproduct.setVisibility(View.GONE);
                        unLiving_Objects.setVisibility(View.GONE);
                        Living_Objects.setVisibility(View.GONE);
                        findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadowclicked);
                        findViewById(R.id.stitle1).setEnabled(false);
                        findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
                        findViewById(R.id.stitle2).setEnabled(true);
                        findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadow);
                        findViewById(R.id.stitle3).setEnabled(true);
                        findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadow);
                        findViewById(R.id.stitle4).setEnabled(true);
                    }
                }
                break;
            case R.id.stitle2:
                if (clicked) {
                    plant.setVisibility(View.GONE);
                    part_Plantproduct.setVisibility(View.VISIBLE);
                    Object f = jsonObj.get("_x0040_Item_Data");
                    if (f instanceof JSONArray) {
                        itemData_plant[0] = gson.fromJson(jsonObj.toString(), ListPlantproduct.class);
                        ItemDatatest_plant.addAll(itemData_plant[0].get_ItemData_test());
                        //////////////////////////////////////////////////////////////////////////////////////////////////
                        for (int i = 0; i < ItemDatatest_plant.size(); i++) {
                            String df = ItemDatatest_plant.get(i).Item_Type;
                            // arrayList.add( ItemDatatest.get(i).Item_Type);
                            if (Float.parseFloat(ItemDatatest_plant.get(i).Item_Type) == Float.parseFloat("5")) {
                                ItemDatatest2_plant.add((ItemDatatest_plant.get(i)));
                                itemDataa_plant[0] = ItemDatatest2_plant;
                                Toast.makeText(context, "item", Toast.LENGTH_SHORT).show();
                            }
                        }


                    if (adapterPlantProduct == null) {
                        if (itemDataa_plant[0]  != null) {
                            findViewById(R.id.recycler2).setVisibility(View.VISIBLE);
                            findViewById(R.id.notext2).setVisibility(View.GONE);
                          adapterPlantProduct = new AdapterPlantProduct(itemDataa_plant[0], context, new ClickCustomItemData_plantproduct() {
                                    @Override
                                    public void plantProduct_click(View view, ItemData_PlantProduct itemData_plantProduct) {
                              Intent i = new Intent(MainActivity_DetailsListOfChimpments.this, MainActivity_subdetails.class);
                                Gson gson1 = new Gson();
                                String detail_plant = gson1.toJson(itemData_plantProduct);
                                i.putExtra("plant_namee", detail_plant);
                                i.putExtra("itemData", detail_plant);
                                i.putExtra("jsonObj", jsonObj.toString());
                                i.putExtra("typenum", 2);
                                startActivity(i);

                                    }
                                });
                            activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setAdapterplant(adapterPlantProduct);
                            activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.recycler2.setLayoutManager(new LinearLayoutManager(context));

                        } else {
                            findViewById(R.id.recycler2).setVisibility(View.GONE);
                            findViewById(R.id.notext2).setVisibility(View.VISIBLE);
                          }

                    } else {

                        }

                    unLiving_Objects.setVisibility(View.GONE);
                    Living_Objects.setVisibility(View.GONE);
                    findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.stitle2).setEnabled(false);
                    findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle1).setEnabled(true);
                    findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle3).setEnabled(true);
                    findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle4).setEnabled(true);
                }
                }
                break;

            case R.id.stitle3:
                if (clicked) {
                    plant.setVisibility(View.GONE);
                    part_Plantproduct.setVisibility(View.GONE);
                    Living_Objects.setVisibility(View.VISIBLE);
                    Object f = jsonObj.get("_x0040_Item_Data");
                    if (f instanceof JSONArray) {

                        itemData_Living[0] = gson.fromJson(jsonObj.toString(), ListLivingObjects.class);
                        ItemDatatest_living.addAll(itemData_Living[0].get_ItemData_test());
                        //////////////////////////////////////////////////////////////////////////////////////////////////
                        for (int i = 0; i < ItemDatatest_living.size(); i++) {
                            String df = ItemDatatest_living.get(i).Item_Type;
                            if (Float.parseFloat(ItemDatatest_living.get(i).Item_Type) == Float.parseFloat("16")) {
                                ItemDatatest2_object.add((ItemDatatest_living.get(i)));
                                itemDataa_object[0] = ItemDatatest2_object;
                                Toast.makeText(context, "item", Toast.LENGTH_SHORT).show();
                            }
                        }

                        if (adapterLivingObjects == null) {
                            if (itemDataa_object[0] != null) {
                                findViewById(R.id.recycler3).setVisibility(View.VISIBLE);
                                findViewById(R.id.notext3).setVisibility(View.GONE);
                                adapterLivingObjects = new AdapterLivingObjects(itemDataa_object[0], context, new ClicikItemLiving() {
                                    @Override
                                    public void eshtratatLiveObject_click(View view, ItemData_LivingObject itemData_livingObject) {
                                        Intent i = new Intent(MainActivity_DetailsListOfChimpments.this, MainActivity_subdetails.class);
                                        Gson gson1 = new Gson();
                                        String detail_Living = gson1.toJson(itemData_livingObject);
                                        i.putExtra("plant_nam", detail_Living);
                                        i.putExtra("itemData", detail_Living);
                                        i.putExtra("jsonObj", jsonObj.toString());
                                        i.putExtra("typenum", 3);
                                        startActivity(i);
                                    }
                                });
                                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setAdapterLiving(adapterLivingObjects);
                                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.recycler3.setLayoutManager(new LinearLayoutManager(context));

                            }
                               else {
                                findViewById(R.id.recycler3).setVisibility(View.GONE);
                                findViewById(R.id.notext3).setVisibility(View.VISIBLE);
                            }

                        }else {
                        }
                    }

                    unLiving_Objects.setVisibility(View.GONE);
                    findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.stitle3).setEnabled(false);
                    findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle2).setEnabled(true);
                    findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle1).setEnabled(true);
                    findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle4).setEnabled(true);
                }
                break;

            case R.id.stitle4:
                if (clicked) {
                    plant.setVisibility(View.GONE);
                    part_Plantproduct.setVisibility(View.GONE);
                    unLiving_Objects.setVisibility(View.VISIBLE);
                    Object f = jsonObj.get("_x0040_Item_Data");

                    if (f instanceof JSONArray) {
                        itemData_UnLiving[0] = gson.fromJson(jsonObj.toString(), ListUnlivingObject.class);
                        ItemDatatest_unliving.addAll(itemData_UnLiving[0].get_ItemData_test());
                        //////////////////////////////////////////////////////////////////////////////////////////////////
                        for (int i = 0; i < ItemDatatest_unliving.size(); i++) {
                            String df = ItemDatatest_unliving.get(i).Item_Type;
                            // arrayList.add( ItemDatatest.get(i).Item_Type);
                            if (Float.parseFloat(ItemDatatest_unliving.get(i).Item_Type) == Float.parseFloat("33")) {
                                ItemDatatest2_unobject.add((ItemDatatest_unliving.get(i)));
                                itemDataa_unobject[0] = ItemDatatest2_unobject;
                                Toast.makeText(context, "item", Toast.LENGTH_SHORT).show();
                            }
                        }


                        if (adapterUnlivingObjects == null) {
                            if (itemDataa_unobject[0]!= null) {
                                findViewById(R.id.recycler4).setVisibility(View.VISIBLE);
                                findViewById(R.id.notext4).setVisibility(View.GONE);
                                adapterUnlivingObjects = new AdapterUnlivingObjects(itemDataa_unobject[0], context, new ClickItemUnliving() {
                                    @Override
                                    public void unLiveObject_click(View view, ItemData_LivingObject itemData_livingObject) {
                                        Intent i = new Intent(MainActivity_DetailsListOfChimpments.this, MainActivity_subdetails.class);
                                        Gson gson1 = new Gson();
                                        String detail_Living = gson1.toJson(itemData_livingObject);
                                        i.putExtra("plant_nam", detail_Living);
                                        i.putExtra("itemData", detail_Living);
                                        i.putExtra("jsonObj", jsonObj.toString());
                                        i.putExtra("typenum", 4);
                                        startActivity(i);
                                    }
                                });
                                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setAdapterunLiving(adapterUnlivingObjects);
                                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.recycler4.setLayoutManager(new LinearLayoutManager(context));

                               }else {
                                findViewById(R.id.recycler4).setVisibility(View.GONE);
                                findViewById(R.id.notext4).setVisibility(View.VISIBLE);
                            }

                        }else {

                        }
                    }

                    Living_Objects.setVisibility(View.GONE);
                    findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.stitle4).setEnabled(false);
                    findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle2).setEnabled(true);
                    findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle3).setEnabled(true);
                    findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.stitle1).setEnabled(true);
                }
                break;
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


    public void showPDF(View view) {
        String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf"; // pdf link
        webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
    }

    public void shownav(View view) {
        drawer.openDrawer(GravityCompat.START);
    }
}
