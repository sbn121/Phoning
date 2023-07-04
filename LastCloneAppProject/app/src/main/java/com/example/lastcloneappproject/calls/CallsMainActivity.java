package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsMainBinding;

import java.util.ArrayList;

public class CallsMainActivity extends AppCompatActivity {

    ActivityCallsMainBinding binding;

    int count = 1;
    int count2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HideActionBar().hideActionBar(this);
        binding = ActivityCallsMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });
        binding.imgvBell.setOnClickListener(v -> {

            if (count % 2 == 1) {
                binding.imgvBell.setImageResource(R.drawable.calls_bell2);
                Toast.makeText(this, "이제부터 통화 알림을 받지 않아요.", Toast.LENGTH_SHORT).show();
                count++;
            } else {
                binding.imgvBell.setImageResource(R.drawable.calls_bell);
                Toast.makeText(this, "이제부터 통화 알림을 받을 수 있어요.", Toast.LENGTH_SHORT).show();
                count++;
            }

        });
        binding.imgvCalls.setOnClickListener(v -> {

            if (count2 % 2 == 1) {
                binding.imgvCalls.setImageResource(R.drawable.calls_missedcall);
                count2++;
            } else {
                binding.imgvCalls.setImageResource(R.drawable.calls_call);
                count2++;
            }

        });

        binding.recv.setAdapter(new CallsMainAdapter(getlist(), this));
        binding.recv.setLayoutManager(new LinearLayoutManager(this));

    }

    public ArrayList<CallsMainDTO> getlist() {
        ArrayList<CallsMainDTO> list = new ArrayList<>();
        list.add(new CallsMainDTO(R.drawable.calls_danielle, R.drawable.calls_callcheck, "다니엘_Danielle\uD83C\uDF3B", "37:46", "2023.6.27 16:10"));
        list.add(new CallsMainDTO(R.drawable.calls_minji, R.drawable.calls_callcheck, "민지Minji\uD83E\uDDF8", "38:00", "2023.6.16 14:05"));
        list.add(new CallsMainDTO(R.drawable.calls_newjeans, R.drawable.calls_callcheck, "NewJeans\uD83D\uDC56", "29:05", "2023.5.17 18:30"));
        list.add(new CallsMainDTO(R.drawable.calls_hyein, R.drawable.calls_callcheck, "혜인:)Hyein\uD83D\uDC23", "37:46", "2023.4.27 21:11"));
        list.add(new CallsMainDTO(R.drawable.calls_hanni, R.drawable.calls_callcheck, "하니_hanni_:)", "51:34", "2023.4.5 13:15"));
        list.add(new CallsMainDTO(R.drawable.calls_haerin, R.drawable.calls_callcheck, "해린_haerin", "26:20", "2023.3.27 15:05"));
        list.add(new CallsMainDTO(R.drawable.calls_hyein, R.drawable.calls_callcheck, "혜인:)Hyein\uD83D\uDC23", "07:14", "2023.3.25 12:57"));
        list.add(new CallsMainDTO(R.drawable.calls_minji, R.drawable.calls_callcheck, "민지\uD83C\uDF80", "45:45", "2023.3.25 11:34"));
        return list;
    }

}

