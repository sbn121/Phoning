package com.example.lastcloneappproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityNicknameBinding;

public class NicknameActivity extends AppCompatActivity {

    ActivityNicknameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNicknameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        binding.imgvClose.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("result", 0);
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}