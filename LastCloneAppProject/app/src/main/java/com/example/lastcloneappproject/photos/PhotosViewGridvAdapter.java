package com.example.lastcloneappproject.photos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.databinding.ItemGridvPhotosviewBinding;

import java.util.ArrayList;

public class PhotosViewGridvAdapter extends BaseAdapter {

    LayoutInflater inflater;

    public PhotosViewGridvAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    ArrayList<NewjeansArray> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemGridvPhotosviewBinding binding = ItemGridvPhotosviewBinding.inflate(inflater, parent, false);
        return binding.getRoot();
    }
}
