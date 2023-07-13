package com.example.lastcloneappproject.calls;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemRecvCallsBinding;

import java.util.ArrayList;

public class CallsMainAdapter extends RecyclerView.Adapter<CallsMainAdapter.ViewHolder> {

    ArrayList<CallsMainDTO> list;

    Context context;
    boolean isCheckCall;
    public CallsMainAdapter(ArrayList<CallsMainDTO> list, Context context, boolean isCheckCall) {
        this.list = list;
        this.context = context;
        this.isCheckCall = isCheckCall;
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
        if (list.get(position).isCheck() == true ){
            holder.binding.callCheck.setImageResource(R.drawable.calls_callcheck);
        }
        //click했을때 이미지를 바꾸고 boolean도 true로 바뀜.
        holder.binding.containerRelative.setOnClickListener(v -> {

            CallsCommonUtility.IsCheck[position] = true;
            list.get(position).setCheck(CallsCommonUtility.IsCheck[position]);
            Intent intent = new Intent(context, CallsSplashActivity.class);
            intent.putExtra("call_date", list.get(position).getCall_date());
            context.startActivity(intent);
           // ((Activity) context).finish();
        });


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
