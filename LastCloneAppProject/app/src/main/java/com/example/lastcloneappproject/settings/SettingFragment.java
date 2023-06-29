package com.example.lastcloneappproject.settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lastcloneappproject.MainActivity;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentSettingBinding;


public class SettingFragment extends Fragment {

   FragmentSettingBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);

        binding.tvEditId.setOnClickListener(v -> {
            Intent intent = new Intent(this.getContext(), SettingEditIdActivity.class);
            intent.putExtra("tv_id", binding.tvId.getText().toString());
            startActivityForResult(intent, 0);

        });



        return binding.getRoot();
    }

}