import java.util.HashMap;
import java.util.Map;
public class FruitIntoBaskets {
    public static void main(String args[]){
        int fruits[] = {3,3,3,1,2,1,1,2,3,3,4};
        int result = maxFruit(fruits);
        System.out.println("The maximum number of fruits is: " + result);
    }
    public static int maxFruit(int fruits[]){
        if(fruits.length == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Integer, Integer> window = new HashMap<>();

        while(right < fruits.length){
            int rightFruit = fruits[right];
            window.put(rightFruit, window.getOrDefault(rightFruit, 0) + 1);

            while(window.size() > 2){
                int leftFruit = fruits[left];
                window.put(leftFruit, window.get(leftFruit) - 1);
                if(window.get(leftFruit) == 0){
                    window.remove(leftFruit);
                }
                left ++;
                
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right ++;
        }
        return maxLength;
    }
}

