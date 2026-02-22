package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;
public class TopKFrequentElement {
    public static int[] topKFrequent(int arr[], int k){
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : arr){
            if(frequencyMap.containsKey(num)){
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            }
            else{
                frequencyMap.put(num , 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> frequencyMap.get(a) - frequencyMap.get(b));
        for(int num : frequencyMap.keySet()){
            if(pq.size() < k){
                pq.offer(num);
            }
            else if(num > pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        int result[] = new int[k];
        for(int i = 0; i< k; i++){
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String args[]){
        int arr[] = {1,1,1,2,2,3};
        int k = 2;
        int result[] = topKFrequent(arr, k);
        System.out.println("The top k frequent elements are: " + Arrays.toString(result));
    }
}
