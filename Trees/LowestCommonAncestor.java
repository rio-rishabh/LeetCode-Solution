package Trees;

public class LowestCommonAncestor {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestorTreeNode(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestorTreeNode(root.left, p, q);
        TreeNode right = lowestCommonAncestorTreeNode(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return left != null ? left : right;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = root.left.right;
        TreeNode q = root.right.left;
        TreeNode result = lowestCommonAncestorTreeNode(root, p, q);
        System.out.println("The lowest common ancestor is: " + result.val);
    }
}
