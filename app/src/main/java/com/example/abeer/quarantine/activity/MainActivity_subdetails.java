package com.example.abeer.quarantine.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.AdapterEshtratat;
import com.example.abeer.quarantine.adapter.AdapterLotat;
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
    String ipadrass;
    String num_Request;
    AdapterEshtratat adapterEshtratat;
    Public_function public_function;
    Gson gson;
    SharedPreferences sharedPreferences;
    String  jsonObj;
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
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
        ipadrass= sharedPreferences.getString("ipadrass","");
        num_Request= sharedPreferences.getString("num_Request","");
      //  num_Request=getIntent().getStringExtra("num_Request");
        public_function=new Public_function();
//        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ipadrass+ApiCall.UrlDetailsCheckRequest, new IDataValue() {
//            @Override
//            public void Success(Object response) throws JSONException {
//                Gson gson = new Gson();
//                String data = response.toString();
//
//                ListDetailsCheckRequestNew[] result = gson.fromJson(data, ListDetailsCheckRequestNew[].class);
//                String item_data = result[0].getItem_Data();
//                JSONObject jsonObj = null;
//                jsonObj = XML.toJSONObject(item_data);
//                itemData[0] = gson.fromJson(jsonObj.toString(), ListItemDataDetail.class);
//                //    String h = getIntent().getExtras().getString("plant_name");
//                //   t[0] = gson.fromJson(h, ItemData.class);
//                //  itemData2[0] = gson.fromJson(h.toString(), ListItemDataDetail.class);
//
//                activityMainSubdetailsBinding.setDetailItemDataList(itemData[0]);
//                //   activityDetailOfDetailItemDataBinding.setItemm(t[0]);
//            }
//
//            @Override
//            public void Error(VolleyError error) {
//
//            }
//        });
        String g= getIntent().getExtras().getString("itemData");
        jsonObj = getIntent().getExtras().getString("jsonObj");
        t[0] = gson.fromJson(g, ItemData.class);

        activityMainSubdetailsBinding.contentMainActivitySubdetails.setItemm(t[0]);

        //   t[0].It
        //  itemData2[0] = gson.fromJson(h.toString(), ListItemDataDetail.class);
        // activityDetailOfDetailItemDataBinding.setDetailItemDataList(itemDatac [0]);
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
//            i.putExtra("ipadrass", ipadrass);
//            i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        } else if (id == R.id.treatment_title) {
//            //   Intent i=new Intent(context,TreatmentStatement.class);
//            Intent i=new Intent(context,MainActivity_TreatmentStatement.class);
//            i.putExtra("ipadrass", ipadrass);
//            i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//
//        } else if (id == R.id.Committee_title) {
//            Intent i=new Intent(context,MainActivity_Ex_RequestCommitteeResult.class);
//            i.putExtra("ipadrass", ipadrass);
//            i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        }else if (id == R.id.todolist) {
//            Intent i=new Intent(context,MainActivity_Listofchipment.class);
//            i.putExtra("ipadrass", ipadrass);
//            i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        }
//        else if (id == R.id.logout) {
//            Intent i=new Intent(context,LogIn.class);
//            startActivity(i);
//
//        } else if (id == R.id.nav_send) {
//
//        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onclicktext(View view) throws JSONException {
        clicked = ((TextView) view).isClickable();
        switch (view.getId()) {

            case R.id.constrans:
                if (clicked){
                    linearLayoutlotss.setVisibility(View.GONE);
                    linearLayoutconstrans.setVisibility(View.VISIBLE);
//                    dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ApiCall.UrlDetailsCheckRequest, new IDataValue() {
//                        @Override
//                        public void Success(Object response) throws JSONException {
//                            try {
//                                Gson gson = new Gson();
//                                String data = response.toString();
//                                ListDetailsCheckRequestNew[] result = gson.fromJson(data, ListDetailsCheckRequestNew[].class);
//                                final String item_data = result[0].getItem_Data();
//                                JSONObject jsonObj = null;
//                                jsonObj = XML.toJSONObject(item_data);
//                                itemData[0] = gson.fromJson(jsonObj.toString(), ListItemDataDetail.class);
//                                ItemDatatest.addAll(itemData[0].get_ItemData_test());
//                                itemDataa[0]=ItemDatatest;
//
//                                try {
//                                    if(adapterCheckRequest==null) {
//                                        adapterCheckRequest = new AdapterItemData(itemDataa[0], context, new ClickCustomItemData() {
//                                            @Override
//                                            public void plant_click(View view, ItemData itemData) {
//                                                String name_plant = itemData.getItem_Name();
//                                                String ShortName = itemData.getItem_ShortName();
//                                                String ItemPurpose = itemData.getItemPurpose();
//                                                String ItemPartTypeName = itemData.getItemPartTypeName();
//                                                String Item_Cat_Name = itemData.getItem_Cat_Name();
//                                                //  Gson h=new Gson();
//                                                // String u=h.toJson("{"+"'_x0040_Item_Data'"+":[{"+"'Item_Name':"+name_plant+","+"'ShortName':"+ShortName+","+"'ItemPurpose':"+ItemPurpose+","+"'ItemPartTypeName':"+ItemPartTypeName+","+"'Item_Cat_Name':"+Item_Cat_Name+"}"+"]"+"}");
//                                                Intent i = new Intent(MainActivity_DetailsListOfChimpments.this, DetailOfDetailItemData.class);
//                                                //  i.putExtra("plant_name","{"+"'_x0040_Item_Data'"+":[{"+"Item_Name:"+name_plant+","+"ShortName:"+ShortName+","+"ItemPurpose:"+ItemPurpose+","+"ItemPartTypeName:"+ItemPartTypeName+","+"Item_Cat_Name:"+Item_Cat_Name+"]"+"}"+"}");
//                                                //      final ItemData[] t = new ItemData[1];
//                                                //      Gson gson1=new Gson();
//                                                //     String data=   gson1.toJson(itemData);
//                                                //    Gson gson4=new Gson();
//                                                //   t[0] = gson4.fromJson(data.toString(), ItemData.class);
//                                                //    i.putExtra("plant_name" ,t[0]);
//                                                startActivity(i);
//                                            }
//                                        });
//                                        activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setAdapter(adapterCheckRequest);
//                                        activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.recycler.setLayoutManager(new LinearLayoutManager(context));
//                                    }
//                                    else {
//
//                                    }
//                                }
//                                catch (Exception ex){
//                                    Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
//                                }
//
//
//                            }
//                            catch (Exception ex){
//                                Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//
//                        @Override
//                        public void Error(VolleyError error) {
//
//                        }
//                    });
                    itemConstrainsData22=new ArrayList<>();
                        String  itemNumber =   t[0].Item_number;
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
                        if(itemConstrainsData22.isEmpty()){
                            itemConstrainsData22.add(new ItemConstrainsData("لا توجد اشتراطات"));
                            activityMainSubdetailsBinding.contentMainActivitySubdetails.setAdapter2(adapterEshtratat);

                        }else {
                            adapterEshtratat = new AdapterEshtratat(itemConstrainsData22, context);
                            try {
                                activityMainSubdetailsBinding.contentMainActivitySubdetails.setAdapter2(adapterEshtratat);
                                activityMainSubdetailsBinding.contentMainActivitySubdetails.detialsconstrans.setLayoutManager(new LinearLayoutManager(context));
                            } catch (Exception ex) {
                                Toast.makeText(context, "" + ex.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }

                    findViewById(R.id.constrans).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.constrans).setEnabled(false);
                    findViewById(R.id.lotss).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.lotss).setEnabled(true);
                }

                break;
            case R.id.lotss:
                if (clicked)
                    itemLotatData22=new ArrayList<>();
                  linearLayoutconstrans.setVisibility(View.GONE);
                  linearLayoutlotss.setVisibility(View.VISIBLE);
                String  itemNumber =   t[0].Item_number;
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
                                if (Float.parseFloat(itemNumber) == Float.parseFloat(item_number)&&(Float.parseFloat(Lot_Number)!=Float.parseFloat("-1"))) {
                                    // itemConstrainsData.addAll((ItemConstrainsData)jsonobject2)
                                    ItemLotatData itemConstrainsData = j.fromJson(jsonArray1.getJSONObject(k).toString(), ItemLotatData.class);
                                    //ItemLotatData itemConstrainsData = j.fromJson(jsonobject2.toString(), ItemLotatData.class);
                                    itemLotatData22.add(itemConstrainsData);
                                }
                            }
                        }
                    }
                    AdapterLotat adapterLotat=new AdapterLotat(itemLotatData22,context);
                activityMainSubdetailsBinding.contentMainActivitySubdetails.setAdapter7(adapterLotat);
                activityMainSubdetailsBinding.contentMainActivitySubdetails.detialslotss.setLayoutManager(new LinearLayoutManager(context));
                findViewById(R.id.lotss).setBackgroundResource(R.drawable.btnshadowclicked);
                findViewById(R.id.lotss).setEnabled(false);
                findViewById(R.id.constrans).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.constrans).setEnabled(true);
                break;
        }
    }

    public void shownav(View view) {
        drawer.openDrawer(GravityCompat.START);
    }
}
