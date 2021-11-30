package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.databinding.ActivityProfileBinding;
import com.moviles.lucky_smart.databinding.ActivityProfileSellerBinding;
import com.moviles.lucky_smart.entities.SellerEntity;
import com.moviles.lucky_smart.entities.UserEntity;

public class ProfileSellerActivity extends AppCompatActivity {

    private ActivityProfileSellerBinding profileSellerBinding;
    private DbHelper dbHelper;
    private int idSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_seller);
        profileSellerBinding = ActivityProfileSellerBinding.inflate(getLayoutInflater());
        View view = profileSellerBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
        SellerEntity sellerData = (SellerEntity) getIntent().getSerializableExtra("sellerData");
        getSeller(sellerData);
    }

    public void getSeller(SellerEntity seller){
        idSeller= seller.getIdSeller();
        profileSellerBinding.etEmailSeller.setText(seller.getEmailSeller());
        profileSellerBinding.etPasswordSeller.setText(seller.getPasswordSeller());
        profileSellerBinding.etNameSeller.setText(seller.getNameSeller());
        profileSellerBinding.etCitySeller.setText(seller.getCitySeller());
        profileSellerBinding.etNameShopSeller.setText(seller.getNameShop());

    }

    public void updateSeller(View view){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String emailSeller = profileSellerBinding.etEmailSeller.getText().toString();
        String passwordSeller = profileSellerBinding.etPasswordSeller.getText().toString();
        String nameSeller = profileSellerBinding.etNameSeller.getText().toString();
        String citySeller = profileSellerBinding.etCitySeller.getText().toString();
        String nameShop = profileSellerBinding.etNameShopSeller.getText().toString();


        String sql = String.format("UPDATE users set emailSeller='%s',passwordSeller='%s',nameSeller='%s',citySeller='%s',nameShop='%s' WHERE idUser=%s",emailSeller,passwordSeller,nameSeller,citySeller,nameShop,idSeller);
        db.execSQL(sql);
        Intent intent = new Intent(this,ListUsersActivity.class);
        startActivity(intent);
    }
}