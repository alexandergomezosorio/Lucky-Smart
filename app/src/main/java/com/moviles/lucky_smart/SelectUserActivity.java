package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.adapters.UserAdapter;
import com.moviles.lucky_smart.databinding.ActivitySelectBinding;
import com.moviles.lucky_smart.databinding.ActivitySelectUserBinding;

public class SelectUserActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySelectUserBinding selectUserBinding;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        selectUserBinding = ActivitySelectUserBinding.inflate(getLayoutInflater());
        View view = selectUserBinding.getRoot();
        setContentView(view);
        selectUserBinding.btnProduct2.setOnClickListener(this);
        selectUserBinding.btnProfile.setOnClickListener(this);
        selectUserBinding.btnBack9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnProduct2:
                Intent intent = new Intent(this, ListProductsUserActivity.class);
                startActivity(intent);
                break;
            case R.id.btnProfile:
                Intent intent2 = new Intent(this, ListUsersActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnBack9:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                break;

        }
    }
}