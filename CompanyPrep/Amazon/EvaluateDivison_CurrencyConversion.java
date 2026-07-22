package CompanyPrep.Amazon;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EvaluateDivison_CurrencyConversion {
    public static void main(String agrs[]){
       List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double values[] = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        double result [] = (calcEquation(equations, values, queries));
        System.out.println(Arrays.toString(result));
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0 ; i< equations.size(); i++){
            String a = equations.get(i).get(0) , b = equations.get(i).get(1);

            double v = values[i];

            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b,v);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0/v);
        }

        double ans[] = new double[queries.size()];

        for(int i = 0 ; i<queries.size(); i++){
            String a = queries.get(i).get(0), b = queries.get(i).get(1);

            if(!graph.containsKey(a) || !graph.containsKey(b)){
                ans[i] = -1.0;
                continue;
            }
            else if(a.equals(b)) ans[i] = 1.0;
            else{
                ans[i] = dfs(a,b, graph, new HashSet<>(),1.0);
            }
        }
        return ans;
    }


    public static double dfs(String a, String b, Map<String, Map<String, Double>> graph, Set<String> seen, double acc){
        if(a.equals(b)) return acc;
        seen.add(a);

        for( var e : graph.get(a).entrySet()){
            if(seen.contains(e.getKey())) continue;

            double res = dfs(e.getKey(), b, graph, seen, acc * e.getValue());
            if(res != -1.0) return res;
        }
        return -1.0;
    }
}
