package Trees;

public class SymmetricTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static boolean isSymmetric(TreeNode root){
        if(root == null){return true;}
        return isMirror(root.left, root.right);
    }

    static boolean isMirror(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null){return true;}
        if(node1 == null || node2 == null){return false;}
        if(node1.val != node2.val){return false;}
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);       
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean result = isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}
