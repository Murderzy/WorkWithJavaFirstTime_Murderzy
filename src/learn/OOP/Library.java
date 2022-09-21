package learn.OOP;

import java.util.ArrayList;
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
        {
            literature.Print();
        }
    }

    public void Run()
    {

        Add(new Book().setAuthor("Knuth").setTitle("Art of programming"));
        PrintFunds();
    }

}
