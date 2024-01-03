import java.util.*;

class Solution {
    
    StringBuilder sb = new StringBuilder();
    
    String result = "Z"; // ICN 보다 큰 Z
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        
        sb.append("ICN");
        dfs(0, "ICN", tickets, visited);
        return result.split(" ");
    }
    
    private void dfs(int pos, String startPoint, String[][] tickets, boolean[] visited) {
        if (pos == tickets.length) {
            if (result.compareTo(sb.toString()) > 0) {
                result = sb.toString();
            }
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String dest = tickets[i][1];
            if (!visited[i] && start.equals(startPoint)) {
                visited[i] = true;
                sb.append(" " + dest);
                dfs(pos + 1, dest, tickets, visited);
                sb.delete(sb.length() - (1 + dest.length()), sb.length());
                visited[i] = false;
            }
        }
    }
}