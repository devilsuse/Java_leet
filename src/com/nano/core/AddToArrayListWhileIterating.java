package com.nano.core;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayListWhileIterating {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int i=0;
        /*
        Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1043)
	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:997)
	at com.nano.core.AddToArrayListWhileIterating.main(AddToArrayListWhileIterating.java:13)

         */
        for(int a : list){
            System.out.println(a);
            if(i++<4)
                list.add(i);
        }

    }
}
