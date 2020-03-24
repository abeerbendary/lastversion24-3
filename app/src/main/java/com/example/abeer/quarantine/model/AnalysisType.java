package com.example.abeer.quarantine.model;

public class AnalysisType {

    public int $id;
    public int Value;
    public String DisplayText;

    public AnalysisType(int $id, int value, String displayText) {
        this.$id = $id;
        Value = value;
        DisplayText = displayText;
    }

    public int get$id() {
        return $id;
    }

    public void set$id(int $id) {
        this.$id = $id;
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
