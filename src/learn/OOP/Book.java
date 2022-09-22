package learn.OOP;

public class Book
        extends Literature
        implements Printable{
        private String author;

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setTitle(String title)
    {
        super.setTitle(title);
        return this;
    }


    @Override
    public void Print() {
        System.out.printf("Book.Author: %s. Title : %s%n",
                this.author, super.getTitle());
    }
}
