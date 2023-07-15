package com.example.lastcloneappproject.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMessageMainBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MessageMainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    ActivityMessageMainBinding binding;

    MessageMainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        // 메인 액티비티에 보이는 부분들 --> 챗어댑터? 챗 액티비티?

        adapter = new MessageMainAdapter(this, getlist());
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));

    }

    public ArrayList<MessageMainDTO> getlist() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String currentTime = dateFormat.format(new Date());
        ArrayList<MessageMainDTO> list = new ArrayList<>();
        list.add(new MessageMainDTO(R.drawable.haerin3, "해린1", "메시지확인용,", currentTime));
        list.add(new MessageMainDTO(R.drawable.minji3, "민지1", "메시지확인용,", currentTime));
        list.add(new MessageMainDTO(R.drawable.danielle5, "다니엘1", "메시지확인용,", currentTime));
        list.add(new MessageMainDTO(R.drawable.hyein2, "혜인1", "메시지확인용,", currentTime));
        list.add(new MessageMainDTO(R.drawable.hanni11, "하니1", "메시지확인용,", currentTime));
        list.add(new MessageMainDTO(R.drawable.newjeans11, "NewJeans1", "메시지확인용,", currentTime));
        return list;
    }


}