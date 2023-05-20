package com.zeroplus.zeroplus_legal.lawChamber.Modals;

public class list_SoldServices {

    private String ServiceTitle, ClientName, ServiceType, Amount, MyEarnings, SoldDate, Status;

    public list_SoldServices(String serviceTitle, String clientName, String serviceType, String amount, String myEarnings, String soldDate, String status) {
        ServiceTitle = serviceTitle;
        ClientName = clientName;
        ServiceType = serviceType;
        Amount = amount;
        MyEarnings = myEarnings;
        SoldDate = soldDate;
        Status = status;
    }

    public String getServiceTitle() {
        return ServiceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        ServiceTitle = serviceTitle;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getMyEarnings() {
        return MyEarnings;
    }

    public void setMyEarnings(String myEarnings) {
        MyEarnings = myEarnings;
    }

    public String getSoldDate() {
        return SoldDate;
    }

    public void setSoldDate(String soldDate) {
        SoldDate = soldDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
