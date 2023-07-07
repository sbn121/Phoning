package com.example.lastcloneappproject.calendar;

import java.util.Date;

public class CalendarDTO {

    private String year, month, date, day;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public CalendarDTO(String year, String month, String day, String date) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.date = date;
    }
}
