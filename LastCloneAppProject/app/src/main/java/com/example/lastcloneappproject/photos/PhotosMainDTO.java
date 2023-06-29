package com.example.lastcloneappproject.photos;

import java.io.Serializable;
import java.util.ArrayList;

public class PhotosMainDTO implements Serializable {
    private int imgRes;
    private String name;

    private int[] imgSubs;


    public int[] getImgSubs() {
        return imgSubs;
    }

    public void setImgSubs(int[] imgSubs) {
        this.imgSubs = imgSubs;
    }

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
