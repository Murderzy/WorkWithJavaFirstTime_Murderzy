package learn.thread;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ThreadDemo {

    public void run(){
        System.out.println("Enter the number:");
        Scanner kbScanner = new Scanner(System.in);
        String str = kbScanner.nextLine();

        int digit = Integer.parseInt(str);                    //  получаем число от пользователя

        for(int i=1; i < digit+1; i++)
            new MyThread("MyThread " + i).start();      //  создаем заданное количество поток с
                                                              //  уникальным именем

    }
}

