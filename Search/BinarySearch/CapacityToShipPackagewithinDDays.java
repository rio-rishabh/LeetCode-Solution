public class CapacityToShipPackagewithinDDays {
    public static void main(String args[]){
        int weights[] = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        int left  = findMax(weights);
        int right = findSum(weights);

        while(left < right){
            int mid = left + (right -left) / 2;

            if(canShip(weights, mid, days)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println("The minimum capacity is: " + left);
    }

    public static int findMax(int weights[]){
        int max = 0;

        for(int weight : weights){
            max = Math.max(max, weight);
        }
        return max;
    }

    public static boolean canShip(int weights[], int capacity, int days){
        int daysNeeded  = 1;
        int currentWeight = 0;

        for(int weight : weights){
            if(currentWeight + weight > capacity){
                daysNeeded ++;
                currentWeight = weight;

                if(daysNeeded > days){
                    return false;
                }
            }
            else{
                currentWeight += weight;
            }
        }
        return daysNeeded <= days;
    }

    public static int findSum(int weights[]){
        int sum = 0;
        for(int weight : weights){
            sum += weight;
        }
        return sum;
    }
}
