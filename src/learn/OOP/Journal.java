package learn.OOP;

import java.io.Serializable;

public class Journal
        extends  Literature
        implements Printable, Periodic, Serializable {
    private Integer number;

    public Integer getNumber() {                           //  return this.number value
        return number;
    }

    public Journal setNumber(Integer number) {             //  set this.number value ;
                                                           // return object pointer
        this.number = number;
        return this;
    }

    public Journal setTitle(String title)                   //  set super.title;
                                                            //  return object pointer
    {
        super.setTitle(title);
        return this;
    }

    @Override
    public void print()                                     //  show data
    {
        System.out.printf("Journal.Title: %s. Number : %s%n",
                super.getTitle(), this.number);
    }
}
