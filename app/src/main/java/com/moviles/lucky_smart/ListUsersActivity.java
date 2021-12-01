package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.adapters.UserAdapter;
import com.moviles.lucky_smart.databinding.ActivityListUsersBinding;
import com.moviles.lucky_smart.entities.UserEntity;

import java.util.ArrayList;

public class ListUsersActivity extends AppCompatActivity {

    private ActivityListUsersBinding listUsersBinding;
    private DbHelper dbHelper;
    private int idUser;
    private ArrayList<UserEntity> usersArrayList;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listUsersBinding = ActivityListUsersBinding.inflate(getLayoutInflater());
        View v = listUsersBinding.getRoot();
        setContentView(v);
        usersArrayList = new ArrayList<>();
        dbHelper = new DbHelper(this);
        userAdapter = new UserAdapter(this,usersArrayList);
        listUsersBinding.rvListUsers.setHasFixedSize(true);
        listUsersBinding.rvListUsers.setLayoutManager(new LinearLayoutManager(this));
        listUsersBinding.rvListUsers.setAdapter(userAdapter);
        listUser();
    }

    public void listUser(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM users",
                null);

        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                idUser = Integer.parseInt( cursor.getString(0));
                int indexEmailRow = cursor.getColumnIndex("email");
                int indexPasswordRow = cursor.getColumnIndex("password");
                int indexNameRow = cursor.getColumnIndex("name");
                int indexCityRow = cursor.getColumnIndex("city");
                String name =cursor.getString(indexNameRow);
                String email = cursor.getString(indexEmailRow);
                String password = cursor.getString(indexPasswordRow).toString();
                String city = cursor.getString(indexCityRow).toString();
                UserEntity userEntity = new UserEntity();
                userEntity.setIdUser(idUser);
                userEntity.setEmail(email);
                userEntity.setPassword(password);
                userEntity.setName(name);
                userEntity.setCity(city);

                usersArrayList.add(userEntity);
            }
            userAdapter.notifyDataSetChanged();
        }

    }

}