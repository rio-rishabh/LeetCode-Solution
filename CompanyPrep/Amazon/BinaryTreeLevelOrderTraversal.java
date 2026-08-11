package CompanyPrep.Amazon;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class BinaryTreeLevelOrderTraversal {
    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result  = new ArrayList<>();
        if(root == null){return result;}
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            for(int i = 0 ; i < levelSize; i++){
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if(node.left != null){queue.add(node.left);}
                if(node.right != null){queue.add(node.right);}
            }
            result.add(levelValues);
        }
        return result;
    }
}
