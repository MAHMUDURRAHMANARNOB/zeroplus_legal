package com.zeroplus.zeroplus_legal.Earnings.Models;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeroplus.zeroplus_legal.R;

import java.util.List;

public class adapter_earnings extends RecyclerView.Adapter<adapter_earnings.ViewHolder> {

    List<list_Earnings> earningItems;
    private Context context;

    public adapter_earnings(List<list_Earnings> earningItems, Context context) {
        this.earningItems = earningItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_earnig_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        list_Earnings listitem = earningItems.get(position);

        holder.txtProjectName.setText(listitem.getProjectName());
        holder.paid_amount.setText(listitem.getPaidAmount());
        holder.your_earings.setText(listitem.getYourEarnings());
        holder.platform_charge.setText(listitem.getAdminCharge());
        holder.paid_date.setText(listitem.getPaidAt());

    }

    @Override
    public int getItemCount() {
        return earningItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtProjectName, paid_amount, your_earings, platform_charge, paid_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProjectName = (TextView) itemView.findViewById(R.id.txtProjectName);
            paid_amount = (TextView) itemView.findViewById(R.id.paid_amount);
            your_earings = (TextView) itemView.findViewById(R.id.your_earings);
            platform_charge = (TextView) itemView.findViewById(R.id.platform_charge);
            paid_date = (TextView) itemView.findViewById(R.id.paid_date);
        }
    }
}
