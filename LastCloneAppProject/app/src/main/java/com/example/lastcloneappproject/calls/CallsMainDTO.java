package com.example.lastcloneappproject.calls;

public class CallsMainDTO {
    private int newjeansimg, call_check;
    private String name, call_time, call_date;

    public CallsMainDTO(int newjeansimg, int call_check, String name, String call_time, String call_date) {
        this.newjeansimg = newjeansimg;
        this.call_check = call_check;
        this.name = name;
        this.call_time = call_time;
        this.call_date = call_date;
    }

    public int getNewjeansimg() {
        return newjeansimg;
    }

    public void setNewjeansimg(int newjeansimg) {
        this.newjeansimg = newjeansimg;
    }

    public int getCall_check() {
        return call_check;
    }

    public void setCall_check(int call_check) {
        this.call_check = call_check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCall_time() {
        return call_time;
    }

    public void setCall_time(String call_time) {
        this.call_time = call_time;
    }

    public String getCall_date() {
        return call_date;
    }

    public void setCall_date(String call_date) {
        this.call_date = call_date;
    }
}
