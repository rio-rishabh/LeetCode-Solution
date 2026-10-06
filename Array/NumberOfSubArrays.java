/*
* Given an array of integers and two integers k and threshold, 
* return the number of subarrays of size k and average greater than or equal to threshold.
*/
public class NumberOfSubArrays {
    public static void main(String args[]){
        int arr[] = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;
        int windowSum = 0;
        int count = 0;

        if(arr.length == 0 || arr.length < k){
            System.out.println("Invalid Output");
        }

        for(int i = 0; i< k; i++){
            windowSum += arr[i];
        }
        if(windowSum / k >= threshold){
            count ++;
        }
        for(int i = k ; i< arr.length ; i++){
            windowSum = windowSum -arr[i -k];
            windowSum = windowSum + arr[i];
            if(windowSum / k >= threshold){
                count ++;
            }
        }
        System.out.println("Number of subarrays is: " + count);
    }
}
