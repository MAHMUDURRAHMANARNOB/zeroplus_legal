package com.zeroplus.zeroplus_legal;

import static android.widget.Toast.LENGTH_SHORT;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.zeroplus.zeroplus_legal.databinding.FragmentForgerPassBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ForgerPassFragment extends Fragment {

    TextInputEditText PhoneEmail;
    Button Reset, Signup, getbackLogin;

    private FragmentForgerPassBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forger_pass, container, false);
        binding = FragmentForgerPassBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PhoneEmail = (TextInputEditText) view.findViewById(R.id.userid_phone_email);
        Reset = (Button) view.findViewById(R.id.btnResetPass);
        Signup = (Button) view.findViewById(R.id.btnSignUp);

        Dialog dialog = new Dialog(getActivity());


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ForgerPassFragment.this)
                        .navigate(R.id.action_forgerPassFragment_to_registrationFragment);
            }
        });

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processData();

                dialog.setContentView(R.layout.custom_dialogbox_forgetpass);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                /*dialog.setCancelable(false);*/
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.animation;
                dialog.show();

                getbackLogin = dialog.findViewById(R.id.btnLoginPage);
                getbackLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        NavHostFragment.findNavController(ForgerPassFragment.this)
                                .navigate(R.id.action_forgerPassFragment_to_loginFragment);

                    }
                });
            }
        });
    }

    private void processData(){

        //API
        String MobileEmail=PhoneEmail.getText().toString().trim();
        /*globalVariable.setMobileNo(Mobile);*/
        //parameter sending to the API
        JSONObject parameter = new JSONObject();
        try {

            parameter.put("phone", MobileEmail);

            Log.d("Phone in", MobileEmail);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Calling Application class (see application tag in AndroidManifest.xml)

        String ApiUrl = ((MyApplication) getActivity().getApplication()).getBaseURL()+"auth/updatepassword";
        /*String ApiUrl = "http://128.199.193.12/zeroplus20/public/api/auth/updatepassword";*/
        //Response From API
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, ApiUrl ,parameter,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            Boolean result = response.getBoolean("result");
                            Toast.makeText(getActivity(), "Success", LENGTH_SHORT).show();
                            Log.d("response",response.toString());

                        } catch (JSONException e) {
                            Log.d("Error",e.toString());
                            e.printStackTrace();
                        }
                        /*Log.d("Response From API",response.toString());*/
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error", error.toString());
                        String errormsg = "No Data Found";
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

        /*To restrict multiple sms*/
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
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