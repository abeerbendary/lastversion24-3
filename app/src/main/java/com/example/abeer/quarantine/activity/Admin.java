package com.example.abeer.quarantine.activity;
//fz 7-10-2019
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.MyAdapter_Admin;
import com.example.abeer.quarantine.model.User_class;
import com.example.abeer.quarantine.model.location;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
//abeer 7-10-2019
//Aly 7-10-201
public class Admin extends AppCompatActivity implements MyAdapter_Admin.customListener{
    RecyclerView recyclerView;
    String url_get_users;
    List<User_class> Users_data = new ArrayList<>();
    MyAdapter_Admin adapter;
    List<location> data_person;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Backendless.initApp(this, "591A2A43-2A1C-7432-FF91-AF34A2722600", "981FC391-F4C6-C6F6-FFF8-BF6DF49A2700");
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        recyclerView = (RecyclerView) findViewById(R.id.recycleradmin);
    }

    @Override
    protected void onStart() {
        try {
            if (adapter == null) {
               url_get_users = "http://10.5.1.8:8013/api/home/get_users";
                 // url_get_users = "http://192.168.8.101:4040/api/home/get_users";
                RequestQueue rq = Volley.newRequestQueue(this.getApplicationContext());
                JsonObjectRequest postrequest = new JsonObjectRequest(Request.Method.GET, url_get_users, null
                        , new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            display_data(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", String.valueOf(error));
                    }

                });
                rq.add(postrequest);

            }
        } catch(Exception ex){

            Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
        }
        super.onStart();
    }
    public void display_data(JSONObject s) throws JSONException {
        JSONArray data = s.getJSONArray("name_data");
        for (int i = 0; i < data.length(); i++) {
            try {
                JSONObject jsonObject = data.getJSONObject(i);
                Users_data.add(new User_class(Integer.parseInt(jsonObject.get("ID").toString()), jsonObject.get("Name").toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        adapter = new MyAdapter_Admin(Users_data, this);
        adapter.setCustomListner(Admin.this);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }
    @Override
    public void on_name_ClickListner(int id) {
        Toast.makeText(this, "goooooood", Toast.LENGTH_SHORT).show();
        String whereClause ="User_ID =" + id;
        data_person = new ArrayList<>();
        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setWhereClause(whereClause);
        try {
            Backendless.Data.of("location_details").find(queryBuilder,
                    new AsyncCallback<List<Map>>() {
                        @Override
                        public void handleResponse(List<Map> foundContacts) {
                            retrieve_data(foundContacts);
                        }
                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Log.d("hi",fault.getMessage());
                        }
                    });
        }catch (Exception ex)
        {
            TextView textView=findViewById(R.id.textView4);
            textView.setText(ex.toString());
            Toast.makeText(this, ""+ex , Toast.LENGTH_SHORT).show();
        }
    }
    public void retrieve_data(List<Map> foundContacts) {
        try {


            Toast.makeText(this, "load map", Toast.LENGTH_SHORT).show();
            for(int i=0;i<foundContacts.size();i++) {

                String Name_location=(String)foundContacts.get(i).get("name_location");
                Date time = (Date) foundContacts.get(i).get("Time");
                double latitude = Double.parseDouble( foundContacts.get(i).get("latitude").toString());
                double longitude =  Double.parseDouble(foundContacts.get(i).get("longitude").toString());
                data_person.add(new location(Name_location,time, latitude, longitude));

            }

            Intent i=new Intent(this,mapforadmin.class);
            Bundle args = new Bundle();

            args.putSerializable("ARRAYLIST",(Serializable)data_person);
            i.putExtra("BUNDLE",args);
            startActivity(i);
        }
        catch (Exception ex)
        {
            TextView textView=findViewById(R.id.textView4);
            textView.setText(ex.toString());
            Toast.makeText(this,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

//    public void generate_barcode(View view) {
//        Intent i = new Intent(this,generate_barcode.class);
//        startActivity(i);
//    }
}