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
import android.widget.ImageView;
import android.widget.TextView;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.zeroplus.zeroplus_legal.ResponseModels.loginResponseModel;
import com.zeroplus.zeroplus_legal.databinding.FragmentFirstBinding;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;

public class FirstFragment extends Fragment {
    Button loginbtn, regbtn, getbackLogin;
    ImageView animatedImage;
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
        animatedImage = view.findViewById(R.id.imageView2);
        Glide.with(this)
                .load(R.drawable.lawyer_first_img)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(animatedImage);


        SessionManager sessionManager = new SessionManager(getContext(), SessionManager.SESSION_REMEMBERME);
        if(sessionManager.CheckRememberMe()) {
            String msg = "Checking Previous Login Info";
            showToast(msg);
            //processdata();
            loginData();
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

    public void showToast(String Msg){
        LayoutInflater inflater = getLayoutInflater();
        View layout =inflater.inflate(R.layout.custom_toast, (ViewGroup) getActivity().findViewById(R.id.toastRoot) );
        TextView Text = (TextView) layout.findViewById(R.id.textView5);
        Text.setText(Msg);
        Toast toast = new Toast(getContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        toast.show();
    }




    public void loginData() {
        MyApplication globalVariable = (MyApplication) getActivity().getApplication();

        SessionManager sessionManager = new SessionManager(getContext(), SessionManager.SESSION_REMEMBERME);

        HashMap<String, String> rememberMeDetails = sessionManager.getRememberMeDetailsFromSession();
        String Email=rememberMeDetails.get(SessionManager.KEY_SESSIONEMAIL);
        String Password=rememberMeDetails.get(SessionManager.KEY_SESSIONPASSWORD);

        if(Email.equals("null")&&Password.equals("null")){
            CustomDialog();
        }

        else{
            /*CALLING THE LOGIN_RESPONSE_MODEL TO GET THE RESPONSE*/
            Call<loginResponseModel> call = apiController.getInstance()
                    .getApi().getLoginInfo(Email,Password);

            call.enqueue(new Callback<loginResponseModel>() {
                @Override
                public void onResponse(Call<loginResponseModel> call, retrofit2.Response<loginResponseModel> response) {
                    loginResponseModel lrm = response.body();
                    /*lrm.getEmail();*/
                    //Log.d("response", lrm.getName());
                    assert lrm != null;
                    if(Objects.equals(lrm.getResult(), "true")){
                        globalVariable.setlName(lrm.getName());
                        globalVariable.setlEmail(lrm.getEmail());
                        globalVariable.setlPhone(lrm.getPhone());
                        globalVariable.setlUname(lrm.getUsername());
                        globalVariable.setlRefer(lrm.getRefer());

                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                /*sleep(3000);*/
                                Intent i = new Intent(getContext(), DashboardActivity.class);
                                startActivity(i);
                                getActivity().finish();
                            }
                        });
                        thread.start();
                        String msg = "Successfully Logged In";
                        showToast(msg);
                        //Toast.makeText(getActivity(), "Successfully Logged In", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        /*Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();*/
                        String errormsg = "User Not Found\nEnter Valid Email and Password";
                        showToast(errormsg);
                    }


                }

                @Override
                public void onFailure(Call<loginResponseModel> call, Throwable t) {
                    String error = t.getMessage();
                    Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();

                }
            });
        }


    }


}
