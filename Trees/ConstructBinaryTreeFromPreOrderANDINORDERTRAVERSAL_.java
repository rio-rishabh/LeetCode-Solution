package Trees;

import java.util.HashMap;
public class ConstructBinaryTreeFromPreOrderANDINORDERTRAVERSAL_ {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static int preOrderIndex[];

    static HashMap<Integer, Integer> inOrderIndexMap;
    public static TreeNode buildTree(int preOrder[], int inOrder[]){
        
        preOrderIndex = new int[]{0};

        inOrderIndexMap = new HashMap<>();

        for(int i = 0; i< inOrder.length; i++){
            inOrderIndexMap.put(inOrder[i], i);
        }

        return buildTreeHelper(preOrder, 0, inOrder.length -1);
    }

    private static TreeNode buildTreeHelper(int preOrder[], int inOrderLeft, int inOrderRight){
        if(inOrderLeft > inOrderRight){
            return null;
        }
        int rootValue = preOrder[preOrderIndex[0]];
        preOrderIndex[0]++;
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInInOrder = inOrderIndexMap.get(rootValue);

        root.left = buildTreeHelper(preOrder, inOrderLeft, rootIndexInInOrder -1);
        root.right = buildTreeHelper(preOrder, rootIndexInInOrder + 1, inOrderRight);

        return root;
    }
    public static void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);
        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }

    // Verify: Print inorder traversal
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Verify: Print preorder traversal
    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        System.out.println("========== EXAMPLE 1 ==========");
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};

        System.out.println("Input:");
        System.out.println("  Preorder: [3, 9, 20, 15, 7]");
        System.out.println("  Inorder:  [9, 3, 15, 20, 7]");
        System.out.println();

        TreeNode root1 = buildTree(preorder1, inorder1);

        System.out.println("Constructed Tree:");
        System.out.println(root1.val);
        printTree(root1.left, "", true);
        printTree(root1.right, "", false);

        System.out.println("\nVerification:");
        System.out.print("  Preorder of result: ");
        printPreorder(root1);
        System.out.println();
        System.out.print("  Inorder of result:  ");
        printInorder(root1);
        System.out.println("\n");

        /*
         * Example 2:
         * Build this tree:
         *          1
         *         / \
         *        2   3
         *       / \
         *      4   5
         */
        System.out.println("========== EXAMPLE 2 ==========");
        int[] preorder2 = {1, 2, 4, 5, 3};
        int[] inorder2 = {4, 2, 5, 1, 3};

        System.out.println("Input:");
        System.out.println("  Preorder: [1, 2, 4, 5, 3]");
        System.out.println("  Inorder:  [4, 2, 5, 1, 3]");
        System.out.println();

        TreeNode root2 = buildTree(preorder2, inorder2);

        System.out.println("Constructed Tree:");
        System.out.println(root2.val);
        printTree(root2.left, "", true);
        printTree(root2.right, "", false);

        System.out.println("\nVerification:");
        System.out.print("  Preorder of result: ");
        printPreorder(root2);
        System.out.println();
        System.out.print("  Inorder of result:  ");
        printInorder(root2);
        System.out.println("\n");

        /*
         * Example 3: Single node
         */
        System.out.println("========== EXAMPLE 3 (Single Node) ==========");
        int[] preorder3 = {1};
        int[] inorder3 = {1};

        TreeNode root3 = buildTree(preorder3, inorder3);
        System.out.println("Tree: " + root3.val);
        System.out.println("Left: " + root3.left);
        System.out.println("Right: " + root3.right);
    }
}
