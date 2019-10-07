package com.example.abeer.quarantine.activity.dashactivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.remote.ApiCall;


public class ExaminationCommittee extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

   setContentView(R.layout.activity_examination_committee);
   final      TextView textView=findViewById(R.id.textView);

        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Initialize a new StringRequest
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                ApiCall.UrlLabName,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with response string
                        textView.setText(response);
                        requestQueue.stop();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ExaminationCommittee.this, "reeeeeee", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        // Add StringRequest to the RequestQueue
        requestQueue.add(stringRequest);
    }
}


