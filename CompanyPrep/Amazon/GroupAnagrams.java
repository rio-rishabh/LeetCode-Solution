package CompanyPrep.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class GroupAnagrams {
    public static void main(String args[]){
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String strs[]){
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int count[] = new int[26];
            for(int i = 0 ; i< s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i< 26; i++){
                sb.append("#").append(count[i]);
            }
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
