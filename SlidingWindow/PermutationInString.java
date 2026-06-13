public class PermutationInString {
    public static void main(String args[]){
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = isPermutation(s1, s2);
        System.out.println("Is the string a permutation of the other? " + result);
    }
    public static boolean isPermutation(String s1, String s2){
        if(s1.length() > s2.length()){
            return false;
        }
        int k = s1.length();
        int need[] = new int[26];
        int window[] = new int[26];

        for(int i = 0; i< k; i++){
            need[s1.charAt(i) - 'a']++; // this here is used to compare values in ascii characters since value of a is 97 so any character that comes up here will get its count based on its presence in string s1
            window[s2.charAt(i) - 'a']++;
        }
        if(arraysEqual(need, window)){return true;}

        for(int i = k ; i<s2.length(); i++){
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i-k) - 'a']--;
            if(arraysEqual(need, window)){return true;}
        }
        return false;
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
