package com.moviles.lucky_smart.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moviles.lucky_smart.DbHelper;
import com.moviles.lucky_smart.ProfileProductActivity;
import com.moviles.lucky_smart.ProfileSellerActivity;
import com.moviles.lucky_smart.databinding.ProductsItemBinding;
import com.moviles.lucky_smart.databinding.SellersItemBinding;
import com.moviles.lucky_smart.entities.ProductEntity;


import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private ProductsItemBinding productsItemBinding;
    private Context context;
    private DbHelper dbHelper;
    private ArrayList<ProductEntity> productArrayList;

    public ProductAdapter(Context context, ArrayList<ProductEntity> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
        dbHelper = new DbHelper(context);
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productsItemBinding = ProductsItemBinding.inflate(LayoutInflater.from(context));
        return new ProductAdapter.ProductViewHolder(productsItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        final ProductEntity product = productArrayList.get(position);
        holder.itemBinding.tvNameProduct.setText(product.getNameProduct());
        holder.itemBinding.tvValueProduct.setText(String.valueOf(product.getValueProduct()));
        holder.itemBinding.tvCategoryProduct.setText(product.getCategoryProduct());
        holder.itemBinding.tvAmountProduct.setText(String.valueOf(product.getAmountProduct()));

        holder.itemBinding.btnDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("products","idProduct="+product.getIdProduct(),null);
                for(int i=0;i<productArrayList.size();i++){
                    if(productArrayList.get(i).getIdProduct() == product.getIdProduct()){
                        productArrayList.remove(i);
                        break;
                    }
                }
                notifyDataSetChanged();
            }
        });

        holder.itemBinding.btnEditProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileProductActivity.class);
                intent.putExtra("productData",product);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder{
        private ProductsItemBinding itemBinding;

        public ProductViewHolder(@NonNull ProductsItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
