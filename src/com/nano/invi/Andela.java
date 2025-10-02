package com.nano.invi;

import java.util.*;

/*
Given a jumbled collection of segments, each of which is represented as
a Pair (startPoint, endPoint), this function sorts the segments to
make a continuous path
A few assumptions you can make:
1. Each particular segment goes in one direction only, i.e.: if you
• see (1, 2), you will not see (2, 1).
2. Each starting point only have one way to the end point, i.e.: if
-you see • (6, 5), you will not see• (6, 10), (6, 3), etc.
For example, if you're passed a list containing the following intarrays:
.. • [(4, 5), • (9, 4), • (5, •1), • (11, 9)]
Then your implementation should sort it such:
• [ (11, 9), • (9, 4) , • (4, 5), (5, 1)] @param segments collection of segments, each represented
by a Pair
(startPoint, endPoint).
@return • The sorted segments such that they form a continuous path.
@throws Exception if there is no way to create one continuous path -from *all - the segments
passed into this function. Feel -free to change the
Exception type as you think appropriate.
 */
public class Andela {

    public static void main(String[] args) throws Exception{
        List<int[]> list = Arrays.asList(
                new int[]{4,5},
                new int[]{9,4},
                new int[]{5,1},
                new int[]{11,9}//,
                //new int[]{10,10}
        );
        list = continuousInterval(list);
        for(int[] a : list)
            System.out.println(a[0] + " " + a[1]);

    }

    private static List<int[]> continuousInterval(List<int[]> arr) throws Exception{
        // find start inetrval
        Map<Integer,int[]> map = new HashMap<>();
        Set<Integer> endPoints = new HashSet<>();
        for(int[] a: arr){
            map.put(a[0], a);
            endPoints.add(a[1]);
        }

        int[] startPoint = null;
        for(int[] a : arr){
            if(!endPoints.contains(a[0]))
                startPoint = map.get(a[0]);
        }

        if(startPoint==null)
            throw new Exception("start point not found possibly because of cycle");

        List<int[]> result = new ArrayList<>();
        result.add(startPoint);
        int sp = startPoint[1];
        for(int i=0;i<arr.size()-1;i++){
            if(map.containsKey(sp)){
                int[] next = map.get(sp);
                result.add(next);
                sp=next[1];
            }
            else
                throw new Exception("Input is not a continuous path");
        }
        return result;
    }

//    private static List<int[]> continuousInterval(List<int[]> arr) throws Exception{
//        if(arr == null || arr.isEmpty())
//            throw new Exception("Input array is either null or empty");
//
//        Collections.sort(arr, (a,b)->b[0]-a[0]);
//        for(int i=1;i<arr.size();i++){
//            int prev = arr.get(i-1)[1];
//            int curr = arr.get(i)[0];
//            if(prev!=curr){
//                throw new Exception("Input is not a continuous path");
//            }
//        }
//        return arr;
//    }

}
