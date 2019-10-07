package com.example.abeer.quarantine.viewmodel.login;

import com.example.abeer.quarantine.model.Subclass_Response_Login;

public class Response_login {
//    "$id": "1",
//            "state_Code": 1,
//            "obj": {
//        "$id": "2",
//                "UserId": 1,
//                "FullName": "Iscc",
//                "Token": "06/08/2019 11:18:19 ص_10.5.1.8_True"
//    }

    String $id;
    int state_Code;
    Subclass_Response_Login obj=new Subclass_Response_Login();

    public Response_login() {
    }

    public Response_login(String $id, int state_Code, Subclass_Response_Login obj) {
        this.$id = $id;
        this.state_Code = state_Code;
        this.obj = obj;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public int getState_Code() {
        return state_Code;
    }

    public void setState_Code(int state_Code) {
        this.state_Code = state_Code;
    }

    public Subclass_Response_Login getObj() {
        return obj;
    }

    public void setObj(Subclass_Response_Login obj) {
        this.obj = obj;
    }
}
