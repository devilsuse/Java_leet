package com.nano.core;

import java.beans.Transient;
import java.util.Objects;

public class TransientHashcodeTest {
    //@Transient
    private String name; /*transient*/

    private int id;
    private int age;

    public TransientHashcodeTest(String name, int id, int age){
        this.name=name;
        this.id=id;
        this.age=age;
    }

    /*public int hashCode(){
        int hash = 31;
        hash+= hash*name.hashCode();
        hash+= hash*id;
        hash+= hash*age;
        return hash;
    }*/
}
