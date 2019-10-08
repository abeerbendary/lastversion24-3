package com.example.abeer.quarantine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.abeer.quarantine.R;
import com.example.abeer.quarantine.adapter.AdapterBarcod;
import com.example.abeer.quarantine.databinding.ActivityGenerateBarcodeBinding;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.Barcod_Card;
import com.example.abeer.quarantine.viewmodel.sampleWithDraw.ListLabName;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Generate_barcode extends AppCompatActivity {

//    ImageView imageView;
//   // TextView barcodenum;
//    Bitmap bitmap;
//    String barcode;
    List<Barcod_Card>barcod_cards=new ArrayList<>();
    ActivityGenerateBarcodeBinding activityGenerateBarcodeBinding;
    Context context=this;
    String contextsample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.acti
        // vity_generate_barcode);
        activityGenerateBarcodeBinding = DataBindingUtil.setContentView((Activity) context, R.layout.activity_generate_barcode);
        Intent i=getIntent();
//       String barcodestring = i.getStringExtra("barcode");
        barcod_cards = (List<Barcod_Card>) i.getSerializableExtra("barcode");
        contextsample=i.getStringExtra("contextsample");
//      Gson  gson = new Gson();
//       barcod_cards.addAll(Arrays.asList(gson.fromJson(barcodestring, Barcod_Card.class)));
       activityGenerateBarcodeBinding.setAdapterBarcod(new AdapterBarcod(barcod_cards,context));
       activityGenerateBarcodeBinding.recyclerbarcod.setLayoutManager(new LinearLayoutManager(context));


//        barcode = i.getStringExtra("barcode");
//        imageView =findViewById(R.id.image_barcode);
       // barcodenum=findViewById(R.id.var);
    }

    @Override
    protected void onStart() {
        super.onStart();
//      //  String Textsss="123456877";// Whatever you need to encode in the QR code
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//        try {
//            BitMatrix bitMatrix = multiFormatWriter.encode(barcode, BarcodeFormat.CODABAR,360,125);
//            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//            bitmap = barcodeEncoder.createBitmap(bitMatrix);
//            imageView.setImageBitmap(bitmap);
//           // barcodenum.setText(barcode);
//
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
    }

    public void printer_barcode(View view) {
        Toast.makeText(this, "لا توجد طابعة متصلة", Toast.LENGTH_LONG).show();
    }

    public void cancel(View view) {
//      Intent i=new Intent(context,MainActivity_Listofchipment.class);
//      startActivity(i);

      if(contextsample.equals("true"))
        {
          Intent i=new Intent(context,MainActivity_Listofchipment.class);
          startActivity(i);
      }
        finish();
    }
}
