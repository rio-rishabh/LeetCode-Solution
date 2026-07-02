package CompanyPrep.Amazon;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.LinkedList;
public class ReconstructItineray {
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        System.out.println(findItinerary(tickets));
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        if(tickets == null || tickets.size() == 0){return result;}

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> t : tickets){
            graph.computeIfAbsent(t.get(0), K -> new PriorityQueue<>()).add(t.get(1));
        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", graph, route);
        return route;
    }

    public static void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> route){
        PriorityQueue<String> pq = graph.get(airport);
        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll(), graph, route);
        }
        route.addFirst(airport);
    }
}
