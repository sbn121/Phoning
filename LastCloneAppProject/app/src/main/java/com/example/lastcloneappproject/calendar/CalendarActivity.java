package com.example.lastcloneappproject.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCalendarBinding;

import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    ActivityCalendarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalendarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

//        Date currentTime = Calendar.getInstance().getTime();
//
//        binding.tvYear.setText(currentTime.getYear());
//        binding.tvMonth.setText(currentTime.getMonth());
//        binding.tvDay.setText(currentTime.getDay());

        binding.lnDate.setOnClickListener(v -> {
            if(binding.dp.getVisibility()== View.GONE){
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_down_24);
                binding.dp.setVisibility(View.VISIBLE);

                binding.tvYear.setText(binding.dp.getYear()+"년");
                binding.tvMonth.setText(binding.dp.getMonth()+1+"월");
                binding.tvDay.setText(binding.dp.getDayOfMonth()+"일");
            }else {
                binding.imgvIcon.setImageResource(R.drawable.baseline_keyboard_arrow_up_24);
                binding.dp.setVisibility(View.GONE);
            }

        });

//        binding.dp.setOnDateChangedListener();

    }
}