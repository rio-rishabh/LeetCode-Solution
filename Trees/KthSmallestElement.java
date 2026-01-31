package Trees;

public class KthSmallestElement {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    int count = 0;
    int result = 0;
    public static int kthSmallest(TreeNode root, int k){
        count = 0;
        result = 0;
        kthSmallestHelper(root, k);
        return result;
    }

    public static void kthSmallestHelper(TreeNode root, int k){
        if(root == null){
            return;
        }
        kthSmallestHelper(root.left, k);
        count++;

        if(count == k){
            result = root.val;
            return;
        }
        kthSmallestHelper(root.right, k);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 2;
        int result = kthSmallest(root, k);
        System.out.println("The kth smallest element is: " + result);
    }
}
