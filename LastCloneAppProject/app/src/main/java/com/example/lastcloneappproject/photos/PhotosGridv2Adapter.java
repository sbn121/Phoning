package com.example.lastcloneappproject.photos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.lastcloneappproject.databinding.ItemGridv2PhotosBinding;
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

        ItemGridv2PhotosBinding binding = ItemGridv2PhotosBinding.inflate(inflater, parent, false);
        binding.imgvMain.setImageResource(list.get(position).getImgRes());
        binding.tvMain.setText(list.get(position).getName());
        binding.imgvMain.setOnClickListener(v1 -> {
            Intent intent = new Intent(context, PhotosView2Activity.class);
            if (list.get(position).getName().equals("\uD83D\uDC30 \uD83D\uDCF7")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayCamera);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("\uD83D\uDC30 ✏️")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayPen);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("\uD83D\uDC30 \uD83C\uDF15")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayMoon);
                list.get(position).setIsState();
            } else if (list.get(position).getName().equals("NewJeans Day")) {
                list.get(position).setImgSubs(new NewjeansArray().imgArrayNewJeansDay);
                list.get(position).setIsState();
            }
            intent.putExtra("dto2", list.get(position));
            context.startActivity(intent);
        });
        return binding.getRoot();
    }

}
