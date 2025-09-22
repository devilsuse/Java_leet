package com.nano.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTopQuestions {
    public static void main(String[] args) {
/*
        🔥 Challenging Java Streams Problems
1. Top K Frequent Words
Given a list of strings, return the top k most frequent words, sorted by frequency and lex order.
List<String> words = List.of("apple","banana","apple","orange","banana","apple");
int k = 2;
// Expected Output: ["apple", "banana"]
👉 Use Collectors.groupingBy, counting(), Map.Entry.comparingByValue(), and limit(k).
*/
        List<String> words = List.of("apple","banana","apple","orange","banana","apple");
        int k = 2;
        //words.stream().collect(Collectors.groupingBy(x));
/*
2. Find the First Non-Repeated Character

Given a string, find the first character that appears only once.

String input = "swiss";
// Expected Output: "w"
👉 Stream over chars(), collect with LinkedHashMap to preserve order.
*/


/*
3. Find the Employee with the 2nd Highest Salary

You have a list of employees (id, name, salary). Find the employee with the second-highest salary.

List<Employee> employees = ...
// Expected Output: Employee object with 2nd highest salary


👉 Sort + skip(1) + findFirst() or use distinct() with Comparator.

4. Group People by Age and Find Oldest in Each Group

Input:

List<Person> people = List.of(
    new Person("Alice", 30),
    new Person("Bob", 40),
    new Person("Charlie", 30),
    new Person("David", 40),
    new Person("Eve", 25)
);


👉 Output: Map of age → person with max name length (or oldest person per group).

5. Longest Word in a Sentence
String sentence = "The quick brown fox jumped over the lazy dog";
// Expected Output: "jumped"


👉 Split, stream, reduce with max(Comparator.comparingInt(String::length)).

6. Flatten Nested Lists
List<List<Integer>> nested = List.of(
    List.of(1, 2, 3),
    List.of(4, 5),
    List.of(6, 7, 8, 9)
);
// Expected Output: [1,2,3,4,5,6,7,8,9]


👉 Use flatMap.

7. Detect Anagrams in a List

Given a list of words, group them into lists of anagrams.

List<String> words = List.of("eat","tea","tan","ate","nat","bat");
// Expected Output: [["eat","tea","ate"], ["tan","nat"], ["bat"]]


👉 Key trick: sort characters of each word and groupBy that.

8. Stock Span Problem (Functional Way)

Given daily stock prices, compute for each day the number of consecutive days before it with a lower price.
👉 Normally stack-based, but try expressing with IntStream.range() + filtering.

9. Word Frequency from a File

Read a text file, compute word frequencies, print top 10 most frequent words.
👉 Use Files.lines(Paths.get("file.txt")) → flatMap(line.split(" ")).

10. Custom Collector Challenge

Write a custom collector that collects strings into a single string but inserts - between words and uppercases them.

List<String> input = List.of("java", "streams", "are", "powerful");
// Expected Output: "JAVA-STREAMS-ARE-POWERFUL"
         */
    }
}
