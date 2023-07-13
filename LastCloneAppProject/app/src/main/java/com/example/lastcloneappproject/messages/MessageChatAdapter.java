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
        TextView tv_msg = new TextView(context);
        tv_msg.setText(list.get(position).getText());
        tv_msg.setTextColor(Color.parseColor("#000000"));
        tv_msg.setTextSize(16f);
        tv_msg.setBackgroundResource(R.drawable.message_chat_background);
        tv_msg.setPadding(30,20,70,20);
        tv_msg.setMaxWidth(800);
        TextView tv_time = new TextView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.gravity=Gravity.BOTTOM;
        tv_time.setLayoutParams(params);
        tv_time.setText(list.get(position).getTime());
        tv_time.setTextColor(Color.parseColor("#000000"));
        tv_time.setTextSize(12f);
        holder.binding.containerFrame.addView(tv_msg);
        holder.binding.containerFrame.addView(tv_time);
        if (true) {
//            list.get(position).getName().equals("aaa")


          //  holder.binding.tvMessage.setBackgroundResource(R.drawable.message_chat_me_background);
            holder.binding.imgvMain.setVisibility(View.GONE);
            holder.binding.tvName.setVisibility(View.GONE);
            holder.binding.cVMain.setVisibility(View.GONE);

//            <TextView-->
//<!--                    android:id="@+id/tv_time"-->
//<!--                    android:layout_width="wrap_content"-->
//<!--                    android:layout_height="wrap_content"-->
//<!--                    android:text="시간"-->
//<!--                    android:textColor="@color/black"-->
//<!--                    android:textSize="12dp" />-->
//<!--                </LinearLayout>

//            holder.binding.containerTime.setLayoutParams(new LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
//
//            ));
//            LinearLayout.LayoutParams timeLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            timeLayoutParams.gravity = Gravity.BOTTOM ;
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
