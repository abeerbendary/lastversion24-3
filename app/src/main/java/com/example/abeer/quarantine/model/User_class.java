package com.example.abeer.quarantine.model;

public class User_class {
    int User_Id;
    boolean is_admin;
    String Name;

    public User_class(int ID,  String name) {
        this.User_Id = ID;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
