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

import java.util.ArrayList;

public class MessageMainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    ActivityMessageMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        binding.recv.setAdapter(new MessageMainAdapter(this, getlist()));
        binding.recv.setLayoutManager(new LinearLayoutManager(this));
    }

    public ArrayList<MessageMainDTO> getlist() {
        ArrayList<MessageMainDTO> list = new ArrayList<>();
        list.add(new MessageMainDTO(R.drawable.haerin3, "이름 확인용", "메시지확인용,", "날짜"));
        list.add(new MessageMainDTO(R.drawable.minji3, "이름 확인용", "메시지확인용,", "날짜"));
        list.add(new MessageMainDTO(R.drawable.danielle5, "이름 확인용", "메시지확인용,", "날짜"));
        list.add(new MessageMainDTO(R.drawable.hyein2, "이름 확인용", "메시지확인용,", "날짜"));
        list.add(new MessageMainDTO(R.drawable.hanni11, "이름 확인용", "메시지확인용,", "날짜"));
        list.add(new MessageMainDTO(R.drawable.newjeans11, "이름 확인용", "메시지확인용,", "날짜"));
        return list;
    }
}