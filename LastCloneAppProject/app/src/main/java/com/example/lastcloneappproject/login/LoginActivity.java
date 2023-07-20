package com.example.lastcloneappproject.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
                    binding.tvLoginOrJoin.setText("로그인해주세요.");
                    binding.tvPw.setVisibility(View.VISIBLE);
                    binding.edtPw.setVisibility(View.VISIBLE);
                    binding.imgvSubmit.setVisibility(View.GONE);
                    binding.imgvLogin.setVisibility(View.VISIBLE);
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

        binding.edtPw.setOnClickListener(v -> {
            binding.edtPw.clearFocus();
            binding.edtPw.requestFocus();
                    InputMethodManager imm = (InputMethodManager) this.getSystemService(Service.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(binding.edtPw, 0);
                    imm.showSoftInput(binding.edtPw, InputMethodManager.SHOW_IMPLICIT);
        });

        binding.imgvLogin.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this, "login");
            conn.addParamMap("email", binding.edtEmail.getText().toString());
            conn.addParamMap("pw", binding.edtPw.getText().toString());
            conn.onExcute((isResult, data) -> {
//                PhoningVO vo = new Gson().fromJson( data, new TypeToken< PhoningVO >(){}.getType() );
                CommonVar.logininfo = new Gson().fromJson(data, PhoningVO.class);
                if(CommonVar.logininfo!=null){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivityForResult(intent, 0);
                }else {
                    Toast.makeText(this, "비밀번호가 일치하지 않습니다. 다시 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            });
        });

        binding.tvFindPw.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, FindPwActivity.class);
            intent.putExtra("email", binding.edtEmail.getText().toString());
            startActivity(intent);
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