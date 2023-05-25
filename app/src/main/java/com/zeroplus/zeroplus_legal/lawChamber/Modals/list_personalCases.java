package com.zeroplus.zeroplus_legal.lawChamber.Modals;

public class list_personalCases {

    private String FileName, CaseNo, FileNo, FilingDate, CaseStatus, JudgementStatus, Position;

    public list_personalCases(String fileName, String caseNo, String fileNo, String filingDate, String caseStatus, String judgementStatus, String position) {
        FileName = fileName;
        CaseNo = caseNo;
        FileNo = fileNo;
        FilingDate = filingDate;
        CaseStatus = caseStatus;
        JudgementStatus = judgementStatus;
        Position = position;
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public String getCaseNo() {
        return CaseNo;
    }

    public void setCaseNo(String caseNo) {
        CaseNo = caseNo;
    }

    public String getFileNo() {
        return FileNo;
    }

    public void setFileNo(String fileNo) {
        FileNo = fileNo;
    }

    public String getFilingDate() {
        return FilingDate;
    }

    public void setFilingDate(String filingDate) {
        FilingDate = filingDate;
    }

    public String getCaseStatus() {
        return CaseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        CaseStatus = caseStatus;
    }

    public String getJudgementStatus() {
        return JudgementStatus;
    }

    public void setJudgementStatus(String judgementStatus) {
        JudgementStatus = judgementStatus;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
}
