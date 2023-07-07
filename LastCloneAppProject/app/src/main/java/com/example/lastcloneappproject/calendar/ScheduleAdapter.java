package com.example.lastcloneappproject.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemRecvCalendarBinding;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder>{

    ItemRecvCalendarBinding binding;
    ArrayList<CalendarDTO> list;
    Context context;

    public ScheduleAdapter(ArrayList<CalendarDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemRecvCalendarBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvYear.setText(list.get(i).getYear());
        h.binding.tvMonth.setText(list.get(i).getMonth());
        h.binding.tvDay.setText(list.get(i).getDay());
        h.binding.tvDate.setText(list.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRecvCalendarBinding binding;

        public ViewHolder(@NonNull ItemRecvCalendarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
