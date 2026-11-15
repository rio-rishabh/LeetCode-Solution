package Blilnd75.Array_Hashing;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue; 
import java.util.Arrays;
public class TopKFrequentElements {
    public static void main(String args[]){
        int nums[] = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int nums[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) +1 );
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int num: map.keySet()){
            pq.add(num);
        }
        int result[] = new int[k];
        for(int i = 0; i< k ; i++){
            result[i] = pq.poll();
        }
        return result;
    }

}

/**
 * Time Complexity: O(nlogn) because we are using a priority queue to store the elements and the priority queue is a binary heap.
 * Space Complexity: O(n) because we are using a map to store the elements and the priority queue is a binary heap.
 */