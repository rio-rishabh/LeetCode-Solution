package Graphs;

import java.util.List;  
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class CloneGraph {
    public static class Node{
        int val;
        List<Node> neighbors;

       Node(){
        val = 0;
        neighbors = new ArrayList<>();
       }

       Node(int val){
        this.val = val;
        this.neighbors = new ArrayList<>();
       }

        Node(int val, List<Node>neighbors){
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    static Map<Node, Node> nodeMap = new HashMap<>();
    public static Node cloneGraph(Node node){
        if(node == null){
            return null;
        }
        nodeMap.clear();
        return cloneGraphHelper(node);
    }

    public static Node cloneGraphHelper(Node node){
        if(nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }

        Node clone = new Node(node.val);

        nodeMap.put(node,clone);

        for(Node neighbor : node.neighbors){
            clone.neighbors.add(cloneGraphHelper(neighbor));
        }
        return clone;
    }

    public static void main(String args[]){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clone = cloneGraph(node1);
        System.out.println("Original graph: " + node1.val);
        System.out.println("Cloned graph: " + clone.val);
    }
}
