package com.example.kalpak.football.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTime {
    public static String getCurrentData() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());

    }


    public static String getCurrentDataTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    public static String getYesterdayData() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return dateFormat.format(cal.getTime());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public  String convertTime(String time) {

        String converted_date = "";
        try {

            DateFormat utcFormat = new SimpleDateFormat("HH:mm:ss");
            utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

            Date date = utcFormat.parse(time);

            DateFormat currentTFormat = new SimpleDateFormat("HH:mm:ss");
            currentTFormat.setTimeZone(TimeZone.getTimeZone(getCurrentTimeZone()));

            converted_date = currentTFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return converted_date;
    }

    public String getCurrentTimeZone() {
        TimeZone tz = Calendar.getInstance().getTimeZone();
        System.out.println(tz.getDisplayName());
        return tz.getID();
    }

}
