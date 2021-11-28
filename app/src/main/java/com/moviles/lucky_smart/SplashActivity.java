package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startTimer();
    }

    public final void startTimer() {
        (new CountDownTimer(3000L, 1000L) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {

                boolean var3 = false;
                boolean var4 = false;
                boolean var6 = false;
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        }).start();
}
}