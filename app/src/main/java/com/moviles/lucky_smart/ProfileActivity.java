package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.databinding.ActivityProfileBinding;
import com.moviles.lucky_smart.entities.UserEntity;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding profileBinding;
    private DbHelper dbHelper;
    private int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = profileBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
        UserEntity userData = (UserEntity) getIntent().getSerializableExtra("userData");
        getUser(userData);
    }

    public void getUser(UserEntity user){
        idUser= user.getIdUser();
        profileBinding.etEmailEdit.setText(user.getEmail());
        profileBinding.etPasswordEdit.setText(user.getPassword());
        profileBinding.etNameEdit.setText(user.getName());
        profileBinding.etCityEdit.setText(user.getCity());

    }
    public void updateUser(View view){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String email = profileBinding.etEmailEdit.getText().toString();
        String password = profileBinding.etPasswordEdit.getText().toString();
        String name = profileBinding.etNameEdit.getText().toString();
        String city = profileBinding.etCityEdit.getText().toString();


        String sql = String.format("UPDATE users set email='%s',password='%s',name='%s',city='%s' WHERE idUser=%s",email,password,name,city,idUser);
        db.execSQL(sql);
        Intent intent = new Intent(this,ListUsersActivity.class);
        startActivity(intent);
    }
}