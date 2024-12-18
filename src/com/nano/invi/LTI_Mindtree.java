package com.nano.invi;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LTI_Mindtree {
    /*
    Student- id, name, mark

    List<Student> stdList;

    step1- remove duplicate from list
    step2- mark>40
    step3- sorting descending order based on mark
    step4- o/p- Map <id, mark>
     */
    public static void main(String[] args) {
        List<Student> stdList = new ArrayList<>();
        Student s1 = new Student(1,"a",100);
        Student s2 = new Student(2,"b",200);
        Student s3 = new Student(3,"c",21);
        stdList.add(s1);
        stdList.add(s1);//duplicate inserted
        stdList.add(s2);
        stdList.add(s3);

        Map<Integer, Integer> map = stdList.stream()
                .distinct()
                .filter((s)->s.getMark()>40)
                .collect(Collectors.toMap(Student::getId, Student::getMark));
        //stdList.stream().filter(Student::getMark>40).collect(Collectors.toMap(Student::getId, Student::getMark));
        System.out.println(map);
    }

}

class Student{
    private int id;
    private String name;
    private int mark;

    public Student(int id, String name, int mark){
        this.id=id;
        this.name=name;
        this.mark=mark;
    }

    public int getId(){
        return id;
    }
    public int getMark(){
        return mark;
    }
}