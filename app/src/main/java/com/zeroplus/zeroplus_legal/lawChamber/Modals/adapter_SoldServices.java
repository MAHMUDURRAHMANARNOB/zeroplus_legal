package com.zeroplus.zeroplus_legal.lawChamber.Modals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeroplus.zeroplus_legal.R;

import java.util.List;

public class adapter_SoldServices extends RecyclerView.Adapter<adapter_SoldServices.ViewHolder> {

    List<list_SoldServices> soldServicesItems;
    private Context context;

    public adapter_SoldServices(List<list_SoldServices> soldServicesItems, Context context) {
        this.soldServicesItems = soldServicesItems;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter_SoldServices.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_sold_services, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_SoldServices.ViewHolder holder, int position) {

        list_SoldServices listItem = soldServicesItems.get(position);
        holder.txtServiceTitle.setText(listItem.getServiceTitle());
        holder.txtClientName.setText(listItem.getClientName());
        holder.txtServiceType.setText(listItem.getServiceType());
        holder.txtSoldDate.setText(listItem.getSoldDate());
        holder.txtTotalAmount.setText(listItem.getAmount());
        holder.txtStatus.setText(listItem.getStatus());
        holder.txtMyEarnings.setText(listItem.getMyEarnings());

    }

    @Override
    public int getItemCount() {
        return soldServicesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtServiceTitle, txtClientName, txtServiceType, txtSoldDate, txtTotalAmount, txtStatus, txtMyEarnings;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtServiceTitle = (TextView) itemView.findViewById(R.id.txtServiceTitle);
            txtClientName = (TextView) itemView.findViewById(R.id.txtClientName);
            txtServiceType = (TextView) itemView.findViewById(R.id.txtServiceType);
            txtSoldDate = (TextView) itemView.findViewById(R.id.txtSoldDate);
            txtTotalAmount = (TextView) itemView.findViewById(R.id.txtTotalAmount);
            txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
            txtMyEarnings = (TextView) itemView.findViewById(R.id.txtMyEarnings);
        }
    }
}
