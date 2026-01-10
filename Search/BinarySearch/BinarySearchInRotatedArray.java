public class BinarySearchInRotatedArray {
    public static void main(String args[]){
        int arr[] = {5,1,3};
        int target = 3;
        int result = search(arr, target);
        System.out.println("Result is: " + result);
    }
    public static int search(int arr[], int target){
        int left = 0;
        int right = arr.length -1;
        int result = -1;
        while(left <= right){
            int mid = left +(right - left )/2;
            if(arr[mid] == target){
                result = mid;
                break;
            }            
            else if (arr[left] <= arr[mid]){
                if(target >= arr[left] && target < arr[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid +1;
                }
            }
            else{
                if(target > arr[mid] && target <= arr[right]){
                    left = mid +1;
                }
                else{
                    right = mid -1;
                }
            }
        }
        return result;
}
}
