package Trees;

import java.util.Stack;

public class ValidBSTIterative {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;            
        }
    }


    public static boolean isValidBSTIterative(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && root.val <= prev.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean result = isValidBSTIterative(root);
        System.out.println("Is the tree a valid BST? " + result);
    }
}
