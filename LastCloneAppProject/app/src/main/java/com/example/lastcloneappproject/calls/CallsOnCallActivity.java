package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsOnCallBinding;
import com.google.android.play.core.integrity.v;

import org.w3c.dom.Text;

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

        binding.imgvSub.setOnClickListener(view -> {
            AlertDialog.Builder dlg = new AlertDialog.Builder(CallsOnCallActivity.this);
            View dialogView = LayoutInflater.from(CallsOnCallActivity.this).inflate(R.layout.dialog_calls_on_call, null);
            dlg.setView(dialogView);

            AlertDialog dialog = dlg.create();
            dialog.getWindow().setGravity(Gravity.BOTTOM);

            FrameLayout container_frame = dialogView.findViewById(R.id.container_frame);
            TextView tv_resolution = dialogView.findViewById(R.id.tv_resolution);
            container_frame.setOnClickListener(view1 -> {
                AlertDialog.Builder dlgDetail = new AlertDialog.Builder(CallsOnCallActivity.this);
                View dlgDetailView = LayoutInflater.from(CallsOnCallActivity.this).inflate(R.layout.dialog_detail_call_on_call, null);
                dlgDetail.setView(dlgDetailView);
                FrameLayout container_frame_auto = dlgDetailView.findViewById(R.id.container_frame_auto);
                FrameLayout container_frame_720p = dlgDetailView.findViewById(R.id.container_frame_720p);
                FrameLayout container_frame_480p = dlgDetailView.findViewById(R.id.container_frame_480p);
                FrameLayout container_frame_360p = dlgDetailView.findViewById(R.id.container_frame_360p);
                FrameLayout container_frame_160p = dlgDetailView.findViewById(R.id.container_frame_160p);

                TextView tv_auto = dlgDetailView.findViewById(R.id.tv_auto);
                TextView tv_720p = dlgDetailView.findViewById(R.id.tv_720p);
                TextView tv_480p = dlgDetailView.findViewById(R.id.tv_480p);
                TextView tv_360p = dlgDetailView.findViewById(R.id.tv_360p);
                TextView tv_160p = dlgDetailView.findViewById(R.id.tv_160p);
                ImageView imgv_check_auto = dlgDetailView.findViewById(R.id.imgv_check_auto);
                ImageView imgv_check_720p = dlgDetailView.findViewById(R.id.imgv_check_720p);
                ImageView imgv_check_480p = dlgDetailView.findViewById(R.id.imgv_check_480p);
                ImageView imgv_check_360p = dlgDetailView.findViewById(R.id.imgv_check_360p);
                ImageView imgv_check_160p = dlgDetailView.findViewById(R.id.imgv_check_160p);
//
                imgv_check_auto.setVisibility(View.VISIBLE);
                imgv_check_720p.setVisibility(View.INVISIBLE);
                imgv_check_480p.setVisibility(View.INVISIBLE);
                imgv_check_360p.setVisibility(View.INVISIBLE);
                imgv_check_160p.setVisibility(View.INVISIBLE);
                tv_auto.setTextColor(Color.parseColor("#000000"));
                tv_720p.setTextColor(Color.parseColor("#000000"));
                tv_480p.setTextColor(Color.parseColor("#000000"));
                tv_360p.setTextColor(Color.parseColor("#000000"));
                tv_160p.setTextColor(Color.parseColor("#000000"));

                AlertDialog dialogDetail = dlgDetail.create();

                dialogSetting(dlgDetailView.findViewById(R.id.tv_auto), dlgDetailView.findViewById(R.id.imgv_check_auto));
//                tv_resolution.setText("자동");

                container_frame_auto.setOnClickListener(view2 -> {
                    imgv_check_auto.setVisibility(View.VISIBLE);
                    imgv_check_720p.setVisibility(View.INVISIBLE);
                    imgv_check_480p.setVisibility(View.INVISIBLE);
                    imgv_check_360p.setVisibility(View.INVISIBLE);
                    imgv_check_160p.setVisibility(View.INVISIBLE);
                    tv_resolution.setText("자동");
                    dialogDetail.dismiss();
                });

                container_frame_720p.setOnClickListener(view2 -> {
                    imgv_check_720p.setVisibility(View.VISIBLE);
                    imgv_check_auto.setVisibility(View.INVISIBLE);
                    imgv_check_480p.setVisibility(View.INVISIBLE);
                    imgv_check_360p.setVisibility(View.INVISIBLE);
                    imgv_check_160p.setVisibility(View.INVISIBLE);
                    tv_resolution.setText("720p");
                    dialogDetail.dismiss();
                });

                container_frame_480p.setOnClickListener(view2 -> {
                    imgv_check_480p.setVisibility(View.VISIBLE);
                    imgv_check_720p.setVisibility(View.INVISIBLE);
                    imgv_check_auto.setVisibility(View.INVISIBLE);
                    imgv_check_360p.setVisibility(View.INVISIBLE);
                    imgv_check_160p.setVisibility(View.INVISIBLE);
                    tv_resolution.setText("480p");
                    dialogDetail.dismiss();
                });

                container_frame_360p.setOnClickListener(view2 -> {
                    imgv_check_360p.setVisibility(View.VISIBLE);
                    imgv_check_720p.setVisibility(View.INVISIBLE);
                    imgv_check_480p.setVisibility(View.INVISIBLE);
                    imgv_check_auto.setVisibility(View.INVISIBLE);
                    imgv_check_160p.setVisibility(View.INVISIBLE);
                    tv_resolution.setText("360p");
                    dialogDetail.dismiss();
                });

                container_frame_160p.setOnClickListener(view2 -> {
                    imgv_check_160p.setVisibility(View.VISIBLE);
                    imgv_check_720p.setVisibility(View.INVISIBLE);
                    imgv_check_480p.setVisibility(View.INVISIBLE);
                    imgv_check_360p.setVisibility(View.INVISIBLE);
                    imgv_check_auto.setVisibility(View.INVISIBLE);
                    tv_resolution.setText("160p");
                    dialogDetail.dismiss();
                });


                dialogDetail.show();

            });

            dialog.show();
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


                savedProgress = progress;
                if (b) {
                    taskProgress = progress;
                }
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
    private int taskProgress = 0;
    public static AsyncTask<Void, Integer, Void> seekBarTask; // AsyncTask 변수 추가

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
                for (taskProgress = binding.sbTimer.getProgress(); taskProgress <= calltime2; taskProgress++) {
                    if (isCancelled()) {
                        // AsyncTask가 취소된 경우 종료
                        break;
                    }

                    try {
                        Thread.sleep(1000); // 1초마다 진행 상태 업데이트
                        publishProgress(savedProgress);
                        savedProgress = taskProgress; // 진행 상태 저장
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                binding.sbTimer.setProgress(savedProgress);
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

    private void dialogSetting(TextView tvName, ImageView imgvName) {
    }

}