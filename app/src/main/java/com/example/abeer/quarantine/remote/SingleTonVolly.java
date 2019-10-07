package com.example.abeer.quarantine.remote;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by abeer on 27/03/2019.
 */

public class SingleTonVolly {

    private static Context context;

    private static  SingleTonVolly Instance ;
    private RequestQueue requestQueue;


    public static SingleTonVolly getInstance() {
        return Instance;
    }


    private SingleTonVolly() {


        requestQueue=getrequestQueue();

    }


    public SingleTonVolly(Context context)  {
        this.context=context;
        Instance = new SingleTonVolly();

    }


    public static synchronized SingleTonVolly getInstance(Context context) {
        if(Instance==null){
            Instance=new SingleTonVolly(context);
        }
        return Instance;
    }


    public <T> void addtorequestQueue (Request<T> request){
        getrequestQueue().add(request);
    }

    private RequestQueue getrequestQueue() {
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }


}
