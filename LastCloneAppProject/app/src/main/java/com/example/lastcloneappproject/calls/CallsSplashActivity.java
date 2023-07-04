package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsSplashBinding;

public class CallsSplashActivity extends AppCompatActivity {
    ActivityCallsSplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCallsSplashBinding.inflate(getLayoutInflater());
        new HideActionBar().hideActionBar(this);
        setContentView(binding.getRoot());

        // gif 파일 첨부를 위한 코드
        Glide.with(this).asGif().load(R.drawable.calls_loading).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(binding.imgvLoading);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, CallsOnCallActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}