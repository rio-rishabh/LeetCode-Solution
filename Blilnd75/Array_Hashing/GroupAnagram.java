package Blilnd75.Array_Hashing;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
public class GroupAnagram {
    public static void main(String args[]){
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    // public static List<List<String>> groupAnagrams(String strs[]){
    //     Map<String, List<String>> map = new HashMap<>();
    //     for(String str : strs){
    //         char charArray[] = str.toCharArray();
    //         Arrays.sort(charArray);
    //         String sorted = new String(charArray);
    //         if(!map.containsKey(sorted)){
    //             map.put(sorted, new ArrayList<>());
    //         }
    //         map.get(sorted).add(str);
    //     }
    //     return new ArrayList<>(map.values());
    // }

    /**
     * Time complexity: O(n*klogk) since we are sorting each string and there are n strings.
     * Space complexity: O(n*k) since we are storing each string in the map.
     */

    public static List<List<String>> groupAnagrams(String strs[]){
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int count[] = new int[26];
            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int n: count){
                sb.append('#');
                sb.append(n);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
       return new ArrayList<>(map.values());
    }
}


/*
 * Time Complexity: O(n*k) since we are iterating through each string and there are n strings.
 * Space Complexity: O(n*k) since we are storing each string in the map.
 */