package com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;


import com.example.abeer.quarantine.BR;

import java.util.Date;

public class Checkup_Result extends BaseObservable{

     String Checkup;
     int Count;
     int Weight;
     int Result_ID;
      String  Comment ;
      int Kingdom_ID;
       int Phylum_ID;
      int Order_ID;
     int Family_ID;
     int Result_injury;
     Long lot_ID;
    String Address;
    double Latitude,Longitude;
    long Committee_ID;
    long EmployeeId;
    Context context;
   // int Final_result;

    public  Checkup_Result()
    {
    }

//    public Checkup_Result(String checkup, int count, int weight,
//                          int result_ID, String comment, int kingdom_ID, int phylum_ID, int order_ID,int lot_num,
//                          int family_ID) {
//        Checkup = checkup;
//        Count = count;
//        Weight = weight;
//        Result_ID = result_ID;
//        Comment = comment;
//        Kingdom_ID = kingdom_ID;
//        Phylum_ID = phylum_ID;
//        Order_ID = order_ID;
//        Order_ID = lot_num;
//        Family_ID = family_ID;
//        notifyPropertyChanged(BR.checkUpResult);
//
//
//    }

    public Checkup_Result(Checkup_Result Checkup_Result) {

        Checkup = Checkup_Result.Checkup;
        Count = Checkup_Result.Count;
        Weight = Checkup_Result.Weight;
        Result_ID = Checkup_Result.Result_ID;
        Comment = Checkup_Result.Comment;
        Kingdom_ID = Checkup_Result.Kingdom_ID;
        Phylum_ID = Checkup_Result.Phylum_ID;
        Order_ID = Checkup_Result.Order_ID;
        Family_ID = Checkup_Result.Family_ID;
        Result_injury=Checkup_Result.Result_injury;
        lot_ID=Checkup_Result.lot_ID;
        Latitude=Checkup_Result.Latitude;
        Longitude=Checkup_Result.Longitude;
        Address=Checkup_Result.Address;
        Committee_ID=Checkup_Result.Committee_ID;
        EmployeeId=Checkup_Result.EmployeeId;
        notifyPropertyChanged(BR.checkUpResult);

    }

    @Bindable
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
        notifyPropertyChanged(BR.latitude);
    }


    @Bindable
    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
        notifyPropertyChanged(BR.longitude);
    }

    @Bindable
    public String getCheckup() {
        return Checkup;
    }


    public void setCheckup(String checkup) {
        Checkup = checkup;
        notifyPropertyChanged(BR.checkup);

    }

    public long getCommittee_ID() {
        return Committee_ID;
    }

    public void setCommittee_ID(long committee_ID) {
        Committee_ID = committee_ID;
    }

    public long getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }

    @Bindable
    public int getResult_injury() {
        return Result_injury;
    }

    public void setResult_injury(int result_injury) {
        Result_injury = result_injury;
        notifyPropertyChanged(BR.result_injury);
    }

    @Bindable
    public int getCount() {
        return Count;
    }

    @Bindable
    public long getlot_ID() {
        return lot_ID;
    }

    public void setlot_ID(long lotID) {
        lot_ID = lotID;
        notifyPropertyChanged(BR.lot_ID);
    }

    public void setCount(int count) {
        Count =count;
        notifyPropertyChanged(BR.count);
    }

    @Bindable
    public int getWeight() {
        return Weight;
    }


    public void setWeight(int weight) {
       Weight =weight;
      notifyPropertyChanged(BR.weight);

    }

    @Bindable
    public int getResult_ID() {
        return Result_ID;
    }


    public void setResult_ID(int result_ID) {
        Result_ID = result_ID;
      notifyPropertyChanged(BR.result_ID);

    }

    @Bindable
    public String getComment() {
        return Comment;
    }


    public void setComment(String comment) {
        Comment = comment;
        notifyPropertyChanged(BR.comment);

    }

    @Bindable
    public int getKingdom_ID() {
        return Kingdom_ID;
    }


    public void setKingdom_ID(int kingdom_ID) {
        Kingdom_ID = kingdom_ID;
      notifyPropertyChanged(BR.kingdom_ID);

    }

    @Bindable
    public int getPhylum_ID() {
        return Phylum_ID;
    }


    public void setPhylum_ID(int phylum_ID) {
        Phylum_ID = phylum_ID;
         notifyPropertyChanged(BR.phylum_ID);

    }

    @Bindable
    public int getOrder_ID() {
        return Order_ID;
    }


    public void setOrder_ID(int order_ID) {
        Order_ID = order_ID;
     notifyPropertyChanged(BR.order_ID);

    }

    @Bindable
    public int getFamily_ID() {
        return Family_ID;
    }


    public void setFamily_ID(int family_ID) {
        Family_ID = family_ID;
         notifyPropertyChanged(BR.family_ID);
    }


}
