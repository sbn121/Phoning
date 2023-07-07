package com.example.lastcloneappproject.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCalendarBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    ActivityCalendarBinding binding;

    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    SimpleDateFormat day = new SimpleDateFormat("dd");
    SimpleDateFormat date1 = new SimpleDateFormat("E");

    String Syear = new String();
    String Smonth = new String();
    String Sday = new String();
    String Sdate = new String();
    Date date = new Date();



    boolean all=true, newjeans, minji, hanni, danielle, hyein, haerin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalendarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        //오늘날짜 설정

          Syear = year.format(date);
          if(Integer.parseInt(month.format(date))<10){
              Smonth = month.format(date).toString().substring(1);
          }
        if(Integer.parseInt(day.format(date))<10){
            Sday = day.format(date).toString().substring(1);
        }
        Sdate = date1.format(date);

        binding.tvYear.setText(String.valueOf(Syear)+"년");
        binding.tvMonth.setText(String.valueOf(Smonth)+"월");
        binding.tvDay.setText(String.valueOf(Sday)+"일");
        //

        //달력 열고닫기
        binding.lnDate.setOnClickListener(v -> {
            if(binding.dp.getVisibility()== View.GONE){
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                binding.dp.setVisibility(View.VISIBLE);
                binding.flBg.setVisibility(View.VISIBLE);

            }else {
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
                binding.dp.setVisibility(View.GONE);
                binding.flBg.setVisibility(View.GONE);

                binding.tvYear.setText(binding.dp.getYear()+"년");
                binding.tvMonth.setText(binding.dp.getMonth()+1+"월");
                binding.tvDay.setText(binding.dp.getDayOfMonth()+"일");
            }

        });

        //오늘날짜로 되돌리기
        binding.imgvToday.setOnClickListener(v -> {
            binding.tvYear.setText(String.valueOf(Syear)+"년");
            binding.tvMonth.setText(String.valueOf(Smonth)+"월");
            binding.tvDay.setText(String.valueOf(Sday)+"일");
        });

        binding.imgvAll.setOnClickListener(v -> {
            if(!all){
                all=true;
                binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                newjeans=false;
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans);
                minji=false;
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji);
                hanni=false;
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni);
                danielle=false;
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle);
                hyein=false;
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein);
                haerin=false;
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin);
            }
        });

        binding.imgvNewjeans.setOnClickListener(v -> {
            if(newjeans){
                newjeans=false;
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans);
                if(!newjeans&&!minji&&!hanni&&!danielle&&!hyein&&!haerin){
                    all=true;
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                }
            }else {
                newjeans=true;
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans_checked);
                all=false;
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
            }
        });

        binding.imgvMinji.setOnClickListener(v -> {
            if(minji){
                minji=false;
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji);
                if(!newjeans&&!minji&&!hanni&&!danielle&&!hyein&&!haerin){
                    all=true;
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                }
            }else {
                minji=true;
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji_checked);
                all=false;
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
            }
        });

        binding.imgvHanni.setOnClickListener(v -> {
            if(hanni){
                hanni=false;
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni);
                if(!newjeans&&!minji&&!hanni&&!danielle&&!hyein&&!haerin){
                    all=true;
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                }
            }else {
                hanni=true;
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni_checked);
                all=false;
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
            }
        });

        binding.imgvDanielle.setOnClickListener(v -> {
            if(danielle){
                danielle=false;
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle);
                if(!newjeans&&!minji&&!hanni&&!danielle&&!hyein&&!haerin){
                    all=true;
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                }
            }else {
                danielle=true;
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle_checked);
                all=false;
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
            }
        });

        binding.imgvHyein.setOnClickListener(v -> {
            if(hyein){
                hyein=false;
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein);
                if(!newjeans&&!minji&&!hanni&&!danielle&&!hyein&&!haerin){
                    all=true;
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                }
            }else {
                hyein=true;
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein_checked);
                all=false;
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
            }
        });

        binding.imgvHaerin.setOnClickListener(v -> {
            if(haerin){
                haerin=false;
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin);
                if(!newjeans&&!minji&&!hanni&&!danielle&&!hyein&&!haerin){
                    all=true;
                    binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                }
            }else {
                haerin=true;
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin_checked);
                all=false;
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
            }
        });
        ArrayList<CalendarDTO> list = new ArrayList<>();
        list.add(new CalendarDTO("2023년", "7월", "3일", "화요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Sday)+"일", String.valueOf(Sdate)+"요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Sday)+"일", String.valueOf(Sdate)+"요일"));


        binding.recvCalendar.setAdapter(new ScheduleAdapter(list, this));
        binding.recvCalendar.setLayoutManager(new LinearLayoutManager(this));





    }





}