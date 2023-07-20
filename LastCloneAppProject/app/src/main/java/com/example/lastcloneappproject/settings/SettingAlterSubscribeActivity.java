package com.example.lastcloneappproject.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.databinding.ActivitySettingAlterSubscribeBinding;
import com.example.lastcloneappproject.login.CommonVar;
import com.example.lastcloneappproject.login.PhoningVO;
import com.google.gson.Gson;

public class SettingAlterSubscribeActivity extends AppCompatActivity {

    ActivitySettingAlterSubscribeBinding binding;

    CommonUtility cu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingAlterSubscribeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("subscribe", cu.subscribe);
            setResult(RESULT_OK, intent);
            finish();
        });

        binding.imgvSubscribe.setOnClickListener(v -> {
            if(CommonVar.logininfo.getSubscribe().equals("y")){
                CommonConn conn = new CommonConn(this, "subscribeMonth");
                conn.addParamMap("email", CommonVar.logininfo.getEmail());
                conn.onExcute(new CommonConn.SbnCallBack() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(data.equals("성공")){
                            CommonConn conn1 = new CommonConn(SettingAlterSubscribeActivity.this, "checkEmail");
                            conn1.addParamMap("email", CommonVar.logininfo.getEmail());
                            conn1.onExcute((isResult1, data1) -> {
                                CommonVar.logininfo = new Gson().fromJson(data1, PhoningVO.class);
                                if(CommonVar.logininfo!=null){
                                    Toast.makeText(SettingAlterSubscribeActivity.this, "월간 구독으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(SettingAlterSubscribeActivity.this, "구독 변경 실패", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else {
                            Toast.makeText(SettingAlterSubscribeActivity.this, "구독 변경 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        binding.imgvSubscribe2.setOnClickListener(v -> {
            if(CommonVar.logininfo.getSubscribe().equals("m")){
                CommonConn conn = new CommonConn(this, "subscribeYear");
                conn.addParamMap("email", CommonVar.logininfo.getEmail());
                conn.onExcute(new CommonConn.SbnCallBack() {
                    @Override
                    public void onResult(boolean isResult, String data) {
                        if(data.equals("성공")){
                            CommonConn conn1 = new CommonConn(SettingAlterSubscribeActivity.this, "checkEmail");
                            conn1.addParamMap("email", CommonVar.logininfo.getEmail());
                            conn1.onExcute((isResult1, data1) -> {
                                CommonVar.logininfo = new Gson().fromJson(data1, PhoningVO.class);
                                if(CommonVar.logininfo!=null){
                                    Toast.makeText(SettingAlterSubscribeActivity.this, "연간 구독으로 변경되었습니다.", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(SettingAlterSubscribeActivity.this, "구독 변경 실패", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }else {
                            Toast.makeText(SettingAlterSubscribeActivity.this, "구독 변경 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}