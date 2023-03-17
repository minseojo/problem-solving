#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;
int n, m;
vector<int> graph[1000000];
int dist[1000000];
int cycle[1000000];
int answer = 0;
bool visited[1000000];
bool finished[1000000];

int travleGraph(int here) {
    int result = 1;
    dist[here] = 1;
    for(int i=0; i<graph[here].size(); i++) {
        int next= graph[here][i];
        if(dist[next] == 0) {
        	result = travleGraph(next)+1;
           	dist[here] = result;
           	return dist[here];
		}
		else {
        	dist[here] += dist[next];
        	return dist[here];
		}
    }
    return result;
}

int travleCycle(int here, int count) {
	visited[here] = true;
	int result = count;
    for(int i=0; i<graph[here].size(); i++) {
        int next = graph[here][i];
        if(!visited[next]) {
        	result = max(result, travleCycle(next, count+1));
		}
    }
	cycle[here] = result;
	dist[here] = result;
    return result;
}

void findCycle(int here) {
	visited[here] = true;
	for(int i=0; i<graph[here].size(); i++) {
		int next = graph[here][i];
		if(!visited[next]) {
			findCycle(next);
		} else if(!finished[next]) {
			cycle[next] = 1;
		}

	}
	finished[here] = true;
}

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    //n:정점개수(0~n-1) m: 간선개수
    cin >> m >> n;
    for(int i=0; i<m; i++) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
    }

	// 사이클 찾기 
	for(int i=0; i<n; i++) {
		if(!visited[i]) findCycle(i);
	}
	
	// 사이클 인 경우 사이클 크기 넣어주기
	memset(visited, false, sizeof(visited));
	for(int i=0; i<n; i++) {
		if(cycle[i]==1 && !visited[i]) {
			cycle[i] = travleCycle(i, 1);
		}
	}	

	// 사이클까지 가는 경로 + 사이클 크기
    for(int i=0; i<n; i++) {
    	if(dist[i] == 0) {
    		travleGraph(i);
		}
	}

    for(int i=0; i<n; i++) {
        //cout << dist[i] << " ";
        answer = max(answer, dist[i]);
    }

    cout << answer;
    return 0;
}