package com.example.lastcloneappproject.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosMainBinding;

import java.util.ArrayList;

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

        ArrayList<PhotosMainDTO> list = getlist();
        PhotosGridvAdapter adapter = new PhotosGridvAdapter(getLayoutInflater(), list);
        binding.gridv.setAdapter(adapter);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        binding.imgvGallery.setOnClickListener(v -> {
            intent = new Intent(this, PhotosGalleryActivity.class);
            startActivity(intent);
        });


    }

    ArrayList<PhotosMainDTO> getlist() {
        ArrayList<PhotosMainDTO> list = new ArrayList<>();
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN1"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN2"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN3"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN4"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN4"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN4"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN4"));
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN4"));
        return list;
    }

}