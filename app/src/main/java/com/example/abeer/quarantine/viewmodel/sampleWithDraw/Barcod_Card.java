package com.example.abeer.quarantine.viewmodel.sampleWithDraw;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.Serializable;

public class Barcod_Card  extends BaseObservable implements Serializable {

    String Request_Num;
    String Lot_num;
    String Barcod;
    String Barcodetext;


    public Barcod_Card() {
    }

    public Barcod_Card(Barcod_Card barcod_card) {
        Request_Num = barcod_card.Request_Num;
        Lot_num = barcod_card.Lot_num;
        Barcod = barcod_card.Barcod;
        Barcodetext=barcod_card.Barcod;
    }

    public Barcod_Card(String request_Num, String lot_num, String barcod) {
        Request_Num = request_Num;
        Lot_num = lot_num;
        Barcod = barcod;
        Barcodetext=barcod;
    }

    @Bindable
    public String getRequest_Num() {
        return Request_Num;
    }

    public void setRequest_Num(String request_Num) {
        Request_Num = request_Num;
    }

    @Bindable
    public String getLot_num() {
        return Lot_num;
    }
//
//    @Bindable
//    public String getbarcodes() {
//        return Barcod;
//    }
    @Bindable
    public String getBarcodetext() {
        return Barcodetext;
    }

    public void setBarcodetext(String barcodetext) {
        Barcodetext = barcodetext;
    }

    public void setLot_num(String lot_num) {
        Lot_num = lot_num;
    }

@Bindable
    public Bitmap getBarcod() {
        Bitmap bitmap = null;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(Barcod, BarcodeFormat.CODABAR, 360, 125);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(bitMatrix);

        } catch (WriterException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void setBarcod(String barcod) {
        Barcod = barcod;
    }
//    public Bitmap genaratbarcod(String barcod)
//    {
//
//
//    }
}