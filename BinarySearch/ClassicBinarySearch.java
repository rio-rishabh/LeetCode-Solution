package BinarySearch;

public class ClassicBinarySearch {
    public static void main(String args[]){
        int nums[] =  {1,2,3,4,5,6,7,8,9,10};
        int target = 8;
        int result = binarySearch(nums, target);
        System.out.println("The target is found at index: " + result);
    }
    public static int binarySearch(int nums[], int target){
        int left = 0;
        int right = nums.length -1 ;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        return -1;
    }
}
