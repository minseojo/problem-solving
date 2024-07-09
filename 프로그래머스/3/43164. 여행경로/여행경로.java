import java.util.*;

class Solution {
    
    static String DEPARTUE_AIRPORT = "ICN";
    
    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        
        Map<String, PriorityQueue<String>> routes = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            routes.putIfAbsent(from, new PriorityQueue<>());
            routes.get(from).add(to);
        }
        
        dfs(DEPARTUE_AIRPORT, routes, answer);
        
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }
    
    void dfs(String here, Map<String, PriorityQueue<String>> routes, List<String> answer) {
        PriorityQueue<String> route = routes.get(here);
        if (route != null) {
            while (!route.isEmpty()) {
                dfs(route.poll(), routes, answer);
            }
        }
        answer.add(here);
    }

}