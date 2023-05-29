package com.zeroplus.zeroplus_legal.lawChamber.Modals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeroplus.zeroplus_legal.R;

import java.util.List;

public class adapter_serviceRequest extends RecyclerView.Adapter<adapter_serviceRequest.ViewHolder> {

    List <list_ServiceRequests> serviceRequestsItems;
    private Context context;

    public adapter_serviceRequest(List<list_ServiceRequests> serviceRequestsItems, Context context) {
        this.serviceRequestsItems = serviceRequestsItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_service_requests, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        list_ServiceRequests listItems = serviceRequestsItems.get(position);
        holder._cientName.setText(listItems.getClientName());
        holder._serviceName.setText(listItems.getServiceName());
        holder._servicePrice.setText(listItems.getServicePrice());
        holder._startingDate.setText(listItems.getStartingDate());
        holder._package.setText(listItems.getPackageType());
        holder._caseType.setText(listItems.getCaseType());
        holder.clientImage.setImageBitmap(listItems.getClientImage());
    }

    @Override
    public int getItemCount() {
        return serviceRequestsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView _cientName,_serviceName,_servicePrice,_startingDate, _package,_caseType;
        public ImageView clientImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            _cientName = (TextView) itemView.findViewById(R.id._cientName);
            _serviceName = (TextView) itemView.findViewById(R.id._serviceName);
            _servicePrice = (TextView) itemView.findViewById(R.id._servicePrice);
            _startingDate = (TextView) itemView.findViewById(R.id._startingDate);
            _package = (TextView) itemView.findViewById(R.id._package);
            _caseType = (TextView) itemView.findViewById(R.id._caseType);
            clientImage = (ImageView) itemView.findViewById(R.id.clientImage);
        }
    }
}
