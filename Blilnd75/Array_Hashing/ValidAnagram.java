package Blilnd75.Array_Hashing;

public class ValidAnagram {
    public static void main(String args[]){
        String s = "anagram", t = "agaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        
        int count[] = new int[26];
        for(int i = 0 ; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[s.charAt(i) - 'a']--;
        }
        for(int i : count){
            if(i != 0) return false;
        }
        return true;
    }
}
