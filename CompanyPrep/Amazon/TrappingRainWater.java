package CompanyPrep.Amazon;

public class TrappingRainWater {
    public static void main(String args[]){
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trappingRainWater(height);
        System.out.println("The amount of water trapped is: " + result);
    }

    public static int trappingRainWater(int height[]){
        int left = 0 ; 
        int right = height.length -1 ;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;
        
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax){
                trappedWater += leftMax -height[left];
                left ++;
            }
            else{
                trappedWater += rightMax -height[right];
                right --;
            }
        }

        return trappedWater;
    }
}
