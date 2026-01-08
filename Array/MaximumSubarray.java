public class MaximumSubarray {
    public static void main(String args[]){
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        int currentSum = arr[0];
        int maxSum = arr[0];

        if(arr.length == 0){
            System.out.println("Array is empty");
        }
        for(int i = 1; i < arr.length; i++){
         
            currentSum = Math.max(arr[i],  arr[i] + currentSum);


            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Maximum sum is: " + maxSum);
    }
}
