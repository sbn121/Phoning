package com.example.lastcloneappproject.photos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosView2Binding;
import com.example.lastcloneappproject.databinding.ActivityPhotosViewBinding;

public class PhotosView2Activity extends AppCompatActivity {
    ActivityPhotosView2Binding binding;

    PhotosMain2DTO dto;

    PhotosView2GridvAdapter gridvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosView2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        dto = (PhotosMain2DTO) getIntent().getSerializableExtra("dto2");
        gridvAdapter = new PhotosView2GridvAdapter(getLayoutInflater(), dto, this);
        binding.gridv.setAdapter(gridvAdapter);
        binding.name.setText(dto.getName());
        binding.imgvSort.setOnClickListener(v -> {
            int[] tempDtos = new int[dto.getImgSubs().length];
            boolean[] tempDtos2 = new boolean[dto.getIsState().length];
            for (int i = 0; i < dto.getImgSubs().length; i++) {// 10 - 0 - 1 9 , -
                int tempIdx = dto.getImgSubs().length - (i + 1);
                tempDtos[i] = dto.getImgSubs()[tempIdx];
                tempDtos2[i] = dto.getIsState()[tempIdx];
            }
            boolean[] array = PhotosCommonUtility.IsLike;
            for (int i = 0; i< array.length/ 2; i++) {
                boolean temp = array[i];
                array[i] = array[array.length -1 - i];
                array[array.length -1 -i] = temp;
            }
            dto.setImgSubs(tempDtos);
            dto.setIsState(tempDtos2);
            gridvAdapter.notifyDataSetChanged();
        });
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1000) {
            dto = (PhotosMain2DTO) data.getSerializableExtra("dto2");
            gridvAdapter.dto = dto;
            gridvAdapter.notifyDataSetChanged();
        }
    }
}