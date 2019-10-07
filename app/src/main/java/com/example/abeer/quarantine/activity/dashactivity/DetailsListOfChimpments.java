package com.example.abeer.quarantine.activity.dashactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.activity.dashactivity.Ex_RequestCommitteeResult;
import com.example.abeer.quarantine.activity.dashactivity.SampleWithDraw;
import com.example.abeer.quarantine.activity.dashactivity.TreatmentStatement;

public class DetailsListOfChimpments extends AppCompatActivity {
boolean clicked;
WebView webView;
    String ipadrass;
    String num_Request;

LinearLayout data_manafz,Exporting_Organization,Exporting_Company,Exporting_Pass,
    ChimpmentDetails,Examination_Place,attachments ,plant,part_Plantproduct,unLiving_Objects,Living_Objects,linear_title5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_list_of_chimpments);
        webView=findViewById(R.id.pdf);
        webView.getSettings().setJavaScriptEnabled(true);
        data_manafz=findViewById(R.id.data_manafz);
        Exporting_Organization=findViewById(R.id.Exporting_Organization);
        Exporting_Company=findViewById(R.id.Exporting_Company);
        Exporting_Pass=findViewById(R.id.Exporting_Pass);
        ChimpmentDetails=findViewById(R.id.ChimpmentDetails);
        linear_title5=findViewById(R.id.linear_title5);
        Examination_Place=findViewById(R.id.Examination_Place);
        plant=findViewById(R.id.plant);
        part_Plantproduct=findViewById(R.id.part_Plantproduct);
        unLiving_Objects=findViewById(R.id.unLiving_Objects);
        Living_Objects=findViewById(R.id.Living_Objects);
        attachments=findViewById(R.id.attachments);

      //   num_Request = getIntent().getStringExtra("num_Request");
      TextView  title_list=findViewById(R.id.title_list);
   //   title_list.setText(ss);
        ipadrass= getIntent().getStringExtra("ipadrass");


    }

    public void titleclick(View view) {
        clicked =((TextView)view).isClickable();

        switch (view.getId()){

            case R.id.title1:
                if(clicked)
                     data_manafz.setVisibility(View.VISIBLE);
                      Exporting_Organization.setVisibility(View.GONE);
                      Exporting_Company.setVisibility(View.GONE);
                      Exporting_Pass.setVisibility(View.GONE);
                      linear_title5.setVisibility(View.GONE);
                     Examination_Place.setVisibility(View.GONE);
                     attachments.setVisibility(View.GONE);

                break;
            case R.id.title2:
                if(clicked)
                    data_manafz.setVisibility(View.GONE);
                    Exporting_Organization.setVisibility(View.VISIBLE);
                    Exporting_Company.setVisibility(View.GONE);
                    Exporting_Pass.setVisibility(View.GONE);
                linear_title5.setVisibility(View.GONE);
                   Examination_Place.setVisibility(View.GONE);
                   attachments.setVisibility(View.GONE);
                    break;
                    case R.id.title3:
                if(clicked)
                        data_manafz.setVisibility(View.GONE);
                        Exporting_Organization.setVisibility(View.GONE);
                        Exporting_Company.setVisibility(View.VISIBLE);
                        Exporting_Pass.setVisibility(View.GONE);
                        linear_title5.setVisibility(View.GONE);
                        Examination_Place.setVisibility(View.GONE);
                        attachments.setVisibility(View.GONE);
                    break;
                    case R.id.title4:
                        if(clicked)
                        data_manafz.setVisibility(View.GONE);
                        Exporting_Organization.setVisibility(View.GONE);
                        Exporting_Company.setVisibility(View.GONE);
                        Exporting_Pass.setVisibility(View.VISIBLE);
                        linear_title5.setVisibility(View.GONE);
                        Examination_Place.setVisibility(View.GONE);
                        attachments.setVisibility(View.GONE);

                 break;
            case R.id.title5:
                if(clicked)
                    data_manafz.setVisibility(View.GONE);
                Exporting_Organization.setVisibility(View.GONE);
                Exporting_Company.setVisibility(View.GONE);
                Exporting_Pass.setVisibility(View.GONE);
                linear_title5.setVisibility(View.VISIBLE);
                Examination_Place.setVisibility(View.GONE);
                attachments.setVisibility(View.GONE);

                break;
            case R.id.title6:
                if(clicked)
                    data_manafz.setVisibility(View.GONE);
                Exporting_Organization.setVisibility(View.GONE);
                Exporting_Company.setVisibility(View.GONE);
                Exporting_Pass.setVisibility(View.GONE);
                linear_title5.setVisibility(View.GONE);
                Examination_Place.setVisibility(View.VISIBLE);
                attachments.setVisibility(View.GONE);

                break;
            case R.id.title7:
                if(clicked)
                    data_manafz.setVisibility(View.GONE);
                Exporting_Organization.setVisibility(View.GONE);
                Exporting_Company.setVisibility(View.GONE);
                Exporting_Pass.setVisibility(View.GONE);
                linear_title5.setVisibility(View.GONE);
                Examination_Place.setVisibility(View.GONE);
                attachments.setVisibility(View.VISIBLE);

                break;
            default:
                data_manafz.setVisibility(View.GONE);
                Exporting_Organization.setVisibility(View.GONE);
                Exporting_Company.setVisibility(View.GONE);
                Exporting_Pass.setVisibility(View.GONE);
                linear_title5.setVisibility(View.GONE);
                Examination_Place.setVisibility(View.GONE);
                attachments.setVisibility(View.GONE);
                break;

        }
    }

    public void showPDF(View view) {
        String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf"; // pdf link
        webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);
    }

    public void Committee(View view) {
        Intent i= new Intent(this, Ex_RequestCommitteeResult.class);
        i.putExtra("num_Request",String.valueOf(getIntent().getStringExtra("num_Request")));
        i.putExtra("ipadrass",ipadrass);
        startActivity(i);
    }

    public void Sample(View view) {
        Intent i= new Intent(this, SampleWithDraw.class);
        i.putExtra("num_Request",String.valueOf(getIntent().getStringExtra("num_Request")));
        i.putExtra("ipadrass",ipadrass);
        startActivity(i);
    }

    public void Treatment(View view) {
        Intent i= new Intent(this, TreatmentStatement.class);
        i.putExtra("ipadrass",ipadrass);
        i.putExtra("num_Request",String.valueOf(getIntent().getStringExtra("num_Request")));
        startActivity(i);
    }

    public void stitleclick(View view) {

        clicked = ((TextView) view).isClickable();

        switch (view.getId()) {

            case R.id.stitle1:
                if (clicked)

                plant.setVisibility(View.VISIBLE);
                part_Plantproduct.setVisibility(View.GONE);
                unLiving_Objects.setVisibility(View.GONE);
                Living_Objects.setVisibility(View.GONE);

                break;
            case R.id.stitle2:
                if (clicked)

                plant.setVisibility(View.GONE);
                part_Plantproduct.setVisibility(View.VISIBLE);
                unLiving_Objects.setVisibility(View.GONE);
                Living_Objects.setVisibility(View.GONE);

                break;
            case R.id.stitle3:
                if (clicked)

                    plant.setVisibility(View.GONE);
                part_Plantproduct.setVisibility(View.GONE);
                unLiving_Objects.setVisibility(View.VISIBLE);
                Living_Objects.setVisibility(View.GONE);

                break;
            case R.id.stitle4:
                if (clicked)

                 plant.setVisibility(View.GONE);
                part_Plantproduct.setVisibility(View.GONE);
                unLiving_Objects.setVisibility(View.GONE);
                Living_Objects.setVisibility(View.VISIBLE);

                break;
        }
    }


}
