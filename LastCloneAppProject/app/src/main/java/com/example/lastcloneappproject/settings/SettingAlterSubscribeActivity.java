package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivitySettingAlterSubscribeBinding;

public class SettingAlterSubscribeActivity extends AppCompatActivity {

    ActivitySettingAlterSubscribeBinding binding;

    CommonUtility cu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingAlterSubscribeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("subscribe", cu.subscribe);
            setResult(RESULT_OK, intent);
            finish();
        });

        binding.imgvSubscribe.setOnClickListener(v -> {
            if(cu.subscribe.equals("연간")){
                cu.subscribe = "월간";
                Toast.makeText(this, "월간 구독으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        binding.imgvSubscribe2.setOnClickListener(v -> {
            if(cu.subscribe.equals("월간")){
                cu.subscribe = "연간";
                Toast.makeText(this, "연간 구독으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}