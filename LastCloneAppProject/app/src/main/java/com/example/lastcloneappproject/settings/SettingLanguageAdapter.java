package com.example.lastcloneappproject.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemSettingLanguageRecvBinding;

import java.util.ArrayList;

public class SettingLanguageAdapter extends RecyclerView.Adapter<SettingLanguageAdapter.ViewHolder>{


    ArrayList<LanguageDTO> list;


    public SettingLanguageAdapter(ArrayList<LanguageDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSettingLanguageRecvBinding binding = ItemSettingLanguageRecvBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.radio.setText(list.get(i).getTv_lg());
        h.binding.radio.setChecked(list.get(i).isChecked());
        h.binding.radio.setOnClickListener(v-> {
            for (int j = 0; j < list.size(); j++) {
                list.get(j).setChecked(false);
                list.set(j, new LanguageDTO(false, list.get(j).getTv_lg()));
            }
            list.get(i).setChecked(true);
            list.set(i, new LanguageDTO(true, list.get(i).getTv_lg()));
            notifyDataSetChanged();

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemSettingLanguageRecvBinding binding;
        RadioButton rdo;
        TextView tv ;
        public ViewHolder(@NonNull ItemSettingLanguageRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
