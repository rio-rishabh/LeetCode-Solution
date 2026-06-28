package CompanyPrep.Amazon;

import java.util.Arrays;

public class ProductOFArrayExceptSelf {
    public static void main(String args[]){
        int arr[] = {1,2,3,4};
        int result[] = productOfArrayExceptSelf(arr);
        System.out.println("The product of array except self is: " + Arrays.toString(result));
    }

    public static int[] productOfArrayExceptSelf(int arr[]){
        int result[] = new int[arr.length];

        result[0] = 1;
        for(int i = 1 ; i < arr.length; i++){
            result[i] = result[i-1] * arr[i-1];
        }

        int suffix = 1;
        for(int i = arr.length - 1; i >= 0; i--){
            result[i] = result[i] * suffix;
            suffix *= arr[i];
        }
        return result;
    }
}
