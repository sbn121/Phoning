package com.example.lastcloneappproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.lastcloneappproject.calls.CallsMainActivity;
import com.example.lastcloneappproject.calendar.CalendarActivity;
import com.example.lastcloneappproject.databinding.ActivityMainBinding;
import com.example.lastcloneappproject.messages.MessageMainActivity;
import com.example.lastcloneappproject.photos.PhotosMainActivity;
import com.example.lastcloneappproject.settings.SettingActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvMessages.setOnClickListener(v -> {
            Intent intent = new Intent(this, MessageMainActivity.class);
            startActivity(intent);
        });

        binding.imgvCalls.setOnClickListener(v -> {
            Intent intent = new Intent(this, CallsMainActivity.class);
            startActivity(intent);
        });

        binding.relativePhotos.setOnClickListener(v -> {
            Intent intent = new Intent(this, PhotosMainActivity.class);
            startActivity(intent);
        });

        binding.imgvCalendar.setOnClickListener(v -> {
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
        });

        binding.relativeSettings.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivityForResult(intent, 0);
        });

        binding.relativeClick.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://newjeans.kr/"));
            startActivity(intent);
        });

    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && data==null){

        }else if(requestCode == 0 && data.getIntExtra("result", -1)==0){
            Intent intent = new Intent();
            intent.putExtra("result", 0);
            setResult(RESULT_OK, intent);
            finish();

        }else {

        }
    }

}