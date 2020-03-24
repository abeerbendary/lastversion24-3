package com.example.abeer.quarantine.model;

public class Ex_SampleData {

//        "$id": "2",
//            "Lot_Number": "40",
//            "ID": 3,
//            "ProdPlantName": "الفراولة"
//    }
    String $id;
    String Lot_Number;
    int ID;
    String ProdPlantName;

    public Ex_SampleData() {
    }

    public Ex_SampleData(String $id, String lot_Number, int ID, String prodPlantName) {
        this.$id = $id;
        Lot_Number = lot_Number;
        this.ID = ID;
        ProdPlantName = prodPlantName;
    }

    public Ex_SampleData(Ex_SampleData Ex_Data) {
        this.$id = Ex_Data.$id;
        Lot_Number = Ex_Data.Lot_Number;
        this.ID = Ex_Data.ID;
        ProdPlantName = Ex_Data.ProdPlantName;
    }
    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String getLot_Number() {
        return Lot_Number;
    }

    public void setLot_Number(String lot_Number) {
        Lot_Number = lot_Number;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProdPlantName() {
        return ProdPlantName;
    }

    public void setProdPlantName(String prodPlantName) {
        ProdPlantName = prodPlantName;
    }
}
