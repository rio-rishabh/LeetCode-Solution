import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class FindAllAnagramsInAString {
    public static void main(String args[]){
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println("The indices of the anagrams are: " + result);
    }
    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()){
            return result;
        }

        int k = p.length();
        int need[] = new int[26];
        int window[] = new int[26];

        for(int i = 0; i< k ;i++){
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if(arraysEqual(need, window)){
           result.add(0);
        }

        for(int i = k ; i< s.length(); i++){
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i-k) - 'a']--;
            if(arraysEqual(need, window)){
                result.add(i - k + 1);
            }
        }
        return result;
    }
    public static boolean arraysEqual(int[] arr1, int[] arr2){
        for(int i = 0; i< arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
