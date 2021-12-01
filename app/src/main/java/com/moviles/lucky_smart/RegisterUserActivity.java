package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moviles.lucky_smart.databinding.ActivityRegisterUserBinding;

public class RegisterUserActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegisterUserBinding registerUserBinding;
    DbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerUserBinding = ActivityRegisterUserBinding.inflate(getLayoutInflater());
        View view = registerUserBinding.getRoot();
        setContentView(view);
        registerUserBinding.btnBack2.setOnClickListener(this);
        dbHelper = new DbHelper(this);
    }

    public void registerUser(View view){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues userData = new ContentValues();
        String email = registerUserBinding.etEmail2.getText().toString();
        String password = registerUserBinding.etPassword2.getText().toString();
        String name = registerUserBinding.etName4.getText().toString();
        String city = registerUserBinding.etCity.getText().toString();

        userData.put("email",email);
        userData.put("password",password);
        userData.put("name",name);
        userData.put("city",city);

        long newUser = db.insert("users",null,userData);
        Toast.makeText(this, ""+newUser, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SelectUserActivity.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBack2:
                Intent intent2 = new Intent(this, RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }
}