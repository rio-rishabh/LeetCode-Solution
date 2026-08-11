package CompanyPrep.Amazon;

public class ValidateBinarySearchTree {
    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static boolean isValidBST(TreeNode root){
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean valid(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val <=min || node.val >=max){return false;}
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
}
