package BinarySearch;

public class KokoEatsBananas {
    public static void main(String args[]){
        int piles[] = {3, 6, 7, 11};
        int h =8;
        System.out.println(minEatingSpeed(piles, h));
    }
    public static int minEatingSpeed(int piles[], int h){
        int left =1;
        int right = findMax(piles);

        while(left < right){
            int mid = left + (right - left) / 2;
            if(canEatAll(piles, mid, h)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }

    public static int findMax(int piles[]){
        int max = 0;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max;
    }
    public static boolean canEatAll(int piles[], int mid , int hours){
        long hourNeeded = 0;
        for(int pile : piles){
            hourNeeded += (pile + mid -1 ) / mid;
            if(hourNeeded > hours){
                return false;
            }
        }
        return true;
    }
}
