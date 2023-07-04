package com.example.lastcloneappproject.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCalendarBinding;

public class CalendarActivity extends AppCompatActivity {

    ActivityCalendarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalendarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);
    }
}