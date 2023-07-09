package com.example.lastcloneappproject.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMessageChatBinding;

import java.util.ArrayList;

public class MessageChatActivity extends AppCompatActivity {
    ActivityMessageChatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        binding.recv.setAdapter(new MessageChatAdapter(getlist(),this));
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
        binding.imgvSend.setOnClickListener(view -> {
            Intent intent = new Intent(this, MessageChatAdapter.class);
            intent.putExtra("chat", binding.edtMessage.getText().toString());
            startActivityForResult(intent, 123);
        });

    }


    public ArrayList<MessageChatDTO> getlist() {
        ArrayList<MessageChatDTO> list = new ArrayList<>();
        list.add(new MessageChatDTO(R.drawable.haerin12,"이름","할말aaaaaaaaaaaaaaaaaa","12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin11,"이름","할말ㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂ","12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin10,"이름","할말ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㄴㅁㅇㄴㅁㅇ","12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin6,"이름","할말ㄴㅁㅇㅁㄴㅇ","12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin5,"이름","할ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㅇ말","12:34"));
        return list;
    }
}