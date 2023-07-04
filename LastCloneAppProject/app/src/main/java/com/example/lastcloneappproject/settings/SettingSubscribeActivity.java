package com.example.lastcloneappproject.settings;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivitySettingSubscribeBinding;

public class SettingSubscribeActivity extends AppCompatActivity {

    ActivitySettingSubscribeBinding binding;

    CommonUtility cu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingSubscribeBinding.inflate(getLayoutInflater());

        getSupportActionBar().hide();
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        window.setStatusBarColor(Color.TRANSPARENT);
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(view.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        setContentView(binding.getRoot());


        binding.tvSubscribe.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingAlterSubscribeActivity.class);
            startActivityForResult(intent, 0);
        });

        if(cu.subscribe.equals("연간")){
            binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe2);
            cu.subscribe="연간";
        }else {
            binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe);
            cu.subscribe="월간";
        }

//        binding.imgvRefresh.setOnClickListener(v -> {
//            finish();//인텐트 종료
//            overridePendingTransition(0, 0);//인텐트 효과 없애기
//            Intent intent = getIntent(); //인텐트
//            startActivity(intent); //액티비티 열기
//            overridePendingTransition(0, 0);//인텐트 효과 없애기
//            Toast.makeText(this, "새로고침 되었습니다", Toast.LENGTH_SHORT).show();
//        });

        binding.imgvBack.setOnClickListener(v -> {
            Intent intent = new Intent();
            if(cu.subscribe.equals("월간")){
                intent.putExtra("subscribe", "월간");
            }else {
                intent.putExtra("subscribe", "연간");
            }
            setResult(RESULT_OK, intent);
            finish();
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            String subscribe = data.getStringExtra("subscribe");
            if(subscribe.equals("연간")){
                binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe2);
                cu.subscribe="연간";
            }else {
                binding.imgvSubscribe.setImageResource(R.drawable.setting_subscribe);
                cu.subscribe="월간";
            }
        }
    }

}