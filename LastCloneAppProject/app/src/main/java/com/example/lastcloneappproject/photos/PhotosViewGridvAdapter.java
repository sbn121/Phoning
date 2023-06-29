package com.example.lastcloneappproject.photos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.databinding.ItemGridvPhotosviewBinding;

import java.util.ArrayList;

public class PhotosViewGridvAdapter extends BaseAdapter {

    LayoutInflater inflater;

    PhotosMainDTO dto;

    Context context;

    public PhotosViewGridvAdapter(LayoutInflater inflater, PhotosMainDTO dto, Context context) {
        this.inflater = inflater;
        this.dto = dto;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dto.getImgSubs().length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemGridvPhotosviewBinding binding = ItemGridvPhotosviewBinding.inflate(inflater, parent, false);
        binding.imgvPhoto.setImageResource(dto.getImgSubs()[position]);
        binding.imgvPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(context, PhotosViewDetailActivity.class);
            context.startActivity(intent);
        });
        return binding.getRoot();
    }
}
