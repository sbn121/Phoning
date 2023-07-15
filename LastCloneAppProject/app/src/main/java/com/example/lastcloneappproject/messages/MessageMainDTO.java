package com.example.lastcloneappproject.messages;

import java.io.Serializable;

public class MessageMainDTO implements Serializable {
    private int imgRes;
    private String name, content, date;

    public MessageMainDTO(int imgRes, String name, String content, String date) {
        this.imgRes = imgRes;
        this.name = name;
        this.content = content;
        this.date = date;
    }

    public MessageMainDTO() {

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
