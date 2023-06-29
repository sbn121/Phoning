package com.example.lastcloneappproject.photos;

public class PhotosMain2DTO {
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

    public PhotosMain2DTO(int imgRes, String name) {
        this.imgRes = imgRes;
        this.name = name;
    }
}
