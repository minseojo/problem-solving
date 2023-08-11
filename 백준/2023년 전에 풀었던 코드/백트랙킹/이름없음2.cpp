#include <bits/stdc++.h>
using namespace std;

int N, L, R, X;
int a[20];
bool visited[20];
int answer=0;

void solve(int idx, int sum, int mn, int mx, int pick) {
	if(idx>N || sum>R) return;
	if(pick>=2 && L<=sum && sum<=R && mx-mn>=X) {
		answer++;
		cout << mx << " " << mn << " " << pick << endl;
		solve(idx+1, sum+a[idx], mn, mx, pick+1);
		solve(idx+1, sum, mn, mx, pick);
		return;
	}
	
	if(pick==0) {
		mn=a[idx];
		mx=a[idx];
	} else {
		mn=min(mn, a[idx]);
		mx=max(mx, a[idx]);
	}
	
	solve(idx+1, sum+a[idx], mn, mx, pick+1);
	solve(idx+1, sum, mn, mx, pick);

}

int main() {

	cin >> N >> L >> R >> X; // L<= number <= R && R-L>=X 
	for(int i=0; i<N; i++) {
		cin >> a[i];
	}
	
	solve(0, 0, 0, 0, 0);
	cout << answer;
	return 0;
}
