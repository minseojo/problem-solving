#include <bits/stdc++.h>
using namespace std;

int a[10000];

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < 2 * n; i++) {
		cin >> a[i];
	}
	sort(a, a + 2 * n);
	int ans = 1e9;
	for (int i = 0; i < n; i++) {
		ans = min(ans, (a[i] + a[2 * n - i - 1]));
	}
	cout << ans;
	return 0;
}