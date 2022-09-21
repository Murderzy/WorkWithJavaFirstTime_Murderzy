package learn.OOP;

public class Journal extends  Literature{
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public Journal setNumber(Integer number) {
        this.number = number;
        return this;
    }

    public Journal setTitle(String title)
    {
        super.setTitle(title);
        return this;
    }

    public void Print()
    {
        System.out.printf("Journal.Title: %s. Number : %s%n",
                super.getTitle(), this.number);
    }
}
