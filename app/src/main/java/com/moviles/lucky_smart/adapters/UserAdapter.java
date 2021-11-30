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
import com.moviles.lucky_smart.ProfileActivity;
import com.moviles.lucky_smart.databinding.UsersItemBinding;
import com.moviles.lucky_smart.entities.UserEntity;
import com.moviles.lucky_smart.databinding.UsersItemBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersViewHolder> {
    private UsersItemBinding usersItemBinding;
    private Context context;
    private DbHelper dbHelper;
    private ArrayList<UserEntity> userArrayList;
    public UserAdapter(Context context, ArrayList<UserEntity> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
        dbHelper = new DbHelper(context);
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        usersItemBinding = UsersItemBinding.inflate(LayoutInflater.from(context));
        return new UsersViewHolder(usersItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        final UserEntity user = userArrayList.get(position);
        holder.itemBinding.tvEmailSeller.setText(user.getEmail());
        holder.itemBinding.tvName.setText(user.getName());
        holder.itemBinding.tvcity.setText(user.getCity());

        holder.itemBinding.btnDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("users","idUser="+user.getIdUser(),null);
                for(int i=0;i<userArrayList.size();i++){
                    if(userArrayList.get(i).getIdUser() == user.getIdUser()){
                        userArrayList.remove(i);
                        break;
                    }
                }
                notifyDataSetChanged();
            }
        });

        holder.itemBinding.btnEditUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("userData",user);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {
        private UsersItemBinding itemBinding;
        public UsersViewHolder(@NonNull UsersItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;


        }
    }
}
