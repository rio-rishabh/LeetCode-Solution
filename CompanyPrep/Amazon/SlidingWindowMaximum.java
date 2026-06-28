package CompanyPrep.Amazon;

import java.util.Arrays;
public class SlidingWindowMaximum {
    public static void main(String args[]){
        int nums[] = {1,3 ,-1,-3,5,3,6,7};
        int k = 3;
        int result[] = slidingWindowMaximum(nums, k);
        System.out.println("The sliding window maximum is: " + Arrays.toString(result));
    }

    // First Approach : Brute Force
    public static int[] slidingWindowMaximum(int nums[], int k){
        if(nums.length == 0 || k == 0){
            return new int[0];
        }

        int result[] = new int[nums.length - k +1];
        int left = 0;
        int right = k -1;

        while(right < nums.length){
            int max = Integer.MIN_VALUE;
            for(int i = left ; i <= right; i++){
                max = Math.max(max, nums[i]);
                result[left] = max;
            }
            left ++;
            right ++;   
        }
        return result;
    }
}
