package com.example.lastcloneappproject.photos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.databinding.ItemGridvPhotosBinding;

import java.util.ArrayList;

public class PhotosGridv2Adapter extends BaseAdapter {


    LayoutInflater inflater;
    ArrayList<PhotosMain2DTO> list;

    Context context;

    public PhotosGridv2Adapter(LayoutInflater inflater, ArrayList<PhotosMain2DTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

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
    public View getView(int position, View v, ViewGroup parent) {
//        GridViewHolder viewHolder = null;
//        if(v.getTag() == null){
//            viewHolder = new GridViewHolder(ItemGridvPhotosBinding.inflate(inflater , parent , false));
//            v.setTag(viewHolder);
//        }else{
//            viewHolder = (GridViewHolder) v.getTag();
//        }
//        viewHolder.binding.imgvMain.setImageResource(list.get(position).getImgRes());
//        viewHolder.binding.tvMain.setText(list.get(position).getName());
        //v = inflater.inflate(R.layout.item_gridv_photos, parent, false);
        ItemGridvPhotosBinding binding = ItemGridvPhotosBinding.inflate(inflater, parent, false);
        binding.imgvMain.setImageResource(list.get(position).getImgRes());
        binding.tvMain.setText(list.get(position).getName());
        return binding.getRoot();
    }

    public class GridViewHolder {
        ItemGridvPhotosBinding binding;

        public GridViewHolder(ItemGridvPhotosBinding binding) {
            this.binding = binding;
        }

        public void bind() {

        }
    }
}
