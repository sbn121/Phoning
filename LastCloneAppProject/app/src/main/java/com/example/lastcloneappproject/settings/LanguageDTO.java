package com.example.lastcloneappproject.settings;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LanguageDTO {
    private boolean isChecked;
    private String tv_lg;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTv_lg() {
        return tv_lg;
    }

    public void setTv_lg(String tv_lg) {
        this.tv_lg = tv_lg;
    }

    public LanguageDTO(boolean isChecked, String tv_lg) {
        this.isChecked = isChecked;
        this.tv_lg = tv_lg;
    }
}

