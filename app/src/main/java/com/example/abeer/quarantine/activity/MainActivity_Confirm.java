package com.example.abeer.quarantine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.databinding.ActivityMainConfirmBinding;

import com.example.abeer.quarantine.functions.Public_function;

import org.json.JSONException;

public class MainActivity_Confirm extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Context context=this;
    SharedPreferences sharedPreferences;
    Public_function public_function;
    String ipadrass;
    String num_Request;
    String Request_id;
    DrawerLayout drawer;
    ActivityMainConfirmBinding activityMainConfirmBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.content_main_activity__confirm);
       //activityMainConfirmBinding = DataBindingUtil.setContentView((Activity) this, R.layout.activity_main__confirm);
        try {
            activityMainConfirmBinding = DataBindingUtil.setContentView((Activity) context, R.layout.activity_main__confirm);
        } catch (Exception ex) {
            int s = 10;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        drawer = (DrawerLayout) findViewById(R.id.drawer_layoutt);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        sharedPreferences = getApplicationContext().getSharedPreferences("SharedPreference",0);
        num_Request = sharedPreferences.getString("num_Request","");
        Request_id = sharedPreferences.getString("checkRequest_Id","");
        ipadrass= sharedPreferences.getString("ipadrass","");
        public_function=new Public_function();

    }

    @Override
    public void onBackPressed() {
       drawer = (DrawerLayout) findViewById(R.id.drawer_layoutt);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity__confirm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        try {
            public_function.NavMenuClick(id,context,sharedPreferences.getString("Token","")
                    ,sharedPreferences.getBoolean("ISAdmin",false)
                    ,sharedPreferences.getInt("RequestCommittee_Status_Id",0),
                    sharedPreferences.getInt("treatment_data",-1),
                    sharedPreferences.getInt("sample_data",-1),
                    sharedPreferences.getInt("request_data",-1),
                    sharedPreferences.getInt("Committee_Type_Id",0),ipadrass);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        if (id == R.id.language) {
//            // Handle the camera action
//        } else if (id == R.id.sample_title) {
//            Intent i=new Intent(context,MainActivity_SampleWithDraw.class);
//            i.putExtra("ipadrass", ipadrass);
//         //   i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        } else if (id == R.id.treatment_title) {
//         //   Intent i=new Intent(context,TreatmentStatement.class);
//            Intent i=new Intent(context,MainActivity_TreatmentStatement.class);
//            i.putExtra("ipadrass", ipadrass);
//          //  i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//
//        } else if (id == R.id.Committee_title) {
//            Intent i=new Intent(context,MainActivity_Ex_RequestCommitteeResult.class);
//            i.putExtra("ipadrass", ipadrass);
//          //  i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        }else if (id == R.id.todolist) {
//            Intent i=new Intent(context,MainActivity_Listofchipment.class);
//            i.putExtra("ipadrass", ipadrass);
//           // i.putExtra("num_Request", String.valueOf(num_Request));
//            startActivity(i);
//        }
//        else if (id == R.id.logout) {
//            Intent i=new Intent(context,LogIn.class);
//            startActivity(i);
//
//        } else if (id == R.id.nav_send) {
//
//        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void shownav(View view) {
        drawer.openDrawer(GravityCompat.START);
    }
}
