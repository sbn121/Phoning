package com.example.lastcloneappproject.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityJoinBinding;
import com.google.android.play.core.integrity.b;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JoinActivity extends AppCompatActivity {

    ActivityJoinBinding binding;

    Boolean length, english, number, special;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityJoinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent3 = getIntent();
        String email = intent3.getStringExtra("email");

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
                    binding.tvLength.setTag(false);
                    length = (boolean) binding.tvLength.getTag();
                }else {
                    binding.tvLength.setTextColor(Color.parseColor("#5CC8C8"));
                    binding.tvLength.setTag(true);
                    length = (boolean) binding.tvLength.getTag();
                }
                if(Pattern.compile("[0-9]").matcher(binding.edtPw.getText().toString()).find()){
                    binding.tvNumber.setTextColor(Color.parseColor("#5CC8C8"));
                    binding.tvNumber.setTag(true);
                    number = (boolean) binding.tvNumber.getTag();
                }else {
                    binding.tvNumber.setTextColor(Color.parseColor("#E96630"));
                    binding.tvNumber.setTag(false);
                    number = (boolean) binding.tvNumber.getTag();
                }
                if(Pattern.compile("[A-Za-z]").matcher(binding.edtPw.getText().toString()).find()){
                    binding.tvEnglish.setTextColor(Color.parseColor("#5CC8C8"));
                    binding.tvEnglish.setTag(true);
                    english = (boolean) binding.tvEnglish.getTag();
                }else {
                    binding.tvEnglish.setTextColor(Color.parseColor("#E96630"));
                    binding.tvEnglish.setTag(false);
                    english = (boolean) binding.tvEnglish.getTag();
                }
                if(Pattern.compile("[$@$!%*#?&]").matcher(binding.edtPw.getText().toString()).find()){
                    binding.tvSpecial.setTextColor(Color.parseColor("#5CC8C8"));
                    binding.tvSpecial.setTag(true);
                    special = (boolean) binding.tvSpecial.getTag();
                }else {
                    binding.tvSpecial.setTextColor(Color.parseColor("#E96630"));
                    binding.tvSpecial.setTag(false);
                    special = (boolean) binding.tvSpecial.getTag();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.edtPwCheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.edtPwCheck.getText().toString().equals(binding.edtPw.getText().toString())){
                    binding.tvEqual.setText("비밀번호가 일치합니다.");
                    binding.tvEqual.setTextColor(Color.parseColor("#5CC8C8"));
                }else {
                    binding.tvEqual.setText("비밀번호가 일치하지 않습니다. 다시 확인해주세요.");
                    binding.tvEqual.setTextColor(Color.parseColor("#E96630"));
                }
                if(binding.edtPwCheck.getText().toString().length()==0){
                    binding.tvEqual.setText("비밀번호가 일치합니다.");
                    binding.tvEqual.setTextColor(Color.parseColor("#888E95"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        new HideActionBar().hideActionBar(this);

        binding.imgvNext.setOnClickListener(v -> {
            if(binding.edtPw.getText().toString().equals(binding.edtPwCheck.getText().toString())&&length&&english&&special&&number) {
                Intent intent = new Intent(JoinActivity.this, NicknameActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", binding.edtPw.getText().toString());
                startActivityForResult(intent, 0);
            }else {
                Toast.makeText(this, "유효한 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && data==null){

        }else if(requestCode == 0 && data.getIntExtra("result", -1)==0){
            Intent intent3 = new Intent();
            intent3.putExtra("result", 0);
            setResult(RESULT_OK, intent3);
            finish();

        }
    }

}