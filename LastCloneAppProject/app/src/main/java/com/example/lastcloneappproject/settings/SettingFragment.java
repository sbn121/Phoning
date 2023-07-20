package com.example.lastcloneappproject.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lastcloneappproject.common.CommonConn;
import com.example.lastcloneappproject.login.CommonVar;
import com.example.lastcloneappproject.databinding.FragmentSettingBinding;


public class SettingFragment extends Fragment {

   FragmentSettingBinding binding;
    CommonUtility cu = new CommonUtility();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        binding.tvId.setText(CommonVar.logininfo.getNickname());
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
            intent.putExtra("notice", "공지사항");
            startActivity(intent);
        });

        binding.rlAsk.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingNoticeActivity.class);
            intent.putExtra("notice", "자주 묻는 질문");
            startActivity(intent);
        });

        binding.rlTerm.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingNoticeActivity.class);
            intent.putExtra("notice", "이용 약관");
            startActivity(intent);
        });

        binding.rlService.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingNoticeActivity.class);
            intent.putExtra("notice", "유료 서비스 이용 약관");
            startActivity(intent);
        });

        binding.rlPrivacy.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingNoticeActivity.class);
            intent.putExtra("notice", "개인정보 처리 방침");
            startActivity(intent);
        });

        binding.rlSPolicy.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingNoticeActivity.class);
            intent.putExtra("notice", "서비스 운영 정책");
            startActivity(intent);
        });

        binding.rlPPolicy.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingNoticeActivity.class);
            intent.putExtra("notice", "청소년 보호 정책");
            startActivity(intent);
        });

        binding.tvLogout.setOnClickListener(v -> {
            CommonVar.logininfo = null;
//            Intent intent = new Intent();
//            intent.putExtra("result", 0);
//            setResult(RESULT_OK, intent);
//            SettingActivity sa;
//            sa = (SettingActivity) SettingFragment.this.getActivity().result;
//            sa.result = 0;
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().remove(SettingFragment.this).commit();
//            ((SettingActivity) SettingFragment.this.getActivity()).result = 0;
//            finish();
        });

        binding.tvAccount.setOnClickListener(v -> {
            CommonConn conn = new CommonConn(getContext(), "delete");
            conn.addParamMap("email", CommonVar.logininfo.getEmail());
            conn.onExcute((isResult, data) -> {
                if(data.equals("성공")){
                    Toast.makeText(getContext(), "계정이 탈퇴되었습니다.", Toast.LENGTH_SHORT).show();
                    CommonVar.logininfo = null;
//                    ((SettingActivity) SettingFragment.this.getActivity()).result = 0;
//                    Intent intent = new Intent();
//                    intent.putExtra("result", 0);
//                    setResult(RESULT_OK, intent);
//                    finish();
                }else {
                    Toast.makeText(getContext(), "탈퇴 실패", Toast.LENGTH_SHORT).show();
                }
            });
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