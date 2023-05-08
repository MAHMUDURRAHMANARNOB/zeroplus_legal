package com.zeroplus.zeroplus_legal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zeroplus.zeroplus_legal.databinding.FragmentEarningsBinding;

public class EarningsFragment extends Fragment {

    private FragmentEarningsBinding binding;

    LinearLayout EH,WR,WH;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_earnings, container, false);
        binding = FragmentEarningsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EH = (LinearLayout) view.findViewById(R.id.LLEH);
        WR = (LinearLayout) view.findViewById(R.id.LLWR);
        WH = (LinearLayout) view.findViewById(R.id.LLWH);

        EH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(getActivity(), com.zeroplus.zeroplus_legal.Earnings.EarningHistory.class);
                startActivity(Int);
            }
        });
        WR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(getActivity(), com.zeroplus.zeroplus_legal.Earnings.WithdrawRequest.class);
                startActivity(Int);
            }
        });
        WH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Int = new Intent(getActivity(), com.zeroplus.zeroplus_legal.Earnings.WithdrawHistory.class);
                startActivity(Int);
            }
        });



    }
}