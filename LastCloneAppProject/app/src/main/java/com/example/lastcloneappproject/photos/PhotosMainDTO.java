package com.example.lastcloneappproject.photos;

import java.util.ArrayList;

public class PhotosMainDTO {
    private int imgRes;
    private String name;



    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhotosMainDTO(int imgRes, String name) {
        this.imgRes = imgRes;
        this.name = name;
    }
}
