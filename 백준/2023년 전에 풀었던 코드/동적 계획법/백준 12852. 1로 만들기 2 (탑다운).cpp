#include <bits/stdc++.h>
#define MAX 1000000
using namespace std;

bool visited[MAX+1];
int trace[MAX+1];

void bfs(int n) {
	queue<int> q;
	q.push(n);
	visited[n] = true;

	while(!q.empty()) {
		int front = q.front();
		int next=0;
		q.pop();
		if(front <= 1) break;

		if(front % 3 == 0) {
			next = front / 3;
			if(!visited[next]) {
				visited[next] = true;
				trace[next] = front;
				q.push(next);
			}
		}
		
		if(front % 2 == 0) {
			next = front / 2;
			if(!visited[next]) {
				visited[next] = true;
				trace[next] = front;
				q.push(next);
			}
		}
		
		next = front - 1;
		if(!visited[next]) {
			visited[next] = true;
			trace[next] = front;
			q.push(next);
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
	
	int index = 1;
	
	vector<int> answer;
	while(1) {
		answer.push_back(index);
		index = trace[index];
		if(index==n) {
			break;
		}
	}
	answer.push_back(n);
	
	cout << answer.size()-1 << endl;
	sort(answer.rbegin(), answer.rend());
	for(auto i : answer) {
		cout << i << " ";
	}
	return 0;
}
