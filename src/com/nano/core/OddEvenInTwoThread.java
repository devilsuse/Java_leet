package com.nano.core;

//Was Asked in 73Strings
public class OddEvenInTwoThread {

    private static final Object lock = new Object();
    private static final int MAX = 20;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            int i=1;
            while(true){
                synchronized (lock){
                    System.out.println(i);
                    i+=2;
                    lock.notify();
                    if(i>MAX)
                        return;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        });

        Thread t2 = new Thread(()->{
            int i=2;
            while(true){
                synchronized (lock){
                    System.out.println(i);
                    i+=2;
                    lock.notify();
                    if(i>MAX)
                        return;
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }

        });

        t1.start();
        //Thread.sleep(100);
        t2.start();
    }
}
