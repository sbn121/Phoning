package com.example.lastcloneappproject.photos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosViewBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PhotosViewActivity extends AppCompatActivity {


    ActivityPhotosViewBinding binding;

    Intent intent;
    PhotosViewGridvAdapter gridvAdapter ;
    PhotosMainDTO dto ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        dto = (PhotosMainDTO) getIntent().getSerializableExtra("dto");
        gridvAdapter= new PhotosViewGridvAdapter(getLayoutInflater(), dto, this );
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
        if(resultCode==RESULT_OK && requestCode==1000){
            dto = (PhotosMainDTO) data.getSerializableExtra("dto");
            gridvAdapter.dto = dto;
            gridvAdapter.notifyDataSetChanged();
        }
    }

}