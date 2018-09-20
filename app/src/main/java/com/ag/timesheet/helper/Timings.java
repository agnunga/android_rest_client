package com.ag.timesheet.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Timings {

    public static Date stringToDate(String sDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(
                "HH:mm:ss", Locale.getDefault());

        return sdf.parse(sDate);
    }

    public static String getTime() {
        Calendar c = Calendar.getInstance();
        Date time =  c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(time);
    }

    public static String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

}
