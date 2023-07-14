package com.example.lastcloneappproject.messages;

public class MessageChatDTO {
    private int imgRes;
    private String name, text, time;

    private boolean isCheck;

    public MessageChatDTO(){

    }

    public MessageChatDTO(int imgRes, String name, String text, String time, boolean isCheck) {
        this.imgRes = imgRes;
        this.name = name;
        this.text = text;
        this.time = time;
        this.isCheck = isCheck;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
