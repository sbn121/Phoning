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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MessageChatActivity extends AppCompatActivity {
    ActivityMessageChatBinding binding;
    ArrayList<MessageChatDTO> list;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference("messages");

    boolean isChatCheck = false;

    public static String messageId = "";

    public static int img = 0;

    MessageChatDTO chatDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);


        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        MessageMainDTO messageMainDTO = (MessageMainDTO) getIntent().getSerializableExtra("dto");

        String itemName = messageMainDTO.getName();

        binding.tvName.setText(messageMainDTO.getName());
        binding.imgvFace.setImageResource(messageMainDTO.getImgRes());




        list = getlist();
        MessageChatAdapter adapter = new MessageChatAdapter(list, this, isChatCheck, databaseReference);
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
        binding.imgvSend.setOnClickListener(view -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String currentTime = dateFormat.format(new Date());
            String messageText = binding.edtMessage.getText().toString();
            if (!messageText.isEmpty()) {
                String name = getIntent().getStringExtra("name");
                int imgRes = getIntent().getIntExtra("img",0);
                messageId = databaseReference.child("chat").child(itemName).push().getKey();
                chatDTO = new MessageChatDTO(imgRes, name, messageText, currentTime, true);
//                chatDTO = new MessageChatDTO(imgRes, name, messageText, currentTime, false); // 상대방 채팅 넣고 싶을 때
                databaseReference.child("chat").child(itemName).child(messageId).setValue(chatDTO);
//                adapter.list.add(chatDTO);
                adapter.notifyDataSetChanged();
                binding.edtMessage.setText("");
            }
        });

        databaseReference.child("chat").child(itemName).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MessageChatDTO chatDTO = dataSnapshot.getValue(MessageChatDTO.class);
                chatDTO.setImgRes(messageMainDTO.getImgRes());
                adapter.addData(chatDTO);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                MessageChatDTO chatDTO = dataSnapshot.getValue(MessageChatDTO.class);
                adapter.removeData(chatDTO);
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