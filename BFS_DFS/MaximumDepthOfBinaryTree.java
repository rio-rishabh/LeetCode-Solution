package BFS_DFS;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
public class MaximumDepthOfBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        int result = maxDepthBFS(root);
        System.out.println("The maximum depth of the binary tree is: " + result);
    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    // Other Apprach using BFS (Level Order Traversal)

    public static int maxDepthBFS(TreeNode root){
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            depth ++;
            List<Integer> level = new ArrayList<>();

            for(int i =0 ; i< levelSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){queue.add(node.left);}
                if(node.right != null){queue.add(node.right);}
            }

            result.add(level);
        }
        return depth;
    }
}
