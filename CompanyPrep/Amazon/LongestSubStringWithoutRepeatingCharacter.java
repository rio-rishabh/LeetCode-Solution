package CompanyPrep.Amazon;
import java.util.HashSet;
public class LongestSubStringWithoutRepeatingCharacter {
    public static void main(String args[]){
        String s = "pqrstpqrsabc";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){return 0;}

        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int right=0 , left = 0;

        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength , right -left);
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
