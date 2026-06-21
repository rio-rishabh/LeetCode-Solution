package BFS_DFS;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class CloneGraphs {
    public static class Node{
        int val;
        List<Node> neighbors;

        Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node){
        if(node == null){
            return null;
        }
        Map<Node, Node> nodeMap = new HashMap<>();
        return dfs(node, nodeMap);
    }

    public static Node dfs(Node node, Map<Node, Node> nodeMap){
        if(nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }

        Node clone = new Node(node.val);
        nodeMap.put(node, clone);

        for(Node neighbor : node.neighbors){
            clone.neighbors.add(dfs(neighbor, nodeMap));
        }
        return clone;
    }
    public static void main(String args[]){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);
        Node clone = cloneGraph(n1);
        System.out.println(clone.val);                    // 1
        System.out.println(clone.neighbors.get(0).val);   // 2
        System.out.println(clone != n1);                 
}
}