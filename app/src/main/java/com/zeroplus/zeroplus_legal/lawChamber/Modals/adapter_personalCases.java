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

public class adapter_personalCases extends RecyclerView.Adapter<adapter_personalCases.ViewHolder> {

    List<list_personalCases> personalCasesItems;
    private Context context;

    public adapter_personalCases(List<list_personalCases> personalCasesItems, Context context) {
        this.personalCasesItems = personalCasesItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_personal_cases, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        list_personalCases listItems = personalCasesItems.get(position);
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
        return personalCasesItems.size();
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
