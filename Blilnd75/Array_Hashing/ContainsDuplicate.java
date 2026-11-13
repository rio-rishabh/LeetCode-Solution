package Blilnd75.Array_Hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String args[]){
        int nums [] = {1,2,3,4,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums){
        Set<Integer> hasDuplicate = new HashSet<>();
        for(int num : nums){
            if(hasDuplicate.contains(num)){
                return true;
            }
            hasDuplicate.add(num);
        }
        return false;
    }
}
