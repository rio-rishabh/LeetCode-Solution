package CompanyPrep.Amazon;

import java.util.ArrayList;
import java.util.List;

public class NetworkDelayInTime {
    public static void main(String args[]){
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
    public static int networkDelayTime(int times[][], int n , int k){
        List<List<int[]>>  adj = new ArrayList<>(); 
        
        for(int i = 0 ; i< n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edge : times){
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        int dist[] = new int[n+ 1];
    }
}






