package Trees;

public class SameTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){return true;}
        if(root1 == null || root2 == null){return false;}
        if(root1.val != root2.val){return false;}

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
    public static void main(String args[]){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        boolean result = isSameTree(root1, root2);
        System.out.println("Are the trees same? " + result);
    }
}
