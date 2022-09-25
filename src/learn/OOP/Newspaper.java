package learn.OOP;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Newspaper
        extends Literature
        implements Printable, Periodic, Serializable {
    private Date date;
    private Calendar calendar;

    static private final SimpleDateFormat dateParser  = new SimpleDateFormat("yyyy-MM-dd");

    //    форматировщик даты, как на ввод так и на вывод


    static private final SimpleDateFormat datePrinter = new SimpleDateFormat("dd.MM.yyyy");

    static private final SimpleDateFormat datePrinterShort = new SimpleDateFormat("dd.MM");

    public Date getDate() {
        return date;
    }

    public Newspaper setDate(String dateString) throws ParseException {
        this.date = dateParser.parse(dateString);  //  методы Date - deprecated
        this.calendar = Calendar.getInstance();  //  рекомендованный объект для работы с датами
        calendar.setTime(this.date);

        return this;
    }

    @Override
    public Newspaper setTitle(String title)
    {
        return (Newspaper)super.setTitle(title);
    }

    @Override
    public void print()                                     //  show data
    {
        Calendar now = Calendar.getInstance();

        String str;
        if((now.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                (now.get(Calendar.DATE) != calendar.get(Calendar.DATE))))
        {// тот же год - выводим сокращенную дату
            str = datePrinterShort.format(this.getDate());
        }
        else if(now.get(Calendar.DATE) == calendar.get(Calendar.DATE))
        {
            str = "today";
        }
        else
        {
            str = datePrinter.format(this.getDate());
        }

        System.out.printf("Newspaper.Title: %s.  %s%n",
                super.getTitle(), str);

        date.getYear();
    }
}
