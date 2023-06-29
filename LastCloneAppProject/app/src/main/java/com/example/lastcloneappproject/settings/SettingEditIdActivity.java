package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivitySettingEditIdBinding;

public class SettingEditIdActivity extends AppCompatActivity {

    ActivitySettingEditIdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingEditIdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setStatusBarColor(Color.TRANSPARENT);
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        Intent intent = getIntent();
        String tv_id = intent.getStringExtra("tv_id");
        binding.edtId.setText(tv_id);

        binding.tvDone.setOnClickListener(v -> {
//            setResult(binding.edtId.getText().toString());
//            setResult(RESULT_OK);
            finish();
        });

    }
}