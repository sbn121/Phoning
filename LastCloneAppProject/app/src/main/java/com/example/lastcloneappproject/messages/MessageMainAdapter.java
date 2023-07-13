package com.example.lastcloneappproject.messages;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemRecvMessageBinding;

import java.util.ArrayList;

public class MessageMainAdapter extends RecyclerView.Adapter<MessageMainAdapter.ViewHolder> {

    Context context;

    ArrayList<MessageMainDTO> list;

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
//            intent.putExtra("list",list);
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
}
