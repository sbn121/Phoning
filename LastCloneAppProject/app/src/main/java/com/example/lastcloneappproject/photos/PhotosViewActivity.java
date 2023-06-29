package com.example.lastcloneappproject.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosViewBinding;

import java.util.ArrayList;

public class PhotosViewActivity extends AppCompatActivity {

    ActivityPhotosViewBinding binding;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
//        PhotosMainDTO dto = (PhotosMainDTO) getIntent().getSerializableExtra("dto");
        binding.gridv.setAdapter(new PhotosViewGridvAdapter(getLayoutInflater()));
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
    }
}