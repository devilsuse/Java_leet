package com.nano.core;

import java.util.Optional;

public class OptionalExeption {

    public static void main(String[] args) {
        try{
           Optional<Integer> numOp = Optional.of(num(1));
        }catch (Exception e){

        }
    }



    public static int num(int a) throws Exception{
        if(a==1)
            throw new Exception("ssssssssss");
        else
            return 2;
    }
}
