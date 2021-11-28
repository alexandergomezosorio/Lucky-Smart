package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moviles.lucky_smart.databinding.ActivityRegisterSellerBinding;

public class RegisterSellerActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityRegisterSellerBinding registerSellerBinding;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerSellerBinding = ActivityRegisterSellerBinding.inflate(getLayoutInflater());
        View view = registerSellerBinding.getRoot();
        setContentView(view);
        registerSellerBinding.btnBack4.setOnClickListener(this);
        dbHelper = new DbHelper(this);
    }

    public void registerSeller(View view){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues sellerData = new ContentValues();
        String emailSeller = registerSellerBinding.etEmail.getText().toString();
        String passwordSeller = registerSellerBinding.etPassword.getText().toString();
        String nameSeller = registerSellerBinding.etName5.getText().toString();
        String citySeller = registerSellerBinding.etCity2.getText().toString();
        String nameShop = registerSellerBinding.etNameShop.getText().toString();
        sellerData.put("emailSeller",emailSeller);
        sellerData.put("passwordSeller",passwordSeller);
        sellerData.put("nameSeller",nameSeller);
        sellerData.put("citySeller",citySeller);
        sellerData.put("nameShop",nameShop);


        long newSeller = db.insert("sellers",null,sellerData);
        Toast.makeText(this, ""+newSeller, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,RegisterProductsActivity.class);
        startActivity(intent);

    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBack4:
                Intent intent2 = new Intent(this,RegisterActivity.class);
                startActivity(intent2);
                break;
        }
    }
}