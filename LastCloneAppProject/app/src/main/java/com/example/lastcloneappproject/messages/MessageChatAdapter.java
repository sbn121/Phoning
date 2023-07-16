package com.example.lastcloneappproject.messages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.checkerframework.common.subtyping.qual.Bottom;

import java.util.ArrayList;

public class MessageChatAdapter extends RecyclerView.Adapter<MessageChatAdapter.ViewHolder> {

    ArrayList<MessageChatDTO> list;
    Context context;
    boolean isChatCheck;
    private DatabaseReference databaseReference;

    public MessageChatAdapter(ArrayList<MessageChatDTO> list, Context context, boolean isChatCheck, DatabaseReference databaseReference) {
        this.list = list;
        this.context = context;
        this.isChatCheck = isChatCheck;
        this.databaseReference = databaseReference;
    }

    public void addData(MessageChatDTO chatDTO) {
        list.add(chatDTO);
        notifyDataSetChanged();
    }

    public void removeData(MessageChatDTO chatDTO) {
        list.remove(chatDTO);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvMessageChatBinding binding = ItemRecvMessageChatBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageChatDTO chatDTO = list.get(position);
        holder.binding.tvName.setText(chatDTO.getName());
        holder.binding.imgvMain.setImageResource(chatDTO.getImgRes());

        holder.binding.containerFrame.removeAllViews();
        TextView tv_msg = new TextView(context);
        TextView tv_time = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        if (chatDTO.isCheck()) {
            holder.binding.containerFrame.setLayoutParams(params2);
            holder.binding.tvName.setVisibility(View.GONE);
            holder.binding.imgvMain.setVisibility(View.GONE);
            holder.binding.cVMain.setVisibility(View.GONE);
            params2.gravity = Gravity.END;
            tv_msg.setText(chatDTO.getText());
            tv_msg.setTextColor(Color.parseColor("#000000"));
            tv_msg.setTextSize(16f);
            tv_msg.setBackgroundResource(R.drawable.message_chat_me_background);
            tv_msg.setPadding(30, 20, 70, 20);
            tv_msg.setMaxWidth(800);
            params.gravity = Gravity.BOTTOM | Gravity.END;
            params.setMargins(0, 0, 20, 0);
            tv_time.setLayoutParams(params);
            tv_time.setText(chatDTO.getTime());
            tv_time.setTextColor(Color.parseColor("#000000"));
            tv_time.setTextSize(12f);
            holder.binding.containerFrame.addView(tv_time);
            holder.binding.containerFrame.addView(tv_msg);
        } else {
            tv_msg.setText(chatDTO.getText());
            tv_msg.setTextColor(Color.parseColor("#000000"));
            tv_msg.setTextSize(16f);
            tv_msg.setBackgroundResource(R.drawable.message_chat_background);
            tv_msg.setPadding(30, 20, 70, 20);
            tv_msg.setMaxWidth(800);
            params.gravity = Gravity.BOTTOM | Gravity.START;
            tv_time.setLayoutParams(params);
            tv_time.setText(chatDTO.getTime());
            tv_time.setTextColor(Color.parseColor("#000000"));
            tv_time.setTextSize(12f);
            holder.binding.containerFrame.addView(tv_msg);
            holder.binding.containerFrame.addView(tv_time);
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
