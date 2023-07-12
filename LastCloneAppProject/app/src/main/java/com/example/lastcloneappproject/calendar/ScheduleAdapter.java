package com.example.lastcloneappproject.calendar;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemRecvCalendarBinding;
import com.example.lastcloneappproject.databinding.ItemRecvScheduleBinding;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolderParent> {
    ArrayList<CalendarDTO> list;
    Context context;

    public ScheduleAdapter(ArrayList<CalendarDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderParent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderParent(ItemRecvCalendarBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderParent h, int i) {
        h.binding.tvYear.setText(list.get(i).getYear());
        h.binding.tvMonth.setText(list.get(i).getMonth());
        h.binding.tvDay.setText(list.get(i).getDay());
        h.binding.tvDate.setText(list.get(i).getDate());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            h.binding.rlToday.getFocusable();
        }

        ArrayList<ScheduleDTO> list = new ArrayList<>();
        list.add(new ScheduleDTO(R.drawable.calendar_newjeans, R.drawable.calendar_movie, "NewJeans", "'New Jeans' MV'", "891", "오전12:00"));
        list.add(new ScheduleDTO(R.drawable.calendar_newjeans, R.drawable.calendar_music, "NewJeans", "2nd EP 'Get Up' 음원 선공개", "432", "오후1:00"));
        list.add(new ScheduleDTO(R.drawable.calendar_newjeans, R.drawable.calendar_movie, "NewJeans", "'Super Shy' MV", "285", "오후1:00"));

        h.binding.recvSchedule.setAdapter(new ChlidAdapter(list, context));
        h.binding.recvSchedule.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderParent extends RecyclerView.ViewHolder {
        ItemRecvCalendarBinding binding;

        public ViewHolderParent(@NonNull ItemRecvCalendarBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public class ChlidAdapter extends RecyclerView.Adapter<ChlidAdapter.ViewHolderChild>{

        ArrayList<ScheduleDTO> list;
        Context context;

        public ChlidAdapter(ArrayList<ScheduleDTO> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public ViewHolderChild onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolderChild(ItemRecvScheduleBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolderChild h, int i) {
            h.binding.imgvProfile.setImageResource(list.get(i).getImgv_profile());
            h.binding.imgvMovie.setImageResource(list.get(i).getImgv_movie());
            h.binding.tvWriter.setText(list.get(i).getTv_writer());
            h.binding.tvTitle.setText(list.get(i).getTv_title());
            h.binding.tvChat.setText(list.get(i).getTv_chat());
            h.binding.tvTime.setText(list.get(i).getTv_time());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolderChild extends RecyclerView.ViewHolder {
        ItemRecvScheduleBinding binding;

        public ViewHolderChild(@NonNull ItemRecvScheduleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}



}



