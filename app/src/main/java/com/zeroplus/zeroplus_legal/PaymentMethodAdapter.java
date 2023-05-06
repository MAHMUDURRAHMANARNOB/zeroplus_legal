package com.zeroplus.zeroplus_legal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.paymentInventory.paymentMethod;

import java.util.List;

public class PaymentMethodAdapter extends BaseAdapter {
    private Context context;
    private List<paymentMethod> pmList;

    public PaymentMethodAdapter(Context context, List<paymentMethod> pmList) {
        this.context = context;
        this.pmList = pmList;
    }

    @Override
    public int getCount() {
        return pmList != null ? pmList.size():0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_payment_method,viewGroup,false);

        TextView txtName = rootView.findViewById(R.id.pm_item_txt);
        ImageView image = rootView.findViewById(R.id.pm_item_img);

        txtName.setText(pmList.get(i).getPname());
        image.setImageResource(pmList.get(i).getPimage());

        return rootView;
    }
}
