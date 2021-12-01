package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.databinding.ActivityMainBinding;
import com.moviles.lucky_smart.databinding.ActivitySelectBinding;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivitySelectBinding selectBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        selectBinding = ActivitySelectBinding.inflate(getLayoutInflater());
        View view = selectBinding.getRoot();
        setContentView(view);
        selectBinding.btnProduct.setOnClickListener(this);
        selectBinding.btnSellers.setOnClickListener(this);
        selectBinding.btnUsers.setOnClickListener(this);
        selectBinding.btnBack8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btnProduct:
                Intent intent = new Intent(this, ListProductsActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSellers:
                Intent intent2 = new Intent(this, ListSellerActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnUsers:
                Intent intent3 = new Intent(this, ListUsersActivity.class);
                startActivity(intent3);
                break;
            case R.id.btnBack8:
                Intent intent4 = new Intent(this, MainActivity.class);
                startActivity(intent4);
                break;

        }
    }
}