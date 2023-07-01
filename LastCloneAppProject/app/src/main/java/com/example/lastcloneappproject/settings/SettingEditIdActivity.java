package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivitySettingEditIdBinding;

import java.util.ArrayList;

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



        String tv_id = getIntent().getStringExtra("tv_id");
        binding.edtId.setText(tv_id);
        binding.tvCnt.setText(tv_id.length()+"/18");

        binding.imgvBack.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("test" , tv_id);
            setResult(RESULT_OK , intent);
            finish();
        });
        binding.edtId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                binding.tvCnt.setText(s.toString().length()+"/18");
                if(s.toString().length()==0) {
                    binding.tvDone.setTextColor(Color.parseColor("#5980C3"));
                }else {
                    binding.tvDone.setTextColor(Color.parseColor("#000000"));
                    binding.tvDone.setOnClickListener(v -> {

                        Intent intent = new Intent();
                        intent.putExtra("test" , binding.edtId.getText().toString());
                        setResult(RESULT_OK , intent);
//            setResult(RESULT_OK);
                        finish();

                    });
                }
            }
        });

        binding.edtId.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER) return true;
                return false;
            }
        });



        binding.imgvDelete.setOnClickListener(v -> {
            binding.edtId.setText("");
        });
    }
}