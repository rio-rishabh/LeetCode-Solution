public class MaximumSumCircularSubarray {
    public static void main(String args[]){
        int arr[] = {-3, -2, -3};
        int totalSum = 0;

        for(int nums: arr){
            totalSum += nums;
        }

        int noMaxWrap = kadaneMax(arr);

        int minSubArray = kadaneMin(arr);

        int maxWrap = totalSum - minSubArray;

        if(maxWrap == 0){
           System.out.println("Maximum sum is: " + noMaxWrap);
        }

       int result = Math.max(noMaxWrap, maxWrap);
    //    System.out.println("Maximum sum is: " + result);
    }

    public static int kadaneMax(int arr[]){

        int currentMax = arr[0];
        int maxSum = arr[0];

        for(int i =1 ; i< arr.length; i++){
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }

    public static int kadaneMin(int arr[]){
        int currentMin = arr[0];
        int minSum = arr[0];

        for(int i =1 ; i< arr.length; i++){
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minSum = Math.min(minSum, currentMin);
        }
        return minSum;
    }
}
