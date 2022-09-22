package learn.OOP;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Library {
    private List<Literature> funds;

    public Library() {
        this.funds = new ArrayList<>();
    }

    public void Add(Literature literature)
    {
        funds.add(literature);
    }

    public void PrintFunds()
    {
        for(Literature literature : funds)
        {   if(literature instanceof Printable)
            {
                ((Printable)literature).Print();
            }
            else
            {
                System.out.println("Unprintable: "+ literature.getTitle());
            }
        }
    }

    public void showPrintable()
    {
        for(Literature literature : funds)
        {   if(literature instanceof Printable)
        {
            ((Printable)literature).Print();
        }

        }
    }

    public void showPeriodic()
    {
        for(Literature literature : funds)
        {
            if(literature instanceof Periodic)

            {    if(literature instanceof Printable)
                {
                 ((Printable) literature).Print();
                    }
                else
                {
                    System.out.println("Unprintable: "+ literature.getTitle());
                }

            }
        }

    }

    public void showNonPeriodic()
    {
        for(Literature literature : funds)
        {
            if(!(literature instanceof Periodic))

            {    if(literature instanceof Printable)
            {
                ((Printable) literature).Print();
            }
            else
            {
                System.out.println("Unprintable: "+ literature.getTitle());
            }

            }
        }

    }


    public void showUnprintable()
    {
        for(Literature literature : funds)
        {   if(!(literature instanceof Printable))
        {
            System.out.println("Unprintable: "+ literature.getTitle());
        }

        }
    }


    public void Run()
    {

        Add(new Book().setAuthor("Knuth").setTitle("Art of programming"));
        Add(new Hologram().setTitle("Pectoral"));
        Add(new Journal().setNumber(48).setTitle("New York Times"));
        try {
            Add(new Newspaper().setTitle("DailyPlanet").setDate("2021-09-21"));
            Add(new Newspaper().setTitle("DailyPlanet").setDate("2022-09-02"));
            Add(new Newspaper().setTitle("DailyPlanet").setDate("2022-09-22"));
        } catch (ParseException e) {
            System.out.println("Funds creation failed"+ e.getMessage());
            return;
        }

        Add(new Poster().setTitle("X-Man #34"));
        Add(new Poster().setTitle("Logan #1"));
        Add(new Poster().setTitle("X-Man #348"));

        showPeriodic();
        System.out.println();
        showNonPeriodic();

    }

}
