package com.example.abeer.quarantine.activity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.model.InfoWindowData;
import com.example.abeer.quarantine.model.location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class mapforadmin extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    ArrayList<Date> times;
    HashMap<String, ArrayList<Date>> location_dates;
    ArrayList<LatLng> latLngs_location_set;
    HashSet<location> location_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapforadmin);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
          try {
            mMap = googleMap;
            times = new ArrayList<>();
            latLngs_location_set = new ArrayList<>();
            int width = 350;
            int height = 500;
            int padding = (int) (width * 0.19);
            LatLngBounds egypt = new LatLngBounds(new LatLng(24.09082, 25.51965), new LatLng(31.5084, 34.89005));
            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(egypt, width, height, padding));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(20.0f));
            Intent intent = getIntent();
            Bundle args = intent.getBundleExtra("BUNDLE");
            ArrayList<location> data_users = (ArrayList<location>) args.getSerializable("ARRAYLIST");
            location_set = new HashSet<location>();
            for (location l : data_users) {
                location dd = new location(l.getName_location(), l.getTime(), l.getLatitude(), l.longitude);
                if (location_set.contains(dd) == false) {
                    location_set.add(dd);
                }
            }
            Marker marker = null;
            location_dates = new HashMap<String, ArrayList<Date>>();

            for (location loc_set : location_set) {
                times = new ArrayList<Date>();
                for (location loc_data : data_users) {
                    if (loc_data.equals((loc_set)))
                        times.add(loc_data.getTime());
                }
                location_dates.put(loc_set.getName_location(), times);
                marker = mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(loc_set.latitude, loc_set.longitude)));
                InfoWindowData info = new InfoWindowData();
                info.setLocation(loc_set.getName_location());
                info.setTimes(location_dates.get(loc_set.getName_location()));
                InfoWindowOfMap customInfoWindow = new InfoWindowOfMap(this);
                mMap.setInfoWindowAdapter(customInfoWindow);
                marker.setTag(info);
            }
            mMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
