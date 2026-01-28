package Trees;

public class ValidateBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


    static boolean isValidBST(TreeNode root){
        return isValidBSTHelper(root);
    }

    static boolean isValidBSTHelper(TreeNode root){
        TreeNode prev = null;
        if(root == null){return true;}

        if(!isValidBSTHelper(root.left)){return false;}

        if(prev != null && root.val <= prev.val){return false;}

        prev = root;
        return isValidBSTHelper(root.right);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean result = isValidBST(root);
        System.out.println("Is the tree a valid BST? " + result);

        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        result = isValidBST(root);
        System.out.println("Is the tree a valid BST? " + result);
    }
}
