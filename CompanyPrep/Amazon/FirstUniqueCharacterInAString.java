package CompanyPrep.Amazon;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String args[]){
        String s = "loveleetcode";
        int result = firstUniqueCharacter(s);
        System.out.println(result);
    }

    // public static int firstUniqueCharacter(String s){
    //     Map<Character, Integer> frequency = new HashMap<>();

    //     for(Character c : s.toCharArray()){
    //         if(frequency.containsKey(c)){
    //             frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    //         }
    //         else{
    //             frequency.put(c, 1);
    //         }
    //     }
    //     for(int i = 0 ; i < s.length(); i++){
    //         if(frequency.get(s.charAt(i)) == 1){
    //             return i;
    //         }
    //         }
    //         return -1;
    // }

    public static int firstUniqueCharacter(String s){
        int freq[] = new int[26];

        for(int i = 0 ; i< s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i< s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
        }
    }
        return -1;
    }
}
