public class RemoveElement {
    public static void main(String args[]){
        int arr[] = {3,2,2,3};
        int val = 3;
        int left = 0;

        for(int right = 0 ; right < arr.length ; right ++){
            if(arr[right] != val){
                arr[left] = arr[right];
                left ++;
            }
            
        }
        System.out.println("Array after removing element is: " + left);
        for(int i =0; i< left; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
