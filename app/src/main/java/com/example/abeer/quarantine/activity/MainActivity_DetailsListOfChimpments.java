package com.example.abeer.quarantine.activity;

import android.app.Activity;
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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.AdapterItemData;
import com.example.abeer.quarantine.adapter.AdapterPlantProduct;
import com.example.abeer.quarantine.databinding.ActivityDetailsListOfChimpmentsNewBinding;
import com.example.abeer.quarantine.databinding.ActivityMainDetailsListOfChimpmentsBinding;
import com.example.abeer.quarantine.functions.Public_function;
import com.example.abeer.quarantine.model.ExportCheckRequestDetail;
import com.example.abeer.quarantine.presenter.ClickCustomItemData;
import com.example.abeer.quarantine.presenter.ClickCustomItemData_plantproduct;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ItemData;
import com.example.abeer.quarantine.viewmodel.ListDetailsCheckRequest;
import com.example.abeer.quarantine.viewmodel.ListDetailsCheckRequestNew;
import com.example.abeer.quarantine.viewmodel.ListItemDataDetail;
import com.example.abeer.quarantine.viewmodel.plantProduct.ItemData_PlantProduct;
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
    ListDetailsCheckRequestNew[] daa;
    final ListItemDataDetail[] listItemDataDetails = new ListItemDataDetail[1];
    final List<ItemData> []itemDataa = new List[1];
    final ItemData[]ii=new ItemData[1];
    final ArrayList<ItemData> ItemDatatest = new ArrayList<>();
    final ArrayList<ItemData>ItemDatatest2 = new ArrayList<>();
    final ListItemDataDetail[] itemData = new ListItemDataDetail[1];
    AdapterItemData adapterCheckRequest=null;
    String ipadrass;
    String num_Request;
    String Request_id;
    DrawerLayout drawer;
    JSONObject jsonObj;
    Gson gson;
    SharedPreferences sharedPreferences;
    Public_function public_function;

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
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
        num_Request = sharedPreferences.getString("num_Request","");
        Request_id = sharedPreferences.getString("checkRequest_Id","");
        ipadrass= sharedPreferences.getString("ipadrass","");
        public_function=new Public_function();

//        context=this;
//        webView=findViewById(R.id.pdf);
//        webView.getSettings().setJavaScriptEnabled(true);
//        data_manafz=findViewById(R.id.data_manafz);
//        Exporting_Organization=findViewById(R.id.Exporting_Organization);
//        Exporting_Company=findViewById(R.id.Exporting_Company);
//        Exporting_Pass=findViewById(R.id.Exporting_Pass);
//        ChimpmentDetails=findViewById(R.id.ChimpmentDetails);
//        linear_title5=findViewById(R.id.linear_title5);
//        Examination_Place=findViewById(R.id.Examination_Place);
//        plant=findViewById(R.id.plant);
//        part_Plantproduct=findViewById(R.id.part_Plantproduct);
//        unLiving_Objects=findViewById(R.id.unLiving_Objects);
//        Living_Objects=findViewById(R.id.Living_Objects);
//        attachments=findViewById(R.id.attachments);

        //   num_Request = getIntent().getStringExtra("num_Request");
        TextView title_list=findViewById(R.id.title_list);
        //   title_list.setText(ss);

    //    num_Request=getIntent().getStringExtra("num_Request");
    //    Toast.makeText(context, num_Request, Toast.LENGTH_SHORT).show();
        dataManger = new DataManger(this);

        //setContentView(R.layout.activity_details_list_of_chimpments_new);
        plant = findViewById(R.id.plant);
        part_Plantproduct = findViewById(R.id.part_Plantproduct);
        unLiving_Objects = findViewById(R.id.unLiving_Objects);
        Living_Objects = findViewById(R.id.Living_Objects);
        outlet = findViewById(R.id.outlet);
        general_admin = findViewById(R.id.general_admin);
        company = findViewById(R.id.company);
        admin = findViewById(R.id.admin);
        person = findViewById(R.id.person);
        //test
      //  dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ApiCall.UrlDetailsCheckRequest+"40034", new IDataValue() {
     //running
       dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ipadrass+ApiCall.UrlDetailsCheckRequest+Request_id, new IDataValue() {
            @Override
            public void Success(Object response) throws JSONException {
                String result=response.toString();
                gson=new Gson();
                daa= gson.fromJson(result, ListDetailsCheckRequestNew[].class);
                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setDetaill(daa[0]);
                gson = new Gson();
                String item_data = daa[0].getItem_Data();
                jsonObj = null;
                jsonObj = XML.toJSONObject(item_data);
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
    }

    public void stitleclick(View view) throws JSONException {


        clicked = ((TextView) view).isClickable();

        switch (view.getId()) {

            case R.id.stitle1:
                if (clicked) {
                    plant.setVisibility(View.VISIBLE);
//                dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ipadrass+ApiCall.UrlDetailsCheckRequest, new IDataValue() {
//                    @Override
//                    public void Success(Object response) throws JSONException {
//                        try {
//                            Gson gson = new Gson();
//                            String data = response.toString();
//                            ListDetailsCheckRequestNew[] result = gson.fromJson(data, ListDetailsCheckRequestNew[].class);
//                            final String item_data = result[0].getItem_Data();
//                            JSONObject jsonObj = null;
//                            jsonObj = XML.toJSONObject(item_data);
//                            itemData[0] = gson.fromJson(jsonObj.toString(), ListItemDataDetail.class);
//                            ItemDatatest.addAll(itemData[0].get_ItemData_test());
//                            itemDataa[0]=ItemDatatest;

                    //     try {

                    Object f = jsonObj.get("_x0040_Item_Data");

                    if (f instanceof JSONArray) {
                        itemData[0] = gson.fromJson(jsonObj.toString(), ListItemDataDetail.class);
                        ItemDatatest.addAll(itemData[0].get_ItemData_test());
                        //////////////////////////////////////////////////////////////////////////////////////////////////
                        for (int i = 0; i < ItemDatatest.size(); i++) {
                            String df = ItemDatatest.get(i).Item_Type;
                            // arrayList.add( ItemDatatest.get(i).Item_Type);
                            if (Float.parseFloat(ItemDatatest.get(i).Item_Type) == Float.parseFloat("4")) {
                                ItemDatatest2.add((ItemDatatest.get(i)));
                                itemDataa[0] = ItemDatatest2;
                                Toast.makeText(context, "item", Toast.LENGTH_SHORT).show();
                            }
                        }
//                    itemData[0] = gson.fromJson(jsonObj.toString(), ListItemDataDetail.class);
//                    ItemDatatest.addAll(itemData[0].get_ItemData_test());
//                    itemDataa[0]=ItemDatatest;
                        if (adapterCheckRequest == null) {
                            adapterCheckRequest = new AdapterItemData(itemDataa[0], context, new ClickCustomItemData() {
                                @Override
                                public void plant_click(View view, ItemData itemData) {
//                                            String name_plant = itemData.getItem_Name();
//                                            String ShortName = itemData.getItem_ShortName();
//                                            String ItemPurpose = itemData.getItemPurpose();
//                                            String ItemPartTypeName = itemData.getItemPartTypeName();
//                                            String Item_Cat_Name = itemData.getItem_Cat_Name();
                                    //  Gson h=new Gson();
                                    // String u=h.toJson("{"+"'_x0040_Item_Data'"+":[{"+"'Item_Name':"+name_plant+","+"'ShortName':"+ShortName+","+"'ItemPurpose':"+ItemPurpose+","+"'ItemPartTypeName':"+ItemPartTypeName+","+"'Item_Cat_Name':"+Item_Cat_Name+"}"+"]"+"}");
                                    Intent i = new Intent(MainActivity_DetailsListOfChimpments.this, MainActivity_subdetails.class);
                                    gson = new Gson();
                                    String data_detail = gson.toJson(itemData);
                                    i.putExtra("jsonObj",jsonObj.toString());
                                    i.putExtra("itemData", data_detail);
                                    //    i.putExtra("ipadrass", ipadrass);
                                    // i.putExtra("num_Request",num_Request);

                                    //  i.putExtra("plant_name","{"+"'_x0040_Item_Data'"+":[{"+"Item_Name:"+name_plant+","+"ShortName:"+ShortName+","+"ItemPurpose:"+ItemPurpose+","+"ItemPartTypeName:"+ItemPartTypeName+","+"Item_Cat_Name:"+Item_Cat_Name+"]"+"}"+"}");
                                    //      final ItemData[] t = new ItemData[1];
                                    //      Gson gson1=new Gson();
                                    //     String data=   gson1.toJson(itemData);
                                    //    Gson gson4=new Gson();
                                    //   t[0] = gson4.fromJson(data.toString(), ItemData.class);
                                    //    i.putExtra("plant_name" ,t[0]);
                                    startActivity(i);
                                }
                            });
                            activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setAdapter(adapterCheckRequest);
                            activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.recycler.setLayoutManager(new LinearLayoutManager(context));
                        } else {

                        }

                        //   }
//                            catch (Exception ex){
//                                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
//                            }


                        //  }
//                        catch (Exception ex){
//                            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
//                        }

                        // }

//                    @Override
//                    public void Error(VolleyError error) {
//
//                 }
//                });
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
                if (clicked)
                plant.setVisibility(View.GONE);
                part_Plantproduct.setVisibility(View.VISIBLE);
//                dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ApiCall.UrlDetailsCheckRequest, new IDataValue() {
//                    @Override
//                    public void Success(Object response) throws JSONException {
//                        try {
//                            Gson gson = new Gson();
//                            String data = response.toString();
//                            ListDetailsCheckRequestNew[] result = gson.fromJson(data, ListDetailsCheckRequestNew[].class);
//                            final String item_data = result[0].getItem_Data();
//                            JSONObject jsonObj = null;
//                            jsonObj = XML.toJSONObject(item_data);
//                            Object f = jsonObj.get("_x0040_Item_Data");
//
//                            if (f instanceof JSONArray) {
//                                itemData_plant[0] = gson.fromJson(jsonObj.toString(), ListPlantproduct.class);
//                                ItemDatatest_plant.addAll(itemData_plant[0].get_ItemData_test());
//                                //////////////////////////////////////////////////////////////////////////////////////////////////
//                                for (int i = 0; i < ItemDatatest_plant.size(); i++) {
//                                    String df = ItemDatatest_plant.get(i).Item_Type;
//                                    // arrayList.add( ItemDatatest.get(i).Item_Type);
//                                    if (Float.parseFloat(ItemDatatest_plant.get(i).Item_Type) == Float.parseFloat("5")) {
//                                        ItemDatatest2_plant.add((ItemDatatest_plant.get(i)));
//                                        itemDataa_plant[0] = ItemDatatest2_plant;
//                                        Toast.makeText(context, "item", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//                                AdapterPlantProduct adapterPlantProduct = new AdapterPlantProduct(itemDataa_plant[0], context, new ClickCustomItemData_plantproduct() {
//                                    @Override
//                                    public void plantProduct_click(View view, ItemData_PlantProduct itemData_plantProduct) {
//                                        Intent i = new Intent(MainActivity_DetailsListOfChimpments.this, MainActivity_subdetails.class);
//                                        Gson gson1=new Gson();
//                                        String detail_plant= gson1.toJson(itemData_plantProduct);
//                                        i.putExtra("plant_namee" ,detail_plant);
//                                        startActivity(i);
//
//                                    }
//                                });
//
//                                activityMainDetailsListOfChimpmentsBinding.contentDetailsListChimpments.setAdapterplant(adapterPlantProduct);
//                                activityDetailsListOfChimpmentsNewBinding.recycler2.setLayoutManager(new LinearLayoutManager(context));
                        //    }
                      //  }
//                        catch (Exception ex){
//                            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void Error(VolleyError error) {
//
//                    }
//                });

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

                break;
            case R.id.stitle3:
                if (clicked)

                    plant.setVisibility(View.GONE);
                part_Plantproduct.setVisibility(View.GONE);
                unLiving_Objects.setVisibility(View.VISIBLE);
                Living_Objects.setVisibility(View.GONE);
                findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadowclicked);
                findViewById(R.id.stitle3).setEnabled(false);
                findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.stitle2).setEnabled(true);
                findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.stitle1).setEnabled(true);
                findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.stitle4).setEnabled(true);

                break;
            case R.id.stitle4:
                if (clicked)

                    plant.setVisibility(View.GONE);
                part_Plantproduct.setVisibility(View.GONE);
                unLiving_Objects.setVisibility(View.GONE);
                Living_Objects.setVisibility(View.VISIBLE);
                findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadowclicked);
                findViewById(R.id.stitle4).setEnabled(false);
                findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.stitle2).setEnabled(true);
                findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.stitle3).setEnabled(true);
                findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.stitle1).setEnabled(true);

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
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main_activity__details_list_of_chimpments, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
//            i.putExtra("ipadrass", ipadrass);
//         //   i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        } else if (id == R.id.treatment_title) {
//         //   Intent i=new Intent(context,TreatmentStatement.class);
//            Intent i=new Intent(context,MainActivity_TreatmentStatement.class);
//            i.putExtra("ipadrass", ipadrass);
//          //  i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//
//        } else if (id == R.id.Committee_title) {
//            Intent i=new Intent(context,MainActivity_Ex_RequestCommitteeResult.class);
//            i.putExtra("ipadrass", ipadrass);
//          //  i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        }else if (id == R.id.todolist) {
//            Intent i=new Intent(context,MainActivity_Listofchipment.class);
//            i.putExtra("ipadrass", ipadrass);
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
