package com.example.lastcloneappproject.photos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.databinding.ItemGridvPhotosgalleryBinding;

public class PhotosGalleryAdapter extends BaseAdapter {

    LayoutInflater inflater;

    PhotosMainDTO dto;

    public PhotosGalleryAdapter(LayoutInflater inflater, PhotosMainDTO dto) {
        this.inflater = inflater;
        this.dto = dto;
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

        ItemGridvPhotosgalleryBinding binding = ItemGridvPhotosgalleryBinding.inflate(inflater,parent,false);
        binding.imgvPhoto.setImageResource(dto.getImgSubs()[position]);

        return binding.getRoot();
    }
}
