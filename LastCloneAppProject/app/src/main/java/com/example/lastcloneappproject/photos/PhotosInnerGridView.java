package com.example.lastcloneappproject.photos;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class PhotosInnerGridView extends GridView {

    public PhotosInnerGridView(Context context) {
        super(context);
    }

    public PhotosInnerGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotosInnerGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Max Height
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);


        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}