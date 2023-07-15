package com.example.lastcloneappproject.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMessageMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MessageMainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    ActivityMessageMainBinding binding;

    MessageMainAdapter adapter;

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    String currentTime = dateFormat.format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        adapter = new MessageMainAdapter(this, getlist());
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
    }

    public ArrayList<MessageMainDTO> getlist() {
        DatabaseReference chatReference = databaseReference.child("chat").child(MessageChatActivity.messageId);
        ArrayList<MessageMainDTO> list = new ArrayList<>();
        list.add(new MessageMainDTO(R.drawable.haerin3, "해린1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.minji3, "민지1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.danielle5, "다니엘1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.hyein2, "혜인1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.hanni11, "하니1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.newjeans11, "NewJeans1", chatReference.getKey(), currentTime));
        return list;
    }


}