package com.example.tailor.kandoraexpress;

import android.app.Application;
import android.content.Context;

import com.example.tailor.kandoraexpress.font.CustomFontFamily;
import com.example.tailor.kandoraexpress.util.InternetChecker;

public class MyApp extends Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        InternetChecker.getInstance().init();
        CustomFontFamily.getInstance().addAllFont(this);
    }

    public static Context getContext() {
        return context;
    }
}
