package Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversalIterative {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static List<Integer> iterativePostOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            TreeNode temp = stack.peek();

            if(temp.right == null || temp.right == lastVisited){
                stack.pop();
                result.add(temp.val);
                lastVisited = temp;
            }
            else{
                current = temp.right;

            }
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
        List<Integer> result = iterativePostOrder(root);
        System.out.println("Postorder traversal: " + result);
    }
}
