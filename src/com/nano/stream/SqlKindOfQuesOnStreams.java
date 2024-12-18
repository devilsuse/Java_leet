package com.nano.stream;

import java.util.*;
import java.util.stream.Collectors;

public class SqlKindOfQuesOnStreams {

    private static final String MALE = "MALE";
    private static final String FEMALE = "FEMALE";

    public static void main(String[] args) {
        Employee e1 = new Employee(1, 31, 1, MALE, "Krishna");
        Employee e2 = new Employee(2, 35, 1, MALE, "Balram");
        Employee e3 = new Employee(3, 36, 2, MALE, "Shyam");
        Employee e4 = new Employee(4, 96, 2, MALE, "Ram");
        Employee e5 = new Employee(5, 26, 1, FEMALE, "Radha");
        Employee e6 = new Employee(6, 16, 3, FEMALE, "Rukmini");
        Employee e7 = new Employee(7, 17, 2, FEMALE, "Satyabhama");

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        employees.add(e6);
        employees.add(e7);

        //1. print all departments
        distinctDepartments(employees);

        // 2. How many male & female are there?
        genderWiseCount(employees);

        // 3. What is avg age of male & female?
        genderAverageAge(employees);

        // 4. Get the details of oldest employee
            // 4.1 UnOptimized way
            oldestEmployee(employees);
            // 4.2 Better way is below:
            oldestEmployeeBetter(employees);

        // 5.
    }

    public static void distinctDepartments(List<Employee> employees){
        List<Integer> distinctDepartments = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctDepartments);
    }

    public static void genderWiseCount(List<Employee> employees){
        Map<String, Long> genderWiseCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(genderWiseCount);
    }

    public static void genderAverageAge(List<Employee> employees){
        Map<String, Double> genderAverageAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(genderAverageAge);
    }

    public static void oldestEmployee(List<Employee> employees){
        List<Employee> oldestEmployee = employees.stream()
                .sorted((e1,e2)->Integer.compare(e2.getAge(), e1.getAge()))
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(oldestEmployee);
    }

    public static void oldestEmployeeBetter(List<Employee> employees){
        Optional<Employee> oldestEmployee = employees.stream()
                .max(Comparator.comparingInt(Employee::getAge));

        oldestEmployee.ifPresent(System.out::println);
    }
}

class Employee{
    private int id;
    private int age;
    private int department;
    private String gender;
    private String name;

    public Employee(int id, int age, int department, String gender, String name) {
        this.id = id;
        this.age = age;
        this.department = department;
        this.gender = gender;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", department=" + department +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}