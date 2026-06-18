package BinarySearch;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String args[]){
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int result = shipWithinDays(weights, days);
        System.out.println("The minimum capacity is: " + result);
    }

    public static int shipWithinDays(int weights[], int days){
        int left = findMax(weights);
        int right = findSum(weights);

        while(left < right){
            int mid = left +(right - left ) / 2;
            if(canShip(weights, mid, days)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static boolean canShip(int weights[], int capacity, int daysNeeded){
        int days = 1;
        int currentWeight = 0;

        for(int weight : weights){
            if(currentWeight + weight > capacity){
                days ++;
                currentWeight = weight;
                if(days > daysNeeded){
                    return false;
                }
            }
            else{
                currentWeight += weight;
            }
        }
        return days <= daysNeeded;
    }

    public static int findMax(int weights[]){
        int max = 0;
        for(int weight : weights){
            max = Math.max(max, weight);
        }
        return max;
    }

    public static int findSum(int weights[]){
        int sum = 0;
        for(int weight : weights){
            sum += weight;
        }
        return sum;
    }
}
