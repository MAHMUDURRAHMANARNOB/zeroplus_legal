package com.zeroplus.zeroplus_legal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zeroplus.zeroplus_legal.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    TextView Name, Email, Phone, Bio ;
    Button EditProfile;

    private FragmentProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Name = view.findViewById(R.id.txtName);
        Phone = view.findViewById(R.id.txtPhoneNo);
        EditProfile = view.findViewById(R.id.btnEditProfile);

        EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ProSettInt = new Intent(getActivity(),ProfileSettingsActivity.class);
                startActivity(ProSettInt);
            }
        });

        /*Set Veriables*/
        MyApplication globalVariable = (MyApplication) getActivity().getApplication();
        String name = globalVariable.getlName();
        String phone = globalVariable.getlPhone();
        Name.setText(name);
        Phone.setText(phone);
        if(name!=null){
            Log.d("name",name);
        }
        else{
            Log.d("name","not Found");
        }


    }
}