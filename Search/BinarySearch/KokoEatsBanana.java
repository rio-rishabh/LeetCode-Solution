public class KokoEatsBanana {
    public static void main(String args[]){
        int piles []  = {3, 6, 7, 11};
        int h = 8;
        
        int left  = 1;
        int right = findMax(piles);

        while(left < right){
            int mid = left +(right - left) /2;

            if(canEatAll(piles, mid, h)){
                right = mid;
            }
            else{
                left = mid +1;
            }
        }
        System.out.println("The minimum number of bananas Koko can eat is: " + left);
    }

    public static int findMax(int piles[]){
        int max = piles[0];
        for(int pile : piles){
            max = Math.max(max, pile);
    }
    return max;
}

public static boolean canEatAll(int piles[], int mid , int h){
    int hours = 0;

    for(int pile : piles){
        hours += (pile + mid -1) / mid;

        if(hours > h){
            return false;
        }
    }
    return hours <=h;
}
}
