package CompanyPrep.Amazon;

public class LongestRepeatingCharacterReplacement {
    public static void main(String args[]){
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s , k));
    }

    public static int characterReplacement(String s, int k){
        if(s.length() == 0 || k ==0 ){return 0;}
        int maxLength = 0;
        int right = 0, left = 0, bestCount = 0;
        int charCount[] = new int[26];

        while(right < s.length()){
            charCount[s.charAt(right) - 'A']++;
            maxLength = Math.max(maxLength, charCount[s.charAt(right) - 'A']);
            
            while(right - left +1 - maxLength > k){
                charCount[s.charAt(left) - 'A']--;
                left ++;
            }
            bestCount = Math.max(bestCount, right - left +1);
            right ++;
        }
        return bestCount;
    }
}
