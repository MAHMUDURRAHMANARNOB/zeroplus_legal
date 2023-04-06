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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.zeroplus.zeroplus_legal.databinding.FragmentLoginBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class loginFragment extends Fragment {

    //Data variables
    TextInputEditText txtInFldEmail,txtInFldPass;
    TextView forgotpasstxt, txtsignup;
    Button fabCropImage;
    CheckBox remember;


    //Validations
    public boolean LoginValidate(){
        boolean validResult;
        if(!validatePass() || !validateEmail()){
            Log.d("Registration Validate","InValid");
            return true;
        }
        else{
            Log.d("Registration Validate","Valid");
            return false;
        }
    }

     private boolean validateEmail(){

        String Email=txtInFldEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String mobilePattern = "^(?:\\+88|88)?(01[3-9]\\d{8})$";
        Log.d("EmailInput Text",Email);

        if (Email.isEmpty()){
            txtInFldEmail.setError("Email/PhoneField cannot be Empty");
            Log.d("email","empty");
            return false;
        }
        else if (Email.matches(emailPattern)||Email.matches(mobilePattern)) {
            return true;
        }
        /*else if (!Email.matches(mobilePattern)){
            txtInFldEmail.setError("Invalid Email/Phone");
            Log.d("email/phone","Invalid");
            return false;
        }*/
        else {
            Log.d("Email/Phone", " ok");
            txtInFldEmail.setError("Invalid Email/Phone");
            Log.d("email/phone","Invalid");
            return false;
        }

    }

    private boolean validatePass(){
        String password=txtInFldPass.getText().toString().trim();
        Log.d("Password Inputted Text",password);

        if (password.isEmpty()){
            txtInFldPass.setError("Password Field cannot be empty");
            Log.d("password","Password empty");
            return false;
        }
        else if(password.length()<6){
            txtInFldPass.setError("Minimum 6 characters required");
            Log.d("password","6 error");
            return false;
        }
        else{
            Log.d("password","password ok");
            return true;
        }
    }

    //Views and fragemnts functionability

    private FragmentLoginBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        txtInFldPass=(TextInputEditText) view.findViewById(R.id.txtInFldPass);
        txtInFldEmail=(TextInputEditText) view.findViewById(R.id.userid_phone_email);
        remember = (CheckBox) view.findViewById(R.id.checkBoxRemember);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtInFldPass=(TextInputEditText) view.findViewById(R.id.txtInFldPass);
        txtInFldEmail=(TextInputEditText) view.findViewById(R.id.userid_phone_email);
        forgotpasstxt=(TextView) view.findViewById(R.id.forgotpasstxt);
        remember = (CheckBox) view.findViewById(R.id.checkBoxRemember);

        txtsignup=(TextView) view.findViewById(R.id.txtsignup);

        /*binding.logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RegistrationFragment.this)
                        .navigate(R.id.action_registrationFragment_to_loginFragment2);
            }
        });*/

        binding.txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(loginFragment.this)
                        .navigate(R.id.action_loginFragment_to_registrationFragment);
            }
        });

        SessionManager sessionManager = new SessionManager(getContext(), SessionManager.SESSION_REMEMBERME);
        if(sessionManager.CheckRememberMe()){
            HashMap<String, String> rememberMeDetails = sessionManager.getRememberMeDetailsFromSession();
            txtInFldEmail.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONEMAIL));
            txtInFldPass.setText(rememberMeDetails.get(SessionManager.KEY_SESSIONPASSWORD));
        }

        /*SharedPreferences preferences = getActivity().getSharedPreferences("checkbox",Context.MODE_PRIVATE);
        String checkbox = preferences.getString("remember","");
        if(checkbox.equals("true")){
            *//*Toast.makeText(getActivity(), "Error In Login information", Toast.LENGTH_LONG).show();*//*
            processdata();
        }
        else if(checkbox.equals("false")){
            Toast.makeText(getActivity(), "Sign In", Toast.LENGTH_LONG).show();
        }*/

        binding.forgotpasstxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(loginFragment.this)
                        .navigate(R.id.action_loginFragment_to_forgerPassFragment);

            }
        });

        binding.btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(LoginValidate()){
                    Toast.makeText(getActivity(), "Error In Login information", Toast.LENGTH_LONG).show();
                    Log.d("Entered into Reg ","Error Login Validate");
                }
                else{
                    Log.d("Entered into Reg ","Success Login Validate");
                    processdata();
                    /*NavHostFragment.findNavController(loginFragment.this)
                            .navigate(R.id.action_loginFragment_to_zeroplusWebviewFragment);*/
                }
            }
        });

        remember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(getActivity(), "Checked",Toast.LENGTH_SHORT).show();

                }
                else if(!compoundButton.isChecked()){
                    SharedPreferences preferences = getActivity().getSharedPreferences("checkbox", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "flase");
                    editor.apply();
                    Toast.makeText(getActivity(), "Un-Checked!",Toast.LENGTH_SHORT).show();
                }
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

    private void processdata(){

        //API

        String Email=txtInFldEmail.getText().toString().trim();
        String Password=txtInFldPass.getText().toString().trim();

        /*create a Session*/
        SessionManager sessionManager1 = new SessionManager(getContext(), SessionManager.SESSION_USERSESSION);
        sessionManager1.createLoginSession(Email,Password);


        //parameter sending to the API
        JSONObject parameter = new JSONObject();
        try {
            parameter.put("email", Email);
            parameter.put("password", Password);
            Log.d("username in", Email+"\t"+Password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(remember.isChecked()){
            /*If Checked create a Session*/
            SessionManager sessionManager = new SessionManager(getContext(), SessionManager.SESSION_REMEMBERME);
            sessionManager.createRememberSession(Email,Password);
        }

        // Calling Application class (see application tag in AndroidManifest.xml)

        MyApplication globalVariable = (MyApplication) getActivity().getApplication();


         /*String ApiUrl = "http://128.199.193.12/zeroplus/public/api/auth/login";*/
        String ApiUrl = ((MyApplication) getActivity().getApplication()).getBaseURL()+"auth/login";
        /*String ApiUrl = ((MyApplication) getActivity().getApplication()).getBaseURL()+"auth/login";*/
        //Response From API
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, ApiUrl ,parameter,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            /*parse from response*/
                            Boolean result = response.getBoolean("result");
                            /*String id = response.getString("id");*/
                            globalVariable.setId(response.getString("id"));
                            Log.d("inside login response",response.toString());

                            String Name = globalVariable.setName(response.getString("name"));


                            /*NavHostFragment.findNavController(loginFragment.this)
                                    .navigate(R.id.action_loginFragment_to_zeroplusWebviewFragment);*/
                            /*NavHostFragment.findNavController(loginFragment.this)
                                    .navigate(R.id.action_loginFragment_to_shareMatterFragment);*/
                            /*NavHostFragment.findNavController(loginFragment.this)
                                    .navigate(R.id.action_loginFragment_to_shareMatterWebFragment);*/

                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    /*sleep(3000);*/

                                    Intent i = new Intent(getContext(),DashboardActivity.class);
                                    startActivity(i);
                                    getActivity().finish();

                                }
                            });
                            thread.start();

                            Toast.makeText(getActivity(), "--> Success <--", Toast.LENGTH_LONG).show();


                        } catch (JSONException e) {
                            //custom toast start
                            String erroruser = "Invalid UserName or Password";
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
                        String errormsg = "Check your connection and try again";
                        Toast toast = Toast.makeText(
                                getActivity().getApplicationContext(),
                                Html.fromHtml("<h3><font color='#ff0000'>"  +errormsg+  "</font></h3>"),
                                Toast.LENGTH_LONG);

                        // Set the Toast display position layout center
                        //toast.setGravity(Gravity.CENTER,0,0);
                        // Finally, show the toast
                        int lengthShort = Toast.LENGTH_SHORT;
                        toast.setDuration(lengthShort);
                        toast.show();
                        //Toast.makeText(getActivity(), "Check your connection and provide valid user name and password ", Toast.LENGTH_LONG).show();


                    }
                })
        {
            @Override
            public Map<String, String> getParams()throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Accept", "application/json");
                params.put("Content-Type", "application/json; charset=utf-8");
                params.put("User-agent", System.getProperty("http.agent"));
                params.put("password", Password);

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


    private void processDataForShareMatter() {
        final MyApplication globalVariable = (MyApplication) getActivity().getApplication();
        String id  = globalVariable.getId();

        JSONObject parameter = new JSONObject();
        try {
            parameter.put("user_id", id);

            Log.d("global variable", id);
            Log.d("parameter", String.valueOf(parameter));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String ApiUrl=((MyApplication) getActivity().getApplication()).getDataURL()+"matterShare";
        Log.d("URL",ApiUrl);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ApiUrl,parameter,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("request",response.toString());
                        try {
                            boolean success = response.getBoolean("success");

                            Log.d("inside response", response.toString());
                            if (success){
                                String Cyclonedata = response.getString("Cyclonedata");


                                JSONArray jsonArrayCD = new JSONArray(response.getString("Cyclonedata"));

                                for (int i=0;i<jsonArrayCD.length();i++){
                                    /*double Cyclonelatitude=globalVariable.setCyclonelatitude(jsonArrayCD.getJSONObject(i).getDouble("latitude"));
                                    double Cyclonelongitude=globalVariable.setCyclonelongitude(jsonArrayCD.getJSONObject(i).getDouble("longitude"));
                                    Log.d("cyclone latlang ", Cyclonelatitude+"  "+Cyclonelongitude);

                                    String CycloneName=globalVariable.setCycloneName(jsonArrayCD.getJSONObject(i).getString("cyclone_name"));
                                    Log.d("cyclone name ", CycloneName);
                                    String WindSpeed=globalVariable.setWindSpeed(jsonArrayCD.getJSONObject(i).getString("windspeed"));
                                    int AlertLevel=globalVariable.setAlertLevel(jsonArrayCD.getJSONObject(i).getInt("alertLevel"));
                                    String Radius=globalVariable.setRadius(jsonArrayCD.getJSONObject(i).getString("radius"));
                                    String Direction=globalVariable.setDirection(jsonArrayCD.getJSONObject(i).getString("direction"));
                                    String Message=globalVariable.setMessage(jsonArrayCD.getJSONObject(i).getString("msg"));
                                    String LocationPointCyclone=globalVariable.setLocationPointCyclone("( "+Cyclonelatitude+" , "+Cyclonelongitude+" )");*/

                                }
                                Log.d("Cyclone Data", Cyclonedata);

//                                 Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_LONG).show();
                            }
                            else{
                                Log.d("Success", "not succeed");
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
                }
        );

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
    }


    private void processCatData() {
        MyApplication globalVariable = (MyApplication) getActivity().getApplication();

        String ApiUrl=((MyApplication) getActivity().getApplication()).getApiUrl()+"android/categorydata";
        Log.d("URL",ApiUrl);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ApiUrl,null,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("request",response.toString());
                        try {
                            boolean success = response.getBoolean("success");

                            Log.d("inside response", response.toString());
                            if (success){

                                JSONArray jsonArrayCD = new JSONArray(response.getString("CategoryData"));

                                for (int i=0;i<jsonArrayCD.length();i++){
                                    categoryList cl = new categoryList();

                                    String cat_id=jsonArrayCD.getJSONObject(i).getString("id");
                                    String cat_title=jsonArrayCD.getJSONObject(i).getString("name");
                                    globalVariable.setCatId(cat_id);
                                    globalVariable.setCatId(cat_title);



                                    /*double Cyclonelatitude=globalVariable.setCyclonelatitude(jsonArrayCD.getJSONObject(i).getDouble("latitude"));
                                    double Cyclonelongitude=globalVariable.setCyclonelongitude(jsonArrayCD.getJSONObject(i).getDouble("longitude"));
                                    Log.d("cyclone latlang ", Cyclonelatitude+"  "+Cyclonelongitude);

                                    String CycloneName=globalVariable.setCycloneName(jsonArrayCD.getJSONObject(i).getString("cyclone_name"));
                                    Log.d("cyclone name ", CycloneName);
                                    String WindSpeed=globalVariable.setWindSpeed(jsonArrayCD.getJSONObject(i).getString("windspeed"));
                                    int AlertLevel=globalVariable.setAlertLevel(jsonArrayCD.getJSONObject(i).getInt("alertLevel"));
                                    String Radius=globalVariable.setRadius(jsonArrayCD.getJSONObject(i).getString("radius"));
                                    String Direction=globalVariable.setDirection(jsonArrayCD.getJSONObject(i).getString("direction"));
                                    String Message=globalVariable.setMessage(jsonArrayCD.getJSONObject(i).getString("msg"));
                                    String LocationPointCyclone=globalVariable.setLocationPointCyclone("( "+Cyclonelatitude+" , "+Cyclonelongitude+" )");*/
                                }
//                                 Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_LONG).show();
                            }
                            else{
                                Log.d("Success", "not succeed");
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
                }
        );

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
    }



}