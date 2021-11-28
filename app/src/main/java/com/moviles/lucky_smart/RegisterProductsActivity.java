package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moviles.lucky_smart.databinding.ActivityRegisterProductsBinding;

public class RegisterProductsActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegisterProductsBinding registerProductsBinding;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerProductsBinding = ActivityRegisterProductsBinding.inflate(getLayoutInflater());
        View view = registerProductsBinding.getRoot();
        setContentView(view);
        registerProductsBinding.btnBack3.setOnClickListener(this);
        dbHelper = new DbHelper(this);
    }

    public void registerProducts(View view){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues productData = new ContentValues();
        String nameProduct = registerProductsBinding.etNameProduct.getText().toString();
        String valueProduct = registerProductsBinding.etValueProduct.getText().toString();
        String categoryProduct = registerProductsBinding.etCategoryProduct.getText().toString();
        String amountProduct = registerProductsBinding.etAmountProduct.getText().toString();

        productData.put("nameProduct",nameProduct);
        productData.put("valueProduct",valueProduct);
        productData.put("categoryProduct",categoryProduct);
        productData.put("amountProduct",amountProduct);

        long newProduct = db.insert("products",null,productData);
        Toast.makeText(this, ""+newProduct, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,ListUsersActivity.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBack3:
                Intent intent2 = new Intent(this,RegisterSellerActivity.class);
                startActivity(intent2);
                break;
        }
    }
}