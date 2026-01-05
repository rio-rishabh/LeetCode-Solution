import java.util.HashMap;
import java.util.Map;
public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]){
        String s = "AABBA";
        int k =1;
        int left =0;
        int maxLength =0;
        int maxFrequency =0;
        Map<Character, Integer> charCount = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0)+1);
            maxFrequency = Math.max(maxFrequency, charCount.get(rightChar));

            int windowLength = right - left + 1;
            int replacementNeeded = windowLength - maxFrequency;

            if(replacementNeeded > k){
                char leftChar =  s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left ++;
                windowLength = right - left +1;
                replacementNeeded = windowLength - maxFrequency;
            }
            maxLength = Math.max(maxLength, right - left +1);
        }
        System.out.println("Longest repeating character replacement is: " + maxLength);
    }
}
