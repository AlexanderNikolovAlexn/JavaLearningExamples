package com.samodeika.singleton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ShowTime {

    private static ShowTime instance;
    private DateFormat dateFormat;
    private Calendar calendar;

    private ShowTime() {
        dateFormat = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
    }

    public static ShowTime getInstance() {
        if(instance == null)  {
            instance = new ShowTime();
        }
        return instance;
    }

    public String getTime() {
        calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }
}
