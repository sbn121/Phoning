package com.example.lastcloneappproject.calls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCallsMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CallsMainActivity extends AppCompatActivity {

    ActivityCallsMainBinding binding;
    CallsMainAdapter adapter;
    int count = 1;
    public static int count2 = 1;

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
        adapter = new CallsMainAdapter(getlist(), this , true);
        binding.recv.setAdapter(adapter);
        binding.recv.setLayoutManager(new LinearLayoutManager(this));


        binding.imgvCalls.setOnClickListener(v -> {

            if (count2 % 2 == 1) {
                binding.imgvCalls.setImageResource(R.drawable.calls_missedcall);
                // 통화 안 한 상대만 보이게
                 ArrayList<CallsMainDTO> list  = getlist() ;
                 ArrayList<CallsMainDTO> tempList = new ArrayList<>();
                for(int i = 0 ; i< list.size() ; i ++){
                    if(!list.get(i).isCheck()){
                        tempList.add(list.get(i));
                    }
                }
                adapter = new CallsMainAdapter(tempList, this , false);
                binding.recv.setAdapter(adapter);
                binding.recv.setLayoutManager(new LinearLayoutManager(this));


            } else {
                binding.imgvCalls.setImageResource(R.drawable.calls_call);
                // 통화 한 사람 안 한 사람 다 보이게
                adapter = new CallsMainAdapter(getlist(), this , true);
                binding.recv.setAdapter(adapter);
                binding.recv.setLayoutManager(new LinearLayoutManager(this));

            }
            count2++;
        });

    }

    public ArrayList<CallsMainDTO> getlist() {
        ArrayList<CallsMainDTO> list = new ArrayList<>();
        list.add(new CallsMainDTO(R.drawable.calls_danielle, 0, "다니엘_Danielle\uD83C\uDF3B", "37:46", "2023.6.27 16:10", CallsCommonUtility.IsCheck[0]));
        list.add(new CallsMainDTO(R.drawable.calls_minji, 0, "민지Minji\uD83E\uDDF8", "38:00", "2023.6.16 14:05", CallsCommonUtility.IsCheck[1]));
        list.add(new CallsMainDTO(R.drawable.calls_newjeans, 0, "NewJeans\uD83D\uDC56", "29:05", "2023.5.17 18:30", CallsCommonUtility.IsCheck[2]));
        list.add(new CallsMainDTO(R.drawable.calls_hyein, 0, "혜인:)Hyein\uD83D\uDC23", "37:46", "2023.4.27 21:11", CallsCommonUtility.IsCheck[3]));
        list.add(new CallsMainDTO(R.drawable.calls_hanni, 0, "하니_hanni_:)", "51:34", "2023.4.5 13:15", CallsCommonUtility.IsCheck[4]));
        list.add(new CallsMainDTO(R.drawable.calls_haerin, 0, "해린_haerin", "26:20", "2023.3.27 15:05", CallsCommonUtility.IsCheck[5]));
        list.add(new CallsMainDTO(R.drawable.calls_hyein, 0, "혜인:)Hyein\uD83D\uDC23", "07:14", "2023.3.25 12:57", CallsCommonUtility.IsCheck[6]));
        list.add(new CallsMainDTO(R.drawable.calls_minji, 0, "민지\uD83C\uDF80", "45:45", "2023.3.25 11:34", CallsCommonUtility.IsCheck[7]));
        return list;
    }

    @Override
    protected void onRestart() {
        if(adapter.isCheckCall==false){
            for (int i = 0; i < adapter.list.size(); i++) {
                if(adapter.list.get(i).isCheck()){
                    adapter.list.remove(i);
                }
            }
        }

        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        super.onRestart();
    }
}

