package com.example.abeer.quarantine.remote.data;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by abeer on 27/03/2019.
 */

public interface  IDataValue <T> {
    //Write Declaration of Logic function

//    public void Sucee(JSONObject response);
//    public  void Errer(VolleyError error);

        public <T> void Success(T response) throws JSONException;
        public  void Error(VolleyError error);
}
