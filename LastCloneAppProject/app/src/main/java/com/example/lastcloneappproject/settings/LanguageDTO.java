package com.example.lastcloneappproject.settings;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LanguageDTO {
    private ImageView imgv_lg;
    private TextView tv_lg;
    private LinearLayout lg;

    public ImageView getImgv_lg() {
        return imgv_lg;
    }

    public void setImgv_lg(ImageView imgv_lg) {
        this.imgv_lg = imgv_lg;
    }

    public TextView getTv_lg() {
        return tv_lg;
    }

    public void setTv_lg(TextView tv_lg) {
        this.tv_lg = tv_lg;
    }

    public LinearLayout getLg() {
        return lg;
    }

    public void setLg(LinearLayout lg) {
        this.lg = lg;
    }

    public LanguageDTO(ImageView imgv_lg, TextView tv_lg, LinearLayout lg) {
        this.imgv_lg = imgv_lg;
        this.tv_lg = tv_lg;
        this.lg = lg;
    }
}
