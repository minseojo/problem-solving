#include <bits/stdc++.h>
#define ll long long
using namespace std;

int n, m;
priority_queue<ll, vector<ll>, greater<ll>> pq;

int main() {
	// input(start)
	cin >> n >> m;
	ll num;
	for(int i=0; i<n; i++) {
		cin >> num;
		pq.push(num);
	} 
	// input(end)
	
	// sovle(start)
	ll x, y;
	ll answer = 0;
	for(int i=0; i<m; i++) {
		x = pq.top();
		pq.pop();
		y = pq.top();
		pq.pop();
		pq.push(x+y);
		pq.push(x+y);
	}
	
	while(!pq.empty()) {
		answer += pq.top();
		pq.pop();
	}
	
	cout << answer;
	// solve(end)
	
	return 0;
}