public class MaximumAverageSubArrays2 {
    public static void main(String args[]){
        int nums[] = {1,12,-5,-6,50,3};
        int k = 4;
        int threshold = 3;
        int maxAverageCount = findMaxAverage(nums, k, threshold);
        System.out.println("The maximum average count is: " + maxAverageCount);
    }
    public static int findMaxAverage(int nums[], int k, int threshold){
        if(nums.length == 0 || k == 0|| nums.length < k){
            return 0;
        }
        int count = 0;
        int windowSum = 0;

        for(int i = 0 ; i< k ;i++){
            windowSum += nums[i];
        }
        int average = windowSum / k;
        if(average >= threshold){
            count ++;
        }
        for(int i = k ; i< nums.length ; i++){
            windowSum += nums[i] - nums[i - k];
            average = windowSum / k;
            if(average >= threshold){
                count ++;
            }
        }
        return count;
    }
}

