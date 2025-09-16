package com.nano.core;

public class ThreadTest {
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(()-> System.out.println("lambda runnable"));
        t1.start();;
        t2.start();

        System.out.println("main");
    }
}
