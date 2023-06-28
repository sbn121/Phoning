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
        ItemGridvPhotosBinding binding = ItemGridvPhotosBinding.inflate(inflater , parent , false);
        binding.imgvMain.setImageResource(list.get(position).getImgRes());
        binding.tvMain.setText(list.get(position).getName());
        return   binding.getRoot();
    }

    public class GridViewHolder{
        ItemGridvPhotosBinding binding;

        public GridViewHolder(ItemGridvPhotosBinding binding) {
            this.binding = binding;
        }

        public void bind(){

        }
    }
}
