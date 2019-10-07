package com.example.abeer.quarantine.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.example.abeer.quarantine.BR;
public class ListDetailsCheckRequestNew extends BaseObservable {
    public String $id;
    public String CheckRequest_Number;
    public String Reciever_Name;
    public String ImportCompany;
    public String ImportCountry_Name;
    public String Outlet_Name;
    public String Govern_Name;
    public String General_Admin_Name;
    public String PortNational_Shippment_Name;
    public int Exporter_ID;
    public int ExporterType_Id;
    public String  ExporterType_Name;
    public int Importer_Exporter_Id;
    public String Importer_Exporter_Name;
    public String port_arrive_Name;
    public String port_transite_Name;
    public String c_transite_country_Name;
    public String Shipment_Mean_Name;
    public String Transport_Mean_Name;
    public String Ship_Name;
    public int Request_ApprovedUnapprovedID;
    public boolean Request_ApprovedUnapprovedType;
    public String Request_ApprovedUnapproved_StationName;
    public String Request_ApprovedUnapproved_Place_Ar_Name;
    public String Request_ApprovedUnapproved_Place_Address_Ar;
    public String Committee_Type;
    public String Check_Date;
    public String RequestCommittee_Status;
    public String Item_Data;

    @Bindable
    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }
    @Bindable
    public String getCheckRequest_Number() {
        return CheckRequest_Number;
    }

    public void setCheckRequest_Number(String checkRequest_Number) {
        CheckRequest_Number = checkRequest_Number;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getReciever_Name() {
        return Reciever_Name;
    }

    public void setReciever_Name(String reciever_Name) {
        Reciever_Name = reciever_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getImportCompany() {
        return ImportCompany;
    }

    public void setImportCompany(String importCompany) {
        ImportCompany = importCompany;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getImportCountry_Name() {
        return ImportCountry_Name;
    }

    public void setImportCountry_Name(String importCountry_Name) {
        ImportCountry_Name = importCountry_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getOutlet_Name() {
        return Outlet_Name;
    }

    public void setOutlet_Name(String outlet_Name) {
        Outlet_Name = outlet_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getGovern_Name() {
        return Govern_Name;
    }

    public void setGovern_Name(String govern_Name) {
        Govern_Name = govern_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getGeneral_Admin_Name() {
        return General_Admin_Name;
    }

    public void setGeneral_Admin_Name(String general_Admin_Name) {
        General_Admin_Name = general_Admin_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getPortNational_Shippment_Name() {
        return PortNational_Shippment_Name;
    }

    public void setPortNational_Shippment_Name(String portNational_Shippment_Name) {
        PortNational_Shippment_Name = portNational_Shippment_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public int getExporter_ID() {
        return Exporter_ID;
    }

    public void setExporter_ID(int exporter_ID) {
        Exporter_ID = exporter_ID;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public int getExporterType_Id() {
        return ExporterType_Id;
    }

    public void setExporterType_Id(int exporterType_Id) {
        ExporterType_Id = exporterType_Id;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getExporterType_Name() {
        return ExporterType_Name;
    }

    public void setExporterType_Name(String exporterType_Name) {
        ExporterType_Name = exporterType_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public int getImporter_Exporter_Id() {
        return Importer_Exporter_Id;
    }

    public void setImporter_Exporter_Id(int importer_Exporter_Id) {
        Importer_Exporter_Id = importer_Exporter_Id;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getImporter_Exporter_Name() {
        return Importer_Exporter_Name;
    }

    public void setImporter_Exporter_Name(String importer_Exporter_Name) {
        Importer_Exporter_Name = importer_Exporter_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getPort_arrive_Name() {
        return port_arrive_Name;
    }

    public void setPort_arrive_Name(String port_arrive_Name) {
        this.port_arrive_Name = port_arrive_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getPort_transite_Name() {
        return port_transite_Name;
    }

    public void setPort_transite_Name(String port_transite_Name) {
        this.port_transite_Name = port_transite_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getC_transite_country_Name() {
        return c_transite_country_Name;
    }

    public void setC_transite_country_Name(String c_transite_country_Name) {
        this.c_transite_country_Name = c_transite_country_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getShipment_Mean_Name() {
        return Shipment_Mean_Name;
    }

    public void setShipment_Mean_Name(String shipment_Mean_Name) {
        Shipment_Mean_Name = shipment_Mean_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getTransport_Mean_Name() {
        return Transport_Mean_Name;
    }

    public void setTransport_Mean_Name(String transport_Mean_Name) {
        Transport_Mean_Name = transport_Mean_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getShip_Name() {
        return Ship_Name;
    }

    public void setShip_Name(String ship_Name) {
        Ship_Name = ship_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public int getRequest_ApprovedUnapprovedID() {
        return Request_ApprovedUnapprovedID;

    }

    public void setRequest_ApprovedUnapprovedID(int request_ApprovedUnapprovedID) {
        Request_ApprovedUnapprovedID = request_ApprovedUnapprovedID;
        notifyPropertyChanged(BR.detaill);
    }

    public boolean isRequest_ApprovedUnapprovedType() {
        return Request_ApprovedUnapprovedType;
    }

    public void setRequest_ApprovedUnapprovedType(boolean request_ApprovedUnapprovedType) {
        Request_ApprovedUnapprovedType = request_ApprovedUnapprovedType;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getRequest_ApprovedUnapproved_StationName() {
        return Request_ApprovedUnapproved_StationName;
    }

    public void setRequest_ApprovedUnapproved_StationName(String request_ApprovedUnapproved_StationName) {
        Request_ApprovedUnapproved_StationName = request_ApprovedUnapproved_StationName;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getRequest_ApprovedUnapproved_Place_Ar_Name() {
        return Request_ApprovedUnapproved_Place_Ar_Name;
    }

    public void setRequest_ApprovedUnapproved_Place_Ar_Name(String request_ApprovedUnapproved_Place_Ar_Name) {
        Request_ApprovedUnapproved_Place_Ar_Name = request_ApprovedUnapproved_Place_Ar_Name;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getRequest_ApprovedUnapproved_Place_Address_Ar() {
        return Request_ApprovedUnapproved_Place_Address_Ar;
    }

    public void setRequest_ApprovedUnapproved_Place_Address_Ar(String request_ApprovedUnapproved_Place_Address_Ar) {
        Request_ApprovedUnapproved_Place_Address_Ar = request_ApprovedUnapproved_Place_Address_Ar;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getCommittee_Type() {
        return Committee_Type;
    }

    public void setCommittee_Type(String committee_Type) {
        Committee_Type = committee_Type;
        notifyPropertyChanged(BR.detaill);
    }

    @Bindable
    public String getCheck_Date() {
        return Check_Date;
    }

    public void setCheck_Date(String check_Date) {
        Check_Date = check_Date;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getRequestCommittee_Status() {
        return RequestCommittee_Status;
    }

    public void setRequestCommittee_Status(String requestCommittee_Status) {
        RequestCommittee_Status = requestCommittee_Status;
        notifyPropertyChanged(BR.detaill);
    }
    @Bindable
    public String getItem_Data() {
        return Item_Data;
    }

    public void setItem_Data(String item_Data) {
        Item_Data = item_Data;
        notifyPropertyChanged(BR.detaill);
    }

//
//    public String $id;
//    public String CheckRequest_Number;
//    public String Reciever_Name;
//    public String ImportCompany;
//    public String ImportCountry_Name;
//    public String Outlet_Name;
//    public String Govern_Name;
//    public String General_Admin_Name;
//    public String PortNational_Shippment_Name;
//    public int Exporter_ID;
//    public int ExporterType_Id;
//    public String  ExporterType_Name;
//    public int Importer_Exporter_Id;
//    public String Importer_Exporter_Name;
//    public String port_arrive_Name;
//    public String port_transite_Name;
//    public String c_transite_country_Name;
//    public String Shipment_Mean_Name;
//    public String Transport_Mean_Name;
//    public String Ship_Name;
//    public int Request_ApprovedUnapprovedID;
//    public boolean Request_ApprovedUnapprovedType;
//    public String Request_ApprovedUnapproved_StationName;
//    public String Request_ApprovedUnapproved_Place_Ar_Name;
//    public String Request_ApprovedUnapproved_Place_Address_Ar;
//    public String Committee_Type;
//    public String Check_Date;
//    public String RequestCommittee_Status;
//    public String Item_Data;
//
//    @Bindable
//    public String get$id() {
//        return $id;
//    }
//
//    public void set$id(String $id) {
//        this.$id = $id;
//    }
//    @Bindable
//    public String getCheckRequest_Number() {
//        return CheckRequest_Number;
//    }
//
//    public void setCheckRequest_Number(String checkRequest_Number) {
//        CheckRequest_Number = checkRequest_Number;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getReciever_Name() {
//        return Reciever_Name;
//    }
//
//    public void setReciever_Name(String reciever_Name) {
//        Reciever_Name = reciever_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getImportCompany() {
//        return ImportCompany;
//    }
//
//    public void setImportCompany(String importCompany) {
//        ImportCompany = importCompany;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getImportCountry_Name() {
//        return ImportCountry_Name;
//    }
//
//    public void setImportCountry_Name(String importCountry_Name) {
//        ImportCountry_Name = importCountry_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getOutlet_Name() {
//        return Outlet_Name;
//    }
//
//    public void setOutlet_Name(String outlet_Name) {
//        Outlet_Name = outlet_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getGovern_Name() {
//        return Govern_Name;
//    }
//
//    public void setGovern_Name(String govern_Name) {
//        Govern_Name = govern_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getGeneral_Admin_Name() {
//        return General_Admin_Name;
//    }
//
//    public void setGeneral_Admin_Name(String general_Admin_Name) {
//        General_Admin_Name = general_Admin_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getPortNational_Shippment_Name() {
//        return PortNational_Shippment_Name;
//    }
//
//    public void setPortNational_Shippment_Name(String portNational_Shippment_Name) {
//        PortNational_Shippment_Name = portNational_Shippment_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public int getExporter_ID() {
//        return Exporter_ID;
//    }
//
//    public void setExporter_ID(int exporter_ID) {
//        Exporter_ID = exporter_ID;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public int getExporterType_Id() {
//        return ExporterType_Id;
//    }
//
//    public void setExporterType_Id(int exporterType_Id) {
//        ExporterType_Id = exporterType_Id;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getExporterType_Name() {
//        return ExporterType_Name;
//    }
//
//    public void setExporterType_Name(String exporterType_Name) {
//        ExporterType_Name = exporterType_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public int getImporter_Exporter_Id() {
//        return Importer_Exporter_Id;
//    }
//
//    public void setImporter_Exporter_Id(int importer_Exporter_Id) {
//        Importer_Exporter_Id = importer_Exporter_Id;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getImporter_Exporter_Name() {
//        return Importer_Exporter_Name;
//    }
//
//    public void setImporter_Exporter_Name(String importer_Exporter_Name) {
//        Importer_Exporter_Name = importer_Exporter_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getPort_arrive_Name() {
//        return port_arrive_Name;
//    }
//
//    public void setPort_arrive_Name(String port_arrive_Name) {
//        this.port_arrive_Name = port_arrive_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getPort_transite_Name() {
//        return port_transite_Name;
//    }
//
//    public void setPort_transite_Name(String port_transite_Name) {
//        this.port_transite_Name = port_transite_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getC_transite_country_Name() {
//        return c_transite_country_Name;
//    }
//
//    public void setC_transite_country_Name(String c_transite_country_Name) {
//        this.c_transite_country_Name = c_transite_country_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getShipment_Mean_Name() {
//        return Shipment_Mean_Name;
//    }
//
//    public void setShipment_Mean_Name(String shipment_Mean_Name) {
//        Shipment_Mean_Name = shipment_Mean_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getTransport_Mean_Name() {
//        return Transport_Mean_Name;
//    }
//
//    public void setTransport_Mean_Name(String transport_Mean_Name) {
//        Transport_Mean_Name = transport_Mean_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getShip_Name() {
//        return Ship_Name;
//    }
//
//    public void setShip_Name(String ship_Name) {
//        Ship_Name = ship_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public int getRequest_ApprovedUnapprovedID() {
//        return Request_ApprovedUnapprovedID;
//
//    }
//
//    public void setRequest_ApprovedUnapprovedID(int request_ApprovedUnapprovedID) {
//        Request_ApprovedUnapprovedID = request_ApprovedUnapprovedID;
//        notifyPropertyChanged(BR.detaill);
//    }
//
//    public boolean isRequest_ApprovedUnapprovedType() {
//        return Request_ApprovedUnapprovedType;
//    }
//
//    public void setRequest_ApprovedUnapprovedType(boolean request_ApprovedUnapprovedType) {
//        Request_ApprovedUnapprovedType = request_ApprovedUnapprovedType;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getRequest_ApprovedUnapproved_StationName() {
//        return Request_ApprovedUnapproved_StationName;
//    }
//
//    public void setRequest_ApprovedUnapproved_StationName(String request_ApprovedUnapproved_StationName) {
//        Request_ApprovedUnapproved_StationName = request_ApprovedUnapproved_StationName;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getRequest_ApprovedUnapproved_Place_Ar_Name() {
//        return Request_ApprovedUnapproved_Place_Ar_Name;
//    }
//
//    public void setRequest_ApprovedUnapproved_Place_Ar_Name(String request_ApprovedUnapproved_Place_Ar_Name) {
//        Request_ApprovedUnapproved_Place_Ar_Name = request_ApprovedUnapproved_Place_Ar_Name;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getRequest_ApprovedUnapproved_Place_Address_Ar() {
//        return Request_ApprovedUnapproved_Place_Address_Ar;
//    }
//
//    public void setRequest_ApprovedUnapproved_Place_Address_Ar(String request_ApprovedUnapproved_Place_Address_Ar) {
//        Request_ApprovedUnapproved_Place_Address_Ar = request_ApprovedUnapproved_Place_Address_Ar;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getCommittee_Type() {
//        return Committee_Type;
//    }
//
//    public void setCommittee_Type(String committee_Type) {
//        Committee_Type = committee_Type;
//        notifyPropertyChanged(BR.detaill);
//    }
//
//    @Bindable
//    public String getCheck_Date() {
//        return Check_Date;
//    }
//
//    public void setCheck_Date(String check_Date) {
//        Check_Date = check_Date;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getRequestCommittee_Status() {
//        return RequestCommittee_Status;
//    }
//
//    public void setRequestCommittee_Status(String requestCommittee_Status) {
//        RequestCommittee_Status = requestCommittee_Status;
//        notifyPropertyChanged(BR.detaill);
//    }
//    @Bindable
//    public String getItem_Data() {
//        return Item_Data;
//    }
//
//    public void setItem_Data(String item_Data) {
//        Item_Data = item_Data;
//        notifyPropertyChanged(BR.detaill);
//    }
}
