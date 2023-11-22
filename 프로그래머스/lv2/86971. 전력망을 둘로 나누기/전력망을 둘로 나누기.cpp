#include <string>
#include <vector>
#include <math.h>
#include <string.h>
#include <queue>
#include <iostream>

using namespace std;

bool adj[101][101];
bool visited[101];


int bfs(int start, int n) {
    visited[start] = true;
    queue<int> q;
    q.push(start);
    int result = 0;
    while(!q.empty()) {
        int size = q.size();
        while(size--) {
            result++;
            int node = q.front();
            q.pop();
            for (int next = 1; next <= n; next++) {
                if (adj[node][next] && !visited[next]) {
                    visited[next] = true;
                    q.push(next);
                }
            }
        }
    }
    return result;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = 1e9;
    for (int i = 0; i < wires.size(); i++) {
        int u = wires[i][0];
        int v = wires[i][1];
        adj[u][v] = true;
        adj[v][u] = true;
    }
    
    for (int i = 0; i < wires.size(); i++) {
        int u = wires[i][0];
        int v = wires[i][1];
        adj[u][v] = false;
        adj[v][u] = false;
        int a = bfs(u, n);
        memset(visited, 0, sizeof(visited));
        
        int b = bfs(v, n);
        memset(visited, 0, sizeof(visited));   
        answer = min(answer, abs(a-b));
        adj[u][v] = true;
        adj[v][u] = true;
    }

    return answer;
}