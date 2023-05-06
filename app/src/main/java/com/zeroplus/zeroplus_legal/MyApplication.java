package com.zeroplus.zeroplus_legal;

import android.app.Application;

public class MyApplication extends Application {

    private String errCode;

    private String id;
    private String name;

    /*After Login Information*/
    private String lName;
    private String lEmail;
    private String lPhone;
    private String lUname;
    private String lRefer;




    private String phone;
    private String Rname;
    private String email;
    private String password;
    private String refcode;
    

    private String OTP;
    
    


    /*private String BaseURL="http://128.199.193.12/zeroplus/public/api/";
    private String webBaseURL="http://128.199.193.12/zeroplus/public/api/";
    private String DataURL="http://128.199.193.12/zeroplus/public/";
    private String ApiUrl="http://128.199.193.12/zeroplus/public/api/auth/";*/
    private String BaseURL="https://zeroplus.world/api/";
    private String webBaseURL="https://zeroplus.world/api/";
    private String DataURL="https://zeroplus.world/";
    private String ApiUrl="https://zeroplus.world/api/auth/";

    private String CatId;
    private String CatTitle;
    private String SubCatId;
    private String SubCatTitle;


    /*Veriables*/

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
//        return id;
    }

    public String getName() {
        return name;
    }
    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRname() {
        return Rname;
    }

    public void setRname(String rname) {
        Rname = rname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRefcode() {
        return refcode;
    }

    public void setRefcode(String refcode) {
        this.refcode = refcode;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getCatId() {
        return CatId;
    }

    public void setCatId(String catId) {
        CatId = catId;
    }

    public String getCatTitle() {
        return CatTitle;
    }

    public void setCatTitle(String catTitle) {
        CatTitle = catTitle;
    }

    public String getSubCatId() {
        return SubCatId;
    }

    public void setSubCatId(String subCatId) {
        SubCatId = subCatId;
    }

    public String getSubCatTitle() {
        return SubCatTitle;
    }

    public void setSubCatTitle(String subCatTitle) {
        SubCatTitle = subCatTitle;
    }


    /*After Login*/

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlEmail() {
        return lEmail;
    }

    public void setlEmail(String lEmail) {
        this.lEmail = lEmail;
    }

    public String getlPhone() {
        return lPhone;
    }

    public void setlPhone(String lPhone) {
        this.lPhone = lPhone;
    }

    public String getlUname() {
        return lUname;
    }

    public void setlUname(String lUname) {
        this.lUname = lUname;
    }

    public String getlRefer() {
        return lRefer;
    }

    public void setlRefer(String lRefer) {
        this.lRefer = lRefer;
    }

    /*URLS*/
    public String getBaseURL() {
        return BaseURL;
    }
    public void setBaseURL(String baseURL) {
        BaseURL = baseURL;
    }
    public String getWebBaseURL() {
        return webBaseURL;
    }
    public void setWebBaseURL(String webBaseURL) {
        this.webBaseURL = webBaseURL;
    }
    public String getDataURL() {
        return DataURL;
    }
    public void setDataURL(String dataURL) {
        DataURL = dataURL;
    }
    public String getApiUrl() {
        return ApiUrl;
    }
    public void setApiUrl(String apiUrl) {
        ApiUrl = apiUrl;
    }
}
