#include <bits/stdc++.h>
using namespace std;

int a[10000];
vector<int> dist;

int main() {
	int N, K;
	cin >> N >> K;
	if (N <= K) {
		cout << 0;
		return 0;
	}
	
	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}
	sort(a, a + N);
	for (int i = 1; i < N; i++) {
		dist.push_back(a[i] - a[i - 1]);
	}
	sort(dist.begin(), dist.end());
	
	int ans = 0;
	for (int i = 0; i < dist.size() - (K - 1); i++) {
		ans += dist[i];
	}
	cout << ans;
	return 0;
}