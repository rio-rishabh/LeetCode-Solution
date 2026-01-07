public class RemoveDuplicatesFromSortedArray {
    public static void main(String args[]){
        int arr[] = {1,1,2,2,3,3,4,4,5,5};
        int left = 0;

        //edge case:"if array is empty or null"
        if(arr == null || arr.length == 0){
            System.out.println("Array is empty or null");
        }
        for(int right = 1; right < arr.length ; right ++ ){
            if(arr[right] != arr[left]){
                left ++;
                arr[left] = arr[right];
            }
        }
        System.out.println("Array after removing duplicates is: " + (left + 1));
        for(int i = 0; i <= left; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
