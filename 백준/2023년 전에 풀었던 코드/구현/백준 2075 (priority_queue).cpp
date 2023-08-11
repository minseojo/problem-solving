#include <bits/stdc++.h>
using namespace std;

struct comp {
	bool operator() (int a, int b) {
		return a>b;
	}
};

int main() {
	int n, x;
	scanf("%d", &n);
	
	priority_queue<int, vector<int>, comp> pq;
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			scanf("%d", &x);
			if(pq.size()>n) {
				pq.pop();
				pq.push(x);
			}
			else pq.push(x);
		}
	}
	
	pq.pop();
	printf("%d", pq.top());
	
	return 0;
} 
