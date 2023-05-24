package com.zeroplus.zeroplus_legal.lawChamber.Modals;

public class list_sections {
    private String Sectionname, SectionDetails;

    public list_sections(String sectionname, String sectionDetails) {
        Sectionname = sectionname;
        SectionDetails = sectionDetails;
    }

    public String getSectionname() {
        return Sectionname;
    }

    public void setSectionname(String sectionname) {
        Sectionname = sectionname;
    }

    public String getSectionDetails() {
        return SectionDetails;
    }

    public void setSectionDetails(String sectionDetails) {
        SectionDetails = sectionDetails;
    }
}
