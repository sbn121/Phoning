package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsOnCallBinding;

public class CallsOnCallActivity extends AppCompatActivity {
    ActivityCallsOnCallBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HideActionBar().hideActionBar(this);
        binding = ActivityCallsOnCallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent1 = getIntent();

        String callDate = intent1.getStringExtra("call_date");

        if(callDate.equals("2023.6.27 16:10")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_danielle2);
        } else if (callDate.equals("2023.6.16 14:05")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_minji2);
        }else if (callDate.equals("2023.5.17 18:30")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_newjeans2);
        }else if (callDate.equals("2023.4.27 21:11")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_hyein2);
        }else if (callDate.equals("2023.4.5 13:15")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_hanni2);
        }else if (callDate.equals("2023.3.27 15:05")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_haerin2);
        }else if (callDate.equals("2023.3.25 12:57")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_hyein2);
        }else if (callDate.equals("2023.3.25 11:34")) {
            binding.containerBackgorund.setBackgroundResource(R.drawable.calls_minji2);
        }

    }
}