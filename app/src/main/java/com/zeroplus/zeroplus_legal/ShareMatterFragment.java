package com.zeroplus.zeroplus_legal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.zeroplus.zeroplus_legal.databinding.FragmentShareMatterBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShareMatterFragment extends Fragment {
    TextView txtUsername;
    Spinner ServiceSpin,SubServiceSpin;

    ArrayList<String> serviceList= new ArrayList<>();
    ArrayList<String> subserviceList = new ArrayList<>();

    ArrayList<String> serviceIdList = new ArrayList<>();

    ArrayAdapter<String> serviceAdapter;
    ArrayAdapter<String> subServiceAdapter;


    private FragmentShareMatterBinding binding;
    Button Logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_share_matter, container, false);
         ServiceSpin = (Spinner) view.findViewById(R.id.selectService);
         SubServiceSpin = (Spinner) view.findViewById(R.id.selectsubField);
         Logout=(Button) view.findViewById(R.id.btnlogout);
        /*serviceSpinner();*/
        /*subserviceSpinner();*/
        binding = FragmentShareMatterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyApplication globalVariable = (MyApplication) getActivity().getApplication();
        txtUsername=(TextView) view.findViewById(R.id.txtUsername);
        Logout=(Button) view.findViewById(R.id.btnlogout);
        String Name  = globalVariable.getName();
        txtUsername.setText(Name);

        ServiceSpin = (Spinner) view.findViewById(R.id.selectService);
        SubServiceSpin = (Spinner) view.findViewById(R.id.selectsubField);
        serviceSpinner();
        /*subserviceSpinner();*/

        binding.btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.btnsharematter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You are already in Home Page", Toast.LENGTH_LONG).show();
            }
        });
        binding.btndashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*NavHostFragment.findNavController(ShareMatterFragment.this)
                        .navigate(R.id.action_shareMatterFragment_to_zeroplusWebviewFragment);*/
            }
        });
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "flase");
                editor.apply();

                String logout = "Logged Out";
                Toast toast = Toast.makeText(
                        getActivity().getApplicationContext(),
                        Html.fromHtml("<h3><font color='#87CEEB'>"  +logout+  "</font></h3>"),
                        Toast.LENGTH_LONG);

                // Set the Toast display position layout center
                toast.setGravity(Gravity.CENTER,0,50);
                // Finally, show the toast
                int lengthShort = Toast.LENGTH_SHORT;
                toast.setDuration(lengthShort);
                toast.show();

                Intent intent = new Intent(getActivity(),
                        MainActivity.class);

                startActivity(intent);


            }
        });

    }

    private void serviceSpinner() {

        MyApplication globalVariable = (MyApplication) getActivity().getApplication();

        String ApiUrl=((MyApplication) getActivity().getApplication()).getApiUrl()+"android/categorydata";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ApiUrl,null,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("request",response.toString());
                        try {
                                JSONArray jsonArrayCD = new JSONArray(response.getString("service_list"));

                                for (int i=0;i<jsonArrayCD.length();i++){
                                    JSONObject jsonObject  = jsonArrayCD.getJSONObject(i);
                                    String cat_id = jsonObject.getString("id");
                                    String cat_title = jsonObject.getString("name");

                                    serviceList.add(cat_title);
                                    serviceIdList.add(cat_id);

                                    serviceAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item,serviceList);
                                    serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    ServiceSpin.setAdapter(serviceAdapter);

                                    /*categoryList cl = new categoryList();*/
                                    globalVariable.setCatId(cat_id);
                                    globalVariable.setCatId(cat_title);
                                }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "error", Toast.LENGTH_LONG).show();
                        Log.d("inside Else",error.toString());
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);

        ServiceSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                MyApplication globalVariable = (MyApplication) getActivity().getApplication();

                /*int selectedService = adapterView.getSelectedItemPosition();*/
                String selectedService = adapterView.getSelectedItem().toString();
                /*String CatId =  globalVariable.getCatId();*/
                /*Log.d("position", String.valueOf(selectedService));*/

                if(adapterView.getId() == R.id.selectService){
                    JSONObject parameter = new JSONObject();
                    try {
                        parameter.put("cat_name", selectedService);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    subserviceList.clear();

                    String ApiUrl1=((MyApplication) getActivity().getApplication()).getApiUrl()+"android/subcategorydata"/*+selectedService*/;
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ApiUrl1,parameter,
                            new Response.Listener<JSONObject>(){

                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.d("request",response.toString());
                                    try {

                                        JSONArray jsonArraySSL = new JSONArray(response.getString("sub_service_list"));

                                        for (int i=0;i<jsonArraySSL.length();i++){
                                            JSONObject jsonObject  = jsonArraySSL.getJSONObject(i);
                                            String subcat_id = jsonObject.getString("id");
                                            String subcat_title = jsonObject.getString("title");

                                            subserviceList.add(subcat_title);
                                            subServiceAdapter = new ArrayAdapter<>(getActivity(), R.layout.spinner_item,subserviceList);
                                            subServiceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            SubServiceSpin.setAdapter(subServiceAdapter);

                                            globalVariable.setSubCatId(subcat_id);
                                            globalVariable.setSubCatId(subcat_title);
                                        }

                                    }
                                    catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener()
                            {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                                    Log.d("inside Else",error.toString());
                                }
                            });
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    queue.add(request);

                    /*SubServiceSpin.setOnItemSelectedListener(this);*/
                    SubServiceSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
                else{
                    Toast.makeText(getActivity(), "Select Service first", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }
}