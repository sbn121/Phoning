package com.example.lastcloneappproject.photos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.databinding.ItemGridvPhotosBinding;

import java.util.ArrayList;
import java.util.Collections;

public class PhotosGridvAdapter extends BaseAdapter {


    LayoutInflater inflater;
    ArrayList<PhotosMainDTO> list;
    Context context;

    public PhotosGridvAdapter(LayoutInflater inflater, ArrayList<PhotosMainDTO> list, Context context) {
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
        binding.imgvMain.setOnClickListener(v1 -> {
            Intent intent = new Intent(context, PhotosViewActivity.class);
            if (list.get(position).getName().equals("해린 HAERIN")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayHaerin);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("민지 MINJI")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayMinji);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("다니엘 DANIELLE")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayDanielle);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("하니 HANNI")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayHanni);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("혜인 HYEIN")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayHyein);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("NewJeans")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayNewjeans);
                list.get(position).setIsState();
            }
            intent.putExtra("dto", list.get(position));
            context.startActivity(intent);
        });
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
