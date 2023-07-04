package com.example.lastcloneappproject.calls;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.databinding.ItemRecvCallsBinding;

import java.util.ArrayList;

public class CallsMainAdapter extends RecyclerView.Adapter<CallsMainAdapter.ViewHolder> {

    ArrayList<CallsMainDTO> list;

    public CallsMainAdapter(ArrayList<CallsMainDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvCallsBinding binding;
        binding = ItemRecvCallsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.imgvNewjeans.setImageResource(list.get(position).getNewjeansimg());
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.tvCallTime.setText(list.get(position).getCall_time());
        holder.binding.callCheck.setImageResource(list.get(position).getCall_check());
        holder.binding.callDate.setText(list.get(position).getCall_date());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRecvCallsBinding binding;

        public ViewHolder(@NonNull ItemRecvCallsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }

}
