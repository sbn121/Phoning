package com.example.lastcloneappproject.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.FragmentSettingLanguageBinding;

public class SettingLanguageFragment extends Fragment {

    FragmentSettingLanguageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingLanguageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}