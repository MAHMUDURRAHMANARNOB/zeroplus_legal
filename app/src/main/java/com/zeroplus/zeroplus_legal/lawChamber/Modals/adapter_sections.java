package com.zeroplus.zeroplus_legal.lawChamber.Modals;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeroplus.zeroplus_legal.Earnings.Models.adapter_earnings;
import com.zeroplus.zeroplus_legal.R;

import java.util.List;

public class adapter_sections extends RecyclerView.Adapter<adapter_sections.ViewHolder> {

    List<list_sections> sectionsList;
    private Context context;

    public adapter_sections(List<list_sections> sectionsList, Context context) {
        this.sectionsList = sectionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_sections,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        list_sections listItem = sectionsList.get(position);

        holder.txtSectionName.setText(listItem.getSectionname());
        holder.txtDetails.setText(listItem.getSectionDetails());


    }

    @Override
    public int getItemCount() {
        return sectionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtSectionName, txtDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSectionName = (TextView) itemView.findViewById(R.id.txtSectionName);
            txtDetails = (TextView) itemView.findViewById(R.id.txtDetails);
        }
    }

}
