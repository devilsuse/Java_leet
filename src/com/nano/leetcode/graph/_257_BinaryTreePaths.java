package com.nano.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/*
257. Binary Tree Paths
Solved
Easy
Topics
premium lock icon
Companies
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
 */
public class _257_BinaryTreePaths {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, new StringBuffer(), result);
        return result;
    }

    private void dfs(TreeNode node, StringBuffer sb, List<String> result){
        if(node!=null){
            if(sb.isEmpty())
                sb.append(node.val);
            else
                sb.append("->"+node.val);

            if(node.left==null && node.right==null){
                result.add(sb.toString());
                return;
            }
            dfs(node.left,new StringBuffer(sb), result);
            dfs(node.right,new StringBuffer(sb), result);
        }
    }
}