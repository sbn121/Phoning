package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsOnCallBinding;

public class CallsOnCallActivity extends AppCompatActivity {
    ActivityCallsOnCallBinding binding;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HideActionBar().hideActionBar(this);
        binding = ActivityCallsOnCallBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentManager = getSupportFragmentManager();




        Intent intent1 = getIntent();

        String callDate = intent1.getStringExtra("call_date");

        if(callDate.equals("2023.6.27 16:10")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_danielle2);
        } else if (callDate.equals("2023.6.16 14:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
        }else if (callDate.equals("2023.5.17 18:30")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_newjeans2);
        }else if (callDate.equals("2023.4.27 21:11")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
        }else if (callDate.equals("2023.4.5 13:15")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hanni2);
        }else if (callDate.equals("2023.3.27 15:05")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_haerin2);
        }else if (callDate.equals("2023.3.25 12:57")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_hyein2);
        }else if (callDate.equals("2023.3.25 11:34")) {
            binding.containerBackground.setBackgroundResource(R.drawable.calls_minji2);
        }

        binding.containerBackground.setOnClickListener(v -> {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            Dialog dialog = new Dialog(this);
            Window window = dialog.getWindow();

            if(callDate.equals("2023.6.27 16:10")) {
                dialog.setTitle("다니엘_Danielle🌻");
            } else if (callDate.equals("2023.6.16 14:05")) {
                dialog.setTitle("민지Minji\uD83E\uDDF8");
            }else if (callDate.equals("2023.5.17 18:30")) {
                dialog.setTitle("NewJeans\uD83D\uDC56");
            }else if (callDate.equals("2023.4.27 21:11")) {
                dialog.setTitle("혜인:)Hyein\uD83D\uDC23");
            }else if (callDate.equals("2023.4.5 13:15")) {
                dialog.setTitle("하니_hanni_:)");
            }else if (callDate.equals("2023.3.27 15:05")) {
                dialog.setTitle("해린_haerin");
            }else if (callDate.equals("2023.3.25 12:57")) {
                dialog.setTitle("혜인:)Hyein\uD83D\uDC23");
            }else if (callDate.equals("2023.3.25 11:34")) {
                dialog.setTitle("민지Minji\uD83E\uDDF8");
            }
//            dlg.setMessage("확인용 내용");
//            dlg.setIcon(R.drawable.haerin2);
            dlg.show();
        });

    }
}