package com.nano.invi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/*
3 functions:
insert
delete,
getRandom() -> return random one element from DS
All operation should take O(1)

 */
public class _24AI_2 {



}

class DS{
    Map<String, Integer> map = new HashMap<>(); //HashMap<>();
    int i=0;
    Map<Integer, String> reverse = new HashMap<>();
    public DS(Map<String, Integer> map, int i, Map<Integer, String> reverse){
        this.map = map;
        this.i = i;
        this.reverse = reverse;
    }

    public void insert(String s){
        map.put(s,i);
        reverse.put(i,s);
        i++;
    }

    public void delete(String s){
        if(map.containsKey(s)){
            int v = map.remove(s);
            reverse.remove(v);
        }
    }

  /*  public String random(){
        int r = new Random().gMath.random(i);
    }*/
}