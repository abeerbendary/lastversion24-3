package com.example.abeer.quarantine.model;

import java.util.ArrayList;
import java.util.Date;

public class InfoWindowData {
    String location;
    ArrayList<Date> times=new ArrayList<>();
    public InfoWindowData() {

    }

    public InfoWindowData(String location, ArrayList<Date> times) {
        this.location = location;
        this.times = times;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Date> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Date> times) {
        this.times = times;
    }
}

