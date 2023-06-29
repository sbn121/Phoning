package com.example.lastcloneappproject.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentSettingBinding;


public class SettingFragment extends Fragment {

   FragmentSettingBinding binding;
    private final int REQ_CODE = 1000;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);

        binding.tvEditId.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingEditIdActivity.class);
            intent.putExtra("tv_id", binding.tvId.getText().toString());
            startActivityForResult(intent, REQ_CODE);

        });

        binding.rlLanguage.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingLanguageActivity.class);
            startActivity(intent );
        });


        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE){
            String test = data.getStringExtra("test");
            binding.tvId.setText(test);
        }
    }
}