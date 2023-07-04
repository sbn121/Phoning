package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivitySettingNoticeBinding;

public class SettingNoticeActivity extends AppCompatActivity {

    ActivitySettingNoticeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingNoticeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        Intent intent = getIntent();
        String notice = intent.getStringExtra("notice");
        binding.tvNotice.setText(notice);
    }
}