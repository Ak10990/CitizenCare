package com.walmart.citizencare.flows;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.walmart.citizencare.App;
import com.walmart.citizencare.R;
import com.walmart.citizencare.flows.home.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    private final long splashTime = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initValues();
    }

    private void initValues() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startNextActivity();
            }
        }, splashTime);
        //TODO location enable

        App.getInstance().setLocation("12.9716° N, 77.5946° E");
    }

    private void startNextActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
