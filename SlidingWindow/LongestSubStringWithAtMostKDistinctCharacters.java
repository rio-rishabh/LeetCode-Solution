import java.util.HashMap;
import java.util.Map;
public class LongestSubStringWithAtMostKDistinctCharacters {
    public static void main(String args[]){
        String s = "bbccpeqabcccc";
        int k = 2;
        int result = longestDistinctSubstring(s, k);
        System.out.println("The longest substring with at most " + k + " distinct characters is: " + result);
    }
    public static int longestDistinctSubstring(String s , int k){
         if(s.length() == 0 || k == 0){
            return 0;
         }
         int left = 0;
         int maxLength = 0;
         int right = 0;
         Map<Character, Integer> window = new HashMap<>();
         while(right < s.length()){
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);

            while(window.size() > k){
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(window.get(leftChar) == 0){
                    window.remove(leftChar);
                }
                left ++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right ++;
         }
         return maxLength;
    }
}
