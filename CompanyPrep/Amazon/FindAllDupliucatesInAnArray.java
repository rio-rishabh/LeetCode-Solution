package CompanyPrep.Amazon;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class FindAllDupliucatesInAnArray {
    public static void main(String args[]){
        int arr[] = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(arr);
        System.out.println(duplicates);
    }

    // public static List<Integer> findDuplicates(int[] nums){

    //     List<Integer> dup = new ArrayList<>();
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for(int i = 0 ; i< nums.length; i++){
    //         map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
    //     }

    //     for(Map.Entry<Integer, Integer> entry : map.entrySet()){
    //         if(entry.getValue() ==2){
    //             dup.add(entry.getKey());
    //         }
    //     }
    //     return dup;
    // }

    public static List<Integer> findDuplicates(int nums[]){
        List<Integer> dup = new ArrayList<>();

        for(int i = 0 ; i< nums.length; i++){

            int x = Math.abs(nums[i]);
            int idx = x-1 ;
            if(nums[idx] < 0){
                dup.add(x);
            }
            else{
                nums[idx] = -nums[idx];
            }
        }
        return dup;
    }
}
