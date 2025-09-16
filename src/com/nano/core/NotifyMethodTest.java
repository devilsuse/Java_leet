package com.nano.core;

public class NotifyMethodTest {

    /* Running this will result in an Exception because notify() is called by the thread on an object of which it doesn't have a lock on object's monitor.

    Exception in thread "main" java.lang.IllegalMonitorStateException: current thread is not owner
	at java.base/java.lang.Object.notify(Native Method)
	at com.nano.core.NotifyMethodTest.main(NotifyMethodTest.java:7)
     */
    public static void main(String[] args) {
        System.out.println("start");
        A a = new A();
        a.notify();
        System.out.println("end");
    }
}
class A{

}
