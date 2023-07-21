package com.example.lastcloneappproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.example.lastcloneappproject.databinding.ActivityCallsSplashBinding;
import com.example.lastcloneappproject.databinding.ActivitySplashBinding;
import com.example.lastcloneappproject.login.FirstActivity;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        


        new HideActionBar().hideActionBar(this);

//        로그인 화면 연결
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
            finish();
        }, 2000);

//        바로 메인 화면 연결
//        new Handler().postDelayed(() -> {
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }, 2000);

    }
}