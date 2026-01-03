import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithKMostDistinctCharacters {
    public static void main(String args[]){
        String s = "eceba";
        int k =2;
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;
        int maxLength = 0;
       
        for(int right = 0; right< s.length(); right++){
            char rightChar = s.charAt(right);

            charCount.put(rightChar, charCount.getOrDefault(rightChar, 0)+1);

            while(charCount.size() > k){
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.getOrDefault(leftChar, 0)-1);
                if(charCount.get(leftChar) == 0){
                    charCount.remove(leftChar);
                }
                left ++ ;
            }

            maxLength = Math.max(maxLength, right - left +1);
            System.out.println("The maximum length is " + maxLength);
        }
        System.out.println("Final maximum length: " + maxLength);
    }
}
