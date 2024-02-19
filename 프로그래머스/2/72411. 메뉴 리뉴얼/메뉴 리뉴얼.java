import java.util.*;

class Solution {
    class Data {
        String order;
        int count;
        Data (String order, int count) {
            this.order = order;
            this.count = count;
        }
    }
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        boolean[] visited = new boolean[21];
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < orders.length; i++) {
            char[] charArray = orders[i].toCharArray();
            Arrays.sort(charArray);
            String cur = "";
            for (int j = 0; j < charArray.length; j++) {
                cur += charArray[j];
            }
            orders[i] = cur;
        }
        
        for (int c : course) {
            for (String o : orders) {
                dfs(0, c, o, "", visited, result);
            }
        }
        
        List<List<Data>> answerList = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            answerList.add(new ArrayList<>());
        }
        for (String s : result.keySet()) {
            if (result.get(s) >= 2) {
                answerList.get(s.length()).add(new Data(s, result.get(s)));
            }
        }
        
        for (int i = 0; i < 21; i++) {
        Collections.sort(answerList.get(i), (a, b) -> Integer.compare(b.count, a.count));    
        }
        
        for (int c : course) {
            for (int i = 0; i < answerList.get(c).size(); i++) {
                if (i == 0) {
                    answer.add(answerList.get(c).get(i).order);
                } else {
                    if (answerList.get(c).get(0).count == answerList.get(c).get(i).count) {
                    answer.add(answerList.get(c).get(i).order);
                    }
                }
            }
        }
       
        String[] x = new String[answer.size()];
        for (int i = 0; i < x.length; i++) {
            x[i] = answer.get(i);
        }
        Arrays.sort(x);
        return x;
    }
    
    private void dfs(int pos, int course, String order, String cur, boolean[] visited, Map<String, Integer> result) {
        if (cur.length() == course) {
            result.put(cur, result.getOrDefault(cur, 0) + 1);
            return;
        }
        
        for (int i = pos; i < order.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, course, order, cur + order.charAt(i), visited, result);
            visited[i] = false;
        }
    }
}