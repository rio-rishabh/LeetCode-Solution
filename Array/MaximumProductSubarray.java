public class MaximumProductSubarray {
    public static void main(String args[]){
        int arr[] = {-2, 3, -4};
        int maxProduct = arr[0];
        int currentProduct = arr[0];
        int minProduct = arr[0];

        if(arr.length == 0){
            System.out.println("Array is empty");
        }

        for(int i = 1; i< arr.length ; i++){
          
            int temp = currentProduct ;

            currentProduct = Math.max(arr[i], Math.max(arr[i]* currentProduct , arr[i] * minProduct));

            minProduct = Math.min(arr[i], Math.min(arr[i] * temp, arr[i] * minProduct));

            maxProduct = Math.max(maxProduct, currentProduct);
        }
        System.out.println("Maximum product is: " + maxProduct);
    }
}
