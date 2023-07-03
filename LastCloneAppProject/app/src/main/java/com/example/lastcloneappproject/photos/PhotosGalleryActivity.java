package com.example.lastcloneappproject.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosGalaryBinding;

public class PhotosGalleryActivity extends AppCompatActivity {

    ActivityPhotosGalaryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosGalaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
//        binding.girdv.setAdapter();
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
    }
}