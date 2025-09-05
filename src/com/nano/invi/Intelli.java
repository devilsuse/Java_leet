package com.nano.invi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Problem Statement:
Given a list of order records in format: "Amount,Category,DateTime" (where DateTime uses ISO-8601 format: yyyy-MM-ddTHH:mm:ss)
Write a Java Streams solution that:
Filters orders where DateTime is between startDateTime (inclusive) and endDateTime (inclusive)
Groups the filtered orders by category and calculates total amount per category

Example:
For:
List<String> orders = Arrays.asList(
   "299.99,Electronics,2023-06-21T14:35:00",
   "159.99,Clothing,2023-06-21T15:40:00",
   "199.99,Electronics,2023-06-22T09:15:00",
   "149.99,Home,2023-06-22T10:20:00"
);
When analyzing between "2023-06-21T00:00:00" and "2023-06-21T23:59:59", the output should be:

Electronics : 299.99
Clothing    : 159.99

Implement the following method for the above:

Map<String, Double> analyzeOrders(List<String> orders,
                                String startDateTime,
                                String endDateTime)
 */
public class Intelli {
    public static void main(String[] args) {
        List<String> orders = Arrays.asList(
                "299.99,Electronics,2023-06-21T14:35:00",
                "159.99,Clothing,2023-06-21T15:40:00",
                "199.99,Electronics,2023-06-22T09:15:00",
                "149.99,Home,2023-06-22T10:20:00"
        );
        String start = "2023-06-21T00:00:00";
        String end = "2023-06-21T23:59:59";
        Map<String, Double> result = analyzeOrders(orders, start, end);
        System.out.println(result);
    }

   private static Map<String, Double> analyzeOrders(List<String> orders,
                                      String startDateTime,
                                      String endDateTime){
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ISO_DATE_TIME; // 2023-06-21T14:35:00
       final LocalDateTime start = LocalDateTime.parse(startDateTime,dateTimeFormatter);
       final LocalDateTime end = LocalDateTime.parse(endDateTime,dateTimeFormatter);

       return orders.stream().map(x-> x.split(","))
               .filter(x -> {
                   LocalDateTime date = LocalDateTime.parse(x[2].trim());
                   return (!date.isBefore(start) && !date.isAfter(end));
               })
               .collect(Collectors.groupingBy(
                       x-> x[1], Collectors.summingDouble(x-> Double.parseDouble(x[0]))
               ));
    }


}


