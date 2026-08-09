package CompanyPrep.Amazon;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String args[]){
        int nums[] = {1,1,2};
        int n = removeDuplicates(nums);
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int nums[]){
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        for(int right = 1 ; right < nums.length ; right++){
            if(nums[right] != nums[left]){
                left ++;
                nums[left] = nums[right];
            }
        }
        return left +1;
    }
}
