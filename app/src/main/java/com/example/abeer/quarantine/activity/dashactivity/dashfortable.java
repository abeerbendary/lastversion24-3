package com.example.abeer.quarantine.activity.dashactivity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.activity.CheckUp_Lots;
import com.example.abeer.quarantine.adapter.MyAdapterforRecycler;
import com.example.abeer.quarantine.databinding.ActivityDashfortableBinding;
import com.example.abeer.quarantine.presenter.Clickcustum;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.data.DataManger;
import com.example.abeer.quarantine.remote.data.IDataValue;
import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class dashfortable extends AppCompatActivity {
    DataManger DataManger=new DataManger(this);
MyAdapterforRecycler adapter;
RecyclerView recyclerView;
   // ActivityExRequestCommitteeResultBinding
   ActivityDashfortableBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_dashfortable);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashfortable);
     //   populateData();
        final Context context=this;
        final List<SampleData_LOts>[] SampleData_LOts = new List[1];
       // recyclerView=findViewById(R.id.resycler);
        DataManger.SendVollyRequestJsonArrayGet(this, Request.Method.GET, ApiCall.UrlEx_SampleData, new IDataValue() {
            @Override
            public void Error(VolleyError error) {

            }
            @Override
            public void Success(Object response) {
              String  data = response.toString();
               Gson  gson = new Gson();
                SampleData_LOts[0] = Arrays.asList(gson.fromJson(data, SampleData_LOts[].class));
            //    adapter = new MyAdapterforRecycler(SampleData_LOts[0], (Activity) context);
            //    recyclerView.setAdapter(adapter);
             //   RecyclerView.LayoutManager manager = new LinearLayoutManager(context);
              //  recyclerView.setLayoutManager(manager);

//                MyAdapterforRecycler myRecyclerViewAdapter = new MyAdapterforRecycler(SampleData_LOts[0], context);
//            binding.setMyAdapter(myRecyclerViewAdapter);
                MyAdapterforRecycler dd=new MyAdapterforRecycler(SampleData_LOts[0], context, new Clickcustum() {
                    @Override
                    public void button_click(View view,SampleData_LOts sampleData_lOts) {
                        Intent i = new Intent(context, CheckUp_Lots.class);
                        i.putExtra("ID", "" + sampleData_lOts.getLot_Id());
                        i.putExtra("LOTS_NUM", "" + sampleData_lOts.getLot_Number());
                        startActivity(i);
                    }

//                    @Override
//                    public void Generat_barcod_click(View view, com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.SampleData_LOts sampleData_lOts) {
//
//                    }
                });
                        binding.setMyAdapter(dd);
                binding.resycler.setLayoutManager(new LinearLayoutManager(context));


            }
        });

   }
}





//        int i = LISTMKingdom[0].getLIST_M_Kingdoms().size();
//        for (int j = 0; j < i; j++) {
//            TableRow tbrow = new TableRow(Ex_RequestCommitteeResult.this);
//            tbrow.setTag(j);
//            TextView t1v = new TextView(Ex_RequestCommitteeResult.this);
//            t1v.setText("" + LISTMKingdom[0].getLIST_M_Kingdoms().get(j));
//            t1v.setTextColor(Color.RED);
//            t1v.setPadding(5, 15, 5, 12);
//            t1v.setBackgroundResource(R.drawable.rectborder);
//            tbrow.addView(t1v);
//
//
//            TextView t2v = new TextView(Ex_RequestCommitteeResult.this);
//            t2v.setText(LISTMKingdom[0].getLIST_M_Kingdoms().get(j));
//            t2v.setTextColor(Color.RED);
//            t2v.setGravity(Gravity.CENTER);
//            t2v.setPadding(5, 17, 5, 12);
//            t2v.setBackgroundResource(R.drawable.rectborder);
//            tbrow.addView(t2v);
//
//            TextView t3v = new TextView(Ex_RequestCommitteeResult.this);
//            t3v.setText(LISTMKingdom[0].getLIST_M_Kingdoms().get(j));
//            t3v.setTextColor(Color.RED);
//            t3v.setGravity(Gravity.CENTER);
//            t3v.setPadding(5, 17, 5, 12);
//            t3v.setBackgroundResource(R.drawable.rectborder);
//            tbrow.addView(t3v);
//
//            Button t4v = new Button(Ex_RequestCommitteeResult.this);
//            t4v.setText("click");
//            // t4v.setMinHeight(5);


