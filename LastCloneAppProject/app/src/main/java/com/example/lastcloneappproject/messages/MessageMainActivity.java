package com.example.lastcloneappproject.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

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
        databaseReference = FirebaseDatabase.getInstance().getReference("해린1");





        adapter = new MessageMainAdapter(this, getlist());
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    String content = snapshot.child("해린1").child("text").getValue(String.class);
//                    list.add(new MessageMainDTO(R.drawable.haerin3, "해린1", content, currentTime));
//                }
//                adapter.notifyDataSetChanged(); // 어댑터에 변경을 알림
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // onCancelled 메서드 내부에서 에러 처리 로직 작성
//            }
//        });
    }

    public ArrayList<MessageMainDTO> getlist() {
        DatabaseReference chatReference = databaseReference.child("chat").child("다니엘1");
        list.add(new MessageMainDTO(R.drawable.haerin3, "해린1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.minji3, "민지1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.danielle5, "다니엘1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.hanni11, "하니1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.hyein2, "혜인1", chatReference.getKey(), currentTime));
        list.add(new MessageMainDTO(R.drawable.newjeans11, "NewJeans1", chatReference.getKey(), currentTime));
        return list;
    }
}