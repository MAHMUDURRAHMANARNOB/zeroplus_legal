package com.zeroplus.zeroplus_legal;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import com.zeroplus.zeroplus_legal.databinding.FragmentFirstBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FirstFragment extends Fragment {
    Button loginbtn, regbtn, getbackLogin;
    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        loginbtn = (Button) view.findViewById(R.id.loginbtn);
        regbtn = (Button) view.findViewById(R.id.regbtn);

        binding = FragmentFirstBinding.inflate(inflater, container, false);
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

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        SessionManager sessionManager = new SessionManager(getContext(), SessionManager.SESSION_REMEMBERME);
        if(sessionManager.CheckRememberMe()) {
            showToast();
            processdata();
        }

        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_loginFragment);
            }
        });

        binding.regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_registrationFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }


    private void CustomDialog(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.alart_dialog_box_login);
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
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_loginFragment);

            }
        });
    }

    public void showToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout =inflater.inflate(R.layout.custom_toast, (ViewGroup) getActivity().findViewById(R.id.toastRoot) );

        Toast toast = new Toast(getContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }


    private void processdata(){

        //API
        SessionManager sessionManager = new SessionManager(getContext(), SessionManager.SESSION_REMEMBERME);

        HashMap<String, String> rememberMeDetails = sessionManager.getRememberMeDetailsFromSession();
        String Email=rememberMeDetails.get(SessionManager.KEY_SESSIONEMAIL);
        String Password=rememberMeDetails.get(SessionManager.KEY_SESSIONPASSWORD);

        if(Email.equals("null")&&Password.equals("null")){
            CustomDialog();
        }

        else{
            //parameter sending to the API
            JSONObject parameter = new JSONObject();
            try {
                parameter.put("email", Email);
                parameter.put("password", Password);
                Log.d("username in", Email+"\t"+Password);
            } catch (JSONException e) {
                e.printStackTrace();
            }


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
//                            Log.d("id",result.toString());

                                globalVariable.setlName(response.getString("name"));
                                globalVariable.setlEmail(response.getString("email"));
                                globalVariable.setlPhone(response.getString("phone"));
                                globalVariable.setlRefer(response.getString("username"));
                                globalVariable.setlRefer(response.getString("refer"));

                                String msg = response.getString("message");
                                Log.d("response", msg);


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

                                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();


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


    }


}
