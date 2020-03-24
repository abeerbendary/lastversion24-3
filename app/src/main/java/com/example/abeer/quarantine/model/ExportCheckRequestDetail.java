package com.example.abeer.quarantine.model;

public class ExportCheckRequestDetail {
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
    public ExportCheckRequestDetail(String $id, String checkRequest_Number, String reciever_Name, String importCompany, String importCountry_Name, String outlet_Name, String general_Admin_Name, String portNational_Shippment_Name, int exporter_ID, int exporterType_Id, int importer_Exporter_Id, String importer_Exporter_Name, String port_arrive_Name, String port_transite_Name, String c_transite_country_Name, String shipment_Mean_Name, String transport_Mean_Name, String ship_Name, int request_ApprovedUnapprovedID, boolean request_ApprovedUnapprovedType, String request_ApprovedUnapproved_StationName, String request_ApprovedUnapproved_Place_Ar_Name, String request_ApprovedUnapproved_Place_Address_Ar, String committee_Type, String check_Date, String requestCommittee_Status) {
        this.$id = $id;
        CheckRequest_Number = checkRequest_Number;
        Reciever_Name = reciever_Name;
        ImportCompany = importCompany;
        ImportCountry_Name = importCountry_Name;
        Outlet_Name = outlet_Name;
        General_Admin_Name = general_Admin_Name;
        PortNational_Shippment_Name = portNational_Shippment_Name;
        Exporter_ID = exporter_ID;
        ExporterType_Id = exporterType_Id;
        Importer_Exporter_Id = importer_Exporter_Id;
        Importer_Exporter_Name = importer_Exporter_Name;
        this.port_arrive_Name = port_arrive_Name;
        this.port_transite_Name = port_transite_Name;
        this.c_transite_country_Name = c_transite_country_Name;
        Shipment_Mean_Name = shipment_Mean_Name;
        Transport_Mean_Name = transport_Mean_Name;
        Ship_Name = ship_Name;
        Request_ApprovedUnapprovedID = request_ApprovedUnapprovedID;
        Request_ApprovedUnapprovedType = request_ApprovedUnapprovedType;
        Request_ApprovedUnapproved_StationName = request_ApprovedUnapproved_StationName;
        Request_ApprovedUnapproved_Place_Ar_Name = request_ApprovedUnapproved_Place_Ar_Name;
        Request_ApprovedUnapproved_Place_Address_Ar = request_ApprovedUnapproved_Place_Address_Ar;
        Committee_Type = committee_Type;
        Check_Date = check_Date;
        RequestCommittee_Status = requestCommittee_Status;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String getCheckRequest_Number() {
        return CheckRequest_Number;
    }

    public void setCheckRequest_Number(String checkRequest_Number) {
        CheckRequest_Number = checkRequest_Number;
    }

    public String getReciever_Name() {
        return Reciever_Name;
    }

    public void setReciever_Name(String reciever_Name) {
        Reciever_Name = reciever_Name;
    }

    public String getImportCompany() {
        return ImportCompany;
    }

    public void setImportCompany(String importCompany) {
        ImportCompany = importCompany;
    }

    public String getImportCountry_Name() {
        return ImportCountry_Name;
    }

    public void setImportCountry_Name(String importCountry_Name) {
        ImportCountry_Name = importCountry_Name;
    }

    public String getOutlet_Name() {
        return Outlet_Name;
    }

    public void setOutlet_Name(String outlet_Name) {
        Outlet_Name = outlet_Name;
    }

    public String getGeneral_Admin_Name() {
        return General_Admin_Name;
    }

    public void setGeneral_Admin_Name(String general_Admin_Name) {
        General_Admin_Name = general_Admin_Name;
    }

    public String getPortNational_Shippment_Name() {
        return PortNational_Shippment_Name;
    }

    public void setPortNational_Shippment_Name(String portNational_Shippment_Name) {
        PortNational_Shippment_Name = portNational_Shippment_Name;
    }

    public int getExporter_ID() {
        return Exporter_ID;
    }

    public void setExporter_ID(int exporter_ID) {
        Exporter_ID = exporter_ID;
    }

    public int getExporterType_Id() {
        return ExporterType_Id;
    }

    public void setExporterType_Id(int exporterType_Id) {
        ExporterType_Id = exporterType_Id;
    }

    public int getImporter_Exporter_Id() {
        return Importer_Exporter_Id;
    }

    public void setImporter_Exporter_Id(int importer_Exporter_Id) {
        Importer_Exporter_Id = importer_Exporter_Id;
    }

    public String getImporter_Exporter_Name() {
        return Importer_Exporter_Name;
    }

    public void setImporter_Exporter_Name(String importer_Exporter_Name) {
        Importer_Exporter_Name = importer_Exporter_Name;
    }

    public String getPort_arrive_Name() {
        return port_arrive_Name;
    }

    public void setPort_arrive_Name(String port_arrive_Name) {
        this.port_arrive_Name = port_arrive_Name;
    }

    public String getPort_transite_Name() {
        return port_transite_Name;
    }

    public void setPort_transite_Name(String port_transite_Name) {
        this.port_transite_Name = port_transite_Name;
    }

    public String getC_transite_country_Name() {
        return c_transite_country_Name;
    }

    public void setC_transite_country_Name(String c_transite_country_Name) {
        this.c_transite_country_Name = c_transite_country_Name;
    }

    public String getShipment_Mean_Name() {
        return Shipment_Mean_Name;
    }

    public void setShipment_Mean_Name(String shipment_Mean_Name) {
        Shipment_Mean_Name = shipment_Mean_Name;
    }

    public String getTransport_Mean_Name() {
        return Transport_Mean_Name;
    }

    public void setTransport_Mean_Name(String transport_Mean_Name) {
        Transport_Mean_Name = transport_Mean_Name;
    }

    public String getShip_Name() {
        return Ship_Name;
    }

    public void setShip_Name(String ship_Name) {
        Ship_Name = ship_Name;
    }

    public int getRequest_ApprovedUnapprovedID() {
        return Request_ApprovedUnapprovedID;
    }

    public void setRequest_ApprovedUnapprovedID(int request_ApprovedUnapprovedID) {
        Request_ApprovedUnapprovedID = request_ApprovedUnapprovedID;
    }

    public boolean isRequest_ApprovedUnapprovedType() {
        return Request_ApprovedUnapprovedType;
    }

    public void setRequest_ApprovedUnapprovedType(boolean request_ApprovedUnapprovedType) {
        Request_ApprovedUnapprovedType = request_ApprovedUnapprovedType;
    }

    public String getRequest_ApprovedUnapproved_StationName() {
        return Request_ApprovedUnapproved_StationName;
    }

    public void setRequest_ApprovedUnapproved_StationName(String request_ApprovedUnapproved_StationName) {
        Request_ApprovedUnapproved_StationName = request_ApprovedUnapproved_StationName;
    }

    public String getRequest_ApprovedUnapproved_Place_Ar_Name() {
        return Request_ApprovedUnapproved_Place_Ar_Name;
    }

    public void setRequest_ApprovedUnapproved_Place_Ar_Name(String request_ApprovedUnapproved_Place_Ar_Name) {
        Request_ApprovedUnapproved_Place_Ar_Name = request_ApprovedUnapproved_Place_Ar_Name;
    }

    public String getRequest_ApprovedUnapproved_Place_Address_Ar() {
        return Request_ApprovedUnapproved_Place_Address_Ar;
    }

    public void setRequest_ApprovedUnapproved_Place_Address_Ar(String request_ApprovedUnapproved_Place_Address_Ar) {
        Request_ApprovedUnapproved_Place_Address_Ar = request_ApprovedUnapproved_Place_Address_Ar;
    }

    public String getCommittee_Type() {
        return Committee_Type;
    }

    public void setCommittee_Type(String committee_Type) {
        Committee_Type = committee_Type;
    }

    public String getCheck_Date() {
        return Check_Date;
    }

    public void setCheck_Date(String check_Date) {
        Check_Date = check_Date;
    }

    public String getRequestCommittee_Status() {
        return RequestCommittee_Status;
    }

    public void setRequestCommittee_Status(String requestCommittee_Status) {
        RequestCommittee_Status = requestCommittee_Status;
    }
}
//    public String $id;
//    public int CheckRequest_Number;
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
//    public ExportCheckRequestDetail(String $id, int checkRequest_Number, String reciever_Name, String importCompany, String importCountry_Name, String outlet_Name, String general_Admin_Name, String portNational_Shippment_Name, int exporter_ID, int exporterType_Id, int importer_Exporter_Id, String importer_Exporter_Name, String port_arrive_Name, String port_transite_Name, String c_transite_country_Name, String shipment_Mean_Name, String transport_Mean_Name, String ship_Name, int request_ApprovedUnapprovedID, boolean request_ApprovedUnapprovedType, String request_ApprovedUnapproved_StationName, String request_ApprovedUnapproved_Place_Ar_Name, String request_ApprovedUnapproved_Place_Address_Ar, String committee_Type, String check_Date, String requestCommittee_Status) {
//        this.$id = $id;
//        CheckRequest_Number = checkRequest_Number;
//        Reciever_Name = reciever_Name;
//        ImportCompany = importCompany;
//        ImportCountry_Name = importCountry_Name;
//        Outlet_Name = outlet_Name;
//        General_Admin_Name = general_Admin_Name;
//        PortNational_Shippment_Name = portNational_Shippment_Name;
//        Exporter_ID = exporter_ID;
//        ExporterType_Id = exporterType_Id;
//        Importer_Exporter_Id = importer_Exporter_Id;
//        Importer_Exporter_Name = importer_Exporter_Name;
//        this.port_arrive_Name = port_arrive_Name;
//        this.port_transite_Name = port_transite_Name;
//        this.c_transite_country_Name = c_transite_country_Name;
//        Shipment_Mean_Name = shipment_Mean_Name;
//        Transport_Mean_Name = transport_Mean_Name;
//        Ship_Name = ship_Name;
//        Request_ApprovedUnapprovedID = request_ApprovedUnapprovedID;
//        Request_ApprovedUnapprovedType = request_ApprovedUnapprovedType;
//        Request_ApprovedUnapproved_StationName = request_ApprovedUnapproved_StationName;
//        Request_ApprovedUnapproved_Place_Ar_Name = request_ApprovedUnapproved_Place_Ar_Name;
//        Request_ApprovedUnapproved_Place_Address_Ar = request_ApprovedUnapproved_Place_Address_Ar;
//        Committee_Type = committee_Type;
//        Check_Date = check_Date;
//        RequestCommittee_Status = requestCommittee_Status;
//    }
//
//    public String get$id() {
//        return $id;
//    }
//
//    public void set$id(String $id) {
//        this.$id = $id;
//    }
//
//    public int getCheckRequest_Number() {
//        return CheckRequest_Number;
//    }
//
//    public void setCheckRequest_Number(int checkRequest_Number) {
//        CheckRequest_Number = checkRequest_Number;
//    }
//
//    public String getReciever_Name() {
//        return Reciever_Name;
//    }
//
//    public void setReciever_Name(String reciever_Name) {
//        Reciever_Name = reciever_Name;
//    }
//
//    public String getImportCompany() {
//        return ImportCompany;
//    }
//
//    public void setImportCompany(String importCompany) {
//        ImportCompany = importCompany;
//    }
//
//    public String getImportCountry_Name() {
//        return ImportCountry_Name;
//    }
//
//    public void setImportCountry_Name(String importCountry_Name) {
//        ImportCountry_Name = importCountry_Name;
//    }
//
//    public String getOutlet_Name() {
//        return Outlet_Name;
//    }
//
//    public void setOutlet_Name(String outlet_Name) {
//        Outlet_Name = outlet_Name;
//    }
//
//    public String getGeneral_Admin_Name() {
//        return General_Admin_Name;
//    }
//
//    public void setGeneral_Admin_Name(String general_Admin_Name) {
//        General_Admin_Name = general_Admin_Name;
//    }
//
//    public String getPortNational_Shippment_Name() {
//        return PortNational_Shippment_Name;
//    }
//
//    public void setPortNational_Shippment_Name(String portNational_Shippment_Name) {
//        PortNational_Shippment_Name = portNational_Shippment_Name;
//    }
//
//    public int getExporter_ID() {
//        return Exporter_ID;
//    }
//
//    public void setExporter_ID(int exporter_ID) {
//        Exporter_ID = exporter_ID;
//    }
//
//    public int getExporterType_Id() {
//        return ExporterType_Id;
//    }
//
//    public void setExporterType_Id(int exporterType_Id) {
//        ExporterType_Id = exporterType_Id;
//    }
//
//    public int getImporter_Exporter_Id() {
//        return Importer_Exporter_Id;
//    }
//
//    public void setImporter_Exporter_Id(int importer_Exporter_Id) {
//        Importer_Exporter_Id = importer_Exporter_Id;
//    }
//
//    public String getImporter_Exporter_Name() {
//        return Importer_Exporter_Name;
//    }
//
//    public void setImporter_Exporter_Name(String importer_Exporter_Name) {
//        Importer_Exporter_Name = importer_Exporter_Name;
//    }
//
//    public String getPort_arrive_Name() {
//        return port_arrive_Name;
//    }
//
//    public void setPort_arrive_Name(String port_arrive_Name) {
//        this.port_arrive_Name = port_arrive_Name;
//    }
//
//    public String getPort_transite_Name() {
//        return port_transite_Name;
//    }
//
//    public void setPort_transite_Name(String port_transite_Name) {
//        this.port_transite_Name = port_transite_Name;
//    }
//
//    public String getC_transite_country_Name() {
//        return c_transite_country_Name;
//    }
//
//    public void setC_transite_country_Name(String c_transite_country_Name) {
//        this.c_transite_country_Name = c_transite_country_Name;
//    }
//
//    public String getShipment_Mean_Name() {
//        return Shipment_Mean_Name;
//    }
//
//    public void setShipment_Mean_Name(String shipment_Mean_Name) {
//        Shipment_Mean_Name = shipment_Mean_Name;
//    }
//
//    public String getTransport_Mean_Name() {
//        return Transport_Mean_Name;
//    }
//
//    public void setTransport_Mean_Name(String transport_Mean_Name) {
//        Transport_Mean_Name = transport_Mean_Name;
//    }
//
//    public String getShip_Name() {
//        return Ship_Name;
//    }
//
//    public void setShip_Name(String ship_Name) {
//        Ship_Name = ship_Name;
//    }
//
//    public int getRequest_ApprovedUnapprovedID() {
//        return Request_ApprovedUnapprovedID;
//    }
//
//    public void setRequest_ApprovedUnapprovedID(int request_ApprovedUnapprovedID) {
//        Request_ApprovedUnapprovedID = request_ApprovedUnapprovedID;
//    }
//
//    public boolean isRequest_ApprovedUnapprovedType() {
//        return Request_ApprovedUnapprovedType;
//    }
//
//    public void setRequest_ApprovedUnapprovedType(boolean request_ApprovedUnapprovedType) {
//        Request_ApprovedUnapprovedType = request_ApprovedUnapprovedType;
//    }
//
//    public String getRequest_ApprovedUnapproved_StationName() {
//        return Request_ApprovedUnapproved_StationName;
//    }
//
//    public void setRequest_ApprovedUnapproved_StationName(String request_ApprovedUnapproved_StationName) {
//        Request_ApprovedUnapproved_StationName = request_ApprovedUnapproved_StationName;
//    }
//
//    public String getRequest_ApprovedUnapproved_Place_Ar_Name() {
//        return Request_ApprovedUnapproved_Place_Ar_Name;
//    }
//
//    public void setRequest_ApprovedUnapproved_Place_Ar_Name(String request_ApprovedUnapproved_Place_Ar_Name) {
//        Request_ApprovedUnapproved_Place_Ar_Name = request_ApprovedUnapproved_Place_Ar_Name;
//    }
//
//    public String getRequest_ApprovedUnapproved_Place_Address_Ar() {
//        return Request_ApprovedUnapproved_Place_Address_Ar;
//    }
//
//    public void setRequest_ApprovedUnapproved_Place_Address_Ar(String request_ApprovedUnapproved_Place_Address_Ar) {
//        Request_ApprovedUnapproved_Place_Address_Ar = request_ApprovedUnapproved_Place_Address_Ar;
//    }
//
//    public String getCommittee_Type() {
//        return Committee_Type;
//    }
//
//    public void setCommittee_Type(String committee_Type) {
//        Committee_Type = committee_Type;
//    }
//
//    public String getCheck_Date() {
//        return Check_Date;
//    }
//
//    public void setCheck_Date(String check_Date) {
//        Check_Date = check_Date;
//    }
//
//    public String getRequestCommittee_Status() {
//        return RequestCommittee_Status;
//    }
//
//    public void setRequestCommittee_Status(String requestCommittee_Status) {
//        RequestCommittee_Status = requestCommittee_Status;
//    }
//}
