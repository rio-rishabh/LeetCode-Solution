package CompanyPrep.Amazon;

public class maximumSubarraySumWithOneDeletion {
    public static void main(String args[]){
        int nums[] = {1,-2,0,3};
        int result = maximumSubarraySumWithOneDeletion(nums);
        System.out.println("The maximum subarray sum with one deletion is: " + result);
    }
    public static int maximumSubarraySumWithOneDeletion(int nums[]){
        if(nums.length == 0){return 0;}
        int noDelete = nums[0];
        int oneDelete = 0;
        int ans = nums[0];

        for(int i = 1 ; i < nums.length ; i++){
            oneDelete = Math.max(oneDelete + nums[i], noDelete);
            noDelete = Math.max(noDelete + nums[i], nums[i]);
            ans = Math.max(ans, Math.max(oneDelete, noDelete));
        }
        return ans;
    }
}
