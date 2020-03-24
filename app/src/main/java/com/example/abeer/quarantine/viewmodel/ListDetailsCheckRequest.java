package com.example.abeer.quarantine.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


import com.example.abeer.quarantine.model.ExportCheckRequestDetail;

import java.util.ArrayList;


public class ListDetailsCheckRequest extends BaseObservable {

    public String $id;
    public int state_Code;
    public ArrayList<ExportCheckRequestDetail> obj = new ArrayList<>();

   public ListDetailsCheckRequest(ListDetailsCheckRequest listDetailsCheckRequest){
        this.$id=listDetailsCheckRequest.$id;
        this.obj=listDetailsCheckRequest.obj;
        this.state_Code=listDetailsCheckRequest.state_Code;
      // notifyPropertyChanged(BR.details);
    }

    @Bindable
    public String getList_Govern_Name() { return obj.get(0).Govern_Name; }
    @Bindable
    public String getList_Outlet_Name() { return obj.get(0).Outlet_Name; }
    @Bindable
    public String getList_PortNational_Shippment_Name() { return obj.get(0).PortNational_Shippment_Name; }


    @Bindable
    public String getList_ExporterType_Name() { return obj.get(0).ExporterType_Name; }
    @Bindable
    public String getList_General_Admin_Name() { return obj.get(0).General_Admin_Name; }
    @Bindable
    public String getList_ImportCompany() { return obj.get(0).ImportCompany; }
    @Bindable
    public String getList_Reciever_Name() { return obj.get(0).Reciever_Name; }

    @Bindable
    public String getList_Item_Data() { return obj.get(0).Item_Data; }
    @Bindable
    public String getList_ImportCountry_Name() { return obj.get(0).ImportCountry_Name; }
    @Bindable
    public String getList_port_arrive_Name() { return obj.get(0).port_arrive_Name; }

    @Bindable
    public String getList_c_transite_country_Namee() { return obj.get(0).c_transite_country_Name; }

    @Bindable
    public String getList_Shipment_Mean_Name() { return obj.get(0).Shipment_Mean_Name; }

    @Bindable
    public String getList_Transport_Mean_Name() {
        return obj.get(0).Transport_Mean_Name;
    }
    @Bindable
    public String getList_Request_ApprovedUnapproved_StationName() {
        return obj.get(0).Request_ApprovedUnapproved_StationName;
    }

    @Bindable
    public String getList_Request_ApprovedUnapproved_Place_Address_Ar() {
        return obj.get(0).Request_ApprovedUnapproved_Place_Address_Ar;
    }


    @Bindable
    public ArrayList<String> getListItem_Data() {
        ArrayList<String> ArrayDisplayText=new ArrayList<>();
        for (int i = 0; i <obj.size(); i++) {
            ArrayDisplayText.add(obj.get(i).Item_Data);
        }
        return ArrayDisplayText;
    }











    @Bindable
    public String getList_port_transite_Name() {
        return obj.get(0).port_transite_Name;
    }
    @Bindable
    public String getList_Ship_Name() {
        return obj.get(0).Ship_Name;
    }
    public void setList_Shipment_Mean_Name(ListDetailsCheckRequest list_shipment_mean_name) {
        this.$id = list_shipment_mean_name.$id;
        this.state_Code = list_shipment_mean_name.state_Code;
        this.obj =list_shipment_mean_name.obj;
     //   notifyPropertyChanged(BR.details);

    }
}
