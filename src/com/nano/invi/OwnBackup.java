package com.nano.invi;

import java.util.LinkedList;

public class OwnBackup {

    public static void main(String[] args) {

    }

    private static void printTreeZigzag(TreeNode head){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        StringBuilder sb = new StringBuilder();
        boolean flip = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            sb.append("\n"); // sb=1
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    s.append(node.value);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                if(flip){
                    sb.append(s.toString());
                }
                else{
                    sb.append(s.reverse().toString());
                }
                flip=!flip;
        }
        System.out.println(sb);
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right){
        this.value=value;
        this.left=left;
        this.right=right;
    }

}
/*
            1
           2  3
          4 5 6 7
         8 9

*/