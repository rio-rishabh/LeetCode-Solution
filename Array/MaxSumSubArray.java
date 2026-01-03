public class MaxSumSubArray {
    public static void main(String args[]){
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int windowSum = 0;
        int maxSum = 0;

        if(arr.length == 0 || arr.length < k){
            System.out.println("Invalid input");
        }

        for(int i =0; i< k; i++){
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for(int i = k; i< arr.length; i++){
            windowSum = windowSum -arr[i-k];
            windowSum = windowSum +arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println("Maximum sum is: " + maxSum);
    }
}
