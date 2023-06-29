package com.example.lastcloneappproject.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosViewDetailBinding;

public class PhotosViewDetailActivity extends AppCompatActivity {

    ActivityPhotosViewDetailBinding binding;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        PhotosMainDTO dto = (PhotosMainDTO) getIntent().getSerializableExtra("dto");


//        binding.imgvMain.setImageResource();
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        binding.imgvLike.setOnClickListener(v -> {

            if (count % 2 == 0) {
                binding.imgvLike.setImageResource(R.drawable.photos_like_empty);
                count++;
            } else {
                binding.imgvLike.setImageResource(R.drawable.photos_like);
                count++;
            }
        });
    }
}