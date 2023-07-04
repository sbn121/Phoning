package com.example.lastcloneappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.calendar.CalendarActivity;
import com.example.lastcloneappproject.calls.CallsFragment;
import com.example.lastcloneappproject.databinding.ActivityMainBinding;
import com.example.lastcloneappproject.photos.PhotosMainActivity;
import com.example.lastcloneappproject.settings.SettingActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvCalls.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });

        binding.imgvPhotos.setOnClickListener(v -> {
            Intent intent = new Intent(this, PhotosMainActivity.class);
            startActivity(intent);
        });

        binding.imgvCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
        });

        binding.imgvSettings.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        });

        binding.imgvClick.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newjeans.kr/"));
            startActivity(intent);
        });

    }
}