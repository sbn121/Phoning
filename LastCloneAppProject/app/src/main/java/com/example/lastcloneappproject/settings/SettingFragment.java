package com.example.lastcloneappproject.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentSettingBinding;

import org.intellij.lang.annotations.Language;


public class SettingFragment extends Fragment {

   FragmentSettingBinding binding;
    CommonUtility cu = new CommonUtility();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        binding.tvId.setText(cu.user_id);
        binding.tvLanguage.setText(cu.setting_language);
        binding.tvAlarm.setText(cu.setting_alarm);

        binding.tvEditId.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingEditIdActivity.class);
            intent.putExtra("tv_id", binding.tvId.getText().toString());
            startActivityForResult(intent, 0);
        });


        binding.rlLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingLanguageActivity.class);
            startActivityForResult(intent, 1);
        });
        
        binding.rlAlarm.setOnClickListener(v -> {
            if(binding.tvAlarm.getText().toString()=="꺼짐") {
                binding.tvAlarm.setText("켜짐");
                Toast.makeText(getContext(), "알람이 켜졌습니다.", Toast.LENGTH_SHORT).show();
                cu.setting_alarm = "켜짐";
            }else {
                binding.tvAlarm.setText("꺼짐");
                Toast.makeText(getContext(), "알람이 꺼졌습니다.", Toast.LENGTH_SHORT).show();
                cu.setting_alarm = "꺼짐";
            }
        });

        binding.rlSubscribe.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingSubscribeActivity.class);
            startActivity(intent);
        });

        binding.rlNotice.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingNoticeActivity.class);
            startActivity(intent);
        });

        binding.rlAsk.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingAskActivity.class);
            startActivity(intent);
        });

        binding.rlTerm.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingTermActivity.class);
            startActivity(intent);
        });

        binding.rlService.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingServiceActivity.class);
            startActivity(intent);
        });

        binding.rlPrivacy.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingPrivacyActivity.class);
            startActivity(intent);
        });

        binding.rlSPolicy.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingSpolicyActivity.class);
            startActivity(intent);
        });

        binding.rlPPolicy.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingPpolicyActivity.class);
            startActivity(intent);
        });

        return binding.getRoot();
    }

    @Override
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