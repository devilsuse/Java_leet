package com.nano.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
617. Merge Two Binary Trees
Solved
Easy
Topics
premium lock icon
Companies
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.



Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]

Example 2:
Input: root1 = [1], root2 = [1,2]
Output: [2,2]

Constraints:

The number of nodes in both trees is in the range [0, 2000].
-104 <= Node.val <= 104
 */
public class _617_MergeTwoBinaryTrees {
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

class Solution5 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        // Case 1: both are null
        if (root1 == null && root2 == null) {
            return null;
        }

        // Case 2: one is null
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // Case 3: both exist → merge
        TreeNode merged = new TreeNode(root1.val + root2.val);

        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }
}
/*
🔑 Key Observations (Interview Gold)

Base cases handle nulls early

New tree is created, original trees remain unchanged

Time Complexity: O(n)
(every node visited once)

Space Complexity: O(h)
(recursion stack, h = tree height)
 */
class Solution4 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{root1, root2});

        while (!queue.isEmpty()) {
            TreeNode[] pair = queue.poll();
            TreeNode n1 = pair[0];
            TreeNode n2 = pair[1];

            // merge values
            n1.val += n2.val;

            // LEFT children
            if (n1.left != null && n2.left != null) {
                queue.offer(new TreeNode[]{n1.left, n2.left});
            } else if (n1.left == null) {
                n1.left = n2.left;
            }

            // RIGHT children
            if (n1.right != null && n2.right != null) {
                queue.offer(new TreeNode[]{n1.right, n2.right});
            } else if (n1.right == null) {
                n1.right = n2.right;
            }
        }

        return root1;
    }
}
/*
| Metric        | Value            |
| ------------- | ---------------- |
| Time          | **O(n)**         |
| Space         | **O(n)** (queue) |
| Tree creation | ❌ No (in-place)  |

 */

class Solution3 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2==null)
            return null;
        if(root1==null & root2!=null)
            return root2;
        if(root1!=null & root2==null)
            return root1;

        int newNodeValue = (root1!=null?root1.val:0) + (root2!=null?root2.val:0);
        TreeNode mergedTreeNode = new TreeNode(newNodeValue);
        Queue<TreeNode[]> q = new LinkedList<>();
        q.offer(new TreeNode[]{root1, root2, mergedTreeNode});

        while(!q.isEmpty()){
            //   int size = q.size();

            //    for(int i=0; i<size; i++ ){ NOTE: No for loop is required
            TreeNode[] arr = q.poll();
            TreeNode n1 = arr[0];
            TreeNode n2 = arr[1];
            TreeNode merged = arr[2];

            //Process Left Child
            TreeNode left1 = n1!=null?n1.left:null;
            TreeNode left2 = n2!=null?n2.left:null;
            if(left1 != null || left2 != null){
                int leftV = 0;
                if(left1!=null)
                    leftV = left1.val;
                if(left2!=null)
                    leftV += left2.val;
                merged.left = new TreeNode(leftV);
                q.offer(new TreeNode[]{left1, left2, merged.left});
            }

            //Process Right Child
            TreeNode right1 = n1!=null?n1.right:null;
            TreeNode right2 = n2!=null?n2.right:null;
            if(right1 != null || right2 != null){
                int rightV = 0;
                if(right1!=null)
                    rightV = right1.val;
                if(right2!=null)
                    rightV += right2.val;
                merged.right = new TreeNode(rightV);
                q.offer(new TreeNode[]{right1, right2, merged.right});
            }
        }
        return mergedTreeNode;
    }
}
/*
| Metric       | Value                        |
| ------------ | ---------------------------- |
| Time         | **O(n)**                     |
| Space        | **O(n)** (queue + new nodes) |
| Modification | ❌ None                       |

 */