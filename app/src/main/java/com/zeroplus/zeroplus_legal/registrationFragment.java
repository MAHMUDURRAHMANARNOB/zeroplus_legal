package com.zeroplus.zeroplus_legal;

import android.Manifest;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.zeroplus.zeroplus_legal.databinding.FragmentRegistrationBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class registrationFragment extends Fragment {

    //Data Variables
    ArrayList<String> StoreContacts ;
    ArrayAdapter<String> arrayAdapter ;
    ImageView animatedImage;
    Cursor cursor ;
    public  static final int RequestPermissionCode  = 1 ;
    String name, phonenumber ;

    TextInputEditText txtInFldName,txtInFldEmail,txtInFldPhone,txtInFldPass,txtInFldRefCode;
    Button regbtn, BacktoLogin;
    /*RadioGroup RBPayMode;
    RadioButton onlineRB,offlineRB;*/
    FloatingActionButton regular_fab;

        /* Registration validation */
        public boolean RegistrationValidate(){
            boolean validResult;
            if(!validateName() || !validatePass() /*|| !validateRefCode()*/ || !validatePhone() /*|| !validateEmail()*/){
                Log.d("Registration Validate","InValid");
                return true;
            }
            else{
                Log.d("Registration Validate","Valid");
                return false;
            }
        }

        private boolean validateName(){

            String Name=txtInFldName.getText().toString().trim();

            Log.d("UserName Input Text",Name);

            if (Name.isEmpty()){

                txtInFldName.setError("Name Field cannot be Empty");
                Log.d("Name","Name empty");
                return false;
            }
            else{
                Log.d("Name","Name ok");
                return true;
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

        private boolean validateRefCode(){
            String refcode=txtInFldRefCode.getText().toString().trim();
            Log.d("Password Inputted Text",refcode);

            if (refcode.isEmpty()){
                txtInFldRefCode.setError("Referent Code Field cannot be empty");
                Log.d("REFCODE","ref code empty");
                return false;
            }
            else{
                Log.d("Ref Code","ok");
                return true;
            }
        }

        private boolean validateEmail(){

            String Email=txtInFldEmail.getText().toString().trim();
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            Log.d("Email Input Text",Email);

            if (Email.isEmpty()){
                txtInFldEmail.setError("Email Field cannot be Empty");
                Log.d("email","empty");
                return false;
            }
            else if (!Email.matches(emailPattern)) {
                txtInFldEmail.setError("Invalid Email");
                Log.d("email","Invalid");
                return false;
            }
            else {
                Log.d("Email", " ok");
                return true;
            }

        }

        private boolean validatePhone(){

            String Phone=txtInFldPhone.getText().toString().trim();

            Log.d("Phone Input Text",Phone);

            if (Phone.isEmpty()){

                txtInFldPhone.setError("Phone Field cannot be Empty");
                Log.d("Phone","Phone empty");
                return false;
            }
            else if(Phone.length()!=11){
                txtInFldPhone.setError("11 characters required");
                Log.d("Phone","11 error");
                return false;
            }
            else{
                Log.d("Phone","Phone ok");
                return true;
            }

        }



        //Validation End

    private FragmentRegistrationBinding binding;


    private static final int REQUEST_CONTACT = 1;
    private static final int REQUEST_READ_CONTACTS_PERMISSION=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        txtInFldName=(TextInputEditText) view.findViewById(R.id.txtInFldName);
        txtInFldEmail=(TextInputEditText) view.findViewById(R.id.userid_phone_email);
        txtInFldPhone=(TextInputEditText) view.findViewById(R.id.txtInFldPhone);
        txtInFldPass=(TextInputEditText) view.findViewById(R.id.txtInFldPass);
        txtInFldRefCode=(TextInputEditText) view.findViewById(R.id.txtInFldRefCode);
        regbtn=(Button) view.findViewById(R.id.regbtn);
        regular_fab=(FloatingActionButton) view.findViewById(R.id.regular_fab);
        /*RBPayMode=(RadioGroup) view.findViewById(R.id.RBPayMode);
        onlineRB=(RadioButton) view.findViewById(R.id.onlineRB);
        offlineRB=(RadioButton) view.findViewById(R.id.offlineRB);*/

        EnableRuntimePermission();

        binding = FragmentRegistrationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*requestContactsPermission();*/
        txtInFldName=(TextInputEditText) view.findViewById(R.id.txtInFldName);
        txtInFldEmail=(TextInputEditText) view.findViewById(R.id.userid_phone_email);
        txtInFldPhone=(TextInputEditText) view.findViewById(R.id.txtInFldPhone);
        txtInFldPass=(TextInputEditText) view.findViewById(R.id.txtInFldPass);
        txtInFldRefCode=(TextInputEditText) view.findViewById(R.id.txtInFldRefCode);
        regbtn=(Button) view.findViewById(R.id.regbtn);
        regular_fab=(FloatingActionButton) view.findViewById(R.id.regular_fab);
        CheckBox checkbox = (CheckBox) view.findViewById(R.id.TCcheckBox);
        BacktoLogin = (Button) view.findViewById(R.id.btnbacktologin);

        /*RBPayMode=(RadioGroup) view.findViewById(R.id.RBPayMode);
        onlineRB=(RadioButton) view.findViewById(R.id.onlineRB);
        offlineRB=(RadioButton) view.findViewById(R.id.offlineRB);*/

        animatedImage = view.findViewById(R.id.imgLogin);
        Glide.with(this)
                .load(R.drawable.judge_cuate)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(animatedImage);

        BacktoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(registrationFragment.this)
                        .navigate(R.id.action_registrationFragment_to_loginFragment);
            }
        });

        binding.txtTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(registrationFragment.this)
                        .navigate(R.id.action_registrationFragment_to_tarmsConditionFragment);
            }
        });

                binding.regbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(RegistrationValidate()){
                            Toast.makeText(getActivity(), "Error In Information", Toast.LENGTH_LONG).show();
                            Log.d("Entered into Reg ","Error reg Validate");
                        }
                        else{
                            Log.d("Entered into Reg ","Success reg Validate");

                            SendOTP();

                        }
                    }
                });




        regular_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetContactsIntoArrayList();
              //  getContactInfo();

                /*startActivityForResult(pickContact, REQUEST_CONTACT);*/

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

    /*OTP*/
    private void SendOTP(){
        //API
        String Name=txtInFldName.getText().toString().trim();
        String Email=txtInFldEmail.getText().toString().trim();
        String Phone=txtInFldPhone.getText().toString().trim();
        String Password=txtInFldPass.getText().toString().trim();
        String RefCode=txtInFldRefCode.getText().toString().trim();


        MyApplication globalVariable = (MyApplication) getActivity().getApplication();
        globalVariable.setPhone(Phone);
        globalVariable.setRname(Name);
        globalVariable.setEmail(Email);
        globalVariable.setPassword(Password);
        globalVariable.setRefcode(RefCode);

        //parameter sending to the API
        JSONObject parameter = new JSONObject();
        try {

            parameter.put("phone", Phone);


            Log.d("Perameter Phone", Phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Calling Application class (see application tag in AndroidManifest.xml)

        /*MyApplication globalVariable = (MyApplication) getActivity().getApplication();*/
        String ApiUrl = ((MyApplication) getActivity().getApplication()).getBaseURL()+"auth/getOTP";

        /*String ApiUrl = "http://128.199.193.12/zeroplus20/public/api/auth/getOTP";*/

        //Response From API
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, ApiUrl ,parameter,
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response) {
                        try {


                            String OTP = response.getString("OTP");

                            globalVariable.setOTP(OTP);
                            Log.d("result", OTP);

                            NavHostFragment.findNavController(registrationFragment.this)
                                    .navigate(R.id.action_registrationFragment_to_enabelCodeFragment);

                        } catch (JSONException e) {
                            //custom toast start
                            /*String erroruser = "Refer Code not Valid";
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
                            txtInFldRefCode.setError("Invalid Code");
                            e.printStackTrace();*/

                            e.printStackTrace();

                        }
                        /*Log.d("Response From API",response.toString());*/
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error", error.toString());
                        String errormsg = "Use Unique Mobile-No and Check Your Internet Connection";
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
                params.put("password", Password);

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


    /* Data from contats*/

    @SuppressLint("Range")
    public void GetContactsIntoArrayList(){
        Log.d("enterd", "GetContactsIntoArrayList");

        cursor = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI ,
                null,null, null, "data._id ASC");

        if(cursor != null){
            if(cursor.getCount()>0){
                cursor.moveToLast();
                name =
                        cursor.getString(cursor.getColumnIndex
                                (ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                phonenumber =
                        cursor.getString(cursor.getColumnIndex
                                (ContactsContract.CommonDataKinds.Phone.DATA1));

                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                int cnt = cursor.getCount();
                Log.d("CPount:", String.valueOf(cnt));
                Log.d("ID:",id);

                txtInFldName.setText(name);
                txtInFldPhone.setText(phonenumber);
                txtInFldPass.setText("123456");
                txtInFldEmail.setText(phonenumber + "@gmail.com");


                Log.d("Number", phonenumber);
                Log.d("name", name);
                Log.d("name", name);


                cursor.close();

            }
            else{
                Toast.makeText(getActivity(),"Save a contact first", Toast.LENGTH_LONG).show();
            }

        }
        else{
            Toast.makeText(getActivity(),"No Data Found", Toast.LENGTH_LONG).show();
        }
        /*Cursor cursor1 = getContext().getContentResolver().query(
                ContactsContract.CommonDataKinds.Email.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=?",
                new String[]{id}, "data._id ASC");

        *//*cursor1.moveToLast();*//*
                if( cursor1 != null && cursor1.getCount()>0 ){
                    while (cursor1.moveToNext()) {
                        Log.d("Data from contacts",ContactsContract.CommonDataKinds.Email.DATA);
                        int index = cursor1.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA);
                        Log.d("data from cursor", String.valueOf(cursor1.getCount()));
                        if(index >= 0 && index < cnt){
                            String emailid = cursor1.getString(index);
                            txtInFldEmail.setText(emailid);
                            Log.d("email",emailid);
                            Log.d("inside","email");
                        }
                        else{
                            txtInFldEmail.setText("Write Email");
                        }
                    }

                    cursor1.close();

                }
                else{
                    txtInFldEmail.setText("Write Email Else");
                    Log.d("inside","email else");
                }*/

//        String emailid = cursor1.getString(cursor1.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));

        /*Cursor cursor1 =
                getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI ,
                        null,null, null, "data._id ASC");*/



    }


    /*Permissions*/

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                getActivity(),
                Manifest.permission.READ_CONTACTS))
        {

            Toast.makeText(getActivity(),"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(getActivity(),new String[]{
                    Manifest.permission.READ_CONTACTS}, RequestPermissionCode);

        }
    }
}