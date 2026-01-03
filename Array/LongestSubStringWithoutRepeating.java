import java.util.HashSet;
import java.util.Set;
public class LongestSubStringWithoutRepeating {
    public static void main(String args[]){
        String s = "abcabcbb";
        int left  = 0;
        int right = 0;
        int maxLength = 0;
        Set<Character> window = new HashSet<>();

        while(right < s.length()){
            if(!window.contains(s.charAt(right))){
                window.add(s.charAt(right));
                right ++ ;
                maxLength = Math.max(maxLength, right - left);
            }
            else{
                window.remove(s.charAt(left));
                left ++; 
            }
        }
        System.out.println("Longest substring without repeating characters is: " + maxLength);
    }
}
