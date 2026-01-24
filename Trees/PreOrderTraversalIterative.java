package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversalIterative {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val){
            this.val = val;
        }
    }

    static List<Integer> iterativePreOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(current != null || !stack.isEmpty()){

            while(current != null){
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            current = current.right;
        }
        return result;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        List<Integer> result = iterativePreOrder(root);
        System.out.println("Preorder traversal: " + result);
    }
}
