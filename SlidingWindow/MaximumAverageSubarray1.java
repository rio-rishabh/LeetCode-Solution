public class MaximumAverageSubarray1 {
    public static void main(String args[]){
        int nums[] = {1,12,-5,-6,50,3};
        int k = 0;
        double maxAverage = findMaxAverage(nums, k);
        System.out.println("The maximum average is: " + maxAverage);
    }

    public static double findMaxAverage(int nums[], int k){
        if(nums.length == 0 || k == 0){
            return 0.0;
        }

        int windowSum = 0;
        for(int i = 0 ; i< k ; i++){
            windowSum += nums[i];
        }
        int maxSum = windowSum;

        for(int i  = k ; i<nums.length; i++){{
            windowSum += nums[i] - nums[i -k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
    }
    return (double)maxSum / k;
}
}
