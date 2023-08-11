#include <bits/stdc++.h>
using namespace std;

int N;
int A[1001];
int DP[1001];

void init() {
	cin >> N;
	for(int i = 0; i < N; i++) {
		cin >> A[i];
		DP[i] = 1;
	}	
}

void solve() {
	int answer = 0;
	
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < i; j++) {
			if(A[i] > A[j]) {
				DP[i] = max(DP[i], DP[j] + 1);
			}
		}
		answer = max(answer, DP[i]);
	}
	
	cout << answer;
}

int main() {
	init();
	solve();
	
	return 0;
}
