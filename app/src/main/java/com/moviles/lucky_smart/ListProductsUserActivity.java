package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.adapters.ProductAdapter;
import com.moviles.lucky_smart.adapters.ProductUserAdapter;
import com.moviles.lucky_smart.databinding.ActivityListProductsBinding;
import com.moviles.lucky_smart.databinding.ActivityListProductsUserBinding;
import com.moviles.lucky_smart.entities.ProductEntity;

import java.util.ArrayList;

public class ListProductsUserActivity extends AppCompatActivity {
    private ActivityListProductsUserBinding listProductsUserBinding;
    private DbHelper dbHelper;
    private int idProduct;
    private ArrayList<ProductEntity> productArrayList;
    private ProductUserAdapter productUserAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listProductsUserBinding = ActivityListProductsUserBinding.inflate(getLayoutInflater());
        View v = listProductsUserBinding.getRoot();
        setContentView(v);
        productArrayList = new ArrayList<>();
        dbHelper = new DbHelper(this);
        productUserAdapter = new ProductUserAdapter(this,productArrayList);
        listProductsUserBinding.rvListProductUser.setHasFixedSize(true);
        listProductsUserBinding.rvListProductUser.setLayoutManager(new LinearLayoutManager(this));
        listProductsUserBinding.rvListProductUser.setAdapter(productUserAdapter);
        listProducts();
    }

    public void listProducts() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT * FROM products",
                null);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                idProduct = Integer.parseInt(cursor.getString(0));
                int indexNameProductRow = cursor.getColumnIndex("nameProduct");
                int indexValueProductRow = cursor.getColumnIndex("valueProduct");
                int indexCategoryProductRow = cursor.getColumnIndex("categoryProduct");
                int indexAmountProductRow = cursor.getColumnIndex("amountProduct");

                String nameProduct = cursor.getString(indexNameProductRow);
                int valueProduct = Integer.parseInt(cursor.getString(indexValueProductRow));
                String categoryProduct = cursor.getString(indexCategoryProductRow);
                int amountProduct = Integer.parseInt(cursor.getString(indexAmountProductRow));
                ProductEntity productEntity = new ProductEntity();
                productEntity.setIdProduct(idProduct);
                productEntity.setNameProduct(nameProduct);
                productEntity.setValueProduct(valueProduct);
                productEntity.setCategoryProduct(categoryProduct);
                productEntity.setAmountProduct(amountProduct);
                productArrayList.add(productEntity);
            }
            productUserAdapter.notifyDataSetChanged();
        }
    }
}