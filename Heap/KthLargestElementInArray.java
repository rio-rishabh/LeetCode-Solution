package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static int kthLargestElement(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr){
            if(pq.size() < k){
                pq.offer(num);
            }
            else if( num > pq.peek()){
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }

    public static void main(String args[]){
        int arr[] = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = kthLargestElement(arr, k);
        System.out.println("The kth largest element is: " + result);

        int arr2[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        int result2 = kthLargestElement(arr2, k2);
        System.out.println("The kth largest element is: " + result2);

        int arr3[] = {1};
        int k3 = 1;
        int result3 = kthLargestElement(arr3, k3);
        System.out.println("The kth largest element is: " + result3);
    }
}
