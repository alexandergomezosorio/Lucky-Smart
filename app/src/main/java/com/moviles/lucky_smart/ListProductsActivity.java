package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.adapters.ProductAdapter;
import com.moviles.lucky_smart.adapters.SellerAdapter;
import com.moviles.lucky_smart.databinding.ActivityListProductsBinding;
import com.moviles.lucky_smart.databinding.ActivityListSellerBinding;
import com.moviles.lucky_smart.entities.ProductEntity;
import com.moviles.lucky_smart.entities.SellerEntity;

import java.util.ArrayList;

public class ListProductsActivity extends AppCompatActivity {

    private ActivityListProductsBinding listProductsBinding;
    private DbHelper dbHelper;
    private int idProduct;
    private ArrayList<ProductEntity> productArrayList;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);
        listProductsBinding = ActivityListProductsBinding.inflate(getLayoutInflater());
        View v = listProductsBinding.getRoot();
        setContentView(v);
        productArrayList = new ArrayList<>();
        dbHelper = new DbHelper(this);
        productAdapter = new ProductAdapter(this,productArrayList);
        listProductsBinding.rvListProducts.setHasFixedSize(true);
        listProductsBinding.rvListProducts.setLayoutManager(new LinearLayoutManager(this));
        listProductsBinding.rvListProducts.setAdapter(productAdapter);
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
            productAdapter.notifyDataSetChanged();
        }
    }

}