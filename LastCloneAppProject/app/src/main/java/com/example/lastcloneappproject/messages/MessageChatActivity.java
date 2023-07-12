package com.example.lastcloneappproject.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMessageChatBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MessageChatActivity extends AppCompatActivity {
    ActivityMessageChatBinding binding;
    ArrayList<MessageChatDTO> list;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    boolean isChatCheck =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);



        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        list=getlist() ;
        MessageChatAdapter adapter =  new MessageChatAdapter(list, this, isChatCheck);
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
        binding.imgvSend.setOnClickListener(view -> {
            if(! binding.edtMessage.getText().toString().equals("")) {
                adapter.list.add(new  MessageChatDTO(R.drawable.haerin1 ,"이름", binding.edtMessage.getText().toString(),"시간"));
                isChatCheck = true;
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
        return list;
    }

}