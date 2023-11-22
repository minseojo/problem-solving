#include <bits/stdc++.h>
using namespace std;

vector<int> graph;
bool finished[100001];
bool visited[100001];
int cycle[100001];

void findCycle(int here) {
    visited[here] = true;
    int next = graph.at(here);
    if(next == -1) return;
    if(!visited[next]) {
        findCycle(next);
    } else if(!finished[next]) { // 방문 했고, 아직 끝나지 않은 경우 사이클
        cycle[next] = 1;
    }
    finished[here] = true;
}

int travleCycle(int here, int count) {
    visited[here] = true;
    int next = graph.at(here);
    int result = count;
    if(next == -1) return 0;
    if(!visited[next]) {
        result = max(result, travleCycle(next, count+1));
    }
    cycle[here] = result;
    return result;
}

int main() {	
	graph.push_back(3); // 0 > 3
	graph.push_back(3); // 1 > 3
	graph.push_back(4); // 2 > 4
	graph.push_back(2); // 3 > 2
	graph.push_back(3); // 4 > 3
	for(int i=0; i<graph.size(); i++) {
        if(!visited[i]) findCycle(i);
    }
    for(int i=0; i<graph.size(); i++) {
    	cout << cycle[i] << " ";
	}
	
	memset(visited, false, sizeof(visited));
    for(int i=0; i<graph.size(); i++) {
        if(cycle[i] == 1 && !visited[i]) {
            travleCycle(i, 1);
        }
    }
	cout << endl;
    int answer = -1;
    for(int i=0; i<graph.size(); i++) {
        if(cycle[i] != 0 && graph.at(i) != -1) answer = max(answer, cycle[i]);
        cout << cycle[i] << " ";
    }
	
	
	return 0;
}
