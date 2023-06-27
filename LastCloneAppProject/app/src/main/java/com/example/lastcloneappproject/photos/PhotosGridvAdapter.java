package com.example.lastcloneappproject.photos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ItemGridvPhotosBinding;

import java.util.ArrayList;
import java.util.List;

public class PhotosGridvAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<PhotosMainDTO> list;

    public PhotosGridvAdapter(LayoutInflater inflater, ArrayList<PhotosMainDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_gridv_photos, parent, false);
        return v;
    }
}
