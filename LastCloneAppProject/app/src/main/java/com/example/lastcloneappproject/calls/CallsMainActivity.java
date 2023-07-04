package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsMainBinding;

import java.util.ArrayList;

public class CallsMainActivity extends AppCompatActivity {

    ActivityCallsMainBinding binding;

    int count = 1;
    int count2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HideActionBar().hideActionBar(this);
        binding = ActivityCallsMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        binding.imgvBell.setOnClickListener(v -> {

            if (count % 2 == 1) {
                binding.imgvBell.setImageResource(R.drawable.calls_bell2);
                Toast.makeText(this, "이제부터 통화 알림을 받지 않아요.", Toast.LENGTH_SHORT).show();
                count++;
            } else {
                binding.imgvBell.setImageResource(R.drawable.calls_bell);
                Toast.makeText(this, "이제부터 통화 알림을 받을 수 있어요.", Toast.LENGTH_SHORT).show();
                count++;
            }

        });
        binding.imgvCalls.setOnClickListener(v -> {

            if (count2 % 2 == 1) {
                binding.imgvCalls.setImageResource(R.drawable.calls_missedcall);
                count2++;
            } else {
                binding.imgvCalls.setImageResource(R.drawable.calls_call);
                count2++;
            }

        });

        binding.recv.setAdapter(new CallsMainAdapter(getlist()));
        binding.recv.setLayoutManager(new LinearLayoutManager(this));

    }

    public ArrayList<CallsMainDTO> getlist() {
        ArrayList<CallsMainDTO> list = new ArrayList<>();
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        list.add(new CallsMainDTO(R.drawable.haerin2, R.drawable.calls_callcheck, "이름", "통화시간", "통화날짜"));
        return list;
    }

}

