package com.nano.youtube;

public class CastExceptionNotDetectedAtCompiletime {
    public static void main(String[] args) {
        Rectangle r = new ABC();//new Rectangle();
        Polygon p = (Polygon) r;
    }
}

interface Polygon{}
class Rectangle implements Polygon{
    public Rectangle(){
        System.out.println("works !");
    }
}

class ABC extends Rectangle implements Polygon{
}


