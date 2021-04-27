package com.example.travel.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormatter {
    public String getDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(calendar.getTime());
        return date;
    }
}
