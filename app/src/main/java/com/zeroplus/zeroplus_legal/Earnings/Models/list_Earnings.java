package com.zeroplus.zeroplus_legal.Earnings.Models;

public class list_Earnings {

    private String ProjectName, PaidAmount, YourEarnings, PaidAt, AdminCharge;

    public list_Earnings(String projectName, String paidAmount, String yourEarnings, String paidAt, String adminCharge) {
        ProjectName = projectName;
        PaidAmount = paidAmount;
        YourEarnings = yourEarnings;
        PaidAt = paidAt;
        AdminCharge = adminCharge;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getPaidAmount() {
        return PaidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        PaidAmount = paidAmount;
    }

    public String getYourEarnings() {
        return YourEarnings;
    }

    public void setYourEarnings(String yourEarnings) {
        YourEarnings = yourEarnings;
    }

    public String getPaidAt() {
        return PaidAt;
    }

    public void setPaidAt(String paidAt) {
        PaidAt = paidAt;
    }

    public String getAdminCharge() {
        return AdminCharge;
    }

    public void setAdminCharge(String adminCharge) {
        AdminCharge = adminCharge;
    }
}
