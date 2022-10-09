package learn.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateModule implements DateService{


    public String  getDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String getDate = dateFormat.format(new Date()).toString();
        return getDate;
    }
}
