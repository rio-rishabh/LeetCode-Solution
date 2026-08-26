
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


    // public static int findKthLargest(int nums[], int k){
    //     PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //     for(int num : nums){
    //         if(minHeap.size() < k){
    //             minHeap.offer(num);
    //         }
    //         else if(num > minHeap.peek()){
    //             minHeap.poll();
    //             minHeap.offer(num);
    //         }
    //     }
    //     return minHeap.peek(); // O(n logk) time complexity and O(k) space complexity
    // }

    public static int findKthLargest(int nums[], int k){
        int target = nums.length - k;
        int lo =0, hi = nums.length - 1;
        while(lo < hi){
            int p = partition (nums, lo, hi);
            if(p == target){return nums[p];}
            if(p < target){
                lo = p +1;
            }
            else if(p > target){
                hi = p -1;
            }
        }
        return -1;
    }

    public static int partition(int nums[], int lo , int high){
        int pivot = nums[high];
        int i = lo;
        for(int j = lo ; j < high; j++){
            if(nums[j] <= pivot){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    public static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


