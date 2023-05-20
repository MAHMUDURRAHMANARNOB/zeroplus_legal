package com.zeroplus.zeroplus_legal.lawChamber.Modals;

public class list_courts {
    private String CourtName, Email, RoomNo, City, Country,Description;

    public list_courts(String courtName, String email, String roomNo, String city, String country, String description) {
        CourtName = courtName;
        Email = email;
        RoomNo = roomNo;
        City = city;
        Country = country;
        Description = description;
    }

    public String getCourtName() {
        return CourtName;
    }

    public void setCourtName(String courtName) {
        CourtName = courtName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(String roomNo) {
        RoomNo = roomNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
