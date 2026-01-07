public class MoveZeros {
    public static void main(String args[]){
        int arr[] = {0,1,0,3,12};
        int left = 0;
        for(int right =0 ; right < arr.length; right ++){
            if(arr[right] != 0){
                arr[left] = arr[right];
                left ++;
            }
        }
        for(int i =left ; i< arr.length; i++){
            arr[i] = 0;
        }
        System.out.println("Array after moving zeros is: ");
        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
