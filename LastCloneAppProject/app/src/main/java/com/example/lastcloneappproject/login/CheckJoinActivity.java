package com.example.lastcloneappproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCheckJoinBinding;

public class CheckJoinActivity extends AppCompatActivity {

    ActivityCheckJoinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckJoinBinding.inflate(getLayoutInflater());
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

        binding.tvBack.setOnClickListener(v -> {
            finish();
        });

        binding.imgvJoin.setOnClickListener(v -> {

        });

    }
}