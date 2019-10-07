package com.example.abeer.quarantine.model;

public class Subclass_Response_Login {
// "$id": "2",
//         "UserId": 1,
//         "FullName": "Iscc",
//         "Token": "06/08/2019 11:18:19 ص_10.5.1.8_True"
    String $id;
    Long UserId;
    Long EmpId;
    String FullName;
    String Token;

    public Subclass_Response_Login() {
    }

    public Subclass_Response_Login(String $id, Long userId,Long EmpId,String fullName, String token) {
        this.$id = $id;
        UserId = userId;
        this.EmpId=EmpId;
        FullName = fullName;
        Token = token;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Long getEmpId() {
        return EmpId;
    }

    public void setEmpId(Long empId) {
        EmpId = empId;
    }
}
