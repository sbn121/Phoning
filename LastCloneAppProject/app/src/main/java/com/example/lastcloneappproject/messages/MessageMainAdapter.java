package com.example.lastcloneappproject.messages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemRecvMessageBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MessageMainAdapter extends RecyclerView.Adapter<MessageMainAdapter.ViewHolder> {

    Context context;

    ArrayList<MessageMainDTO> list;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    boolean isFirst = true;

    public MessageMainAdapter(Context context, ArrayList<MessageMainDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvMessageBinding binding;
        binding = ItemRecvMessageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgvNewjeans.setImageResource(list.get(position).getImgRes());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.tvMsg.setText(list.get(position).getContent());
        holder.binding.tvMsgDate.setText(list.get(position).getDate());
        holder.binding.containerLinear.setOnClickListener(v -> {
            Intent intent = new Intent(context,MessageChatActivity.class);





            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecvMessageBinding binding;

        public ViewHolder(@NonNull ItemRecvMessageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

//    private  void loadData(ViewHolder holder) {
//        SharedPreferences pref = context.getSharedPreferences("profile", Context.MODE_PRIVATE);
//        MessageCommonUtility.name = pref.getString("name",null);
//        MessageCommonUtility.profileImg = pref.getString("profileImg",null);
//        if(MessageCommonUtility.name != null) {
//            holder.binding.tvName.setText(MessageCommonUtility.name);
//            Glide.with(context).load(MessageCommonUtility.profileImg).into(holder.binding.imgvNewjeans);
//            isFirst = false;
//        }
//    }




}
