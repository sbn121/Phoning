package com.example.lastcloneappproject.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMessageChatBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MessageChatActivity extends AppCompatActivity {
    ActivityMessageChatBinding binding;
    ArrayList<MessageChatDTO> list;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("messages");

    boolean isChatCheck =false;

    public static String name = "확인용1";

    String userName = "사용자 이름";
    String messageText = "메시지 내용";

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
        MessageChatAdapter adapter =  new MessageChatAdapter(list, this, isChatCheck, databaseReference);
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
        binding.imgvSend.setOnClickListener(view -> {
            String messageText = binding.edtMessage.getText().toString();
            if(! messageText.isEmpty()) {
                String messageId = databaseReference.child("chat").child(name).push().getKey();
                MessageChatDTO chatDTO = new MessageChatDTO(R.drawable.haerin1, userName, messageText, "시간", true);
                databaseReference.child("chat").child(name).child(messageId).setValue(chatDTO);
                adapter.list.add(chatDTO);
                adapter.notifyDataSetChanged();
                binding.edtMessage.setText("");
            }
        });

        databaseReference.child("chat").child(name).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MessageChatDTO chatDTO = dataSnapshot.getValue(MessageChatDTO.class);
                adapter.addData(chatDTO);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                MessageChatDTO chatDTO = dataSnapshot.getValue(MessageChatDTO.class);
                adapter.addData(chatDTO);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public ArrayList<MessageChatDTO> getlist() {
        ArrayList<MessageChatDTO> list = new ArrayList<>();
//        list.add(new MessageChatDTO(R.drawable.haerin12, "이름1", "할말aaaaaaaaaaaaaaaaaa", "12:34", false));
//        list.add(new MessageChatDTO(R.drawable.haerin11, "이름2", "할말ㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂㅂ", "12:34", false));
//        list.add(new MessageChatDTO(R.drawable.haerin10, "이름3", "할말ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㄴㅁㅇㄴㅁㅇ", "12:34", false));
//        list.add(new MessageChatDTO(R.drawable.haerin6, "이름4", "할말ㄴㅁㅇㅁㄴㅇ", "12:34", false));
//        list.add(new MessageChatDTO(R.drawable.haerin5, "이름5", "할ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㅇ말", "12:34", false));
        return list;
    }

    private void addMessage(DataSnapshot dataSnapshot, MessageChatAdapter adapter) {
        MessageChatDTO chatDTO = dataSnapshot.getValue(MessageChatDTO.class);
        adapter.list.add(chatDTO);
    }

    private void removeMessage(DataSnapshot dataSnapshot, MessageChatAdapter adapter) {
        MessageChatDTO chatDTO = dataSnapshot.getValue(MessageChatDTO.class);
        adapter.list.remove(chatDTO);
    }

}