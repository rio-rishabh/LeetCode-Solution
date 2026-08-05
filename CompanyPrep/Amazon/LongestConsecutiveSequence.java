package CompanyPrep.Amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String agrs[]){
        int nums[] = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    // public static int longestConsecutive(int nums[]){
    //     if(nums.length == 0){ return 0; }
    //     Arrays.sort(nums);
    //     int curr = 1;
    //     int best = 1;

    //     for(int i = 1; i < nums.length ; i++){
    //         if(nums[i] == nums[i-1]){continue;}
    //         if(nums[i] == nums[i-1] +1){
    //             curr++;
    //             best = Math.max(best, curr);
    //         }
    //         else{
    //             curr = 1;
    //         }
    //     }

    //     return best;
    // }

    public static int longestConsecutive(int nums[]){
        if(nums.length == 0){ return 0; }
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int best = 0;
        for(int num: set){
            if(!set.contains(num -1)){
                int curr = 1;
                int x = num;
                while(set.contains(x+1)){
                    x++;
                    curr++;
                }
                best = Math.max(best, curr);
            }
        }

        return best;
    }
}
