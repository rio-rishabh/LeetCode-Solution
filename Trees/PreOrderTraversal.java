import java.util.List;
import java.util.ArrayList;
public class PreOrderTraversal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static List<Integer> recursivePreOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }

    static void preOrderHelper(TreeNode node, List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);
        preOrderHelper(node.left, result);
        preOrderHelper(node.right, result);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        List<Integer> result = recursivePreOrder(root);
        System.out.println("Preorder traversal: " + result);
    }
}
