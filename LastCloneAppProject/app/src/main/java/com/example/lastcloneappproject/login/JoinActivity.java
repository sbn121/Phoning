package com.example.lastcloneappproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityJoinBinding;
import com.google.android.play.core.integrity.b;

import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {

    ActivityJoinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJoinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        binding.imgvClose.setOnClickListener(v -> {
            Intent intent1 = new Intent();
            intent1.putExtra("result", 0);
            setResult(RESULT_OK, intent1);
            finish();
        });

        binding.edtPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.edtPw.getText().toString().length()<8||binding.edtPw.getText().toString().length()>32){
                    binding.tvLength.setTextColor(Color.parseColor("#E96630"));
                }else {
                    binding.tvLength.setTextColor(Color.parseColor("#5CC8C8"));
                }
                if(binding.edtPw.getText().toString().contains(Pattern.compile("[A-Za-z]").toString())){
                    binding.tvEnglish.setTextColor(Color.parseColor("#E96630"));
                }else {
                    binding.tvEnglish.setTextColor(Color.parseColor("#5CC8C8"));
                }
                if(binding.edtPw.getText().toString().contains(Pattern.compile("[0-9]").toString())){
                    binding.tvNumber.setTextColor(Color.parseColor("#E96630"));
                }else {
                    binding.tvNumber.setTextColor(Color.parseColor("#5CC8C8"));
                }
                if(binding.edtPw.getText().toString().contains(Pattern.compile("[$@$!%*#?&]").toString())){
                    binding.tvSpecial.setTextColor(Color.parseColor("#E96630"));
                }else {
                    binding.tvSpecial.setTextColor(Color.parseColor("#5CC8C8"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        new HideActionBar().hideActionBar(this);

        binding.imgvNext.setOnClickListener(v -> {
            Intent intent = new Intent(JoinActivity.this, NicknameActivity.class);
            intent.putExtra("password", binding.edtPw.getText().toString());
            startActivity(intent);
        });
    }
}