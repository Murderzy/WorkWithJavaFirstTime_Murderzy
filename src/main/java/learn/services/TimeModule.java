package learn.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeModule implements TimeService{
    public String getTime()
    {
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String getTime = timeFormat.format(new Date()).toString();
        return getTime;
    }
}
