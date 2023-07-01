package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityMainBinding;
import com.example.lastcloneappproject.databinding.ActivitySettingBinding;

public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingFragment()).commit();

    }
}