package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.DialogInterface;
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
    int zoomcnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HideActionBar().hideActionBar(this);
        binding = ActivityCallsOnCallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentManager = getSupportFragmentManager();

        startSeekBar();


        Intent intent1 = getIntent();

        String callDate = intent1.getStringExtra("call_date");

        if (callDate.equals("2023.6.27 16:10")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_danielle2);
            binding.tvName.setText("다니엘_Danielle\uD83C\uDF3B");
            binding.tvCallTotaltime.setText("00:37:46");
        } else if (callDate.equals("2023.6.16 14:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
            binding.tvName.setText("민지Minji\uD83E\uDDF8");
            binding.tvCallTotaltime.setText("00:38:00");
        } else if (callDate.equals("2023.5.17 18:30")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2);
            binding.tvName.setText("NewJeans\uD83D\uDC56");
            binding.tvCallTotaltime.setText("00:29:05");
        } else if (callDate.equals("2023.4.27 21:11")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
            binding.tvName.setText("혜인:)Hyein\uD83D\uDC23");
            binding.tvCallTotaltime.setText("00:37:46");
        } else if (callDate.equals("2023.4.5 13:15")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hanni2);
            binding.tvName.setText("하니_hanni_:)");
            binding.tvCallTotaltime.setText("00:51:34");
        } else if (callDate.equals("2023.3.27 15:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_haerin2);
            binding.tvName.setText("해린_haerin");
            binding.tvCallTotaltime.setText("00:26:20");
        } else if (callDate.equals("2023.3.25 12:57")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
            binding.tvName.setText("혜인:)Hyein\uD83D\uDC23");
            binding.tvCallTotaltime.setText("00:07:14");
        } else if (callDate.equals("2023.3.25 11:34")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
            binding.tvName.setText("민지Minji\uD83E\uDDF8");
            binding.tvCallTotaltime.setText("00:45:45");
        }
        intent1.putExtra("call_date", callDate);
        binding.imgvZoom.setOnClickListener(view -> {
            if (zoomcnt % 2 == 1) {
                binding.imgvZoom.setImageResource(R.drawable.calls_call_reduction);
                zoomcnt++;
            } else {
                binding.imgvZoom.setImageResource(R.drawable.calls_call_expansion);
                zoomcnt++;
            }
        });



        binding.imgvCalloff.setOnClickListener(view -> {
            Intent intent = new Intent(this, CallsCallOffSplashActivity.class);
            intent.putExtra("call_date", callDate);
            startActivity(intent);
            finish();
        });

        binding.containerCall.setVisibility(View.INVISIBLE);
        binding.containerBackground.setOnClickListener(v -> {
            if (binding.containerCall.getVisibility() == View.INVISIBLE) {
                binding.containerCall.setVisibility(View.VISIBLE);
            } else {
                binding.containerCall.setVisibility(View.INVISIBLE);
            }
        });

        binding.sbTimer.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int hours = progress / 3600;
                int minutes = (progress % 3600) / 60;
                int seconds = progress % 60;

                // 변환된 시간을 TextView 등에 표시
                String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                binding.tvTime.setText(timeString);
                binding.tvTime2.setText(timeString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.btnPlay.setOnClickListener(view -> {


            if (imgcnt % 2 == 1) {
                binding.btnPlay.setImageResource(R.drawable.calls_play);
                imgcnt++;
                stopSeekBar();
            } else {
                binding.btnPlay.setImageResource(R.drawable.calls_stop);
                imgcnt++;
                startSeekBar();
            }

        });


    }

    private int savedProgress = 0; // 진행 상태를 저장할 변수

    private AsyncTask<Void, Integer, Void> seekBarTask; // AsyncTask 변수 추가

    private void startSeekBar() {

        Intent intent1 = getIntent();

        String callDate = intent1.getStringExtra("call_date");

        int calltime = 0; // 총 길이를 초 단위로 설정

        if (callDate.equals("2023.6.27 16:10")) {
            calltime = 2266;
        } else if (callDate.equals("2023.6.16 14:05")) {
            calltime = 2280;
        } else if (callDate.equals("2023.5.17 18:30")) {
            calltime = 1745;
        } else if (callDate.equals("2023.4.27 21:11")) {
            calltime = 2266;
        } else if (callDate.equals("2023.4.5 13:15")) {
            calltime = 3094;
        } else if (callDate.equals("2023.3.27 15:05")) {
            calltime = 1580;
        } else if (callDate.equals("2023.3.25 12:57")) {
            calltime = 434;
        } else if (callDate.equals("2023.3.25 11:34")) {
            calltime = 2745;
        }

        int calltime2 = calltime;


        binding.sbTimer.setMax(calltime2);
        binding.sbTimer.setEnabled(true);

        if (savedProgress == 0) {
            // 처음 시작하는 경우
            binding.sbTimer.setProgress(0); // 시작 상태의 진행 상태 설정
        } else {
            // 멈췄던 위치부터 다시 시작하는 경우
            binding.sbTimer.setProgress(savedProgress);
        }

        // 이전에 실행 중인 AsyncTask가 있다면 취소
        if (seekBarTask != null) {
            seekBarTask.cancel(true);
        }

        // SeekBar 진행 상태 업데이트
        seekBarTask = new AsyncTask<Void, Integer, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                for (int progress = binding.sbTimer.getProgress(); progress <= calltime2; progress++) {
                    if (isCancelled()) {
                        // AsyncTask가 취소된 경우 종료
                        break;
                    }

                    try {
                        Thread.sleep(1000); // 1초마다 진행 상태 업데이트
                        publishProgress(progress);
                        savedProgress = progress; // 진행 상태 저장
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                int progress = values[0];
                binding.sbTimer.setProgress(progress);
            }
        };

        seekBarTask.execute();
    }

    private void stopSeekBar() {
        // AsyncTask가 실행 중이라면 취소
        if (seekBarTask != null) {
            seekBarTask.cancel(true);
        }

        // SeekBar 정지 상태 처리
        binding.sbTimer.setEnabled(false);
    }


}