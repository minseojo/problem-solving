#include <bits/stdc++.h>
using namespace std;

bool visited[61][61][61];

struct St {
	int a;
	int b;
	int c;
	int count;
};

queue<St> q;

int main() {
	int n;
	cin >> n;
	
	int ai=0, bi=0, ci=0;
	for(int i=0; i<n; i++) {
		if(i == 0) cin >> ai;
		if(i == 1) cin >> bi;
		if(i == 2) cin >> ci;
	}
	q.push({ai, bi, ci, 0});
	

	while(!q.empty()) {
		int a = q.front().a;
		int b = q.front().b;
		int c = q.front().c;
		int count = q.front().count;
		q.pop();
		
		if(a<0) a=0;
		if(b<0) b=0;
		if(c<0) c=0;

		if(visited[a][b][c]) continue;
		visited[a][b][c] = true;
		
		if(a==0 && b==0 && c==0) {
			cout << count;
			return 0;
		}

		q.push({a-9, b-3, c-1, count+1});
		q.push({a-9, b-1, c-3, count+1});
		q.push({a-3, b-9, c-1, count+1});
		q.push({a-3, b-1, c-9, count+1});
		q.push({a-1, b-9, c-3, count+1});
		q.push({a-1, b-3, c-9, count+1});	
	}
}