package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsCallOffSplashBinding;

public class CallsCallOffSplashActivity extends AppCompatActivity {
    ActivityCallsCallOffSplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCallsCallOffSplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new HideActionBar().hideActionBar(this);

        Intent intent1 = getIntent();

        String callDate = intent1.getStringExtra("call_date");

        if (callDate.equals("2023.6.27 16:10")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.danielle8);
            binding.tvName.setText("다니엘_Danielle\uD83C\uDF3B");
        } else if (callDate.equals("2023.6.16 14:05")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.minji8);
            binding.tvName.setText("민지Minji\uD83E\uDDF8");
        } else if (callDate.equals("2023.5.17 18:30")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.newjeans10);
            binding.tvName.setText("NewJeans\uD83D\uDC56");
        } else if (callDate.equals("2023.4.27 21:11")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.hyein8);
            binding.tvName.setText("혜인:)Hyein\uD83D\uDC23");
        } else if (callDate.equals("2023.4.5 13:15")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.hanni11);
            binding.tvName.setText("하니_hanni_:)");
        } else if (callDate.equals("2023.3.27 15:05")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.haerin8);
            binding.tvName.setText("해린_haerin");
        } else if (callDate.equals("2023.3.25 12:57")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.hyein8);
            binding.tvName.setText("혜인:)Hyein\uD83D\uDC23");
        } else if (callDate.equals("2023.3.25 11:34")) {
            binding.imgvBackground.setBackgroundResource(R.drawable.minji8);
            binding.tvName.setText("민지Minji\uD83E\uDDF8");
        }

        new Handler().postDelayed(() -> {
          //  Intent intent = new Intent(this, CallsMainActivity.class);
          //  startActivity(intent);
            finish();
        }, 3000);
    }
}