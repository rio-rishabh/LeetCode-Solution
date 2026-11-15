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
    public static List<List<String>> groupAnagrams(String strs[]){
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
