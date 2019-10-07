package com.example.abeer.quarantine.activity.dashactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.activity.LogIn;
import com.example.abeer.quarantine.adapter.AdapterCheckRequest;
import com.example.abeer.quarantine.databinding.ActivityListOfChipmentsBinding;
import com.example.abeer.quarantine.presenter.ClickCustomCheckRequest;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ExportCheckRequest;
import com.google.gson.Gson;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class ListOfChipments extends AppCompatActivity {
    DataManger dataManger;
    ActivityListOfChipmentsBinding activityListOfChipmentsBinding;
    Gson gson;
    Context context=this;
    String ipadrass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final List<ExportCheckRequest>[]exportCheckRequestList=new List[1];
        activityListOfChipmentsBinding=  DataBindingUtil.setContentView((Activity) context, R.layout.activity_list_of_chipments);
        dataManger=new DataManger(this);

        ipadrass= getIntent().getStringExtra("ipadrass");
////running but not data added//////////
            SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date(System.currentTimeMillis());
String sssss="http://"+ipadrass+ApiCall.UrlListOfChipment+String.valueOf(formatter.format(date));
        dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, sssss, new IDataValue() {
       /////////////////////////

        //dataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, "http://"+ipadrass+ApiCall.UrlListOfChipment, new IDataValue() {
             @Override
            public void Success(Object response) throws JSONException {
                String Result= response.toString();
                gson=new Gson();
                exportCheckRequestList[0]= Arrays.asList( gson.fromJson(Result, ExportCheckRequest[].class));
                try {
                    AdapterCheckRequest adapterCheckRequest = new AdapterCheckRequest(exportCheckRequestList[0], context, new ClickCustomCheckRequest() {
                        @Override
                        public void CheckRequest_click(View view, ExportCheckRequest exportCheckRequest) {
                            Toast.makeText(context, "gnghh", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(context, DetailsListOfChimpments.class);
                            i.putExtra("ipadrass",ipadrass);
                            i.putExtra("num_Request",String.valueOf(exportCheckRequest.getCheckRequest_Number()));
                            startActivity(i);
                        }
                    });
                    activityListOfChipmentsBinding.setAdapter(adapterCheckRequest);
                    activityListOfChipmentsBinding.recycler.setLayoutManager(new LinearLayoutManager(context));
                }
                catch (Exception ex){
                    Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void Error(VolleyError error) {

            }
        });
        // setContentView(R.layout.activity_list_of_chipments);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //  getLayoutInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.language:
                Toast.makeText(this, "Language", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Log_out:
                Intent i=new Intent(this, LogIn.class);
                startActivity(i);

        }
        return super.onOptionsItemSelected(item);

    }
}