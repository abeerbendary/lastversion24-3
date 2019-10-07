package com.example.abeer.quarantine.activity.dashactivity;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.AdapterItemData;
import com.example.abeer.quarantine.databinding.ActivityDetailOfDetailItemDataBinding;
import com.example.abeer.quarantine.presenter.ClickCustomItemData;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ItemData;
import com.example.abeer.quarantine.viewmodel.ListDetailsCheckRequestNew;
import com.example.abeer.quarantine.viewmodel.ListItemDataDetail;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
public class DetailOfDetailItemData extends AppCompatActivity {
    Context context;
    boolean clicked;
    LinearLayout linearLayoutconstrans;
    LinearLayout linearLayoutlotss;
    final ListItemDataDetail[] itemData = new ListItemDataDetail[1];
    final ListItemDataDetail[] itemData2 = new ListItemDataDetail[1];
    final ItemData[] t = new ItemData[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail_of_detail_item_data);
        final ActivityDetailOfDetailItemDataBinding activityDetailOfDetailItemDataBinding;
        DataManger dataManger = new DataManger(this);
        activityDetailOfDetailItemDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_of_detail_item_data);
        linearLayoutconstrans=findViewById(R.id.Linearconstrans);
    linearLayoutlotss=findViewById(R.id.Linearlotss);

        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ApiCall.UrlDetailsCheckRequest, new IDataValue() {
            @Override
            public void Success(Object response) throws JSONException {
                Gson gson = new Gson();
                String data = response.toString();

                ListDetailsCheckRequestNew[] result = gson.fromJson(data, ListDetailsCheckRequestNew[].class);
                String item_data = result[0].getItem_Data();
                JSONObject jsonObj = null;
                jsonObj = XML.toJSONObject(item_data);
                itemData[0] = gson.fromJson(jsonObj.toString(), ListItemDataDetail.class);
             //    String h = getIntent().getExtras().getString("plant_name");
             //   t[0] = gson.fromJson(h, ItemData.class);
              //  itemData2[0] = gson.fromJson(h.toString(), ListItemDataDetail.class);

                activityDetailOfDetailItemDataBinding.setDetailItemDataList(itemData[0]);
             //   activityDetailOfDetailItemDataBinding.setItemm(t[0]);
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
    }

    public void onclicktext(View view) {
        clicked = ((TextView) view).isClickable();
        switch (view.getId()) {

            case R.id.constrans:
                if (clicked){
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
                   linearLayoutlotss.setVisibility(View.GONE);
                    findViewById(R.id.constrans).setBackgroundResource(R.drawable.btnshadowclicked);
                    findViewById(R.id.constrans).setEnabled(false);
                    findViewById(R.id.lotss).setBackgroundResource(R.drawable.btnshadow);
                    findViewById(R.id.lotss).setEnabled(true);
                }

                break;
            case R.id.lotss:
                if (clicked)
                    linearLayoutconstrans.setVisibility(View.GONE);
                linearLayoutlotss.setVisibility(View.VISIBLE);
                findViewById(R.id.lotss).setBackgroundResource(R.drawable.btnshadowclicked);
                findViewById(R.id.lotss).setEnabled(false);
                findViewById(R.id.constrans).setBackgroundResource(R.drawable.btnshadow);
                findViewById(R.id.constrans).setEnabled(true);
                break;
        }
    }

//    public void stitleclick(View view) {
//
//
//        clicked = ((TextView) view).isClickable();
//
//        switch (view.getId()) {
//
//            case R.id.stitle1:
//                if (clicked){
//                    plant.setVisibility(View.VISIBLE);
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
//                    part_Plantproduct.setVisibility(View.GONE);
//                    unLiving_Objects.setVisibility(View.GONE);
//                    Living_Objects.setVisibility(View.GONE);
//                    findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadowclicked);
//                    findViewById(R.id.stitle1).setEnabled(false);
//                    findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
//                    findViewById(R.id.stitle2).setEnabled(true);
//                    findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadow);
//                    findViewById(R.id.stitle3).setEnabled(true);
//                    findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadow);
//                    findViewById(R.id.stitle4).setEnabled(true);
//                }
//
//                break;
//            case R.id.stitle2:
//                if (clicked)
//                    plant.setVisibility(View.GONE);
//                part_Plantproduct.setVisibility(View.VISIBLE);
//                unLiving_Objects.setVisibility(View.GONE);
//                Living_Objects.setVisibility(View.GONE);
//                findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadowclicked);
//                findViewById(R.id.stitle2).setEnabled(false);
//                findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle1).setEnabled(true);
//                findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle3).setEnabled(true);
//                findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle4).setEnabled(true);
//
//                break;
//            case R.id.stitle3:
//                if (clicked)
//
//                    plant.setVisibility(View.GONE);
//                part_Plantproduct.setVisibility(View.GONE);
//                unLiving_Objects.setVisibility(View.VISIBLE);
//                Living_Objects.setVisibility(View.GONE);
//                findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadowclicked);
//                findViewById(R.id.stitle3).setEnabled(false);
//                findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle2).setEnabled(true);
//                findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle1).setEnabled(true);
//                findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle4).setEnabled(true);
//
//                break;
//            case R.id.stitle4:
//                if (clicked)
//
//                    plant.setVisibility(View.GONE);
//                part_Plantproduct.setVisibility(View.GONE);
//                unLiving_Objects.setVisibility(View.GONE);
//                Living_Objects.setVisibility(View.VISIBLE);
//                findViewById(R.id.stitle4).setBackgroundResource(R.drawable.btnshadowclicked);
//                findViewById(R.id.stitle4).setEnabled(false);
//                findViewById(R.id.stitle2).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle2).setEnabled(true);
//                findViewById(R.id.stitle3).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle3).setEnabled(true);
//                findViewById(R.id.stitle1).setBackgroundResource(R.drawable.btnshadow);
//                findViewById(R.id.stitle1).setEnabled(true);
//
//                break;
//        }
//    }

}
