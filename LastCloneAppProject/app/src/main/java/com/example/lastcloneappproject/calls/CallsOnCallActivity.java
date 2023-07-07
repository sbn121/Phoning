package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.SeekBar;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsOnCallBinding;
import com.google.android.play.core.integrity.v;

public class CallsOnCallActivity extends AppCompatActivity {
    ActivityCallsOnCallBinding binding;

    FragmentManager fragmentManager;

    int imgcnt = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HideActionBar().hideActionBar(this);
        binding = ActivityCallsOnCallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentManager = getSupportFragmentManager();


        Intent intent1 = getIntent();

        String callDate = intent1.getStringExtra("call_date");

        if (callDate.equals("2023.6.27 16:10")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_danielle2);
        } else if (callDate.equals("2023.6.16 14:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
        } else if (callDate.equals("2023.5.17 18:30")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2);
        } else if (callDate.equals("2023.4.27 21:11")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
        } else if (callDate.equals("2023.4.5 13:15")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hanni2);
        } else if (callDate.equals("2023.3.27 15:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_haerin2);
        } else if (callDate.equals("2023.3.25 12:57")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
        } else if (callDate.equals("2023.3.25 11:34")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
        }

        binding.containerCall.setVisibility(View.INVISIBLE);
        binding.containerBackground.setOnClickListener(v -> {
            if(binding.containerCall.getVisibility() == View.INVISIBLE) {
                binding.containerCall.setVisibility(View.VISIBLE);
            } else {
                binding.containerCall.setVisibility(View.INVISIBLE);
            }
        });

        binding.btnPlay.setOnClickListener(view -> {


            if(imgcnt % 2 == 1) {
                binding.btnPlay.setImageResource(R.drawable.calls_stop);
                imgcnt++;
                startSeekBar();
            } else {
                binding.btnPlay.setImageResource(R.drawable.calls_play);
                imgcnt++;
                stopSeekBar();
            }

            binding.sbTimer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                    int hours = progress / 3600;
                    int minutes = (progress % 3600) / 60;
                    int seconds = progress % 60;

                    // 변환된 시간을 TextView 등에 표시
                    String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                    binding.tvTime.setText(timeString);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        });


    }

    private int savedProgress = 0; // 진행 상태를 저장할 변수

    private void startSeekBar() {
        int totalTime = 3600; // 총 길이를 초 단위로 설정 (예시: 1시간)
        binding.sbTimer.setMax(totalTime);
        binding.sbTimer.setEnabled(true);

        if (savedProgress == 0) {
            // 처음 시작하는 경우
            binding.sbTimer.setProgress(0); // 시작 상태의 진행 상태 설정
        } else {
            // 멈췄던 위치부터 다시 시작하는 경우
            binding.sbTimer.setProgress(savedProgress);
        }

        // SeekBar 진행 상태 업데이트
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for (int progress = binding.sbTimer.getProgress(); progress <= totalTime; progress++) {
                    try {
                        Thread.sleep(1000); // 1초마다 진행 상태 업데이트
                        binding.sbTimer.setProgress(progress);
                        savedProgress = progress; // 진행 상태 저장
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void stopSeekBar() {
        // SeekBar 정지 상태 처리
        binding.sbTimer.setEnabled(false);
    }



}