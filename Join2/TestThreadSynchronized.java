package com.example2.Join2;

class PrintDemo{
    public void printCount(){
        try {
            for (int i =5; i> 0;i--){
                System.out.println("Counter..." +i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class ThreadDemo extends Thread  {
    private Thread t;
    private String threadName;
    PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo pd){
        threadName = name;
        printDemo = pd;
    }

    @Override
    public void run() {
        synchronized (printDemo){
            printDemo.printCount();
       }
        System.out.println("Thread " + threadName + "exiting");
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t ==null){
            t= new Thread(this, threadName);
            t.start();
        }
    }
}

public class TestThreadSynchronized {
    public static void main(String[] args) throws InterruptedException {

        PrintDemo printDemo = new PrintDemo();

        ThreadDemo threadDemo1 = new ThreadDemo("Thread-1",printDemo);
        ThreadDemo threadDemo2 = new ThreadDemo("Thread-2",printDemo);

        threadDemo1.start();
        threadDemo2.start();
    }
}