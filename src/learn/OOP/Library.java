package learn.OOP;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Library implements Serializable {
    private List<Literature> funds;

    public Library() {
        this.funds = new ArrayList<>();
    }

    public void add(Literature literature)
    {
        funds.add(literature); this.serializeData();
    }

    public void printFunds()  //  печатаем все
    {
        for(Literature literature : funds)
        {   if(literature instanceof Printable)
            {
                ((Printable)literature).print();
            }
            else
            {
                System.out.println("Unprintable: "+ literature.getTitle());
            }
        }
    }

    public void showPrintable()  //  печатаем только printable
    {
        for(Literature literature : funds)
        {   if(literature instanceof Printable)
        {
            ((Printable)literature).print();
        }

        }
    }

    public void showPeriodic()  //  печатаем только periodic
    {
        for(Literature literature : funds)
        {
            if(literature instanceof Periodic)

            {    if(literature instanceof Printable)
                {
                 ((Printable) literature).print();
                    }
                else
                {
                    System.out.println("Unprintable: "+ literature.getTitle());
                }

            }
        }

    }

    public void showNonPeriodic()  //  печатаем только non periodic
    {
        for(Literature literature : funds)
        {
            if(!(literature instanceof Periodic))

            {    if(literature instanceof Printable)
            {
                ((Printable) literature).print();
            }
            else
            {
                System.out.println("Unprintable: "+ literature.getTitle());
            }

            }
        }

    }


    public void showUnprintable()  //  печатаем только unprintable
    {
        for(Literature literature : funds)
        {   if(!(literature instanceof Printable))
        {
            System.out.println("Unprintable: "+ literature.getTitle());
        }

        }
    }

//    public List<Literature> getFunds() {
//        return funds;
//    }

    public void serializeData()  //  сериализация данных
    {
        try(FileOutputStream file = new FileOutputStream("funds.ser"))
        {
            ObjectOutputStream oos = new ObjectOutputStream(file);


            oos.writeObject(this.funds);


            oos.flush();
        } catch (IOException e) {
            System.out.println("error");
            return;
        }
        //System.out.println("Serialized");
    }

    public void dataRead()  //  дессериализация всех данных
    {
        int number = 0;
        try(FileInputStream file = new FileInputStream("funds.ser"))
        {
            ObjectInputStream ios = new ObjectInputStream(file);
//
//
            List<Literature> list = (List<Literature>)ios.readObject();
            for(Literature data:list)
            {
               if(data instanceof Literature)
                {
                    number++;
                System.out.println(data.getTitle());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error");
            return;
        }


        System.out.printf("Read data %s",number);
        System.out.println();
        System.out.println("Done");
    }

    public void dataReadtoFunds()  //  дессериализация данных в переменную funds для дальнейшей работы с ней
    {
        int number = 0;
        try(FileInputStream file = new FileInputStream("funds.ser"))
        {
            ObjectInputStream ios = new ObjectInputStream(file);
//
//
            this.funds = (List<Literature>)ios.readObject();
            for(Literature data:this.funds)
            {
                if(data instanceof Literature)
                {
                    number++;
                    //System.out.println(data.getTitle());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error");
            return;
        }


        System.out.printf("Read data %s",number);
        System.out.println();
        System.out.println("Done");
    }

    public void dataReadPrintable()  //  дессериализация только printable
    {
        try(FileInputStream file = new FileInputStream("funds.ser"))
        {
            ObjectInputStream ios = new ObjectInputStream(file);
//
//
            List<Literature> list = (List<Literature>)ios.readObject();
            for(Literature data:list)
            {
                if(data instanceof Literature && data instanceof Printable)
                {
                    System.out.println(data.getTitle());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error");
            return;
        }
        System.out.println("Done");
    }

    public void dataReadPeriodic()  //  дессериализация только periodic
    {
        try(FileInputStream file = new FileInputStream("funds.ser"))
        {
            ObjectInputStream ios = new ObjectInputStream(file);
//
//
            List<Literature> list = (List<Literature>)ios.readObject();
            for(Literature data:list)
            {
                if(data instanceof Literature && data instanceof Periodic)
                {
                    System.out.println(data.getTitle());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error");
            return;
        }
        System.out.println("Done");
    }

    public void dataReadNonPrintable()  //  дессериализация только unprintable
    {
        try(FileInputStream file = new FileInputStream("funds.ser"))
        {
            ObjectInputStream ios = new ObjectInputStream(file);
//
//
            List<Literature> list = (List<Literature>)ios.readObject();
            for(Literature data:list)
            {
                if(data instanceof Literature && !(data instanceof Printable))
                {
                    System.out.println(data.getTitle());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error");
            return;
        }
        System.out.println("Done");
    }

    public void dataReadNonPeriodic()  //  дессериализация только NonPeriodic
    {
        try(FileInputStream file = new FileInputStream("funds.ser"))
        {
            ObjectInputStream ios = new ObjectInputStream(file);
//
//
            List<Literature> list = (List<Literature>)ios.readObject();
            for(Literature data:list)
            {
                if(data instanceof Literature && !(data instanceof Periodic))
                {
                    System.out.println(data.getTitle());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error");
            return;
        }
        System.out.println("Done");
    }

    public void Run()
    {

//        add(new Book().setAuthor("Knuth").setTitle("Art of programming"));
//        add(new Hologram().setTitle("Pectoral"));
//        add(new Journal().setNumber(48).setTitle("New York Times"));
//        try {
//            add(new Newspaper().setTitle("DailyPlanet").setDate("2021-09-21"));
//            add(new Newspaper().setTitle("DailyPlanet").setDate("2022-09-02"));
//            add(new Newspaper().setTitle("DailyPlanet").setDate("2022-09-22"));
//        } catch (ParseException e) {
//            System.out.println("Funds creation failed"+ e.getMessage());
//            return;
//        }
//
//        add(new Poster().setTitle("X-Man #34"));
//        add(new Poster().setTitle("Logan #1"));
//        add(new Poster().setTitle("X-Man #348"));
//
//        this.serializeData();

//        showPeriodic();
//        System.out.println();
//        showNonPeriodic();

        boolean flag = true;


        while(flag) {
            this.dataReadtoFunds();
            System.out.println();
            System.out.printf("\n1.Show all\n" +
                    "2.Show printable\n" +
                    "3.Show periodic\n" +
                    "4.Show non printable\n" +
                    "5.Show non periodic\n"+
                    "0.Exit\n");
            System.out.println();

            Scanner kbScanner = new Scanner(System.in);
            String digit = kbScanner.nextLine();

            switch (digit) {
                case "1":
                    this.printFunds();
                    //this.dataRead();
                    break;
                case "2":
                    this.showPrintable();
                    //this.dataReadPrintable();
                    break;
                case "3":
                    this.showPeriodic();
                    //this.dataReadPeriodic();
                    break;
                case "4":
                    this.showUnprintable();
                    //this.dataReadNonPeriodic();
                    break;
                case "5":
                    this.showNonPeriodic();
                    //this.dataReadNonPrintable();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    break;
            }
        }





    }

}
