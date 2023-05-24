package com.zeroplus.zeroplus_legal.lawChamber.Modals;

public class list_appoinments {

    private String ClientName, EventStartDate, EventEndDate, EventDetails;

    public list_appoinments(String clientName, String eventStartDate, String eventEndDate, String eventDetails) {
        ClientName = clientName;
        EventStartDate = eventStartDate;
        EventEndDate = eventEndDate;
        EventDetails = eventDetails;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getEventStartDate() {
        return EventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        EventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return EventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        EventEndDate = eventEndDate;
    }

    public String getEventDetails() {
        return EventDetails;
    }

    public void setEventDetails(String eventDetails) {
        EventDetails = eventDetails;
    }
}
