#include <bits/stdc++.h>
using namespace std;

int N, L, R, X;
int a[20];
bool visited[20];
int answer=0;

void solve(int sum, int pick, int mn, int mx, int start) {
	if(pick==0) {
		if(L<=sum && sum<=R && mx-mn>=X) {
			answer++;
		}
		return;
	}
	
	
	for(int i=start; i<N; i++) {
		if(visited[i]) continue;
		visited[i]=true;
		solve(sum+a[i], pick-1, min(mn, a[i]), max(mx, a[i]), i);
		visited[i]=false;
	}
}

int main() {
	cin >> N >> L >> R >> X; // L<= number <= R && R-L>=X 
	for(int i=0; i<N; i++) {
		cin >> a[i];
	}
	
	for(int i=2; i<=N; i++) {
		solve(0, i, 1e9, 0, 0);
	}
	cout << answer;
	return 0;
}
