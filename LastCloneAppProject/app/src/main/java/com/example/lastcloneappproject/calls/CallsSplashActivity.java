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

        Intent intent1 = getIntent();

        String callDate = intent1.getStringExtra("call_date");

        if(callDate.equals("2023.6.27 16:10")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_danielle2);
        } else if (callDate.equals("2023.6.16 14:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
        }else if (callDate.equals("2023.5.17 18:30")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2);
        }else if (callDate.equals("2023.4.27 21:11")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
        }else if (callDate.equals("2023.4.5 13:15")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hanni2);
        }else if (callDate.equals("2023.3.27 15:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_haerin2);
        }else if (callDate.equals("2023.3.25 12:57")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
        }else if (callDate.equals("2023.3.25 11:34")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
        }


        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, CallsOnCallActivity.class);
            intent.putExtra("call_date", callDate);
            startActivity(intent);
            finish();
        }, 2000);
    }
}