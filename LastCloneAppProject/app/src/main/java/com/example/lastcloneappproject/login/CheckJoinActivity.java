package com.example.lastcloneappproject.login;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityCheckJoinBinding;

public class CheckJoinActivity extends AppCompatActivity {

    ActivityCheckJoinBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCheckJoinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        binding.tvEmail.setText(email);


        new HideActionBar().hideActionBar(this);

        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });

        binding.imgvClose.setOnClickListener(v -> {
            Intent intent1 =  new Intent();
            intent1.putExtra("result", 0);
            setResult(RESULT_OK, intent1);
            finish();
        });

        binding.tvBack.setOnClickListener(v -> {
            finish();
        });

        binding.imgvJoin.setOnClickListener(v -> {
            Intent intent2 = new Intent(CheckJoinActivity.this, JoinActivity.class);
            intent2.putExtra("email", email);
            startActivityForResult(intent2, 0);
        });

    }

    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && data==null){

        }else if(requestCode == 0 && data.getIntExtra("result", -1)==0){
            Intent intent3 = new Intent();
            intent3.putExtra("result", 0);
            setResult(RESULT_OK, intent3);
            finish();

        }else {

        }
    }



}