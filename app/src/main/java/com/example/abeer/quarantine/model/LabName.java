package com.example.abeer.quarantine.model;

public class LabName {
    public int $id;
    public int ID;
    public String Name_Ar;
    public String Name_En;
    public String Addrees_Ar;
    public String Addrees_En;
    public String Phone;
    public String Fax;
    public String Email;
    public boolean IsActive;
    public int User_Creation_Id;
    public String User_Creation_Date;
    public int User_Updation_Id;
    public String User_Updation_Date;
    public int User_Deletion_Id;
    public String User_Deletion_Date;

    public LabName(int $id, int ID, String name_Ar, String name_En, String addrees_Ar, String addrees_En, String phone, String fax, String email, boolean isActive, int user_Creation_Id, String user_Creation_Date, int user_Updation_Id, String user_Updation_Date, int user_Deletion_Id, String user_Deletion_Date) {
        this.$id = $id;
        this.ID = ID;
        Name_Ar = name_Ar;
        Name_En = name_En;
        Addrees_Ar = addrees_Ar;
        Addrees_En = addrees_En;
        Phone = phone;
        Fax = fax;
        Email = email;
        IsActive = isActive;
        User_Creation_Id = user_Creation_Id;
        User_Creation_Date = user_Creation_Date;
        User_Updation_Id = user_Updation_Id;
        User_Updation_Date = user_Updation_Date;
        User_Deletion_Id = user_Deletion_Id;
        User_Deletion_Date = user_Deletion_Date;
    }

    public int get$id() {
        return $id;
    }

    public void set$id(int $id) {
        this.$id = $id;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName_Ar() {
        return Name_Ar;
    }

    public void setName_Ar(String name_Ar) {
        Name_Ar = name_Ar;
    }

    public String getName_En() {
        return Name_En;
    }

    public void setName_En(String name_En) {
        Name_En = name_En;
    }

    public String getAddrees_Ar() {
        return Addrees_Ar;
    }

    public void setAddrees_Ar(String addrees_Ar) {
        Addrees_Ar = addrees_Ar;
    }

    public String getAddrees_En() {
        return Addrees_En;
    }

    public void setAddrees_En(String addrees_En) {
        Addrees_En = addrees_En;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
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

    public int getUser_Updation_Id() {
        return User_Updation_Id;
    }

    public void setUser_Updation_Id(int user_Updation_Id) {
        User_Updation_Id = user_Updation_Id;
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

    public String getUser_Deletion_Date() {
        return User_Deletion_Date;
    }

    public void setUser_Deletion_Date(String user_Deletion_Date) {
        User_Deletion_Date = user_Deletion_Date;
    }
}
