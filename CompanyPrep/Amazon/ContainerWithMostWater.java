package CompanyPrep.Amazon;

public class ContainerWithMostWater {
    public static void main(String args[]) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int height[]){
        int left = 0;
        int right = height.length - 1;
        int best = 0;

        while(left < right){
            int area = Math.min(height[left], height[right]);
            best = Math.max(best, area  *(right - left));

            if(height[left] < height[right]){
                left ++;
            }
            else{
                right --;
            }

        }
        return best;
    }
}
