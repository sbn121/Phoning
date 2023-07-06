package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
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
    int progress = 0;

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
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    progress ++ ;
                    binding.sbTimer.setProgress(progress);
                    int hours = progress / 3600;
                    int minutes = (progress % 3600) / 60;
                    int seconds = progress % 60;

                    // 변환된 시간을 TextView 등에 표시
                    String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                    binding.tvTime.setText(timeString);

                }
            } ;

            // 새로운 스레드 실행 코드. 1초 단위로 현재 시각 표시 요청.
            class NewRunnable implements Runnable {
                @Override
                public void run() {
                    while (true) {

                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace() ;
                        }

                        // 메인 스레드에 runnable 전달.
                        runOnUiThread(runnable) ;
                    }
                }
            }

            NewRunnable nr = new NewRunnable() ;
            Thread t = new Thread(nr) ;
            t.start() ;


            int total = 970;
            binding.sbTimer.setMax(total);
            binding.sbTimer.setEnabled(true);

        });
    }
}