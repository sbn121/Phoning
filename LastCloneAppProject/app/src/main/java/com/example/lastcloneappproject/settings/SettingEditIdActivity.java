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
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.databinding.ActivitySettingEditIdBinding;
import com.example.lastcloneappproject.login.CommonVar;
import com.example.lastcloneappproject.login.LoginActivity;
import com.example.lastcloneappproject.login.PhoningVO;
import com.google.android.gms.common.internal.service.Common;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SettingEditIdActivity extends AppCompatActivity {

    ActivitySettingEditIdBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingEditIdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);



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
                        CommonConn conn = new CommonConn(SettingEditIdActivity.this, "editName");
                        conn.addParamMap("email", CommonVar.logininfo.getEmail());
                        conn.addParamMap("nickname", binding.edtId.getText().toString());
                        conn.onExcute((isResult, data) -> {
                            if(data.equals("성공")){
                                CommonConn conn1 = new CommonConn(SettingEditIdActivity.this, "checkEmail");
                                conn1.addParamMap("email", CommonVar.logininfo.getEmail());
                                conn1.onExcute((isResult1, data1) -> {
                                    CommonVar.logininfo = new Gson().fromJson(data1, PhoningVO.class);
                                    if(CommonVar.logininfo!=null){
                                        finish();
                                    }else {
                                        Toast.makeText(SettingEditIdActivity.this, "닉네임 업데이트 실패", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }else{

                            }
                        });

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