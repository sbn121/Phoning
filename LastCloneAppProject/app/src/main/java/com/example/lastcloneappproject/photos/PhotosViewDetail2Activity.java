    package com.example.lastcloneappproject.photos;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;

    import com.example.lastcloneappproject.HideActionBar;
    import com.example.lastcloneappproject.R;
    import com.example.lastcloneappproject.databinding.ActivityPhotosViewDetail2Binding;

    public class PhotosViewDetail2Activity extends AppCompatActivity {

        ActivityPhotosViewDetail2Binding binding;

        int count = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityPhotosViewDetail2Binding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            new HideActionBar().hideActionBar(this);
            int imgRes = getIntent().getIntExtra("imgres2", 0);
            if (imgRes != 0) {
                binding.imgvMain.setImageResource(imgRes);
            }
            PhotosMain2DTO dto = (PhotosMain2DTO) getIntent().getSerializableExtra("dto2");
            int cnt = getIntent().getIntExtra("count2", 0);
            if (dto.getIsState()[cnt]) {
                binding.imgvLike.setImageResource(R.drawable.photos_like);
            }
            binding.imgvBack.setOnClickListener(v -> {
                Intent intent = new Intent();
                intent.putExtra("dto2", dto);
                setResult(RESULT_OK, intent);
                finish();
            });
            binding.imgvLike.setOnClickListener(v -> {
                //[이미지1]....[이미지12]
                //[불리언1 true]....[불리언12 false]
                if (count % 2 == 0) {
                    PhotosCommonUtility.IsLike2[cnt] = false;
                    binding.imgvLike.setImageResource(R.drawable.photos_like_empty);
                    dto.getIsState()[cnt] = false;
                    count++;
                } else {
                    PhotosCommonUtility.IsLike2[cnt] = true;
                    binding.imgvLike.setImageResource(R.drawable.photos_like);
                    dto.getIsState()[cnt] = true;
                    count++;
                }
            });
        }
    }