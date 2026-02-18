package Graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;    
import java.util.PriorityQueue;
public class NetworkDelayTime {

    public static int networkDelayTime(int [][] times, int n, int k){

        List<List<int []>> adj = new ArrayList<>();
        for(int i = 0 ; i<=n ;i++){
            adj.add(new ArrayList<>());
        }

        for(int time[] : times){
            int u = time[0];// Source node
            int v = time[1];// Destinatin Node
            int w = time[2];// Weight/ time taken to reach destination node from source node

            adj.get(u).add(new int[]{v,w}); // Adding the destination node and weight to the source node's adjacency list
        }

        int dist[] = new int[n+1]; // Distance array to store the shortest distance from source node to each node.
        Arrays.fill(dist, Integer.MAX_VALUE); // All distances are initially set to infinity.

        dist[k] = 0; //Distance from Source node to itself is 0.
        
        //We always start with the node that has the shortest distance from the source node.

        PriorityQueue<int []>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // Priority Queue here is to store the node and its distance from the source node. and also here it uses comparator to sort the nodes based on their distance from the source node.
        pq.offer(new int[]{0,k}); // starts with the source node and its distance from the source node is 0.

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int d = curr[0]; // take the smallest distance from the source node to the current node.
            int u = curr[1]; // take the node with the smallest distance from the source node.

            if(d > dist[u]){
                continue;
            } // this is to avoid the nodes that are already visited and present one has shorter distance from the source node.

            for(int []  e :  adj.get(u)){
                int v = e[0];
                int w = e[1];
                int newDist = dist[u] + w;

                if(newDist < dist[v]){
                    dist[v] = newDist;
                    pq.offer(new int[]{newDist, v});
                }
            }
        }

        int max = 0;
        for(int i = 1 ; i<= n; i++){
            if(dist[i] == Integer.MAX_VALUE){return -1;}
            max = Math.max(max, dist[i]);
        }
        return max;
    }   


    public static void main(String args[]){
        int times[][] = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        int result = networkDelayTime(times, n, k);
        System.out.println("The time taken to reach all nodes is: " + result);
    }
}
