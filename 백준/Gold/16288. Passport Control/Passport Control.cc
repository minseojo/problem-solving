#include <bits/stdc++.h>
using namespace std;

int main() {
	int N, K;
	cin >> N >> K;
	
	stack<int> s[K];
	for (int i = 0; i < N; i++) {
		int x;
		cin >> x;
		for (int j = 0; j < K; j++) {
			if (s[j].empty()) {
				s[j].push(x);
				break;	
			}
			else {
				if (s[j].top() < x) {
					s[j].push(x);
					break;
				}
			}
			
			if (j == K - 1) {
				cout << "NO";
				return 0;
			}
		}
	}
	cout << "YES";
	return 0;
}