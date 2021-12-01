package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.moviles.lucky_smart.adapters.SellerAdapter;
import com.moviles.lucky_smart.adapters.UserAdapter;
import com.moviles.lucky_smart.databinding.ActivityMainBinding;
import com.moviles.lucky_smart.entities.UserEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mainBinding;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
        mainBinding.ibtnNext.setOnClickListener(this);
        mainBinding.btnSignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ibtnNext:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSignIn:
                Intent intent2 = new Intent(this, SelectActivity.class);
                startActivity(intent2);
                break;

        }

    }
}