package Trees;

public class BalancedBinaryTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static boolean isBalanced(TreeNode root){
        return isBalancedHelper(root) != -1;
    }

    public static int isBalancedHelper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = isBalancedHelper(root.left);
        int rightHeight = isBalancedHelper(root.right);
        
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        boolean result = isBalanced(root);
        System.out.println("Is the tree balanced? " + result);
    }
}
