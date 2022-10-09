package learn.thread;

public class MyThread extends Thread {

    MyThread(String name){
        super(name);
    }

    public void run(){

        System.out.printf("%s works... \n", Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            System.out.println("Thread has been interrupted");
        }

    }
}