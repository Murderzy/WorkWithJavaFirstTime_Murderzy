package learn.thread;

import learn.anno.EntryPoint;

import java.util.Scanner;
import java.util.concurrent.*;
import java.util.function.Function;

public class Inflation {
    private int basic;
    private int current;

    public void getInflationByYears()                           //  ввод данных пользователем
    {
        System.out.println("Enter base year inflation: ");
        Scanner kbScanner = new Scanner(System.in);
        this.basic =Integer.parseInt( kbScanner.nextLine());

        System.out.println("Enter current year inflation: ");
        this.current =Integer.parseInt( kbScanner.nextLine());
    }

    @EntryPoint
    public void run()                                            //  метод общей работыы класса
    {
        getInflationByYears();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for(int i = 1; i < 10; ++i)
        {
            pool.submit(
                    ( (Function<Integer,Runnable>) x ->
                            () -> System.out.printf( "pool %d works %n", x )
                    ).apply(i)
            ) ;
        }

        Future<String> res = (Future<String>) pool.submit(InflSync1);
        res = (Future<String>) pool.submit(InflSync2);

        pool.shutdown() ;
    }

    private final Object sumLocker = new Object() ;
    //private double sum ;

    private Runnable InflSync1 = () -> {
        double tmp ;
        synchronized( sumLocker ) {
            tmp = ((this.current - this.basic)*100)/this.basic;
        }
        System.out.println(
                "current inflation level = " + tmp);
    } ;

    private Runnable InflSync2 = () -> {
        double tmp ;
        synchronized( sumLocker ) {
            tmp =this.current/this.basic;
        }
        System.out.println(
                "current inflation index = " + tmp);
    } ;

}
