package com.example.lastcloneappproject.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.lastcloneappproject.HideActionBar;
import com.example.lastcloneappproject.R;
import com.example.lastcloneappproject.databinding.ActivityPhotosViewDetailBinding;

public class PhotosViewDetailActivity extends AppCompatActivity {

    ActivityPhotosViewDetailBinding binding;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosViewDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new HideActionBar().hideActionBar(this);
        int imgRes = getIntent().getIntExtra("imgres", 0);
        if (imgRes != 0) {
            binding.imgvMain.setImageResource(imgRes);
        }
        PhotosMainDTO dto = (PhotosMainDTO) getIntent().getSerializableExtra("dto");
        int cnt = getIntent().getIntExtra("count", 0);
        if(dto.getIsState()[cnt]){
            binding.imgvLike.setImageResource(R.drawable.photos_like);
        }
        binding.imgvBack.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("dto", dto);
            intent.putExtra("count",cnt);
            setResult(RESULT_OK, intent);
            finish();
        });
        binding.imgvLike.setOnClickListener(v -> {
            //[이미지1]....[이미지12]
            //[불리언1 true]....[불리언12 false]
            if (count % 2 == 0) {
                PhotosCommonUtility.IsLike[cnt] = false;
                binding.imgvLike.setImageResource(R.drawable.photos_like_empty);
                dto.getIsState()[cnt] = PhotosCommonUtility.IsLike[cnt] ;
                count++;
            } else {
                PhotosCommonUtility.IsLike[cnt] = true;
                binding.imgvLike.setImageResource(R.drawable.photos_like);
//                dto.getImgLikes()[cnt] = R.drawable.photos_like;
                dto.getIsState()[cnt] = PhotosCommonUtility.IsLike[cnt] ;
                count++;
            }
        });
    }
}