package CompanyPrep.Amazon;

public class MaxConsecutiveOnesIII {
    public static void main(String args[]){
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k =2;
        int result = maxConsecutiveOnes(nums, k);
        System.out.println("The maximum consecutive ones is: " + result);
    }
    public static int maxConsecutiveOnes(int nums[], int k){
        if(nums.length == 0 || k == 0){return 0;}
        int left = 0;
        int right = 0;
        int maxLength = 0;

        int zeroCount = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                zeroCount ++;
            }

            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount --;
                }
                left ++;
            }
            maxLength = Math.max(maxLength, right - left  + 1);
            right ++;
        }
        return maxLength;
    }
}
