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
		//mn=min(mn, a[i]);이렇게 할 경우 원하지 않는 답 출력, 함수를 들어갈때 갱신 해줘야함
		//mx=max(mx, a[i]);그렇지 않으면 mn, mx 변수를 기억해버림 
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
