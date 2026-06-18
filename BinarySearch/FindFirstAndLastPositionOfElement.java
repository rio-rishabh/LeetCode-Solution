package BinarySearch;

public class FindFirstAndLastPositionOfElement {
    public static void main(String args[]){
        int arr[] = {5,7,7,8,8,9, 10};
        int target = 2;
        int result[] = searchRange(arr, target);
        System.out.println("First position of element is: " + result[0]);
        System.out.println("Last position of element is: " + result[1]);
        System.out.println("First and last position of element is: " + result[0] + " " + result[1]);
    }


    public static int[] searchRange(int arr[] , int target){
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        return new int[] {first, last};
    }

    public static int findFirst(int arr[] , int target){
        int left = 0;
        int right = arr.length -1 ;
        int result = -1;
        while(left <= right){
            int mid = left +(right - left) /2 ;

            if(arr[mid] == target){
                result = mid;
                right = mid -1;
            }
            else if(arr[mid] < target){
                left = mid+1;
            }
            else{
                right = mid -1;
            }
        }
        return result;
    }
    public static int findLast(int arr[] , int target){
        int left = 0;
        int right = arr.length -1 ;
        int result = -1;
        while(left <= right){
            int mid = left +(right - left) /2 ;
            if(arr[mid] == target){
                result = mid;
                left = mid +1;
            }
            else if(arr[mid] < target){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return result;
    }
}
