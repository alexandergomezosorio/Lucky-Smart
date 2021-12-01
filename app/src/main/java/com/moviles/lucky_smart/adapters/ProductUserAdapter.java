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
import com.moviles.lucky_smart.databinding.ProductsuserItemBinding;
import com.moviles.lucky_smart.entities.ProductEntity;

import java.util.ArrayList;


public class ProductUserAdapter extends RecyclerView.Adapter<ProductUserAdapter.ProductUserViewHolder>{
    private ProductsuserItemBinding productsuserItemBinding;
    private Context context;
    private DbHelper dbHelper;
    private ArrayList<ProductEntity> productArrayList;

    public ProductUserAdapter(Context context, ArrayList<ProductEntity> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
        dbHelper = new DbHelper(context);
    }

    @NonNull
    @Override
    public ProductUserAdapter.ProductUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        productsuserItemBinding = ProductsuserItemBinding.inflate(LayoutInflater.from(context));
        return new ProductUserAdapter.ProductUserViewHolder(productsuserItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductUserViewHolder holder, int position) {
        final ProductEntity product = productArrayList.get(position);
        holder.itemBinding.tvNameProUs.setText(product.getNameProduct());
        holder.itemBinding.tvValueProUs.setText(String.valueOf(product.getValueProduct()));
        holder.itemBinding.tvCategoryProUs.setText(product.getCategoryProduct());
        holder.itemBinding.tvAmountProUs.setText(String.valueOf(product.getAmountProduct()));

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }


    public class ProductUserViewHolder extends RecyclerView.ViewHolder{
        private ProductsuserItemBinding itemBinding;

        public ProductUserViewHolder(@NonNull ProductsuserItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
