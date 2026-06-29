package CompanyPrep.Amazon;

import java.util.List;
import java.util.ArrayList;

public class RestoreIpAddresses {
    public static void main(String args[]){
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        System.out.println(result);
    }

    public static List<String> restoreIpAddresses(String s){
        List<String> result = new ArrayList<>();
        if(s.length() < 3 || s.length() > 12){return result;}

        int n = s.length();
        for(int l1 = 1; l1 <=3; l1++){
            for(int l2 = 1; l2 <=3; l2++){
                for(int l3 = 1; l3<=3; l3++){
                    int l4 = n - l1 -l2 - l3;
                    if(l4 < 1 || l4 >3){ continue; }

                    String p1 = s.substring(0, l1);
                    String p2 = s.substring(l1, l1+l2);
                    String p3 = s.substring(l1+l2, l1+l2+l3);
                    String p4 = s.substring(l1+l2+l3, n);

                    if(isValid(p1) && isValid(p2) && isValid(p3) && isValid(p4)){
                        result.add(p1+"."+p2+"."+p3+"."+p4);
                    }
                }
            }
        }
        return result;
    }

    public static boolean isValid(String seg){
        if(seg.length() > 1 && seg.charAt(0) == '0'){return false;}
        return Integer.parseInt(seg) <= 255;
    }
}
