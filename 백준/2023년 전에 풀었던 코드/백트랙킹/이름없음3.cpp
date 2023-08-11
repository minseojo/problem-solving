#include <bits/stdc++.h>
using namespace std;

int N, L, R, X;
int a[20];
bool visited[20];
int answer=0;

void solve(int idx, int sum, int mn, int mx, int pick, int start) {
	if(idx>N || sum>R) return;
	if(pick>=2 && L<=sum && sum<=R && mx-mn>=X) {
		answer++;
		cout << mx << " " << mn << " " << pick << endl;
		return;
	}
	
	if(pick==0) {
		mn=a[idx];
		mx=a[idx];
	} else {
		mn=min(mn, a[idx]);
		mx=max(mx, a[idx]);
	}
	for(int i=start; i<N; i++) {
		solve(idx+1, sum+a[idx], mn, mx, pick+1, i);

	}
}

int main() {

	cin >> N >> L >> R >> X; // L<= number <= R && R-L>=X 
	for(int i=0; i<N; i++) {
		cin >> a[i];
	}
	
	solve(0, 0, 0, 0, 0, 0);
	cout << answer;
	return 0;
}
