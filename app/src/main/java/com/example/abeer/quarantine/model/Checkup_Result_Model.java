package com.example.abeer.quarantine.model;

import android.content.Context;

import com.example.abeer.quarantine.viewmodel.ex_RequestCommitteeResult.Checkup_Result;

import org.w3c.dom.Text;

import java.util.Date;

public class Checkup_Result_Model {
//    String  Checkup;
//    int Count;
//    int Weight;
//    int Result_ID;
//    Text Comment;
//    int Kingdom_ID;
//    int Phylum_ID;
//    int Order_ID;
//    int Lot_Num;
//    int Family_ID;
//    int Final_result;
//    int Result_injury;
//Context context;
//
//
//    public  Checkup_Result(Context context)
//    {
//        this.context=context;
//    }
//
//    public Checkup_Result(String checkup, int count, int weight,
//                               int result_ID, Text comment, int kingdom_ID, int phylum_ID, int order_ID,int lot_num,
//                               int family_ID, int final_result,int result_injury) {
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
//        Final_result = final_result;
//        Result_injury=result_injury;
//    }
//
//    public Checkup_Result(Checkup_Result Checkup_Result) {
//
//        Checkup = Checkup_Result.Checkup;
//        Count = Checkup_Result.Count;
//        Weight = Checkup_Result.Weight;
//        Result_ID = Checkup_Result.Result_ID;
//        Comment = Checkup_Result.Comment;
//        Kingdom_ID = Checkup_Result.Kingdom_ID;
//        Phylum_ID = Checkup_Result.Phylum_ID;
//        Order_ID = Checkup_Result.Order_ID;
//        Lot_Num = Checkup_Result.Lot_Num;
//        Family_ID = Checkup_Result.Family_ID;
//        Final_result = Checkup_Result.Final_result;
//        Result_injury=Checkup_Result.Result_injury;
//
//    }

//nbmnbm
//    {
//        "ID": 0,
//            "Ex_RequestLotData_ID": null,
//            "Committee_ID": 40011,
//            "EmployeeId": 18244,
//            "CommitteeResultType_ID":4,
//            "Weight": 5.5,
//            "QuantitySize": 0,
//            "Notes":"note-----",
//            "Item_ID": 5,
//            "Item__OrderID": 65
//    }

    long ID;
    long Ex_RequestLotData_ID;
    long Committee_ID;
    long EmployeeId;
    int CommitteeResultType_ID;
   float Weight;
    int QuantitySize;
    String Notes;
    int Item_ID;
    int Item__OrderID;
    byte Result_injuryID;
    String Date;

    public Checkup_Result_Model(Checkup_Result_Model checkupResult) {
        this.ID = checkupResult.ID;
        this.Ex_RequestLotData_ID = checkupResult.Ex_RequestLotData_ID;
        this.Committee_ID = checkupResult.Committee_ID;
        this.EmployeeId = checkupResult.EmployeeId;
        this.CommitteeResultType_ID = checkupResult.CommitteeResultType_ID;
        this.Weight = checkupResult.Weight;
        this.QuantitySize = checkupResult.QuantitySize;
        this.Notes = checkupResult.Notes;
        this.Item_ID = checkupResult.Item_ID;
        this.Item__OrderID = checkupResult.Item__OrderID;
        this.Date=checkupResult.Date;
        this.Result_injuryID=checkupResult.Result_injuryID;

    }

    public Checkup_Result_Model(Checkup_Result checkupResult) {
        this.ID=0;
        this.Ex_RequestLotData_ID =checkupResult.getlot_ID();
        this.Committee_ID = checkupResult.getCommittee_ID();
        this.EmployeeId = checkupResult.getEmployeeId();
        this.CommitteeResultType_ID = checkupResult.getResult_ID();
        this.Weight = checkupResult.getWeight();
        this.QuantitySize = checkupResult.getCount();
        this.Notes = checkupResult.getComment();
        if(checkupResult.getFamily_ID()!= 0)
        {
            this.Item_ID = checkupResult.getFamily_ID();
            this.Item__OrderID =68;
        }
        else if(checkupResult.getFamily_ID()==0 && checkupResult.getOrder_ID()!=0)
        {
            this.Item_ID = checkupResult.getOrder_ID();
            this.Item__OrderID =67;
        }
        else if(checkupResult.getOrder_ID()==0 && checkupResult.getPhylum_ID() !=0)
        {
            this.Item_ID = checkupResult.getPhylum_ID();
            this.Item__OrderID =66;
        }
        else if(checkupResult.getPhylum_ID()==0 && checkupResult.getKingdom_ID()!=0)
        {
            this.Item_ID = checkupResult.getKingdom_ID();
            this.Item__OrderID =65;
        }
        else if(checkupResult.getKingdom_ID()==0)
        {
            this.Item_ID = 0;
            this.Item__OrderID = 0;
        }
        this.Result_injuryID= (byte) checkupResult.getResult_injury();
        this.Date=checkupResult.getCheckup();
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getEx_RequestLotData_ID() {
        return Ex_RequestLotData_ID;
    }

    public void setEx_RequestLotData_ID(long ex_RequestLotData_ID) {
        Ex_RequestLotData_ID = ex_RequestLotData_ID;
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

    public int getCommitteeResultType_ID() {
        return CommitteeResultType_ID;
    }

    public void setCommitteeResultType_ID(int committeeResultType_ID) {
        CommitteeResultType_ID = committeeResultType_ID;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float weight) {
        Weight = weight;
    }

    public int getQuantitySize() {
        return QuantitySize;
    }

    public void setQuantitySize(int quantitySize) {
        QuantitySize = quantitySize;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int item_ID) {
        Item_ID = item_ID;
    }

    public int getItem__OrderID() {
        return Item__OrderID;
    }

    public void setItem__OrderID(int item__OrderID) {
        Item__OrderID = item__OrderID;
    }

    public byte getResult_injuryID() {
        return Result_injuryID;
    }

    public void setResult_injuryID(byte result_injuryID) {
        Result_injuryID = result_injuryID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
