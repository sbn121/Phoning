package com.example.lastcloneappproject.settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.databinding.ActivityMainBinding;
import com.example.lastcloneappproject.databinding.ActivitySettingBinding;
import com.example.lastcloneappproject.login.CommonVar;

public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding binding;

    CommonUtility cu = new CommonUtility();

//    public int result=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        binding.tvId.setText(CommonVar.logininfo.getNickname());
        binding.tvLanguage.setText(cu.setting_language);
        binding.tvAlarm.setText(cu.setting_alarm);

        binding.tvEditId.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingEditIdActivity.class);
            intent.putExtra("tv_id", binding.tvId.getText().toString());
            startActivityForResult(intent, 0);
        });


        binding.rlLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingLanguageActivity.class);
            startActivityForResult(intent, 1);
        });

        binding.rlAlarm.setOnClickListener(v -> {
            if(binding.tvAlarm.getText().toString()=="꺼짐") {
                binding.tvAlarm.setText("켜짐");
                Toast.makeText(this, "알람이 켜졌습니다.", Toast.LENGTH_SHORT).show();
                cu.setting_alarm = "켜짐";
            }else {
                binding.tvAlarm.setText("꺼짐");
                Toast.makeText(this, "알람이 꺼졌습니다.", Toast.LENGTH_SHORT).show();
                cu.setting_alarm = "꺼짐";
            }
        });

        binding.rlSubscribe.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingSubscribeActivity.class);

            startActivity(intent);
        });

        binding.rlNotice.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingNoticeActivity.class);
            intent.putExtra("notice", "공지사항");
            startActivity(intent);
        });

        binding.rlAsk.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingNoticeActivity.class);
            intent.putExtra("notice", "자주 묻는 질문");
            startActivity(intent);
        });

        binding.rlTerm.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingNoticeActivity.class);
            intent.putExtra("notice", "이용 약관");
            startActivity(intent);
        });

        binding.rlService.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingNoticeActivity.class);
            intent.putExtra("notice", "유료 서비스 이용 약관");
            startActivity(intent);
        });

        binding.rlPrivacy.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingNoticeActivity.class);
            intent.putExtra("notice", "개인정보 처리 방침");
            startActivity(intent);
        });

        binding.rlSPolicy.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingNoticeActivity.class);
            intent.putExtra("notice", "서비스 운영 정책");
            startActivity(intent);
        });

        binding.rlPPolicy.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingNoticeActivity.class);
            intent.putExtra("notice", "청소년 보호 정책");
            startActivity(intent);
        });

        binding.tvLogout.setOnClickListener(v -> {
            CommonVar.logininfo = null;
            Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra("result", 0);
            setResult(RESULT_OK, intent);
            finish();
        });

        binding.tvAccount.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(this, "delete");
            conn.addParamMap("email", CommonVar.logininfo.getEmail());
            conn.onExcute((isResult, data) -> {
                if(data.equals("성공")){
                    Toast.makeText(this, "계정이 탈퇴되었습니다.", Toast.LENGTH_SHORT).show();
                    CommonVar.logininfo = null;
                    Intent intent = new Intent();
                    intent.putExtra("result", 0);
                    setResult(RESULT_OK, intent);
                    finish();
                }else {
                    Toast.makeText(this, "탈퇴 실패", Toast.LENGTH_SHORT).show();
                }
            });
        });


//        getSupportFragmentManager().beginTransaction().replace(R.id.container, new SettingFragment()).commit();


//        if(CommonVar.logininfo==null) {
//            Intent intent = new Intent();
//            intent.putExtra("result", 0);
//            setResult(RESULT_OK, intent);
//            finish();
//        }



    }


    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            String test = data.getStringExtra("test");
            binding.tvId.setText(test);;
            cu.user_id = test;
        }else if(requestCode ==1) {
            String language = data.getStringExtra("language");
            binding.tvLanguage.setText(language);
            cu.setting_language = language;
        }
    }

}