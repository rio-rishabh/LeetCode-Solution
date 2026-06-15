import java.util.HashMap;
import java.util.Map;
public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]){
        String s = "AABBA";
        int k = 2;
        int result = longestRepeatingCharacterReplacement(s, k);
        System.out.println("The longest repeating character replacement is: " + result);
    }
    public static int longestRepeatingCharacterReplacement(String s, int k){
        if(s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxFrequency = 0;;
        Map<Character, Integer> window = new HashMap<>();

        while(right < s.length()){
            char rightChar = s.charAt(right);

            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            maxFrequency = Math.max(maxFrequency, window.get(rightChar));

            int windowLength = right - left +1; 

            int replacementNeeded = windowLength - maxFrequency;

            if(replacementNeeded > k){
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) -1);
                left ++;
                windowLength = right - left +1;
                replacementNeeded = windowLength - maxFrequency;
            }
            maxFrequency = Math.max(maxFrequency, right - left +1);
            right ++;
        }
        return maxFrequency;
    }
}
