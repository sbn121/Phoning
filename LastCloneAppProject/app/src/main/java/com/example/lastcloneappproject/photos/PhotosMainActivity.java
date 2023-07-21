package com.example.lastcloneappproject.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosMainBinding;

import java.util.ArrayList;

public class PhotosMainActivity extends AppCompatActivity {

    ActivityPhotosMainBinding binding;

    Intent intent;

    PhotosGridvAdapter adapter;
    PhotosGridv2Adapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);

        ArrayList<PhotosMainDTO> list = getlist();
        ArrayList<PhotosMain2DTO> list2 = getlist2();
        adapter = new PhotosGridvAdapter(getLayoutInflater(), list, this);
        adapter2 = new PhotosGridv2Adapter(getLayoutInflater(), list2, this);
        binding.gridv.setAdapter(adapter);
        binding.gridv2.setAdapter(adapter2);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

    }

//    @Override
//    protected void onRestart() {
//        if(adapter!=null){
//            adapter.notifyDataSetChanged();
//        }
//        super.onRestart();
//
//    }

    ArrayList<PhotosMainDTO> getlist() {
        ArrayList<PhotosMainDTO> list = new ArrayList<>();
        list.add(new PhotosMainDTO(R.drawable.haerin1, "해린 HAERIN"));
        list.add(new PhotosMainDTO(R.drawable.minji1, "민지 MINJI"));
        list.add(new PhotosMainDTO(R.drawable.danielle1, "다니엘 DANIELLE"));
        list.add(new PhotosMainDTO(R.drawable.hanni1, "하니 HANNI"));
        list.add(new PhotosMainDTO(R.drawable.hyein1, "혜인 HYEIN"));
        list.add(new PhotosMainDTO(R.drawable.newjeans1, "NewJeans"));
//        역순 확인용
//        Collections.reverse(list);

        return list;
    }

    ArrayList<PhotosMain2DTO> getlist2() {
        ArrayList<PhotosMain2DTO> list = new ArrayList<>();
        list.add(new PhotosMain2DTO(R.drawable.photo_camera1, "\uD83D\uDC30 \uD83D\uDCF7"));
        list.add(new PhotosMain2DTO(R.drawable.photo_pen1, "\uD83D\uDC30 ✏️"));
        list.add(new PhotosMain2DTO(R.drawable.photo_moon1, "\uD83D\uDC30 \uD83C\uDF15"));
        list.add(new PhotosMain2DTO(R.drawable.photo_newjeansday1, "NewJeans Day"));

        return list;
    }


}