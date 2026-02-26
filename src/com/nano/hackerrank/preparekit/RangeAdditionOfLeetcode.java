package com.nano.hackerrank.preparekit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
https://www.hackerrank.com/challenges/crush/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to
each array element between two given indices, inclusive. Once all operations have been performed,
return the maximum value in the array.

Example
Queries are interpreted as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

image

The largest value is  after all operations are performed.

Function Description

Complete the function  with the following parameters:

: the number of elements in the array
: a two dimensional array of queries where each  contains three integers, , , and .
Returns

: the maximum value in the resultant array
Input Format

The first line contains two space-separated integers  and , the size of the array and the number of queries.
Each of the next  lines contains three space-separated integers ,  and , the left index, right index and number to add.

Constraints

Sample Input

STDIN       Function
-----       --------
5 3         arr[] size n = 5, queries[] size q = 3
1 2 100     queries = [[1, 2, 100], [2, 5, 100], [3, 4, 100]]
2 5 100
3 4 100
Sample Output

200
Explanation

After the first update the list is 100 100 0 0 0.
After the second update list is 100 200 100 100 100.
After the third update list is 100 200 200 200 100.

The maximum value is 200.
 */
public class RangeAdditionOfLeetcode {
    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here

        long[] arr = new long[n];
        for(int i=0; i<queries.size();i++){
            int start = queries.get(i).get(0)-1;
            int end   = queries.get(i).get(1);
            int value = queries.get(i).get(2);

            arr[start] += value;
            if(end<n)
                arr[end] -= value;  // NOT arr[end] = -value;
        }
        long max=arr[0];
        for(int i=1;i<n;i++){
            arr[i] += arr[i-1];
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    /* Below code runs into TLE
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
        long max=Integer.MIN_VALUE;
        long[] arr = new long[n];
        for(int i=0; i<queries.size();i++){
            int start = queries.get(i).get(0)-1;
            int end   = queries.get(i).get(1)-1;
            int value = queries.get(i).get(2);
            //int j=start;
            while(start<=end){
                arr[start] += value;
                max=Math.max(max, arr[start]);
                start++;
            }
        }
        return max;
    }
    */
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = RangeAdditionOfLeetcode.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
