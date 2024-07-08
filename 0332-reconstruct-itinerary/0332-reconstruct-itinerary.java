import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> routes = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            routes.putIfAbsent(from, new PriorityQueue<>());
            routes.get(from).add(to);
        }
        
        dfs("JFK", routes, result);
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> routes, List<String> result) {
        result.add(airport);
        PriorityQueue<String> destinations = routes.getOrDefault(airport, new PriorityQueue<>());
        while (!destinations.isEmpty()) {
            dfs(destinations.poll(), routes, result);
        }
    }
}
