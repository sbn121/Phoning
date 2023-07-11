package com.example.lastcloneappproject.photos;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemGridvPhotosviewBinding;

public class PhotosView2GridvAdapter extends BaseAdapter {

    LayoutInflater inflater;

    PhotosMain2DTO dto;

    PhotosView2Activity context;



    public PhotosView2GridvAdapter(LayoutInflater inflater, PhotosMain2DTO dto, PhotosView2Activity context) {
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
        if(PhotosCommonUtility.IsLike2[position] == true) {
            binding.imgvLike.setImageResource(R.drawable.photos_like);
        } else {
            binding.imgvLike.setImageResource(0);
        }
        binding.imgvPhoto.setImageResource(dto.getImgSubs()[position]);
        binding.imgvPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(context, PhotosViewDetail2Activity.class);
            intent.putExtra("imgres2" , dto.getImgSubs()[position]);
            intent.putExtra("dto2", dto);
            intent.putExtra("count2", position);
            context.startActivityForResult(intent , 1000);
        });
        return binding.getRoot();
    }
}
