package com.example.abeer.quarantine.model;

public class TreatmentMethod {

    public String $id;
    public int ID;
    public String Ar_Name;
    public String En_Name;
    public int TreatmentType_ID;
    public String User_Updation_Date;
    public int User_Deletion_Id;
    public int User_Creation_Id;
    public String User_Creation_Date;
    public String User_Deletion_Date;
    public int User_Updation_Id;

    public TreatmentMethod(String $id, int ID, String ar_Name, String en_Name, int treatmentType_ID, String user_Updation_Date, int user_Deletion_Id, int user_Creation_Id, String user_Creation_Date, String user_Deletion_Date, int user_Updation_Id) {
        this.$id = $id;
        this.ID = ID;
        Ar_Name = ar_Name;
        En_Name = en_Name;
        TreatmentType_ID = treatmentType_ID;
        User_Updation_Date = user_Updation_Date;
        User_Deletion_Id = user_Deletion_Id;
        User_Creation_Id = user_Creation_Id;
        User_Creation_Date = user_Creation_Date;
        User_Deletion_Date = user_Deletion_Date;
        User_Updation_Id = user_Updation_Id;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAr_Name() {
        return Ar_Name;
    }

    public void setAr_Name(String ar_Name) {
        Ar_Name = ar_Name;
    }

    public String getEn_Name() {
        return En_Name;
    }

    public void setEn_Name(String en_Name) {
        En_Name = en_Name;
    }

    public int getTreatmentType_ID() {
        return TreatmentType_ID;
    }

    public void setTreatmentType_ID(int treatmentType_ID) {
        TreatmentType_ID = treatmentType_ID;
    }

    public String getUser_Updation_Date() {
        return User_Updation_Date;
    }

    public void setUser_Updation_Date(String user_Updation_Date) {
        User_Updation_Date = user_Updation_Date;
    }

    public int getUser_Deletion_Id() {
        return User_Deletion_Id;
    }

    public void setUser_Deletion_Id(int user_Deletion_Id) {
        User_Deletion_Id = user_Deletion_Id;
    }

    public int getUser_Creation_Id() {
        return User_Creation_Id;
    }

    public void setUser_Creation_Id(int user_Creation_Id) {
        User_Creation_Id = user_Creation_Id;
    }

    public String getUser_Creation_Date() {
        return User_Creation_Date;
    }

    public void setUser_Creation_Date(String user_Creation_Date) {
        User_Creation_Date = user_Creation_Date;
    }

    public String getUser_Deletion_Date() {
        return User_Deletion_Date;
    }

    public void setUser_Deletion_Date(String user_Deletion_Date) {
        User_Deletion_Date = user_Deletion_Date;
    }

    public int getUser_Updation_Id() {
        return User_Updation_Id;
    }

    public void setUser_Updation_Id(int user_Updation_Id) {
        User_Updation_Id = user_Updation_Id;
    }
}
