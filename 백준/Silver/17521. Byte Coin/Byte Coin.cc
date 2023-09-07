//B
#include <bits/stdc++.h>
using namespace std;

int a[15];

int main() {
	long long N, W;
	cin >> N >> W;
	for (int i = 0; i < N; i++) {
		cin >> a[i];
	}
	int buy = a[0], sell = 0, size = 0;
	bool sequence = false; // 연속된 상승곡선 
	for (int i = 0; i < N; i++) {
		buy = min(buy, a[i]);
		if (a[i] <= a[i + 1]) {
			sell = max(sell, a[i + 1]);
			sequence = true; 
		}
		if (sequence && a[i] > a[i + 1]) {
			long long temp = W;
			W %= buy;
			W = W + (temp / buy) * sell;
			sequence = false;
			sell = 0;
			buy = a[i];
		}
	}
	cout << W;
	return 0;
	
}