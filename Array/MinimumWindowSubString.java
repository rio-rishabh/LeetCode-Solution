import java.util.HashMap;
import java.util.Map;
public class MinimumWindowSubString {
    public static void main(String args[]){
        String s ="ADOBECODEBANC";
        String t = "ABC";
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            required.put( c, required.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int formed = 0 ;
        int result [] = {-1, 0, 0};

        
        for(int right = 0; right < s.length(); right ++){
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) +1);

            if(required.containsKey(rightChar) && window.get(rightChar).intValue() == required.get(rightChar). intValue()){
                formed ++;
            }

            while(formed == required.size()){
              int windowLength = right - left + 1;

              if(result[0] == -1  || windowLength < result[0]){
                result[0] = windowLength ;
                result[1] = left ;
                result[2] = right;
              }
              char leftChar = s.charAt(left);
              window.put(leftChar, window.get(leftChar)-1);
              if(required.containsKey(leftChar) && window.get(leftChar) < required.get(leftChar)){
                formed --;
              }
                left ++;              
            }
        }
        if(result[0] == -1){
            System.out.println("No window found");
        }
        else{
            System.out.println("Minimum window substring is: " + s.substring(result[1], result[2]+1));
        }
    }
}
