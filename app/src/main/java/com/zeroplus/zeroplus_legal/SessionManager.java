package com.zeroplus.zeroplus_legal;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    //Variables
    SharedPreferences usersSession;
    SharedPreferences.Editor editor;
    Context context;

    //Session Names
    public static final String SESSION_USERSESSION="userLoginSession";
    public static final String SESSION_REMEMBERME="rememberMe";


    //USER SESSION VARIABLES
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";


    //REMEMBER ME VATIABLES
    private static final String IS_REMEMBERME = "IsRememberMe";
    protected static final String KEY_SESSIONEMAIL = "email";
    protected static final String KEY_SESSIONPASSWORD = "password";



    public SessionManager(Context _context, String sessionName){
        context = _context;
        usersSession = context.getSharedPreferences(sessionName, Context.MODE_PRIVATE);
        editor= usersSession.edit();
    }

    /*USers Login Session*/
    public void createLoginSession (String email, String password){

        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD,password);

        editor.commit();

    }

    /*REMEMBER ME SESSION FUNCTIONS*/

    public void createRememberSession (String email, String password){

        editor.putBoolean(IS_REMEMBERME, true);

        editor.putString(KEY_SESSIONEMAIL, email);
        editor.putString(KEY_SESSIONPASSWORD,password);

        editor.commit();

    }

    public HashMap<String, String> getRememberMeDetailsFromSession(){
        HashMap<String, String> userData = new HashMap<>();
        userData.put(KEY_SESSIONEMAIL, usersSession.getString(KEY_SESSIONEMAIL,null));
        userData.put(KEY_SESSIONPASSWORD, usersSession.getString(KEY_SESSIONPASSWORD,null));

        return userData;

    }

    public boolean CheckRememberMe(){
        if(usersSession.getBoolean(IS_REMEMBERME,false)){
            return true;
        }
        else{
            return false;
        }
    }


}
