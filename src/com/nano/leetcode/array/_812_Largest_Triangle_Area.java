package com.nano.leetcode.array;
/*
812. Largest Triangle Area
Easy
Topics
premium lock icon
Companies
Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
Example 1:


Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2.00000
Explanation: The five points are shown in the above figure. The red triangle is the largest.
Example 2:

Input: points = [[1,0],[0,0],[0,1]]
Output: 0.50000


Constraints:

3 <= points.length <= 50
-50 <= xi, yi <= 50
All the given points are unique.
 */
public class _812_Largest_Triangle_Area {

    public double largestTriangleArea(int[][] points) {
        double area=0 ;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                for(int k=0;k<points.length;k++){
                    area = Math.max(area, area(points[i], points[j], points[k]));
                }
            }
        }
        return area;
    }

    private double area(int[] x, int[] y, int[] z){
        return 0.5 * Math.abs(x[0]*y[1]+y[0]*z[1]+z[0]*x[1]
                - x[1]*y[0]- y[1]*z[0]- z[1]*x[0]);
    }
/*
    Approach #1: Brute Force [Accepted]
    Intuition

    For each possible triangle, check it's area and keep the area of the largest.

    Algorithm

    We will have 3 for loops to cycle through each choice of 3 points in the array.

    After, we'll need a function to calculate the area given 3 points. Here we have some options:

    We can use the Shoelace formula directly, which tells us the area given the 3 points;

    We can use Heron's formula, which requires the 3 side lengths which we can get by taking the distance of two points;

    We can use the formula area = 0.5 * a * b * sin(C) and calculate the angle C with trigonometry.

    Our implementation illustrates the use of the shoelace formula.

    If we did not know the shoelace formula, we could derive it for triangles with the following approach: starting with points (px, py), (qx, qy), (rx, ry), the area of this triangle is the same under a translation by (-rx, -ry), so that the points become (px-rx, py-ry), (qx-rx, qy-ry), (0, 0).

    From there, we could draw a square around the triangle with sides touching the coordinate axes, and calculate the area of the square minus the area of the right triangles surrounding the inner triangle.

    For more on this approach, see the Wikipedia entry for the Shoelace formula.

   class Solution {
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }
}


   class Solution(object):
    def largestTriangleArea(self, points):
        def area(p, q, r):
            return .5 * abs(p[0]*q[1]+q[0]*r[1]+r[0]*p[1]
                           -p[1]*q[0]-q[1]*r[0]-r[1]*p[0])

        return max(area(*triangle)
            for triangle in itertools.combinations(points, 3))


    Complexity Analysis

    Time Complexity: O(N3), where N is the length of points. We use three for-loops of length O(N), and our work calculating the area of a single triangle is O(1).

    Space Complexity: O(1).

    */
}
