package com.example.abeer.quarantine.model;

public class Plant {

    public String   $id;
    public int Value;
    public String DisplayText;

//    public Plant(int value, String displayText) {
//        Value = value;
//        DisplayText = displayText;
//    }


    public Plant(String $id, int value, String displayText) {
        this.$id = $id;
        Value = value;
        DisplayText = displayText;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }


    public String getDisplayText() {
        return DisplayText;
    }

    public void setDisplayText(String displayText) {
        DisplayText = displayText;
    }
}
