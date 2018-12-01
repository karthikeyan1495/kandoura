package com.example.tailor.kandoraexpress.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tailor.kandoraexpress.user.login.modal.User;
import com.google.gson.Gson;


public class MySession extends SessionConstant{

    private final String FILE_NAME = "Kandoraexpress-Preferences";

    private static MySession MySession;
    SharedPreferences preferences;

    private MySession() {
    }

    public static MySession getInstance(Context context) {
        if (MySession == null) {
            MySession = new MySession();
        }
        MySession.getPreferenceObject(context);
        return MySession;
    }

    private void getPreferenceObject(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME,
                Context.MODE_PRIVATE);
    }

    public void saveLoginStatus(boolean status){
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(IS_LOGIN,status);
        editor.commit();
    }
    public boolean isLogin(){
        return preferences.getBoolean(IS_LOGIN,false);
    }


    public void saveAppFirstTimeLoad(boolean status){
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean(APP_FIRST_TIME_LOAD,status);
        editor.commit();
    }
    public boolean isAppFirstTimeLoad(){
        return preferences.getBoolean(APP_FIRST_TIME_LOAD,true);
    }


    public void saveUser(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(USER_INFO, json);
        editor.commit();
    }

    public User getUser(){
        String json = preferences.getString(USER_INFO, null);
        Gson gson = new Gson();
        return  gson.fromJson(json, User.class);
    }
   /* public void saveLanguageKey(String key){
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString(LANGUAGE_KEY, key);
        editor.commit();
    }
*/
   /* public String getLanguageKey(){
        return preferences.getString(LANGUAGE_KEY, MyApp.getContext().getString(R.string.en));
    }*/
    public void clearUserData() {
        preferences.edit().clear().commit();
    }
}
