class Solution {
    long answer;
    
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=roads.length;i++) graph.add(new ArrayList<>());
        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited=new boolean[roads.length+1];
        dfs(graph, 0, seats, visited);

        return answer;
    }

    public int dfs(List<List<Integer>> graph, int root, int seats, boolean[] visited) {
        int persons = 1;
        visited[root] = true;

        // find the number of persons that are coming including current
        for(int next : graph.get(root)) {
            if(!visited[next]) {
                persons += dfs(graph, next, seats, visited);
            }        
        }
        //dont count fuel if we are at capital
        // fuel is calculated by diving no. of persons-1 by seats and include the current too i.e. 1
        if(root != 0)
           answer += ((persons-1)/seats) + 1;
        
        return persons;
    }
}