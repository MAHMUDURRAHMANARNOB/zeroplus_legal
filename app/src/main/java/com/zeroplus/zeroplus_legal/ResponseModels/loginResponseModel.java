package com.zeroplus.zeroplus_legal.ResponseModels;

public class loginResponseModel {

    String name, email, phone, username, refer;

    public loginResponseModel(String name, String email, String phone, String username, String refer) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.refer = refer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }
}
