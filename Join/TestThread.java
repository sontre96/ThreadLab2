package com.example2.Join;

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
        printDemo.printCount();
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

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo threadDemo1 = new ThreadDemo("Thread -1", printDemo);
        ThreadDemo threadDemo2 = new ThreadDemo("Thread -2", printDemo);
        ThreadDemo threadDemo3 = new ThreadDemo("Thread -3", printDemo);

        threadDemo1.start();
        threadDemo2.start();
        threadDemo3.start();//Chạy song song với thread main

        threadDemo1.join();
        threadDemo2.join();
        System.out.println("Thread 3: " + threadDemo3.isAlive());
    }
}