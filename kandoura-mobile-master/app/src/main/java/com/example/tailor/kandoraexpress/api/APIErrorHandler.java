package com.example.tailor.kandoraexpress.api;

import android.app.Activity;

import com.example.tailor.kandoraexpress.R;
import com.example.tailor.kandoraexpress.util.MySnackBar;

import org.json.JSONObject;


public class APIErrorHandler {
    private static final APIErrorHandler ourInstance = new APIErrorHandler();

    public static APIErrorHandler getInstance() {
        return ourInstance;
    }

    private APIErrorHandler() {
    }

    public void errorHandler(Activity activity, int status_code, String message){
        switch (status_code){
            case 200:
                MySnackBar.getInstance().showPositiveSnackBar(activity,message);
                break;
            case 201:
                MySnackBar.getInstance().showPositiveSnackBar(activity,message);
                break;
            default:
                MySnackBar.getInstance().showNagativeSnackBar(activity,messageParsing(activity,message));
                break;
        }
    }

    private String messageParsing(Activity activity,String message){
        try {
            JSONObject jsonObject=new JSONObject(message);
            if (jsonObject.has("message")){
                return jsonObject.getString("message");
            }
        }catch (Exception e){
            return activity.getString(R.string.something_went_wrong_while_retrieving_information);
        }
        return activity.getString(R.string.something_went_wrong_while_retrieving_information);

    }

    public int messageParsing(String message){
        try {
            JSONObject jsonObject=new JSONObject(message);
            if (jsonObject.has("code")){
                return jsonObject.getInt("code");
            }
        }catch (Exception e){
            return 0;
        }
        return 0;
    }

}

