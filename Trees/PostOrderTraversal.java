package Trees;

import java.util.List;
import java.util.ArrayList;

public class PostOrderTraversal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> result  = new ArrayList<>();
        postOrderTraversalHelper(root, result);
        return result;
    }

    static void postOrderTraversalHelper(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        postOrderTraversalHelper(root.left, result);
        postOrderTraversalHelper(root.right, result);
        result.add(root.val);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        List<Integer> result = postOrderTraversal(root);
        System.out.println("Postorder traversal: " + result);
    }
}
