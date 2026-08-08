package CompanyPrep.Amazon;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static void main(String agrs[]){
        int nums[] = {1,2,3,4,5};
        int k = 5;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int nums[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
