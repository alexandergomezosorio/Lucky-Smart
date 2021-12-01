package com.moviles.lucky_smart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.moviles.lucky_smart.databinding.ActivityProfileBinding;
import com.moviles.lucky_smart.databinding.ActivityProfileProductBinding;
import com.moviles.lucky_smart.databinding.ActivityRegisterProductsBinding;
import com.moviles.lucky_smart.entities.ProductEntity;
import com.moviles.lucky_smart.entities.UserEntity;

public class ProfileProductActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityProfileProductBinding profileProductBinding;
    private DbHelper dbHelper;
    private int idProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_product);
        profileProductBinding = ActivityProfileProductBinding.inflate(getLayoutInflater());
        View view = profileProductBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
        ProductEntity productData = (ProductEntity) getIntent().getSerializableExtra("productData");
        getProduct(productData);
    }

    public void getProduct(ProductEntity product){
        idProduct= product.getIdProduct();
        profileProductBinding.etNameProductEdit.setText(product.getNameProduct());
        profileProductBinding.etValueProductEdit.setText(String.valueOf(product.getValueProduct()));
        profileProductBinding.etCategoryProductEdit.setText(product.getCategoryProduct());
        profileProductBinding.etAmountProductEdit.setText(String.valueOf(product.getAmountProduct()));

    }

    public void updateProduct(View view){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String name = profileProductBinding.etNameProductEdit.getText().toString();
        String value = profileProductBinding.etValueProductEdit.getText().toString();
        String category = profileProductBinding.etCategoryProductEdit.getText().toString();
        String amount = profileProductBinding.etAmountProductEdit.getText().toString();


        String sql = String.format("UPDATE products set nameProduct='%s',valueProduct='%s',categoryProduct='%s',amountProduct='%s' WHERE idProduct=%s",name,value,category,amount,idProduct);
        db.execSQL(sql);
        Intent intent = new Intent(this,ListProductsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBack7:
                Intent intent2 = new Intent(this,ListProductsActivity.class);
                startActivity(intent2);
                break;
        }
    }
}