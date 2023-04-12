package com.example.osproject.ParseC;

import android.app.Application;

import com.example.osproject.R;
import com.parse.Parse;

public class parse extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.applicationKey))
                .clientKey(getString(R.string.clientKey))
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
