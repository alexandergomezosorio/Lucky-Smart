package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moviles.lucky_smart.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegisterBinding registerSelectBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerSelectBinding =ActivityRegisterBinding.inflate(getLayoutInflater());
        View view = registerSelectBinding.getRoot();
        setContentView(view);
        registerSelectBinding.btnBack.setOnClickListener(this);
        registerSelectBinding.btnUser.setOnClickListener(this);
        registerSelectBinding.btnSeller.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBack:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnUser:
                Intent intent2 = new Intent(this, RegisterUserActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnSeller:
                Intent intent3 = new Intent(this, RegisterSellerActivity.class);
                startActivity(intent3);
                break;
        }
    }


}