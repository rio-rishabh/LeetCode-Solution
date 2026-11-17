package Blilnd75.Array_Hashing;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class EncodeDecodeString {
    public static void main(String agrs[]){
        List<String> strs = Arrays.asList("lint", "code", "love", "you");
        // also try: Arrays.asList("Hello", "#World", "", "a#b");
        String encoded = encode(strs);
        System.out.println(encoded);          // e.g. 4#lint4#code4#love3#you
        List<String> decoded = decode(encoded);
        System.out.println(decoded);          
    }

    public static String encode(List<String> s){
        StringBuilder encoded = new StringBuilder();
        for(String str: s){
            encoded.append(str.length()) .append('#').append(str);
        }
        return encoded.toString();
    }

    public static List<String> decode(String s){
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < s.length()){
            int j = i;
            while(s.charAt(j) != '#') j++;

            int len = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)