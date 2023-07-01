package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivitySettingLanguageBinding;

import java.util.ArrayList;

public class SettingLanguageActivity extends AppCompatActivity {

    ActivitySettingLanguageBinding binding;
    CommonUtility cu = new CommonUtility();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.tvBack.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("language", cu.setting_language);
            setResult(RESULT_OK, intent);
            finish();
        });
        SettingLanguageAdapter adapter = new SettingLanguageAdapter(getList());
        binding.recvLanguage.setAdapter(adapter);
        binding.recvLanguage.setLayoutManager(new LinearLayoutManager(this));



        binding.tvDone.setOnClickListener(v -> {
            String j = null;
            for (int i = 0; i < adapter.list.size(); i++) {
                if(adapter.list.get(i).isChecked()){
                    j = adapter.list.get(i).getTv_lg();
                }
            }

            Intent intent = new Intent();
            intent.putExtra("language", j);
            setResult(RESULT_OK, intent);
            finish();
        });

    }

    public ArrayList<LanguageDTO> getList(){
        ArrayList<LanguageDTO> list = new ArrayList<>();
        list.add(new LanguageDTO(false, "English"));
        list.add(new LanguageDTO(false, "한국어"));
        list.add(new LanguageDTO(false, "日本語"));
        list.add(new LanguageDTO(false, "中國語"));
        list.add(new LanguageDTO(false, "Español"));
        list.add(new LanguageDTO(false, "français"));
        list.add(new LanguageDTO(false, "Deutsch"));
        list.add(new LanguageDTO(false, "Русский"));
        list.add(new LanguageDTO(false, "português "));
        list.add(new LanguageDTO(false, "tiếng Việt"));
        list.add(new LanguageDTO(false, "Bahasa Indonesia"));
        list.add(new LanguageDTO(false, "Italiano"));
//        list.add(new LanguageDTO(false, "الْعَرَبِيَّة"));
        list.add(new LanguageDTO(false, "Türkçe "));
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getTv_lg().toString().equals(cu.setting_language)){
                list.set(i, new LanguageDTO(true, list.get(i).getTv_lg()));
            }
        }
        return list;
    }



}