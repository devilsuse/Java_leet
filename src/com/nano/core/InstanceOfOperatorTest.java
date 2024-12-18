package com.nano.core;

public class InstanceOfOperatorTest {
    public static void main(String[] args) {
        Point   p = new Point();
        Element e = new Element();
        if (e instanceof Point) {  // compile-time error
            System.out.println("I get your point!");
            p = (Point)e;  // compile-time error
            System.out.println(p.x);
        }
        else{
            System.out.println("All elements are Not com.nano.core.Point");
        }
    }

}
class Point  extends Element { int x=5, y; }
class Element { int atomicNumber; }
