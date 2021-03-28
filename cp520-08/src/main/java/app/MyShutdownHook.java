package app;

public class MyShutdownHook extends Thread {

    @Override
    public void run() {
        System.out.println("Look, I added a shutdown hook all by myself!");
    }

}