package com.zeroplus.zeroplus_legal.lawChamber.Modals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeroplus.zeroplus_legal.R;
import com.zeroplus.zeroplus_legal.lawChamber.Interfaces.appoinments;

import java.util.List;

public class adapter_appointments extends RecyclerView.Adapter<adapter_appointments.ViewHolder> {

    /*private final appoinments appoinments;*/
    List<list_appoinments> appoinmentsItems;
    private Context context;

    public adapter_appointments(/*com.zeroplus.zeroplus_legal.lawChamber.Interfaces.appoinments appoinments,*/ List<list_appoinments> appoinmentsItems, Context context) {
        /*this.appoinments = appoinments;*/
        this.appoinmentsItems = appoinmentsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_appoinments,parent,false);

        return new ViewHolder(view/*,appoinments*/);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        list_appoinments listItems = appoinmentsItems.get(position);
        holder.txtClientName.setText(listItems.getClientName());
        holder.eventSDate.setText(listItems.getEventStartDate());
        holder.eventEDate.setText(listItems.getEventEndDate());
        holder.txtEventDetails.setText(listItems.getEventDetails());

    }

    @Override
    public int getItemCount() {
        return appoinmentsItems.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtClientName, eventSDate, eventEDate, txtEventDetails;

        public ViewHolder(@NonNull View itemView/*, appoinments appoinments*/) {
            super(itemView);

            txtClientName = (TextView) itemView.findViewById(R.id.txtClientName);
            eventSDate = (TextView) itemView.findViewById(R.id.eventSDate);
            eventEDate = (TextView) itemView.findViewById(R.id.eventEDate);
            txtEventDetails = (TextView) itemView.findViewById(R.id.txtEventDetails);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(appoinments != null){
                        int pos = getBindingAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            appoinments.onItemClick(pos);
                        }
                    }
                }
            });*/

        }
    }

}
