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
import com.moviles.lucky_smart.ProfileSellerActivity;
import com.moviles.lucky_smart.databinding.SellersItemBinding;
import com.moviles.lucky_smart.entities.SellerEntity;


import java.util.ArrayList;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.SellerViewHolder>{
    private SellersItemBinding sellersItemBinding;
    private Context context;
    private DbHelper dbHelper;
    private ArrayList<SellerEntity> sellerArrayList;

    public SellerAdapter(Context context, ArrayList<SellerEntity> sellerArrayList) {
        this.context = context;
        this.sellerArrayList = sellerArrayList;
        dbHelper = new DbHelper(context);
    }

    @NonNull
    @Override
    public SellerAdapter.SellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        sellersItemBinding = SellersItemBinding.inflate(LayoutInflater.from(context));
        return new SellerAdapter.SellerViewHolder(sellersItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerAdapter.SellerViewHolder holder, int position) {
        final SellerEntity seller = sellerArrayList.get(position);
        holder.itemBinding.tv.setText(seller.getEmailSeller());
        holder.itemBinding.tvName.setText(seller.getNameSeller());
        holder.itemBinding.tvcity.setText(seller.getCitySeller());

        holder.itemBinding.btnDeleteSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("seller","idSeller="+seller.getIdSeller(),null);
                for(int i=0;i<sellerArrayList.size();i++){
                    if(sellerArrayList.get(i).getIdSeller() == seller.getIdSeller()){
                        sellerArrayList.remove(i);
                        break;
                    }
                }
                notifyDataSetChanged();
            }
        });

        holder.itemBinding.btnEditSeller2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileSellerActivity.class);
                intent.putExtra("sellerData",seller);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sellerArrayList.size();
    }

    public class SellerViewHolder extends RecyclerView.ViewHolder {
        private SellerItemBinding itemBinding;
        public SellerViewHolder(@NonNull SellerItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;


        }
    }
}
