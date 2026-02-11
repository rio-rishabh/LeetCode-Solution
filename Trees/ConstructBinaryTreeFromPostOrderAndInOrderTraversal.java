package Trees;
import java.util.HashMap;
public class ConstructBinaryTreeFromPostOrderAndInOrderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static int postOrderIndex[];
    static HashMap<Integer, Integer> inOrderIndexMap;

    public static TreeNode buildTree(int postOrder[], int inOrder[]){

        postOrderIndex = new int []{postOrder.length -1};
        inOrderIndexMap = new HashMap<>();

        for(int i = 0; i< inOrder.length ; i++){
            inOrderIndexMap.put(inOrder[i], i);
        }

        return buildTreeHelper(postOrder, 0, inOrder.length -1 );
    }

    private static TreeNode buildTreeHelper(int postOrder[], int inOrderLeft, int inOrderRight){
        if(inOrderLeft > inOrderRight){
            return null;
        }

        int rootValue = postOrder[postOrderIndex[0]];
        postOrderIndex[0]--;

        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInOrder = inOrderIndexMap.get(rootValue);

        root.right = buildTreeHelper(postOrder, rootIndexInInOrder + 1, inOrderRight);
        root.left = buildTreeHelper(postOrder, inOrderLeft, rootIndexInInOrder -1);

        return root;
    }

    public static void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);
        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
    public static void printPostorder(TreeNode root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {    
        int postOrder[] = {9, 15, 7, 20, 3};
        int inOrder[] = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(postOrder, inOrder);
        printTree(root, "", true);
        printInorder(root);
        printPostorder(root);
        System.out.println();   
    }
}
