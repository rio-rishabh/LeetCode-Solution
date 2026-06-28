package CompanyPrep.Amazon;

import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
public class SlidingWindowMaximum {
    public static void main(String args[]){
        int nums[] = {1,3 ,-1,-3,5,3,6,7};
        int k = 3;
        int result[] = slidingWindowMaximum(nums, k);
        System.out.println("The sliding window maximum is: " + Arrays.toString(result));
    }

    // First Approach : Brute Force
    // public static int[] slidingWindowMaximum(int nums[], int k){
    //     if(nums.length == 0 || k == 0){
    //         return new int[0];
    //     }

    //     int result[] = new int[nums.length - k +1];
    //     int left = 0;
    //     int right = k -1;

    //     while(right < nums.length){
    //         int max = Integer.MIN_VALUE;
    //         for(int i = left ; i <= right; i++){
    //             max = Math.max(max, nums[i]);
    //             result[left] = max;
    //         }
    //         left ++;
    //         right ++;   
    //     }
    //     return result;
    // }

    public static int[] slidingWindowMaximum(int nums[], int k){
        if(nums.length == 0 || k ==0){
            return new int[0];
        }
        if(nums.length < k){
            return new int[]{nums[0]};
        }

        int result[] = new int[nums.length - k +1];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i< nums.length ; i++){
            while(!deque.isEmpty() && deque.peekLast() <= i - k){
                deque.pollLast();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);

            if(i >= k - 1){
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
