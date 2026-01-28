package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class MaximumDepthOFBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            depth++;
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0 ; i< levelSize; i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null){queue.add(node.left);}
                if(node.right != null){queue.add(node.right);}
            }
            result.add(level);
        }
        return depth;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        int result = maxDepth(root);
        System.out.println("Maximum depth of binary tree is: " + result);
    }
}
