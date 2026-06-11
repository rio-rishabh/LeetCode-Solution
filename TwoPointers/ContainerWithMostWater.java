public class ContainerWithMostWater {
    public static void main(String args[]){
        int height[] = {1,8,6,2,5,4,8,3,7};
        int result = containerWithMostWater(height);
        System.out.println("The maximum area is: " + result);
    }

    public static int containerWithMostWater(int height[]){
        int left = 0;
        int right = height.length -1;
        int maxArea = 0;

        while(left < right){
            int width = right - left;
            int shorterHeight = Math.min(height[left], height[right]);
            int area = width * shorterHeight;
            maxArea= Math.max(area, maxArea);
            if(height[left] < height[right]){
                left ++;
            }
            else{
                right --;
            }
        }
        return maxArea;
    }
}
