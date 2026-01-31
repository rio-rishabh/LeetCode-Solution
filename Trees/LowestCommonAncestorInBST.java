package Trees;

public class LowestCommonAncestorInBST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestorInBST(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return null;
        }

        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestorInBST(root.left, p, q);   
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestorInBST(root.right, p, q);
        }

        return root;
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
    TreeNode p = root.left.left;
    TreeNode q = root.left.right;
    TreeNode result = lowestCommonAncestorInBST(root, p, q);
    System.out.println("The lowest common ancestor is: " + result.val);
}
}
