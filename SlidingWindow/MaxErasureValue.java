import java.util.HashSet;
import java.util.Set;
public class MaxErasureValue {
    public static void main(String args[]){
        int nums[] = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        int result = maxErasureValue(nums);
        System.out.println("The maximum erasure value is: " + result);
    }
    public static int maxErasureValue(int nums[]){
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxValue = 0;
        int windowSum = 0;
        Set<Integer> window = new HashSet<>();
        while(right < nums.length){
            if(!window.contains(nums[right])){
                window.add(nums[right]);
                windowSum += nums[right];
                right ++;
                maxValue = Math.max(maxValue, windowSum);
            }
            else{
                windowSum -= nums[left];
                window.remove(nums[left]);
                left ++;
            }
        }
        return maxValue;
    }
}
