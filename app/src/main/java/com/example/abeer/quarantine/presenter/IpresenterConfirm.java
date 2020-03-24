package com.example.abeer.quarantine.presenter;

import android.view.View;

import com.example.abeer.quarantine.viewmodel.confirm.ConfirmResult;

public interface IpresenterConfirm {
    public  void SaveConfirm(View view, ConfirmResult confirmResult);
    public  void OnClickcancel(View view, ConfirmResult confirmResult);
}
