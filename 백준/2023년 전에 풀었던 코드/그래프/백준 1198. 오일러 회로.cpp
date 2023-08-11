#include <bits/stdc++.h>
using namespace std;

int n;
int a[1111][1111];
int degree[1111];
int nxt[1111];

void solve(int here) {
	for(int &i=nxt[here]; i<=n; i++) {
		if(i==here) continue;
		while(a[here][i]>0) {
			a[here][i]--;
			a[i][here]--;
			solve(i);
		}
	}
	
	cout << here << " ";	
	return;
}

int main() {
	cin >> n;
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=n; j++) {
			cin >> a[i][j];
			degree[i]+=a[i][j];
		}
	}

	for(int i=1; i<=n; i++) {
		if((degree[i]%2)!=0) {
			cout << -1;
			return 0;
		}
	}
	
	for(int i=1; i<=n; i++) nxt[i]=1; //시작점 메모리 초기화 
	solve(1);
	return 0;
}
