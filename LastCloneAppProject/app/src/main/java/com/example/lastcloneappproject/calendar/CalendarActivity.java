package com.example.lastcloneappproject.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCalendarBinding;
import com.google.android.play.core.integrity.b;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class CalendarActivity extends AppCompatActivity {

    ActivityCalendarBinding binding;
    ScheduleAdapter adapter;
    SimpleDateFormat year = new SimpleDateFormat("yyyy");
    SimpleDateFormat month = new SimpleDateFormat("M");
    SimpleDateFormat day = new SimpleDateFormat("d");
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
          Smonth = month.format(date);
          Sday = day.format(date);
          Sdate = date1.format(date);

        binding.tvYear.setText(String.valueOf(Syear)+"년");
        binding.tvMonth.setText(String.valueOf(Smonth)+"월");
        binding.tvDay.setText(String.valueOf(Sday)+"일");
        //



        //요일 설정
        String[] dateArr = {"일", "월", "화", "수", "목", "금", "토"};
        String[] todayArr = new String[7];
        int k;
        for (int i = 0; i < dateArr.length; i++) {
            if(Sdate.equals(dateArr[i])){
                k = i;
                todayArr[0] = Sdate;
                for (int j = 1; j < dateArr.length; j++) {
                    if(k+j==dateArr.length){
                        k=-j;
                    }
                    todayArr[j] = dateArr[k+j];
                    if(todayArr[1]!=null&&todayArr[2]!=null&&todayArr[3]!=null&&todayArr[4]!=null&&todayArr[5]!=null&&todayArr[6]!=null){
                        break;
                    }
                }
            }
        }


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

                for (int i = 0; i < adapter.list.size(); i++) {
                    if (adapter.list.get(i).getYear().equals(binding.dp.getYear()+"년") &&
                            adapter.list.get(i).getMonth().equals(binding.dp.getMonth()+1+"월") &&
                            adapter.list.get(i).getDay().equals(binding.dp.getDayOfMonth()+"일")
                    ){
//                        binding.recvCalendar.getLayoutManager().scrollToPosition(i); // 맨마지막으로 있음.
                        ((LinearLayoutManager)binding.recvCalendar.getLayoutManager()).scrollToPositionWithOffset(i , 0); //맨위로 스크롤

                    }
                }

            }

        });

        binding.flBg.setOnClickListener(v -> {
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

                for (int i = 0; i < adapter.list.size(); i++) {
                    if (adapter.list.get(i).getYear().equals(binding.dp.getYear()+"년") &&
                            adapter.list.get(i).getMonth().equals(binding.dp.getMonth()+1+"월") &&
                            adapter.list.get(i).getDay().equals(binding.dp.getDayOfMonth()+"일")
                    ){
//                        binding.recvCalendar.getLayoutManager().scrollToPosition(i); // 맨마지막으로 있음.
                        ((LinearLayoutManager)binding.recvCalendar.getLayoutManager()).scrollToPositionWithOffset(i , 0); //맨위로 스크롤

                    }
                }
            }
        });

        //오늘날짜로 되돌리기
        binding.imgvToday.setOnClickListener(v -> {
            binding.tvYear.setText(String.valueOf(Syear)+"년");
            binding.tvMonth.setText(String.valueOf(Smonth)+"월");
            binding.tvDay.setText(String.valueOf(Sday)+"일");

            ((LinearLayoutManager)binding.recvCalendar.getLayoutManager()).scrollToPositionWithOffset(3 , 0);

            binding.dp.init(Integer.parseInt(Syear), Integer.parseInt(Smonth)-1, Integer.parseInt(Sday), null);
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
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Integer.parseInt(Sday)-3)+"일", todayArr[4]+"요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Integer.parseInt(Sday)-2)+"일", todayArr[5]+"요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Integer.parseInt(Sday)-1)+"일", todayArr[6]+"요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Sday)+"일", todayArr[0]+"요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Integer.parseInt(Sday)+1)+"일", todayArr[1]+"요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Integer.parseInt(Sday)+2)+"일", todayArr[2]+"요일"));
        list.add(new CalendarDTO(String.valueOf(Syear)+"년", String.valueOf(Smonth)+"월", String.valueOf(Integer.parseInt(Sday)+3)+"일", todayArr[3]+"요일"));

        adapter = new ScheduleAdapter(list, this);
        binding.recvCalendar.setAdapter(adapter);
        binding.recvCalendar.setLayoutManager(new LinearLayoutManager(this));

        ((LinearLayoutManager)binding.recvCalendar.getLayoutManager()).scrollToPositionWithOffset(3 , 0);

    }







}