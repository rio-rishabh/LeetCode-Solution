import java.util.HashSet;
public class LongestSubStringWithoutRepeating {
    public static void main(String args[]){
        String s = "abcabcbb";
        int result = longestSubstringWithoutRepeating(s);
        System.out.println("The longest substring without repeating characters is: " + result);
    }

    public static int longestSubstringWithoutRepeating(String s){
        if(s.length() == 0){
            return 0;
        }

       int left = 0;
       HashSet<Character> window = new HashSet<>();
       int maxLength = 0;
       int right = 0;
       while(right < s.length()){
        if(!window.contains(s.charAt(right))){
            window.add(s.charAt(right));
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        else{
            window.remove(s.charAt(left));
            left++;
        }
       }
       return maxLength;
    }
}
