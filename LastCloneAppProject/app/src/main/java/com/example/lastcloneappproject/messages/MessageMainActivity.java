package com.example.lastcloneappproject.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMessageMainBinding;
import com.google.firebase.database.ChildEventListener;
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

    ArrayList<MessageMainDTO> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        databaseReference = FirebaseDatabase.getInstance().getReference();





        adapter = new MessageMainAdapter(this, getlist());
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
        addList("해린", R.drawable.haerin3);
        addList("혜인", R.drawable.hyein2);
        addList("민지", R.drawable.minji3);
        addList("다니엘", R.drawable.danielle5);
        addList("하니", R.drawable.hanni11);
        addList("NewJeans", R.drawable.newjeans11);
    }

    public ArrayList<MessageMainDTO> getlist() {
        DatabaseReference chatReference = databaseReference.child("chat").child("다니엘1");
        return list;
    }

    public void addList(String name, int img) {
        databaseReference.child("messages/chat/" + name).limitToLast(1).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                Log.d("", "onChildAdded: "+snapshot);
                MessageChatDTO dto = snapshot.getValue(MessageChatDTO.class);
//                Log.d("", "onChildAdded: "+dto.getName());
                list.add(new MessageMainDTO(img, name, dto.getText(), dto.getTime()));

                MessageMainDTO dto2 = new MessageMainDTO(img,name,dto.getText(), dto.getTime());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}