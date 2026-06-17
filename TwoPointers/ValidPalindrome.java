public class ValidPalindrome {
    public static void main(String args[]){
        String s = "abc";
        boolean result = isPalindrome(s);
        System.out.println("Is the string a valid palindrome? " + result);
    }

    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right --;
        }
        return true;
    }
}
