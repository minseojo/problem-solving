class Solution {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redEdges2 = new ArrayList[101];
        List<Integer>[] blueEdges2 = new ArrayList[101];

        for(int i=0; i<=100; i++) {
            redEdges2[i] = new ArrayList<>();
            blueEdges2[i] = new ArrayList<>();
        }
        for(int i=0; i<redEdges.length; i++) {
            int cur = redEdges[i][0];
            int next = redEdges[i][1];
            redEdges2[cur].add(next);
        }
        for(int i=0; i<blueEdges.length; i++) {
            int cur = blueEdges[i][0];
            int next = blueEdges[i][1];
            blueEdges2[cur].add(next);
        }

        int[] dist = new int[n];
        for(int i=0; i<n; i++) {
            dist[i] = 400;
        }

        int[] answer = bfs(n, redEdges2, blueEdges2, dist);
        //answer = bfs(n, blueEdges2, redEdges2, dist);
        for(int i=1; i<n; i++) {
            if(dist[i] == 400) dist[i] = -1;
        }
        return answer;
    }

    public int[] bfs(int n, List<Integer>[] redEdges, List<Integer>[] blueEdges, int[] dist) {
        boolean[][][] visited = new boolean[2][n][n];
        for(int i=0; i<2; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    visited[i][j][k] = false;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // 현재노드, 색(0은 레드, 1은 블루)
        q.add(new int[]{0, 1});

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0; j<size; j++) {
                int[] currentQ = q.poll();
                int cur = currentQ[0];
                int color = currentQ[1];
                dist[cur] = Math.min(dist[cur], count);
                if(color%2 == 0) {
                    for(int i=0; i<redEdges[cur].size(); i++) {
                        int next = redEdges[cur].get(i);
                        if(!visited[color%2][cur][next]) {
                            q.add(new int[]{next, color+1});
                            visited[color%2][cur][next] = true;
                        }
                    }
                } else {
                    for(int i=0; i<blueEdges[cur].size(); i++) {
                        int next = blueEdges[cur].get(i);
                        if(!visited[color%2][cur][next]) {
                            q.add(new int[]{next, color+1});
                            visited[color%2][cur][next] = true;
                        }
                    }
                }
            }
            count++;
        }
        return dist;
    }
}