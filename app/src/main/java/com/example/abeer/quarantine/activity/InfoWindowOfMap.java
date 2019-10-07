package com.example.abeer.quarantine.activity;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.model.InfoWindowData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.Date;

public class InfoWindowOfMap implements GoogleMap.InfoWindowAdapter {
        Context context ;
        public InfoWindowOfMap(Context context) {
            this.context = context;
        }
        @Override
        public View getInfoWindow(Marker marker) {
            return null;
        }
        @Override
        public View getInfoContents(Marker marker) {
            View view = ((Activity)context).getLayoutInflater()
                    .inflate(R.layout.activity_info_window_of_map, null);
            TextView position = view.findViewById(R.id.location);
            ListView times_list=view.findViewById(R.id.times_list);
            InfoWindowData infoWindowData = (InfoWindowData) marker.getTag();
            position.setText(infoWindowData.getLocation());
            ArrayAdapter<Date> adapter = new ArrayAdapter<Date> ((Activity)context,android . R . layout . simple_list_item_1,infoWindowData.getTimes() )  ;
            times_list.setAdapter(adapter);
            return  view;
        }
    }

