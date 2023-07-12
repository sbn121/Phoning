package com.example.lastcloneappproject.photos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemGridvPhotosviewBinding;

import java.util.ArrayList;

public class PhotosViewGridvAdapter extends BaseAdapter {

    LayoutInflater inflater;

    PhotosMainDTO dto;

    PhotosViewActivity context;

    public PhotosViewGridvAdapter(LayoutInflater inflater, PhotosMainDTO dto, PhotosViewActivity context) {
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
//        dto.setIsState(PhotosCommonUtility.IsLike);
        if(dto.getIsState()[position] == true) {
            binding.imgvLike.setImageResource(R.drawable.photos_like);
        } else {
            binding.imgvLike.setImageResource(0);
        }
        binding.imgvPhoto.setImageResource(dto.getImgSubs()[position]);
        binding.imgvPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(context, PhotosViewDetailActivity.class);
            intent.putExtra("imgres" , dto.getImgSubs()[position]);
            intent.putExtra("dto", dto);
            intent.putExtra("count", position);
            context.startActivityForResult(intent , 1000);
        });
        return binding.getRoot();
    }
}
