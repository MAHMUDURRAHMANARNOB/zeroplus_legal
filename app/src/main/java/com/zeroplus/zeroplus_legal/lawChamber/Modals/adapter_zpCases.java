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

public class adapter_zpCases extends RecyclerView.Adapter<adapter_zpCases.ViewHolder> {

    List<list_zpCases> zpcasesItems;
    private Context context;

    public adapter_zpCases(List<list_zpCases> zpcasesItems, Context context) {
        this.zpcasesItems = zpcasesItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_zpcases,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        list_zpCases listItems = zpcasesItems.get(position);
        holder._fileName.setText(listItems.getFileName());
        holder._caseNo.setText(listItems.getCaseNo());
        holder._fileNo.setText(listItems.getFileNo());
        holder._fileingDate.setText(listItems.getFilingDate());
        holder._caseStatus.setText(listItems.getCaseStatus());
        holder._judgementStatus.setText(listItems.getJudgementStatus());
        holder._position.setText(listItems.getPosition());
    }

    @Override
    public int getItemCount() {
        return zpcasesItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView _fileName,_caseNo,_fileNo,_fileingDate, _caseStatus,_judgementStatus, _position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            _fileName = (TextView) itemView.findViewById(R.id._fileName);
            _caseNo = (TextView) itemView.findViewById(R.id._caseNo);
            _fileNo = (TextView) itemView.findViewById(R.id._fileNo);
            _fileingDate = (TextView) itemView.findViewById(R.id._fileingDate);
            _caseStatus = (TextView) itemView.findViewById(R.id._caseStatus);
            _judgementStatus = (TextView) itemView.findViewById(R.id._judgementStatus);
            _position = (TextView) itemView.findViewById(R.id._position);
        }
    }
}
