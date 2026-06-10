import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class AccountsMerge {
    public static void main(String args[]){
        String accounts[][] = {
            {
                "John", "johnsmith@gmail.com", "john00@gmail.com"
            },
            {
                "John", "johnybravo@gmail.com", "johnnybravo@gmail.com"
            },
            {
                "Mary", "mary@gmail.com"
            },
            {
                "John", "johnsmith@gmail.com", "johnnybravo@gmail.com"
            }
        };

        List<List<String>> result = accountsMerge(accounts);
        System.out.println(result);
    }

    public static List<List<String>> accountsMerge(String[][] accounts) {
        if(accounts == null || accounts.length == 0){
            return new ArrayList<>();
        }

        Map<String , String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        for(String[] account : accounts){
            String name = account[0];
            String firstEmail = null;


            for(int i = 1; i < account.length; i++){
                String email = account[i];
                emailToName.put(email, name);
                parent.putIfAbsent(email, email);
                if(firstEmail == null){
                    firstEmail = email;
                }
                else{
                    union(parent, firstEmail, email);
                }
            }
        }

        Map<String, List<String>> mergedAccounts = new HashMap<>();
        for(String email: parent.keySet()){
            String root = find(email, parent);
            mergedAccounts.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> emails : mergedAccounts.values()){
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);
            result.add(merged);
        }
        return result;
    }

    public static String find(String email, Map<String , String> parent){
        if(!parent.get(email).equals(email)){
            parent.put(email, find(parent.get(email), parent));
        }
        return parent.get(email);
    }

    public static void union(Map<String, String> parent, String email1, String email2){
        String rootA = find(email1, parent);
        String rootB = find(email2, parent);
        if(!rootA.equals(rootB)){
            parent.put(rootA, rootB);
        }
    }
}
