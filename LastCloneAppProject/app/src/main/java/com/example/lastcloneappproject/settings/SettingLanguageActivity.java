package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivitySettingLanguageBinding;

import java.util.ArrayList;

public class SettingLanguageActivity extends AppCompatActivity {

    ActivitySettingLanguageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setStatusBarColor(Color.TRANSPARENT);
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        binding.tvBack.setOnClickListener(v -> {
            finish();
        });

        ArrayList<LanguageDTO> list = new ArrayList<>();
        list.add(new LanguageDTO(binding.imgvLg1, binding.tvLg1, binding.lg1));
        list.add(new LanguageDTO(binding.imgvLg2, binding.tvLg2, binding.lg2));
        list.add(new LanguageDTO(binding.imgvLg3, binding.tvLg3, binding.lg3));
        list.add(new LanguageDTO(binding.imgvLg4, binding.tvLg4, binding.lg4));
//        for(int i=0;i<list.size();i++) {
//            int j = i;
//            list.get(i).getLg().setOnClickListener(v -> {
//               list.get(j).setImgv_lg();
//            });
//        }

        binding.tvDone.setOnClickListener(v -> {

            finish();
        });

    }
}