package com.example.lastcloneappproject.calendar;

public class ScheduleDTO {

    private int imgv_profile;
    private String tv_writer, tv_title, tv_chat, tv_time;

    public int getImgv_profile() {
        return imgv_profile;
    }

    public void setImgv_profile(int imgv_profile) {
        this.imgv_profile = imgv_profile;
    }

    public String getTv_writer() {
        return tv_writer;
    }

    public void setTv_writer(String tv_writer) {
        this.tv_writer = tv_writer;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_chat() {
        return tv_chat;
    }

    public void setTv_chat(String tv_chat) {
        this.tv_chat = tv_chat;
    }

    public String getTv_time() {
        return tv_time;
    }

    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }

    public ScheduleDTO(int imgv_profile, String tv_writer, String tv_title, String tv_chat, String tv_time) {
        this.imgv_profile = imgv_profile;
        this.tv_writer = tv_writer;
        this.tv_title = tv_title;
        this.tv_chat = tv_chat;
        this.tv_time = tv_time;
    }
}
