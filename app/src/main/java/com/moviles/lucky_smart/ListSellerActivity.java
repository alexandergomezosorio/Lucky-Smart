package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.adapters.SellerAdapter;
import com.moviles.lucky_smart.databinding.ActivityListSellerBinding;
import com.moviles.lucky_smart.entities.SellerEntity;

import java.util.ArrayList;

public class ListSellerActivity extends AppCompatActivity {

    private ActivityListSellerBinding listSellerBinding;
    private DbHelper dbHelper;
    private int idSeller;
    private ArrayList<SellerEntity> sellerArrayList;
    private SellerAdapter sellerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seller);
        listSellerBinding = ActivityListSellerBinding.inflate(getLayoutInflater());
        View v = listSellerBinding.getRoot();
        setContentView(v);
        sellerArrayList = new ArrayList<>();
        dbHelper = new DbHelper(this);
        sellerAdapter = new SellerAdapter(this,sellerArrayList);
        listSellerBinding.rvListSellers.setHasFixedSize(true);
        listSellerBinding.rvListSellers.setLayoutManager(new LinearLayoutManager(this));
        listSellerBinding.rvListSellers.setAdapter(sellerAdapter);
        listSeller();

    }

    public void listSeller() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM sellers",
                null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                idSeller = Integer.parseInt(cursor.getString(0));
                int indexEmailSellerRow = cursor.getColumnIndex("emailSeller");
                int indexPasswordSellerRow = cursor.getColumnIndex("passwordSeller");
                int indexNameSellerRow = cursor.getColumnIndex("nameSeller");
                int indexCitySellerRow = cursor.getColumnIndex("citySeller");
                int indexNameShopRow = cursor.getColumnIndex("nameShop");

                String email = cursor.getString(indexEmailSellerRow);
                String password = cursor.getString(indexPasswordSellerRow).toString();
                String name = cursor.getString(indexNameSellerRow);
                String city = cursor.getString(indexCitySellerRow);
                String nameShop = cursor.getString(indexNameShopRow);
                SellerEntity sellerEntity = new SellerEntity();
                sellerEntity.setIdSeller(idSeller);
                sellerEntity.setEmailSeller(email);
                sellerEntity.setPasswordSeller(password);
                sellerEntity.setNameSeller(name);
                sellerEntity.setCitySeller(city);
                sellerEntity.setNameShop(nameShop);
                sellerArrayList.add(sellerEntity);
            }
            sellerAdapter.notifyDataSetChanged();
        }

    }


}