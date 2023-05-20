package com.zeroplus.zeroplus_legal.lawChamber.Modals;

import android.animation.LayoutTransition;
import android.content.Context;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeroplus.zeroplus_legal.R;

import java.util.List;

public class adapter_courts extends RecyclerView.Adapter<adapter_courts.ViewHolder> {

    List<list_courts> courtsItems;
    private Context context;



    public adapter_courts(List<list_courts> courtsItems, Context context) {
        this.courtsItems = courtsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_courts, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        list_courts listItem = courtsItems.get(position);
        holder.txtCourtName.setText(listItem.getCourtName());
        holder.txtEmail.setText(listItem.getEmail());
        holder.roomNo.setText(listItem.getRoomNo());
        holder.txtCity.setText(listItem.getCity());
        holder.txtCountry.setText(listItem.getCountry());
        holder.txtDesc.setText(listItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return courtsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtCourtName, txtEmail, roomNo, txtCity, txtCountry,txtDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCourtName = (TextView) itemView.findViewById(R.id.txtCourtName);
            txtEmail = (TextView) itemView.findViewById(R.id.txtEmail);
            roomNo = (TextView) itemView.findViewById(R.id.roomNo);
            txtCity = (TextView) itemView.findViewById(R.id.txtCity);
            txtCountry = (TextView) itemView.findViewById(R.id.txtCountry);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
        }
    }
}
