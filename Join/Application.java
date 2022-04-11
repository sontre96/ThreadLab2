package com.example2.Join;

public class Application {

    public static void main(String[] args) throws InterruptedException{

        System.out.println("-------Main Thread...");
        Thread joinThreadA = new JoinThread("A*", 2);
        Thread joinThreadB = new JoinThread("B*", 3);

        Thread nonJoinThreadC = new JoinThread("C*", 5);

        joinThreadA.start();
        joinThreadB.start();
        nonJoinThreadC.start();

        joinThreadA.join();
        joinThreadB.join();

        // chờ threadA và threadB chạy xong message mới được gọi
        System.out.println("Message from main thread...");

        System.out.println("ThreadA isALive? " + joinThreadA.isAlive());
        System.out.println("ThreadB isALive? " + joinThreadB.isAlive());
        System.out.println("ThreadC isALive? " + nonJoinThreadC.isAlive());

        System.out.println("----------------Main Thread end");

    }
}
