package com.nano.invi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Addepar_1_PrintNestedLoop {
    public static void main(String[] args) {
        NestedListHandler handler = new NestedListHandler(Boolean.valueOf(true));
        handler.printAlternateElementsInNestedList(prepareNestedList());
        //expected output: a,c,e,2,4,11,m,O,y,6
    }

    private static List<Object> prepareNestedList(){
        //List<Object> l1 = List.of("a","b","c","d","e");
        List<Object> l1 = new ArrayList<>(
                Arrays.asList("a", "b", "c", "d", "e", null)
        );
        List<Object> l2 = List.of("1","2","3","4","5");
        List<Object> l3 = List.of(11,12,"m","n","O");
        return List.of(l1, l2,l3,"x","y","z",6,7);
    }

}

class NestedListHandler{
    Boolean flag; // = Boolean.valueOf(false);
    public NestedListHandler(Boolean flag){
        this.flag=flag;
    }
    public void printAlternateElementsInNestedList(List<Object> list){
        if(list==null)
            return;
        for(Object obj : list){
           // if(obj==null)
           //     return;
            if(obj instanceof List){
                //flag=!flag;
                printAlternateElementsInNestedList((List)obj);
            }
            //boolean f = false;
            if(flag) {
                if (obj instanceof String || obj instanceof Integer){
                    System.out.println(obj);
                    //f = true;
                }
            }
            flag=!flag;
        }
    }
}