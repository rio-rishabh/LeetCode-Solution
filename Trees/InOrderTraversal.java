import java.util.List;
import java.util.ArrayList;
public class InOrderTraversal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static List<Integer> recursiveInOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    static void inOrderHelper(TreeNode node, List<Integer> result){
        if(node == null){
            return ;
        }
        inOrderHelper(node.left, result);
        result.add(node.val);
        inOrderHelper(node.right, result);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        List<Integer> result = recursiveInOrder(root);
        System.out.println("Inorder traversal: " + result);
    }
}
