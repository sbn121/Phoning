package com.example.lastcloneappproject.messages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemRecvMessageChatBinding;

import java.util.ArrayList;

public class MessageChatAdapter extends RecyclerView.Adapter<MessageChatAdapter.ViewHolder> {

    ArrayList<MessageChatDTO> list;

    Context context;

    boolean isChatCheck;

    public MessageChatAdapter(ArrayList<MessageChatDTO> list, Context context, boolean isChatCheck) {
        this.list = list;
        this.context = context;
        this.isChatCheck = isChatCheck;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvMessageChatBinding binding;
        binding = ItemRecvMessageChatBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.tvTime.setText(list.get(position).getTime());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.imgvMain.setImageResource(list.get(position).getImgRes());
        holder.binding.tvMessage.setText(list.get(position).getText());
        if (isChatCheck) { //false로 넘어옴
//            holder.binding.tvName.getVisibility() == View.GONE // false
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.gravity = Gravity.END;
            holder.binding.containerFrame.setLayoutParams(layoutParams);
            holder.binding.tvMessage.setBackgroundResource(R.drawable.message_chat_me_background);
            holder.binding.imgvMain.setVisibility(View.GONE);
            holder.binding.tvName.setVisibility(View.GONE);
            holder.binding.cVMain.setVisibility(View.GONE);
            // 텍스트뷰만 위치 조정이안됨
//            LinearLayout.LayoutParams timeLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            timeLayoutParams.gravity = Gravity.BOTTOM | Gravity.LEFT;
//            holder.binding.containerTime.setLayoutParams(timeLayoutParams);
        }
    }

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
