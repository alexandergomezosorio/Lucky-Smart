package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        mainBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mainBinding.etEmail.getText().toString();
                String password = mainBinding.etPassword.getText().toString();
                if(email.equals("") && password.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter the user", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean result = login(email,password);
                    Boolean result2 = loginSeller(email,password);
                    if(result == true){
                        Intent intent2 = new Intent(MainActivity.this, SelectUserActivity.class);
                        startActivity(intent2);
                        Toast.makeText(MainActivity.this, "Welcome user", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                    }

                    if(result2 == true){
                        Intent intent2 = new Intent(MainActivity.this, SelectActivity.class);
                        startActivity(intent2);
                        Toast.makeText(MainActivity.this, "Welcome user", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Invalid user", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public Boolean login(String email,String password){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM users where email= ? and password= ?",
                new String[] {email,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean loginSeller(String email,String password){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM sellers where emailSeller= ? and passwordSeller= ?",
                new String[] {email,password});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ibtnNext:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;

        }

    }
}