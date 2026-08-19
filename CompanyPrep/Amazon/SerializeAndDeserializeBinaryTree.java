package CompanyPrep.Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        String serialized = serialize(root);
        System.out.println(serialized);
        TreeNode deserialized = deserialize(serialized);
        System.out.println(deserialized.val);
        System.out.println(deserialized.left.val);
        System.out.println(deserialized.right.val);
        System.out.println(deserialized.left.left.val);
        System.out.println(deserialized.left.right.val);
        System.out.println(deserialized.right.left.val);
        System.out.println(deserialized.right.right.val);
    }

    public static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public static void serializeHelper(TreeNode root, StringBuilder sb){

        if(sb.length() > 0){sb.append(',');}
        if(root == null){
            sb.append("null");
            return;
        }
        sb.append(root.val);
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }

    public static TreeNode deserialize(String data){
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    public static TreeNode deserializeHelper(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("null")){return null;}

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }
}
