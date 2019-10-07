package com.example.abeer.quarantine.model;

import java.io.Serializable;
import java.util.Date;

public class location implements Serializable {
    String name_location;
    Date Time;
   public double latitude;
  public   double  longitude;
    int  User_ID;
    public location() {
    }
    public location(String Name_location, double latitude, double longitude) {
        name_location=Name_location;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public location( double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public location(String name_location, Date time, double latitude, double longitude, int user_ID) {
        this.name_location = name_location;
        Time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        User_ID = user_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public location(String Name_location, Date time, double latitude, double longitude) {
        name_location=Name_location;

        Time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName_location() {
        return name_location;
    }

    public void setName_location(String name_location) {
        this.name_location = name_location;
    }

    public Date getTime() {
        return Time;
    }

    public void setTime(Date time) {
        Time = time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object obj) {

        return  (  this.name_location .equals(((location) obj).name_location )&&
                (this.latitude ==((location) obj).latitude )
                && (this.longitude ==((location) obj).longitude ))? true: false;

    }

    public int hashCode() {
        return getName_location().hashCode();
    }

}

