package com.example.lastcloneappproject.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.databinding.ActivityNicknameBinding;

public class NicknameActivity extends AppCompatActivity {

    ActivityNicknameBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNicknameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent2 = getIntent();

        String email = intent2.getStringExtra("email");
        String pw = intent2.getStringExtra("password");


        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });



        Intent intent = new Intent();
        binding.imgvClose.setOnClickListener(v -> {
            intent.putExtra("result", 0);
            setResult(RESULT_OK, intent);
            finish();
        });

        binding.imgvNext.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this, "join");
            conn.addParamMap("email", email);
            conn.addParamMap("pw", pw);
            conn.addParamMap("nickname", binding.edtNickname.getText().toString());
            conn.onExcute((isResult, data) -> {
                if(data.equals("성공")){
                    Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("result", 0);
                    setResult(RESULT_OK, intent);
                    finish();
                }else {
                    Toast.makeText(this, "회원가입 실패!", Toast.LENGTH_SHORT).show();
                    intent.putExtra("result", 0);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        });

    }
}