package com.zeroplus.zeroplus_legal.lawChamber.Modals;

import android.graphics.Bitmap;

public class list_ServiceRequests {

    private String ClientName, ServiceName, ServicePrice, StartingDate, PackageType, CaseType;
    private Bitmap ClientImage;

    public list_ServiceRequests(String clientName, String serviceName, String servicePrice, String startingDate, String packageType, String caseType, Bitmap clientImage) {
        ClientName = clientName;
        ServiceName = serviceName;
        ServicePrice = servicePrice;
        StartingDate = startingDate;
        PackageType = packageType;
        CaseType = caseType;
        ClientImage = clientImage;
    }

    public Bitmap getClientImage() {
        return ClientImage;
    }

    public void setClientImage(Bitmap clientImage) {
        ClientImage = clientImage;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getServicePrice() {
        return ServicePrice;
    }

    public void setServicePrice(String servicePrice) {
        ServicePrice = servicePrice;
    }

    public String getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(String startingDate) {
        StartingDate = startingDate;
    }

    public String getPackageType() {
        return PackageType;
    }

    public void setPackageType(String packageType) {
        PackageType = packageType;
    }

    public String getCaseType() {
        return CaseType;
    }

    public void setCaseType(String caseType) {
        CaseType = caseType;
    }
}
