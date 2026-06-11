public class RemoveDuplicatesFromSortedArray {
    public static void main(String args[]){
        int arr[] = {1,1,2,2,3,3,4,4,5,5};
        int result = removeDuplicates(arr);
        System.out.println("The number of unique elements is: " + result);
    }

    public static int removeDuplicates(int arr[]){
        if(arr.length == 0 || arr == null){
            return 0;
        }
        int left  = 0;
        
        for(int right = 1; right < arr.length; right ++){
            if(arr[right] != arr[left]){
                left ++;
                arr[left] = arr[right];
            }
        }
        return left + 1;
    }
}
