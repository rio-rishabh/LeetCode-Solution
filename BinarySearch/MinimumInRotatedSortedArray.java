package BinarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String args[]){
        int arr[] = {5,6,7,8,9,10,1,2,3,4};
        int result = search(arr);
        System.out.println("The minimum element is: " + result);
    }
    public static int search(int arr[]){
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        if(arr.length == 1){
            return arr[0];
        }
        while(left < right){
            int mid = left + (right - left ) / 2;
            if(arr[mid] > arr[right]){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }
        result = arr[left];
        return result;
    }
}
