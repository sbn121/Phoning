package com.example.lastcloneappproject.messages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemRecvMessageChatBinding;

import java.util.ArrayList;

public class MessageChatAdapter extends RecyclerView.Adapter<MessageChatAdapter.ViewHolder> {

    ArrayList<MessageChatDTO> list;

    Context context;

    ArrayList<MessageChatMeDTO> meList;

    public MessageChatAdapter(ArrayList<MessageChatDTO> list, Context context, ArrayList<MessageChatMeDTO> meList) {
        this.list = list;
        this.context = context;
        this.meList = meList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvMessageChatBinding binding;
        binding = ItemRecvMessageChatBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvTime.setText(list.get(position).getTime());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.imgvMain.setImageResource(list.get(position).getImgRes());
        holder.binding.tvMessage.setText(list.get(position).getText());
        holder.binding.tvMessageMe.setText(meList.get(0).getChat());
        holder.binding.tvTimeMe.setVisibility(View.GONE);
        holder.binding.tvMessageMe.setVisibility(View.GONE);
        if(holder.binding.tvName.getText().equals("")) {
            holder.binding.tvName.setVisibility(View.GONE);
        }


    }
    //준병 잘존
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecvMessageChatBinding binding;

        public ViewHolder(@NonNull ItemRecvMessageChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
