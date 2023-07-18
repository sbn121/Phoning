package com.example.lastcloneappproject.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        new HideActionBar().hideActionBar(this);

        binding.imgvClose.setOnClickListener(v -> {
            finish();
        });


        
        binding.imgvSubmit.setOnClickListener(v -> {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$");
        Matcher matcher = pattern.matcher(binding.edtEmail.getText().toString());

        if(matcher.find()){
            //이메일 형식에 맞을 때
            CommonConn conn = new CommonConn(this, "checkEmail");
            conn.addParamMap("email", binding.edtEmail.getText().toString());
            conn.onExcute((isResult, data) -> {
                PhoningVO vo = new Gson().fromJson( data, new TypeToken< PhoningVO >(){}.getType() );
                if(vo!=null){
                    Toast.makeText(this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent   = new Intent(LoginActivity.this, CheckJoinActivity.class);
                    intent.putExtra("email", binding.edtEmail.getText().toString());
                    startActivityForResult(intent, 0);
                }
            });

        }else{
            //이메일 형식에 맞지 않을 때
            binding.tvWrong.setVisibility(View.VISIBLE);
        }
        });

        binding.edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(binding.edtEmail.getText().toString().length()>0){
                    binding.tvWrong.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.tvFindPw.setOnClickListener(v -> {

        });

    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && data==null){

        }else if(requestCode == 0 && data.getIntExtra("result", -1)==0){
            finish();

        }else {

        }
    }

}