package com.zeroplus.zeroplus_legal.paymentInventory;

import java.io.Serializable;

public class paymentMethod implements Serializable {

    private String pname;
    private int pimage;


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPimage() {
        return pimage;
    }

    public void setPimage(int pimage) {
        this.pimage = pimage;
    }
}
