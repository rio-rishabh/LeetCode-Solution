import java.util.HashMap;

public class MinimumWindowSubString {
    public static void main(String args[]){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minimumWindowSubstring(s, t);
        System.out.println("The minimum window substring is: " + result);
    }
    public static String minimumWindowSubstring(String s , String t){
        if(s.length() < t.length()){
            return "";
        }
        int left = 0; 
        int right = 0;
        int formed = 0;
        int result [] = {-1, 0,0}; // This is to store the result window which is like length , left index and right index of the window
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        while(right < s.length()){
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0)+ 1);

            if(required.containsKey(rightChar) && window.get(rightChar).intValue() == required.get(rightChar).intValue()){ formed ++;} // also can be done like window.get(rightChar).equals(required.get(rightChar)))

            while(formed ==(required.size())){ // here formed.equals(required.size()) will not work since formed is a primitive type like int and not an Object like Integer
                int len = right - left + 1;
                if(result[0] == -1 || len < result[0]){
                    result[0] = len;
                    result[1] = left;
                    result[2] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(required.containsKey(leftChar) && window.get(leftChar) < required.get(leftChar)){
                    formed --;
                }
                left ++;
            }
            right ++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
