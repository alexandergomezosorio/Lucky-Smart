package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moviles.lucky_smart.adapters.UserAdapter;
import com.moviles.lucky_smart.databinding.ActivityListSellerBinding;
import com.moviles.lucky_smart.entities.SellerEntity;
import com.moviles.lucky_smart.entities.UserEntity;

import java.util.ArrayList;

public class ListSellerActivity extends AppCompatActivity {

    private ActivityListSellerBinding listSellerBinding;
    private DbHelper dbHelper;
    private int idSeller;
    private ArrayList<SellerEntity> sellerArrayList;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_seller);
    }
}