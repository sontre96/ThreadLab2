package com.example2.Join;

public class JoinThread extends Thread {

    private String threadName;
    private int count;

    public JoinThread(String threadName, int count){
        this.threadName = threadName;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i =1; i < count+1; i++){
            System.out.println("Message from " + this.threadName + "" + i);
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("------Thread " + threadName + "end");
    }
}
