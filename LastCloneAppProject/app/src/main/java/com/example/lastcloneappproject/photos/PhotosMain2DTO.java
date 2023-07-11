package com.example.lastcloneappproject.photos;

import java.io.Serializable;

public class PhotosMain2DTO implements Serializable {
    private int imgRes;
    private String name;

    private int[] imgSubs;

    public int[] getImgSubs() {
        return imgSubs;
    }

    public void setImgSubs(int[] imgSubs) {
        this.imgSubs = imgSubs;
    }

    public boolean[] getIsState() {
        return isState;
    }

    public void setIsState() {
        this.isState = new boolean[imgSubs.length];
    }

    public void setIsState(boolean[] isState) {
        this.isState = isState;
    }

    private boolean[] isState;

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

    public PhotosMain2DTO(int imgRes, String name) {
        this.imgRes = imgRes;
        this.name = name;
    }
}
