package com.example.lastcloneappproject.messages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemRecvMessageChatBinding;

import org.checkerframework.common.subtyping.qual.Bottom;

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
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.imgvMain.setImageResource(list.get(position).getImgRes());


//        if (list.get(position).isCheck() == false) { // true 일 때로 바꾸기
        if (list.get(position).getName().equals("")) {

        }
//
        TextView tv_msg = new TextView(context);
        TextView tv_time = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        if(list.get(position).isCheck() == true) {
            tv_msg.setText(list.get(position).getText());
            tv_msg.setTextColor(Color.parseColor("#000000"));
            tv_msg.setTextSize(16f);
            tv_msg.setBackgroundResource(R.drawable.message_chat_me_background);
            tv_msg.setPadding(30, 20, 70, 20);
            tv_msg.setMaxWidth(800);
            params.gravity = Gravity.BOTTOM;
            tv_time.setLayoutParams(params);
            tv_time.setText(list.get(position).getTime());
            tv_time.setTextColor(Color.parseColor("#000000"));
            tv_time.setTextSize(12f);
            holder.binding.containerFrame.addView(tv_msg);
            holder.binding.containerFrame.addView(tv_time);
        } else {
            tv_msg.setText(list.get(position).getText());
            tv_msg.setTextColor(Color.parseColor("#000000"));
            tv_msg.setTextSize(16f);
            tv_msg.setBackgroundResource(R.drawable.message_chat_background);
            tv_msg.setPadding(30, 20, 70, 20);
            tv_msg.setMaxWidth(800);
            params.gravity = Gravity.BOTTOM;
            tv_time.setLayoutParams(params);
            tv_time.setText(list.get(position).getTime());
            tv_time.setTextColor(Color.parseColor("#000000"));
            tv_time.setTextSize(12f);
            holder.binding.containerFrame.addView(tv_msg);
            holder.binding.containerFrame.addView(tv_time);
        }


//            holder.binding.imgvMain.setVisibility(View.GONE);
//            holder.binding.tvName.setVisibility(View.GONE);
//            holder.binding.cVMain.setVisibility(View.GONE);
//        }
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

    public void changeText(ViewHolder holder, int position) {

        TextView tv_msg = new TextView(context);
        tv_msg.setText(list.get(position).getText());
        tv_msg.setTextColor(Color.parseColor("#000000"));
        tv_msg.setTextSize(16f);
        tv_msg.setBackgroundResource(R.drawable.message_chat_background);
        tv_msg.setPadding(30, 20, 70, 20);
        tv_msg.setMaxWidth(800);
        TextView tv_time = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.BOTTOM;
        tv_time.setLayoutParams(params);
        tv_time.setText(list.get(position).getTime());
        tv_time.setTextColor(Color.parseColor("#000000"));
        tv_time.setTextSize(12f);
        holder.binding.containerFrame.addView(tv_msg);
        holder.binding.containerFrame.addView(tv_time);

    }

}
