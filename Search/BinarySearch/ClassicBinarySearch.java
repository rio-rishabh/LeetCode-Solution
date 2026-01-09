public class ClassicBinarySearch {
        public static void main(String args[]){
        int arr [] =  {1, 2, 3,4,5,6,7,8,9,10};
        int target = 21;
        int left = 0;
        int right = arr.length -1 ;
        boolean found = false;
        while(left <= right){
            int mid = left + (right -left ) / 2;
            if(arr[mid] == target){
                System.out.println("Target found at index: " + mid);
                found = true;
                break;
            }
            else if(arr[mid] < target){
                left = mid +1;
            }
            else if (arr[mid] > target){
                right = mid -1;
            }
        }
        if(!found){
            System.out.println("Target not found");
        }
    }
}
