package com.example.abeer.quarantine.remote.data;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.abeer.quarantine.remote.ApiCall;
import com.example.abeer.quarantine.remote.SingleTonVolly;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abeer on 27/03/2019.
 */

public class DataManger {

    //Write Functions of Volly Requestes

    public Context context;

    public DataManger(Context context) {
        this.context = context;
    }
//Methed Put
public void SendVolleyRequestJsonObjectPut(Context context, int method, String url,JSONObject JSONObject, final IDataValue IDataValue)
{
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, JSONObject, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                IDataValue.Success(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            IDataValue.Error(error);
        }
    }){
        @Override
        public Map<String, String> getHeaders() throws AuthFailureError {
            final Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
            return headers;
        }

        @Override
        public String getBodyContentType() {
            return "application/json";
        }
    };
    SingleTonVolly.getInstance(context).addtorequestQueue(jsonObjectRequest);
}

//Method Get
public void SendVollyRequestJsonObjectGet(Context context, int method, String url,final IDataValue IDataValue)
{
    JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(method, url , new JSONObject(), new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                IDataValue.Success(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            IDataValue.Error(error);
        }
    }

    );

    SingleTonVolly.getInstance(context).addtorequestQueue(jsonObjectRequest);
}

    public void SendVollyRequestJsonArrayGet(Context context, int method, String url,final IDataValue IDataValue)
    {
        JsonArrayRequest jsonObjectRequest= new JsonArrayRequest(method, url , new JSONArray(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    IDataValue.Success(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                IDataValue.Error(error);
            }
        }

        );

        SingleTonVolly.getInstance(context).addtorequestQueue(jsonObjectRequest);
    }
//Method post
    public void SendVolleyRequestJsonObjectpost(Context context, int method, String url,JSONObject JSONObject, final IDataValue IDataValue)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(method, url, JSONObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    IDataValue.Success(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                IDataValue.Error(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };


        SingleTonVolly.getInstance(context).addtorequestQueue(jsonObjectRequest);
    }


    public void SendVolleyRequestJsonArraypost(Context context, int method, String url ,JSONArray JsonArray, final IDataValue IDataValue)
    {
        JsonArrayRequest JsonArrayRequest = new JsonArrayRequest( method , url ,JsonArray , new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    IDataValue.Success(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                IDataValue.Error(error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };

        SingleTonVolly.getInstance(context).addtorequestQueue(JsonArrayRequest);
    }

//    public  <T>void GetSendVollyRequestLISTMKingdom(Context context, JSONObjectLoader<T> d, int method, String url, final  IDataValue IDataValue){
////        JSONObjectLoader<JsonObjectRequest,JSONObject> h = new JSONObjectLoader<JsonObjectRequest,JSONObject>(Request.Method.GET, ApiCall.UrlPlantKingdom, new JSONObject(), new Response.Listener<JSONObject>() {
//        d = new JSONObjectLoader<T>(method,url, new JSONObject(), new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//              IDataValue.Success(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                IDataValue.Error(error);
//            }
//        }
//        );
//        SingleTonVolly.getInstance(context).addtorequestQueue(d);
//    }

}
