package com.example.abeer.quarantine.viewmodel.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.abeer.quarantine.BR;

public class Request_login extends BaseObservable{
    String LoginName;
    String Password;

    public Request_login() {
    }

public Request_login(String LoginName, String Password) {
        this.LoginName = LoginName;
        this.Password = Password;

    }

    @Bindable
    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String LoginName) {
        this.LoginName = LoginName;
        notifyPropertyChanged(BR.loginName);
    }

    @Bindable
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
        notifyPropertyChanged(BR.password);
    }
}
