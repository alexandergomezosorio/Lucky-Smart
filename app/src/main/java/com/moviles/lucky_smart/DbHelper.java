package com.moviles.lucky_smart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "luckyApp";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE users (idUser INTEGER PRIMARY KEY AUTOINCREMENT," + "" +
                        "email VARCHAR(50),password VARCHAR(50),name VARCHAR(50),city VARCHAR(50) )");

        sqLiteDatabase.execSQL(
                "CREATE TABLE sellers (idSeller INTEGER PRIMARY KEY AUTOINCREMENT," + "" +
                        "emailSeller VARCHAR(50),passwordSeller VARCHAR(50),nameSeller VARCHAR(50),citySeller VARCHAR(50),nameShop VARCHAR(50) )");

        sqLiteDatabase.execSQL(
                "CREATE TABLE products (idProduct INTEGER PRIMARY KEY AUTOINCREMENT," + "" +
                        "nameProduct VARCHAR(50),valueProduct int,categoryProduct VARCHAR(50),amountProduct int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS sellers");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS products");
        onCreate(sqLiteDatabase);
    }
}
