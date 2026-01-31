package Trees;

public class DiameterOfTree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static int diameter = 0;

    public static int diameterOfTree(TreeNode root){
        diameter = 0;
        diameterOfTreeHelper(root);
        return diameter;
    }

    public static int diameterOfTreeHelper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = diameterOfTreeHelper(root.left);
        int rightHeight = diameterOfTreeHelper(root.right);

        diameter = Math.max(diameter, leftHeight+rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int result = diameterOfTree(root);
        System.out.println("The diameter of the tree is: " + result);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        result = diameterOfTree(root);
        System.out.println("The diameter of the tree is: " + result);
    }
}
