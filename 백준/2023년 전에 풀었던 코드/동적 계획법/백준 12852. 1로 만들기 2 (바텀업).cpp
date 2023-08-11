#include <bits/stdc++.h>
using namespace std;

bool visited[11110111];
int trace[11111011];

void bfs(int n) {
	queue<int> q;
	q.push(1);
	visited[1] = true;
	while(!q.empty()) {
		int front = q.front();
		q.pop();
		if(front>1000000) continue;
		if(front == n) return;
	
		if(!visited[front+1]) {
			if(front+1 > n) continue;
			visited[front+1] = true;
			trace[front+1] = front;
			q.push(front+1);
		}

		if(!visited[front*2]) {
			if(front*2 > n) continue;
			visited[front*2] = true;
			trace[front*2] = front;
			q.push(front*2);
		}

		if(!visited[front*3]) {
			if(front*3 > n) continue;
			visited[front*3] = true;
			trace[front*3] = front;
			q.push(front*3);
		}
	}
}

int main() {
	int n;
	cin >> n;
    if(n==1) {
		cout << 0 << endl << 1;
		exit(0);
	}
	bfs(n);
	
	vector<int> answer;
	int index = n;
	answer.push_back(n);
	while(1) {
		index = trace[index];
		answer.push_back(index);
		if(index==1) {
			break;
		}
	}
	cout << answer.size()-1 << endl;
	for(auto & i : answer) {
		cout << i << " ";
	}
	
	return 0;
}

