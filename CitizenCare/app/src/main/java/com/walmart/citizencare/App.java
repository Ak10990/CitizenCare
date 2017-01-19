package com.walmart.citizencare;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class App extends Application {

    private static App mInstance;
    private SharedPreferences mPrefs;
    private String location;

    public static App getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initSharedPreferences();
    }

    private void initSharedPreferences() {
        mPrefs = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
    }

    public SharedPreferences getPrefs() {
        return mPrefs;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
