package com.zeroplus.zeroplus_legal;

import static android.widget.Toast.LENGTH_SHORT;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.zeroplus.zeroplus_legal.databinding.FragmentEnabelCodeBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EnabelCodeFragment extends Fragment {


    Button proceedbtn;
    private FragmentEnabelCodeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_enabel_code, container, false);


        binding = FragmentEnabelCodeBinding.inflate(inflater, container, false);
        return binding.getRoot();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtPhone=(TextView) view.findViewById(R.id.txtPhone);
        TextInputEditText TFOTP = (TextInputEditText) view.findViewById(R.id.TFOTP);

        MyApplication globalVariable = (MyApplication) getActivity().getApplication();
        String Phone  = globalVariable.getPhone();

        txtPhone.setText(Phone);

        /*binding.proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                *//*NavHostFragment.findNavController(EnabelCodeFragment.this)
                        .navigate(R.id.action_enabelCodeFragment_to_zeroplusWebviewFragment);

                    Toast.makeText(getActivity(), "--> Success <--", Toast.LENGTH_LONG).show();*//*
            }
        });*/

        binding.proceedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String OTP  = globalVariable.getOTP();
                String InputOtp = TFOTP.getText().toString().trim();
                Log.d("OTP",OTP);
                Log.d("I-OTP",InputOtp);

                if(!Objects.equals(OTP, InputOtp)){
                    String info = "Invalid OTP";
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setIcon(R.drawable.ic_baseline_error_24);
                    builder.setMessage(info);
                    builder.setTitle("Error !!");
                    builder.setCancelable(true);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                    Log.d("OTP",info);

                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(),"Congratulations..!!",Toast.LENGTH_SHORT).show();

                    /*Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            Intent i = new Intent(getActivity().getApplicationContext(),DashboardActivity.class);
                            startActivity(i);
                            getActivity().finish();

                        }
                    });
                    thread.start();*/

                    registration();
                }

            }
        });
    }
    private void registration(){

        //API
        /*String Mobile=TFMobile.getText().toString().trim();*/

        MyApplication globalVariable = (MyApplication) getActivity().getApplication();

        String Phone = globalVariable.getPhone();
        String Name = globalVariable.getRname();
        String RefCode = globalVariable.getRefcode();
        String Email = globalVariable.getEmail();
        String Password = globalVariable.getPassword();
        /*globalVariable.setMobileNo(Mobile);*/


        //parameter sending to the API
        JSONObject parameter = new JSONObject();
        try {

            parameter.put("name", Name);
            parameter.put("email", Email);
            parameter.put("phone", Phone);
            parameter.put("password", Password);
            parameter.put("refer", RefCode);


            Log.d("username in", Name+"\t"+Email+"\t"+Phone+"\t"+Password+"\t"+RefCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // Calling Application class (see application tag in AndroidManifest.xml)

        String ApiUrl = ((MyApplication) getActivity().getApplication()).getBaseURL()+"auth/signup";
        /*String ApiUrl = "http://128.199.193.12/zeroplus20/public/api/auth/signup";*/
        //Response From API
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, ApiUrl ,parameter,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            /*String msg = response.getString("msg");
                            String errcode= response.getString("errcode");
                            globalVariable.setErrCode(errcode);
                            Log.d("result", msg);
                            Log.d("errcode", errcode);*/
                            /*parse from response*/
                            Boolean result = response.getBoolean("result");
                            Log.d("result", String.valueOf(result));
                            String userId = response.getString("user_id");
                            Log.d("user_id", userId);
                            globalVariable.setId(userId);

                            /*Valid Registration*/
                            /*if(errcode.equals("200")){*/

                                Toast.makeText(getActivity(), "Success", LENGTH_SHORT).show();

                                /*Start Dashboard*/
                                Thread thread = new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        /*sleep(3000);*/

                                        Intent i = new Intent(getActivity().getApplicationContext(),DashboardActivity.class);
                                        startActivity(i);
                                        getActivity().finish();

                                    }
                                });
                                thread.start();
                            /*}*/

                            /*Invalid Registration*/
                            /*else if(errcode.equals("100")){
                                String info = "Invalid UserName or Password";
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setIcon(R.drawable.ic_baseline_error_24);
                                builder.setMessage(info);
                                builder.setTitle("Error !!");
                                builder.setCancelable(true);
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            }*/

                            Log.d("response",response.toString());

                        } catch (JSONException e) {

                            String erroruser = "Refer Code not Valid";
                            Toast toast = Toast.makeText(
                                    getActivity().getApplicationContext(),
                                    Html.fromHtml("<h3><font color='#ff0000'>"  +erroruser+  "</font></h3>"),
                                    Toast.LENGTH_LONG);

                            // Set the Toast display position layout center
                            toast.setGravity(Gravity.CENTER,0,50);
                            // Finally, show the toast
                            int lengthShort = Toast.LENGTH_SHORT;
                            toast.setDuration(lengthShort);
                            toast.show();
                            //custom toast end

                            e.printStackTrace();
                        }
                        /*Log.d("Response From API",response.toString());*/
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error", error.toString());
                        String errormsg = "Use Unique Email & Phone and Check Your Connection";
                        Toast toast = Toast.makeText(
                                getActivity().getApplicationContext(),
                                Html.fromHtml("<h3><font color='#ff0000'>"  +errormsg+  "</font></h3>"),
                                Toast.LENGTH_LONG);

                        // Set the Toast display position layout center
//                        toast.setGravity(Gravity.CENTER,0,0);
                        // Finally, show the toast
                        int lengthShort = Toast.LENGTH_SHORT;
                        toast.setDuration(lengthShort);
                        toast.show();
                    }
                })
        {
            @Override
            public Map<String, String> getParams()throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=utf-8");
                params.put("User-agent", System.getProperty("http.agent"));
                /*params.put("password", Password);*/

                return params;
            }

            @Override
            public Priority getPriority() {
                return Priority.IMMEDIATE;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }


}