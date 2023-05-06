package com.zeroplus.zeroplus_legal.paymentInventory;

import com.zeroplus.zeroplus_legal.R;

import java.util.ArrayList;
import java.util.List;

public class data_PM {

    public static List<paymentMethod> getPM(){
        List<paymentMethod> pmList = new ArrayList<>();

        paymentMethod bKash = new paymentMethod();
        bKash.setPname("bKash");
        bKash.setPimage(R.drawable.bkash);
        pmList.add(bKash);

        paymentMethod Rocket = new paymentMethod();
        Rocket.setPname("Rocket");
        Rocket.setPimage(R.drawable.rocket);
        pmList.add(Rocket);

        paymentMethod Nagad = new paymentMethod();
        Nagad.setPname("Nagad");
        Nagad.setPimage(R.drawable.nagad);
        pmList.add(Nagad);

        paymentMethod Upay = new paymentMethod();
        Upay.setPname("Upay");
        Upay.setPimage(R.drawable.upay);
        pmList.add(Upay);

        return pmList;

    }
}
