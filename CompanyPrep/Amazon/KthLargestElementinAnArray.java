
package CompanyPrep.Amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementinAnArray {
    public static void main(String args[]){
        int nums[] = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    // public static int findKthLargest(int nums[], int k){
    //     Arrays.sort(nums);
    //     return nums[nums.length - k];
    // } // 0(nlogn) time complexity and 0(1) space complexity


    public static int findKthLargest(int nums[], int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.offer(num);
            }
            else if(num > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }
}


