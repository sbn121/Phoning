package com.example.lastcloneappproject.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.databinding.ActivityPhotosMainBinding;

public class PhotosMainActivity extends AppCompatActivity {

    ActivityPhotosMainBinding binding;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setStatusBarColor(Color.TRANSPARENT);
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding.gridv.setAdapter(new PhotosGridvAdapter(getLayoutInflater()));

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        binding.imgvGallery.setOnClickListener(v -> {
            intent = new Intent(this, PhotosGalleryActivity.class);
            startActivity(intent);
        });
    }
}