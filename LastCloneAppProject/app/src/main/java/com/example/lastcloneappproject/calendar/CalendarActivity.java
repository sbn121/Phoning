package com.example.lastcloneappproject.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCalendarBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    ActivityCalendarBinding binding;

    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("MM");
    SimpleDateFormat day = new SimpleDateFormat("dd");

    String Syear = new String();

    String Smonth = new String();
    String Sday = new String();

    boolean all=true, newjeans=false, minji=false, hanni=false, danielle=false, hyein=false, haerin=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalendarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        //현재날짜 설정
          Date date = new Date();
          Syear = year.format(date);
          if(Integer.parseInt(month.format(date))<10){
              Smonth = month.format(date).toString().substring(1);
          }
        if(Integer.parseInt(day.format(date))<10){
            Sday = day.format(date).toString().substring(1);
        }

        binding.tvYear.setText(String.valueOf(Syear)+"년");
        binding.tvMonth.setText(String.valueOf(Smonth)+"월");
        binding.tvDay.setText(String.valueOf(Sday)+"일");
        //

        //달력 열고닫기
        binding.lnDate.setOnClickListener(v -> {
            if(binding.dp.getVisibility()== View.GONE){
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                binding.dp.setVisibility(View.VISIBLE);

            }else {
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
                binding.dp.setVisibility(View.GONE);

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
            if(all&&(!newjeans||!minji||!hanni||!danielle||!hyein||!haerin)){
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
                all=false;
            }else if(!all) {
                all=true;
                binding.imgvAll.setImageResource(R.drawable.calendar_all_checked);
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans);
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji);
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni);
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle);
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein);
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin);
            }
        });
        binding.imgvNewjeans.setOnClickListener(v -> {
            if(newjeans){
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans);
                all=false;
            }else if(!newjeans){
                binding.imgvNewjeans.setImageResource(R.drawable.calendar_newjeans_checked);
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
                all=true;
            }
        });
        binding.imgvMinji.setOnClickListener(v -> {
            if(minji){
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji);
                all=false;
            }else if(!minji){
                binding.imgvMinji.setImageResource(R.drawable.calendar_minji_checked);
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
                all=true;
            }
        });
        binding.imgvHanni.setOnClickListener(v -> {
            if(hanni){
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni);
                all=false;
            }else if(!hanni){
                binding.imgvHanni.setImageResource(R.drawable.calendar_hanni_checked);
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
                all=true;
            }
        });
        binding.imgvDanielle.setOnClickListener(v -> {
            if(danielle){
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle);
                all=false;
            }else if(!danielle){
                binding.imgvDanielle.setImageResource(R.drawable.calendar_danielle_checked);
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
                all=true;
            }
        });
        binding.imgvHyein.setOnClickListener(v -> {
            if(hyein){
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein);
                all=false;
            }else if(!hyein){
                binding.imgvHyein.setImageResource(R.drawable.calendar_hyein_checked);
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
                all=true;
            }
        });
        binding.imgvHaerin.setOnClickListener(v -> {
            if(haerin){
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin);
                all=false;
            }else if(!haerin){
                binding.imgvHaerin.setImageResource(R.drawable.calendar_haerin_checked);
                binding.imgvAll.setImageResource(R.drawable.calendar_all);
                all=true;
            }
        });


    }



}