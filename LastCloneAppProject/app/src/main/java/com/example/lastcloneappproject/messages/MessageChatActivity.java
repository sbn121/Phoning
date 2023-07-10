package com.example.lastcloneappproject.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMessageChatBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MessageChatActivity extends AppCompatActivity {
    ActivityMessageChatBinding binding;
    ArrayList<MessageChatMeDTO> meList ;
    ArrayList<MessageChatDTO> list;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        meList = getmelist();
        list=getlist() ;
        MessageChatAdapter adapter =  new MessageChatAdapter(list, this, meList);
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
        binding.imgvSend.setOnClickListener(view -> {
            if(! binding.edtMessage.getText().toString().equals("")) {
                //Intent intent = new Intent(this, MessageChatAdapter.class);
               // intent.putExtra("chat", binding.edtMessage.getText().toString());
                adapter.list.add(new  MessageChatDTO(R.drawable.haerin1 ,"이름", binding.edtMessage.getText().toString(),"시간"));
                adapter.notifyDataSetChanged();
            }
        });

    }


    public ArrayList<MessageChatDTO> getlist() {
        ArrayList<MessageChatDTO> list = new ArrayList<>();
        list.add(new MessageChatDTO(R.drawable.haerin12, "이름", "할말aaaaaaaaaaaaaaaaaa", "12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin11, "이름", "할말ㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂ", "12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin10, "이름", "할말ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㄴㅁㅇㄴㅁㅇ", "12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin6, "이름", "할말ㄴㅁㅇㅁㄴㅇ", "12:34"));
        list.add(new MessageChatDTO(R.drawable.haerin5, "이름", "할ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㅇ말", "12:34"));
        list.add(new MessageChatDTO(0,"","확인1",""));
        return list;
    }

    public ArrayList<MessageChatMeDTO> getmelist() {
        ArrayList<MessageChatMeDTO> list = new ArrayList<>();
        list.add(new MessageChatMeDTO("할말", "시간"));
        return list;
    }
}